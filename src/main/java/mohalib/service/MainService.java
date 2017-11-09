package mohalib.service;

import mohalib.domain.PostData;
import mohalib.domain.ReserveForm;
import mohalib.domain.Room;
import mohalib.net.HttpRequest;
import mohalib.net.HttpRequestImpl;
import mohalib.parser.RoomLayoutParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pendragon on 16-12-16.
 */

@Service(value = "homeService")
public class MainService {

    public boolean isAuthorizedUser(String username) {
        File file = new File(System.getProperty("web.root") + "/authorizedUsers.json");
        try (FileReader fileReader = new FileReader(file)) {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[2048];
            int tem;
            while ((tem = fileReader.read(buf)) != -1){
                sb.append(buf, 0, tem);
            }
            JSONArray users = new JSONArray(sb.toString());
            for (int i = 0; i < users.length(); i++){
                if (users.optString(i).equals(username))
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean doReserve(ReserveForm reserveForm) {
        Calendar calendar = Calendar.getInstance();
        //TODO 请检查这里时间是否需要提前，学校服务器好像经常提前30s启动
        calendar.set(Calendar.HOUR_OF_DAY, 22); //设置22点的时候触发
        calendar.set(Calendar.MINUTE, 30); //设置30分钟的时候触发
        calendar.set(Calendar.SECOND, 0); //设置30秒的时候触发

        Timer timer = new Timer();
        PostData postData = new PostData();
        ReserveTask reserveTask = new ReserveTask(postData, reserveForm);
        reserveTask.run();
        timer.schedule(reserveTask, calendar.getTime());
        timer.cancel();

        System.out.println("reservation received...");
        return true;
    }

    private class ReserveTask extends TimerTask {
        private PostData postData;
        private ReserveForm reserveForm;

        ReserveTask(PostData postData, ReserveForm reserveForm){
            this.postData = postData;
            this.reserveForm = reserveForm;
        }

        @Override
        public void run() {
            System.out.println("start running...");
            login(reserveForm, postData);
            attemptReserve(reserveForm, postData);
        }
    }

    /**
     * error
     * {"status":"fail","code":"13","message":"登录失败: 用户名或密码不正确","data":null}
     *
     * success
     * {"status":"success","data":{"token":"GJXQY7OZTQ12195322"},"code":"0","message":""}
     */
    private PostData login(ReserveForm reserveForm, PostData postData){
        //Test
        System.out.println(reserveForm);

        String url = "http://seat.lib.whu.edu.cn/rest/auth?username=" + reserveForm.getUsername() + "&password=" + reserveForm.getPassword();
        HttpRequest httpRequest = new HttpRequestImpl();
        String response = httpRequest.get(url);
        while (response == null){
            response = httpRequest.get(url);
        }

        JSONObject jsonObject = new JSONObject(response);
        String code = jsonObject.optString("code");
        if (code.equals("0")){
            postData.setToken(jsonObject.optJSONObject("data").optString("token"));
            System.out.println(postData.getToken());
        } else {
            Logger.getGlobal().log(Level.SEVERE, jsonObject.optString("message"));
        }
        return postData;
    }

    /**
     * success
     * {"status":"success","data":{"startTimes":[{"id":"930","value":"15:30"},{"id":"1290","value":"21:30"}]},"message":"","code":"0"}
     *
     *
     */

    private boolean attemptReserve(ReserveForm reserveForm, PostData postData) {
        for (int i = 0; i < reserveForm.getNumber().length; i++){
            String url;
            url = "http://seat.lib.whu.edu.cn/rest/v2/startTimesForSeat/"
                    + new RoomLayoutParser().parse(reserveForm.getRoom()).get(reserveForm.getNumber()[i]).getId() //座位id
                    + "/" + reserveForm.getDate() //时间
                    + "?token=" + postData.getToken(); //Token

            HttpRequest httpRequest = new HttpRequestImpl();
            String response = httpRequest.get(url);
            while (response == null){
                response = httpRequest.get(url);
            }

            System.out.println(response);

            JSONObject startObject = new JSONObject(response);
            if (startObject.optString("code").equals("0")) {
                for (Object o : startObject.optJSONObject("data").optJSONArray("startTimes")) {
                    String id = ((JSONObject) o).optString("value");
                    if (id.equals(reserveForm.getStartTime())) {
                        postData.setStartTime((((JSONObject) o).optString("id")));
                        break;
                    }
                }
            } else {
                Logger.getGlobal().log(Level.SEVERE, startObject.optString("message"));
            }


            if (postData.getStartTime() != null){
                //statTime 满足, 测试 endTime
                if (endTime(i, reserveForm, postData)){
                    //endTime 满足, 开始预约
                    if (doReserve(i, reserveForm, postData)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean endTime(int i, ReserveForm reserveForm, PostData postData) {
        HttpRequest httpRequest = new HttpRequestImpl();
        String url = "http://seat.lib.whu.edu.cn/rest/v2/endTimesForSeat/"
                + new RoomLayoutParser().parse(reserveForm.getRoom()).get(reserveForm.getNumber()[i]).getId() //座位id
                + "/" + reserveForm.getDate() //时间
                + "/" + postData.getStartTime()
                + "?token=" + postData.getToken(); //Token

        String response = httpRequest.get(url);
        while (response == null){
            response = httpRequest.get(url);
        }
        //Test
        System.out.println(response);

        JSONObject startObject = new JSONObject(response);
        if (startObject.optString("code").equals("0")){
            for (Object o : startObject.optJSONObject("data").optJSONArray("endTimes")) {
                String id = ((JSONObject) o).optString("value");
                if (id.equals(reserveForm.getEndTime())) {
                    postData.setEndTime((((JSONObject) o).optString("id")));
                    return true;
                }
            }
        } else {
            Logger.getGlobal().log(Level.SEVERE, startObject.optString("message"));
        }
        return false;
    }

    /**
     * success
     * {"status":"success","data":{"id":92061,"receipt":"0227-061-1","onDate":"2016 年 12 月 19 日","begin":"21 : 30","end":"22 : 00","location":"信息部图书馆2层西区二楼自然科学图书借阅区西，座位号016"},"message":"当前没有可用预约","code":"0"}
     *
     */
    private boolean doReserve(int i, ReserveForm reserveForm, PostData postData){
        postData.setDate(reserveForm.getDate());
        postData.setSeat(new RoomLayoutParser().parse(reserveForm.getRoom()).get(reserveForm.getNumber()[i]).getId() + "");

        String url = "http://seat.lib.whu.edu.cn/rest/v2/freeBook";
        HttpRequest httpRequest = new HttpRequestImpl();
        Map<String, Object> map = new HashMap<>();
        map.put("token", postData.getToken());
        map.put("startTime", postData.getStartTime());
        map.put("endTime", postData.getEndTime());
        map.put("seat", postData.getSeat());
        map.put("date", postData.getDate());
        String response = httpRequest.post(url, map);
        while (response == null){
            response = httpRequest.post(url, map);
        }
        System.out.println(response);
        JSONObject object = new JSONObject(response);
        if (object.optString("code").equals("0")){
            return true;
        } else {
            Logger.getGlobal().log(Level.SEVERE, object.optString("message"));
            return false;
        }
    }

    public List<Room> getRoomsByFloor(int floor){
        List<Room> roomList = new ArrayList<>();
        switch (floor){
            case 1:
                roomList.add(new Room(RoomNumber.FL1_3C_SPACE, "一楼3C创客空间", getSeatsByRoom(RoomNumber.FL1_3C_SPACE)));
                roomList.add(new Room(RoomNumber.FL1_CREATE_STUDY, "一楼创新学习讨论区", getSeatsByRoom(RoomNumber.FL1_CREATE_STUDY)));
                roomList.add(new Room(RoomNumber.FL1_3C_ELECTRIC, "3C创客-电子资源阅览", getSeatsByRoom(RoomNumber.FL1_3C_ELECTRIC)));
                roomList.add(new Room(RoomNumber.FL1_3C_DOUBLE_SCREENS, "3C创客-双屏电脑", getSeatsByRoom(RoomNumber.FL1_3C_DOUBLE_SCREENS)));
                roomList.add(new Room(RoomNumber.FL1_MAC, "创新学习-MAC电脑", getSeatsByRoom(RoomNumber.FL1_MAC)));
                roomList.add(new Room(RoomNumber.FL1_CLOUD, "创新学习-云桌面", getSeatsByRoom(RoomNumber.FL1_CLOUD)));
                return roomList;
            case 2:
                roomList.add(new Room(RoomNumber.FL2_EAST, "二楼社会科学借阅东区", getSeatsByRoom(RoomNumber.FL2_EAST)));
                roomList.add(new Room(RoomNumber.FL2_WEST, "二楼社会科学借阅西区", getSeatsByRoom(RoomNumber.FL2_WEST)));
                return roomList;
            case 3:
                roomList.add(new Room(RoomNumber.FL3_EAST, "三楼社会科学借阅东区", getSeatsByRoom(RoomNumber.FL3_EAST)));
                roomList.add(new Room(RoomNumber.FL3_WEST, "三楼社会科学借阅西区", getSeatsByRoom(RoomNumber.FL3_WEST)));
                roomList.add(new Room(RoomNumber.FL3_FREE, "三楼自主学习区", getSeatsByRoom(RoomNumber.FL3_FREE)));
                return roomList;
            case 4:
                roomList.add(new Room(RoomNumber.FL4_EAST, "四楼社会科学借阅东区", getSeatsByRoom(RoomNumber.FL4_EAST)));
                roomList.add(new Room(RoomNumber.FL4_WEST, "四楼社会科学借阅西区", getSeatsByRoom(RoomNumber.FL4_WEST)));
                return roomList;
            default:
                return roomList;
        }
    }

    private String[] getSeatsByRoom(int roomNumber){
        switch (roomNumber){
            case RoomNumber.FL1_3C_SPACE:
                return buildRoomSeat(110);
            case RoomNumber.FL1_CREATE_STUDY:
                return buildRoomSeat(64);
            case RoomNumber.FL1_3C_ELECTRIC:
                return buildRoomSeat(20);
            case RoomNumber.FL1_3C_DOUBLE_SCREENS:
                return buildRoomSeat(20);
            case RoomNumber.FL1_MAC:
                return buildRoomSeat(12);
            case RoomNumber.FL1_CLOUD:
                return buildRoomSeat(42);
            case RoomNumber.FL2_EAST:
                return buildRoomSeat(91);
            case RoomNumber.FL2_WEST:
                return buildRoomSeat(91);
            case RoomNumber.FL3_EAST:
                return buildRoomSeat(84);
            case RoomNumber.FL3_WEST:
                return buildRoomSeat(88);
            case RoomNumber.FL3_FREE:
                return buildRoomSeat(132);
            case RoomNumber.FL4_WEST:
                return buildRoomSeat(88);
            case RoomNumber.FL4_EAST:
                return buildRoomSeat(80);
            default:
                return buildRoomSeat(0);
        }
    }

    private String[] buildRoomSeat(int total){
        String[] seats = new String[total];
        for (int i = 1; i <= total; i++){
            seats[i - 1] = String.format("%-3d", i);
        }
        return seats;
    }

    private static class RoomNumber {
        static final int FL1_3C_DOUBLE_SCREENS = 14;
        static final int FL1_3C_SPACE = 4;
        static final int FL1_3C_ELECTRIC = 13;
        static final int FL1_CREATE_STUDY = 5;
        static final int FL1_MAC = 15;
        static final int FL1_CLOUD = 16;

        static final int FL2_EAST = 7;
        static final int FL2_WEST = 6;

        static final int FL3_EAST = 10;
        static final int FL3_WEST = 8;
        static final int FL3_FREE = 12;

        static final int FL4_EAST = 11;
        static final int FL4_WEST = 9;
    }
}

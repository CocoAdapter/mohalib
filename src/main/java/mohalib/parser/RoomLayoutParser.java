package mohalib.parser;

import mohalib.domain.Seat;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by pendragon on 16-12-19.
 */
public class RoomLayoutParser {
    private static final HashMap<Integer, Integer> LAYOUT_DIC = new HashMap<>();
    static {
        LAYOUT_DIC.put(4, 110);
        LAYOUT_DIC.put(5, 64);
        LAYOUT_DIC.put(6, 92);
        LAYOUT_DIC.put(7, 92);
        LAYOUT_DIC.put(8, 88);
        LAYOUT_DIC.put(9, 88);
        LAYOUT_DIC.put(10, 84);
        LAYOUT_DIC.put(11, 80);
        LAYOUT_DIC.put(12, 188);
        LAYOUT_DIC.put(13, 20);
        LAYOUT_DIC.put(14, 20);
        LAYOUT_DIC.put(15, 12);
        LAYOUT_DIC.put(16, 42);
    }

    public HashMap<Integer, Seat> parse(int roomId) {
        HashMap<Integer, Seat> hashMap = new HashMap<>();
        File file = new File(System.getProperty("web.root") + "/layout/" + roomId + ".json");
        try (FileReader fileReader = new FileReader(file)) {
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[2048];
            int tem;
            while ((tem = fileReader.read(buf)) != -1){
                sb.append(buf, 0, tem);
            }
            JSONObject room = new JSONObject(sb.toString());
            for (int i = 1; i <= LAYOUT_DIC.get(roomId); i++) {
                JSONObject seatString = room.optJSONObject(i + "");
                if (seatString == null)
                    continue;

                Seat seat = new Seat();
                seat.setSeatNum(i);
                seat.setHasWindow(seatString.optBoolean("window"));
                seat.setHasPower(seatString.optBoolean("power"));
                seat.setHasComputer(seatString.optBoolean("computer"));
                seat.setId(seatString.optInt("id"));
                hashMap.put(seat.getSeatNum(), seat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}

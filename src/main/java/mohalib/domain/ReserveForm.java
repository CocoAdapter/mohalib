package mohalib.domain;

import java.util.Arrays;

/**
 * Created by pendragon on 16-12-16.
 */
public class ReserveForm {

    private int room;
    private int[] number;
    private String date;
    private String startTime;
    private String endTime;

    private String username;
    private String password;

    public ReserveForm(){}

    public ReserveForm(int room, int[] number, String date, String startTime, String endTime, String username, String password) {
        this.room = room;
        this.number = number;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.username = username;
        this.password = password;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ReserveForm{" +
                "room=" + room +
                ", number=" + Arrays.toString(number) +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

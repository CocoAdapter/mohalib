package mohalib.domain;

import mohalib.parser.RoomLayoutParser;

import java.util.HashMap;

/**
 * Created by pendragon on 16-12-16.
 */
public class Room {

    private int id;
    private String name;
    private String[] seats;

    private HashMap<Integer, Seat> seatMap;

    public Room() {

    }

    public Room(int id, String name, String[] seats) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        if (seatMap == null){
            seatMap = new RoomLayoutParser().parse(id);
        }
    }

    public int getId() {
        return id;
    }

    public HashMap<Integer, Seat> getSeatMap() {
        return seatMap;
    }

    public void setId(int id) {
        this.id = id;
        if (seatMap == null){
            seatMap = new RoomLayoutParser().parse(id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSeats() {
        return seats;
    }

    public void setSeats(String[] seats) {
        this.seats = seats;
    }
}

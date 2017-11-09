package mohalib.domain;

/**
 * Created by pendragon on 16-12-19.
 */
public class Seat {

    private int seatNum;
    private int id;
    private boolean hasPower;
    private boolean hasComputer;
    private boolean hasWindow;

    public Seat(){}

    public Seat(int seatNum, int id, boolean hasPower, boolean hasComputer, boolean hasWindow) {
        this.seatNum = seatNum;
        this.id = id;
        this.hasPower = hasPower;
        this.hasComputer = hasComputer;
        this.hasWindow = hasWindow;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasPower() {
        return hasPower;
    }

    public void setHasPower(boolean hasPower) {
        this.hasPower = hasPower;
    }

    public boolean isHasComputer() {
        return hasComputer;
    }

    public void setHasComputer(boolean hasComputer) {
        this.hasComputer = hasComputer;
    }

    public boolean isHasWindow() {
        return hasWindow;
    }

    public void setHasWindow(boolean hasWindow) {
        this.hasWindow = hasWindow;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNum=" + seatNum +
                ", id=" + id +
                ", hasPower=" + hasPower +
                ", hasComputer=" + hasComputer +
                ", hasWindow=" + hasWindow +
                '}';
    }
}

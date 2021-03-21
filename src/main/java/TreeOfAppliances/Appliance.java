package TreeOfAppliances;

public class Appliance implements Comparable<Appliance> {

    double powerW;
    boolean isPlugged;
    String room;


    public double getPowerW() {
        return powerW;
    }

    public boolean isPlugged() {
        return isPlugged;
    }

    public String getRoom() {
        return room;
    }

    public void setPowerW(double powerW) {
        this.powerW = powerW;
    }

    public void setPlugged(boolean plugged) {
        isPlugged = plugged;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public int compareTo(Appliance o) {
        if (this.getPowerW() < o.getPowerW()) return -1;
        if (this.getPowerW() >= o.getPowerW()) return 1;

        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nAppliance{ ");
        sb.append("power = '").append(powerW).append('\'');
        sb.append(", isPlugged = ").append(isPlugged);
        sb.append(", room = ").append(room);
        sb.append("").append('}');
        return sb.toString();
    }


}

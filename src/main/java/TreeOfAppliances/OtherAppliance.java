package TreeOfAppliances;

public class OtherAppliance extends Appliance{

    public OtherAppliance(double powerW, boolean isPlugged, String room) {
        this.powerW = powerW;
        this.isPlugged = isPlugged;
        this.room = room;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("power = '").append(powerW).append('\'');
        sb.append(", isPlugged = ").append(isPlugged);
        sb.append(", room = ").append(room);
        sb.append(", OtherAppliance");
        return sb.toString();
    }

}

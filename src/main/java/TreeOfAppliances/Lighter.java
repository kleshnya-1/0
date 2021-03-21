package TreeOfAppliances;

public class Lighter extends Appliance  {
    private String lightColour;


    public Lighter(double powerW, boolean isPlugged, String room, String lightColour) {
        this.powerW = powerW;
        this.isPlugged = isPlugged;
        this.room = room;
        this.lightColour = lightColour;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");

        sb.append("power = '").append(powerW).append('\'');
        sb.append(", isPlugged = ").append(isPlugged);
        sb.append(", room = ").append(room);
        sb.append(", lightColour = ").append(lightColour);
        sb.append(", Lighter");
        return sb.toString();
    }

}

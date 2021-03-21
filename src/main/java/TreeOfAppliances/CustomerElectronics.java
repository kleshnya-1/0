package TreeOfAppliances;

public class CustomerElectronics extends Appliance {
    private String brandName;

    public CustomerElectronics(String brandName, double powerW, boolean isPlugged, String room) {
        this.brandName = brandName;
        this.powerW = powerW;
        this.isPlugged = isPlugged;
        this.room = room;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("power = '").append(powerW).append('\'');
        sb.append(", isPlugged = ").append(isPlugged);
        sb.append(", room = ").append(room);
        sb.append(", brandName = ").append(brandName);
        sb.append(", CustomerElectronics");
        return sb.toString();
    }
}

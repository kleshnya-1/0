package Core;

import Services.Creator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Started main!");

        // write your code here
        Creator flatOne = new Creator();
        log.info("Flat added");
        /*
        flatOne.addRoom();
        flatOne.addRoom();
*/
        flatOne.addRoomAuto(8);

       // flatOne.addAppliance();

    flatOne.getRoomRandom();
    flatOne.getRoomRandom();
    flatOne.getRoomRandom();
        System.out.println(flatOne.getRoomRandom());




        System.out.println();


       /* flatOne.setAppliance(new Lighter(45,false,"3-th room","3Colour"));
        flatOne.setAppliance(new Lighter(45,true,"3-th room","30Colour"));
        flatOne.setAppliance(new Lighter(45,false,"2-th room","3C0olour"));
*/
        flatOne.addApplianceAuto(14);
       // flatOne.addAppliance();
        //flatOne.getSortByPower();
        //flatOne.plugAppliance(45, "3-th room");
        flatOne.findApplianceInRange(20,90);

        // flatOne.getSortByPower();
        // flatOne.calculapeConsumption();


        //flatOne.PlugApp(flatOne.ApplianceHash, "ggggg");

        log.info("Ended main!");
    }
}

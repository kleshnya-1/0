import Services.Creator;
import TreeOfAppliances.Appliance;
import TreeOfAppliances.CustomerElectronics;
import TreeOfAppliances.Lighter;
import TreeOfAppliances.OtherAppliance;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Services.Creator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>???. 10, 2021</pre>
 */


@Slf4j
@DisplayName("Services.Creator Test")
class CreatorTest {

    private static Creator FlatForTest;

    private static int PowerW_forTests = 50;

    @BeforeEach
    void before() throws Exception {
        log.info("@BeforeEach method started...");
        FlatForTest = new Creator();
    }

    @AfterEach
    void after() throws Exception {
    }

    /**
     * Method: getApplianceHash()
     */
    @Test
    @DisplayName("Test Get Appliance Hash")
    void testGetApplianceHash() throws Exception {
        // TODO: Test goes here...
    }

    /*  */
    /**
     * Method: addAppliance()
     */
    /*
    @Test
    @DisplayName("Test Add Appliance Manual")
    void testAddAppliance() throws Exception {
        FlatForTest.addAppliance();
        // TODO: Test goes here...
    }*/
    /* */
    /**
     * Method: addRoom()
     */
    /*
    @Test
    @DisplayName("Test Add Room")
    void testAddRoom() throws Exception {
        // TODO: Test goes here...
    }*/
    /**
     * Method: addRoomAuto(int numberOfAutoRooms)
     */
    @ParameterizedTest
    @ValueSource(ints = { 1, 5, 6, 8, 50, 68, 94, 129 })
    @DisplayName("Auto Services.Creator Check")
    public void autoCreatorCheck(int rooms) {
        Creator FlatForTestParametrised = new Creator();
        FlatForTestParametrised.addRoomAuto(rooms);
        assertEquals(rooms, FlatForTestParametrised.getRoomHash().size());
    }

    /**
     * Method: getRoomRandom()
     */
    @Test
    @DisplayName("Test Get Room Random")
    void testGetRoomRandom() throws Exception {
        String roomName = "nice";
        int numOfRooms = 6;
        Set<String> roomHash_Expected = new HashSet<String>();
        FlatForTest.addRoomString(roomName);
        FlatForTest.addRoomAuto(numOfRooms);
        roomHash_Expected.add(roomName);
        for (int i = 1; i <= numOfRooms; i++) {
            roomHash_Expected.add(Integer.toString((i)) + "-th room");
        }
        Assertions.assertEquals(roomHash_Expected, FlatForTest.getRoomHash());
        // TODO: Test goes here...
    }

    /**
     * Method: addApplianceAuto(int numberOfAutoApps)
     */
    @Test
    @DisplayName("Test Add Appliance Auto")
    void testAddApplianceAuto() throws Exception {


        int numOFroomsFORtest = 99;
        for (int i = 1; i <= numOFroomsFORtest; i++) {
            Random random = new Random();
            int typeRandom = random.nextInt(3) + 1;

            FlatForTest.addRoomAuto(6);


            switch (typeRandom) {
                case 1:


                    FlatForTest.addAppliance(new Lighter(random.nextInt(30), random.nextBoolean(),
                            "3-th room",
                            "RandomAutoColourNumber" + Integer.toString(i)));
                    break;
                case 2:
                    FlatForTest.addAppliance(new CustomerElectronics
                            ("brand in " + FlatForTest.getRoomRandom(),
                                    random.nextInt(100), random.nextBoolean(), FlatForTest.getRoomRandom()));
                    break;
                case 3:
                    FlatForTest.addAppliance(new OtherAppliance(random.nextInt(3000),
                            random.nextBoolean(), FlatForTest.getRoomRandom()));
                    break;


            }



        }
        Assertions.assertEquals(FlatForTest.getApplianceHash().size(), numOFroomsFORtest);

        // TODO: Test goes here...
    }

    /**
     * Method: getSortByPower()
     */
    @Test
    @DisplayName("Test Get Sort By Power")
    void testGetSortByPower() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: plugAppliance(int power, String room)
     */
    @Test
    @DisplayName("Test Plug Appliance")
    void testPlugAppliance() throws Exception {
        FlatForTest.setAppliance(new Lighter(PowerW_forTests, false, "3", "noColour"));
        FlatForTest.setAppliance(new Lighter(PowerW_forTests, false, "3", "1Colour"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FlatForTest.plugAppliance(PowerW_forTests, "3");
        }, "i gde ono vipataet?");
        System.out.println();
        int appHashSizeBeforePlugging = FlatForTest.getApplianceHash().size();
        FlatForTest.plugAppliance(PowerW_forTests, "3");
        Assertions.assertEquals(FlatForTest.getApplianceHash().size(), appHashSizeBeforePlugging);
        // TODO: Test goes here...
    }

    /**
     * Method: findApplianceInRange(int powerFrom, int powerTo)
     */
    @Test
    @DisplayName("Test Find Appliance In Range")
    void testFindApplianceInRange() throws Exception {
        // TODO: Test goes here...

        Iterator<Appliance> iteratorRange = FlatForTest.getApplianceHash().iterator();
        FlatForTest.addRoomString("5");
        FlatForTest.addAppliance(new Lighter(20, true, "5", "red"));
        FlatForTest.addAppliance(new Lighter(40, true, "5", "red"));
        FlatForTest.addAppliance(new Lighter(100, true, "5", "red"));
        FlatForTest.addAppliance(new Lighter(500, true, "5", "red"));
        FlatForTest.addAppliance(new Lighter(700, true, "5", "red"));
        int counter = 0;
        while (iteratorRange.hasNext()) {
            Appliance apCheck = iteratorRange.next();
            if (apCheck.getPowerW() >= 30 && apCheck.getPowerW() <= 600) {
                counter++;
                            }

            Assertions.assertEquals(counter, 3);
        }




    }

    /**
     * Method: setAppliance(Appliance appliance)
     */
    @Test
    @DisplayName("Test Set Appliance")
    void testSetAppliance() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: calculapeConsumption()
     */
    @Test
    @DisplayName("Test Calculape Consumption")
    void testCalculapeConsumption() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: getRoomHash()
     */
    @Test
    @DisplayName("Test Get Room Hash")
    void testGetRoomHash() throws Exception {
        // TODO: Test goes here...
    }
}

package Services;


import TreeOfAppliances.Appliance;
import TreeOfAppliances.CustomerElectronics;
import TreeOfAppliances.Lighter;
import TreeOfAppliances.OtherAppliance;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


import java.util.*;


@Slf4j
public class Creator {


    public Set<Appliance> getApplianceHash() {
        return ApplianceHash;
    }

    Set<String> roomHash = new HashSet<String>();

    NavigableSet<Appliance> ApplianceHash = new TreeSet<Appliance>();

    String appRoom;
    Scanner plugSc;

    public void addAppliance() {
        if (this.roomHash.isEmpty()) {

            System.out.println("Комнат не добавлено. сначала добавьте комнаты");
            return;
        }


        System.out.print("В какую комнату добавлить прибор? ");
        if (!this.roomHash.isEmpty()) {
            System.out.print("Уже имеются: ");
            for (String text : this.roomHash) {
                System.out.print(text + ", ");
            }
        }

        do {
            Scanner sc = new Scanner(System.in);
            appRoom = sc.nextLine();
            if (!roomHash.contains(appRoom)) {
                System.out.println("Комнаты не существует, повторите ввод");
            }

        }
        while (!roomHash.contains(appRoom));

        System.out.println("Выберите тип электроники: \n1.Освещение \n2.Потребительская \n3.Иное");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();

        System.out.println("Введите мощность");
        Scanner powerSc = new Scanner(System.in);
        int power = powerSc.nextInt();


        do {
            System.out.println("Подключена ли она? True/False");
            plugSc = new Scanner(System.in);

            if (!plugSc.hasNextBoolean()) {
                System.out.println("Ошибка ввода, введите TRUE/FALSE");
            }
        }
        while (!plugSc.hasNextBoolean());


        switch (type) {
            case 1:
                System.out.println("Введите цвет");
                Scanner colSc = new Scanner(System.in);
                String col = colSc.nextLine();

                ApplianceHash.add(new Lighter(power, plugSc.nextBoolean(), appRoom, col));
                break;
            case 2:
                System.out.println("Введите Название бренда");
                Scanner brandNameSc = new Scanner(System.in);
                String brandName = brandNameSc.nextLine();
                ApplianceHash.add(new CustomerElectronics(brandName, power, plugSc.nextBoolean(), appRoom));
                break;
            case 3:
                ApplianceHash.add(new OtherAppliance(power, plugSc.nextBoolean(), appRoom));
                break;

            default:
                System.out.println("Введеного типа не существует. Прибор не будет создан.");


        }
        log.info("Вручную добавлен прибор " + power+ "Вт");

    }

    public void addAppliance(Appliance appliance){
        ApplianceHash.add(appliance);
    };
    public void addRoom() {


        System.out.print("Добавьте комнату. ");
        if (!this.roomHash.isEmpty()) {
            System.out.print("Уже имеются: ");
            for (String text : this.roomHash) {
                System.out.print(text + ", ");
            }
        }

        Scanner sc = new Scanner(System.in);
        String roomScanner = sc.nextLine();
        this.roomHash.add(roomScanner);
        log.info("Добавлена комната "+ roomScanner+" через консоль");
    }

    public void addRoomString(String roomName) {

        this.roomHash.add(roomName);
        log.info("Добавлена комната "+ roomName+" через конструктор");

    }

    public void addRoomAuto(int numberOfAutoRooms) {


        for (int i = 1; i <= numberOfAutoRooms; i++) {
            this.roomHash.add(Integer.toString((i)) + "-th room");
        }


        log.info("Автоматически добавленно " + numberOfAutoRooms + " комнат(ы) типа N-th room");


    }

    public String getRoomRandom() {

        Random randomRoom = new Random();

        //this will generate a random number between 0 and HashSet.size - 1
        int randomNumber = randomRoom.nextInt(roomHash.size());

        //get an iterator
        Iterator<String> iterator = roomHash.iterator();

        int currentIndex = 0;
        String randomElement = null;

        //iterate the HashSet
        while (iterator.hasNext()) {

            randomElement = iterator.next();

            //if current index is equal to random number
            if (currentIndex == randomNumber) {
                log.info("Был вызван геттер случайной комнаты, который передал: "+ randomElement);
                return randomElement;
            }

            //increase the current index
            currentIndex++;
        }


        return randomElement;
    }

    public void addApplianceAuto(int numberOfAutoApps) {

        for (int i = 1; i <= numberOfAutoApps; i++) {
            Random random = new Random();
            int typeRandom = random.nextInt(3) + 1;


            switch (typeRandom) {
                case 1:


                    this.ApplianceHash.add(new Lighter(random.nextInt(30), random.nextBoolean(),
                            getRoomRandom(),
                            "RandomAutoColourNumber" + Integer.toString(i)));
                    break;
                case 2:
                    ApplianceHash.add(new CustomerElectronics
                            ("brand in " + getRoomRandom(),
                                    random.nextInt(100), random.nextBoolean(), getRoomRandom()));
                    break;
                case 3:
                    ApplianceHash.add(new OtherAppliance(random.nextInt(3000),
                            random.nextBoolean(), getRoomRandom()));
                    break;


            }


        }
        log.info("Был вызван метод автоматического добавления прибора, который добавил "+numberOfAutoApps+ " прибора(-ов)");
    }

    public void getSortByPower() {
        System.out.println("\nСписок приборов по возрастанию мощности:");
        System.out.println(this.ApplianceHash.toString());
        log.info("Был вызван сортировщик приборов по возрастанию мощностей");
    }

    public void plugAppliance(int power, String room) {
        Iterator<Appliance> iterator = this.ApplianceHash.iterator();
        Iterator<Appliance> iteratorForTest = this.ApplianceHash.iterator();
        int appHashSizeBeforePlugging = this.ApplianceHash.size();

        while (iterator.hasNext()) {
            Appliance ap = iterator.next();

            if (ap.getPowerW() == power && ap.getRoom().equals(room)) {
                iterator.remove();
                System.out.println("Прибор " + ap + " был успешно включен в сеть");
                ap.setPlugged(true);
                ApplianceHash.add(ap);
                log.info("Прибор "+ap+ " включен в сеть методом");
                break;
            }
        }

        if (ApplianceHash.size() < appHashSizeBeforePlugging) {
            throw new IllegalArgumentException("Прибор удален, но новый не добавлен");
        }
        iteratorForTest = this.ApplianceHash.iterator();

        while (iteratorForTest.hasNext()) {


            Appliance apForTest = iteratorForTest.next();

            if (apForTest.getPowerW() == power && apForTest.getRoom().equals(room)
                    && apForTest.isPlugged() == false) {
                throw new IllegalArgumentException("Отключенный прибор или " +
                        "равный ему по введенным параметрам все еще присутствует");
            }


        }


    }

    public void findApplianceInRange(int powerFrom, int powerTo) {


        Iterator<Appliance> iteratorRange = this.ApplianceHash.iterator();
        int counter = 0;
        while (iteratorRange.hasNext()) {
            Appliance apCheck = iteratorRange.next();
            if (apCheck.getPowerW() >= powerFrom && apCheck.getPowerW() <= powerTo) {
                counter++;
                if (counter == 1) {
                    System.out.print("В диапазоне " + powerFrom + "-"
                            + powerTo + "W Найдены следующие приборы:");
                }

                System.out.print(apCheck);


            }


        }


        System.out.println();
        log.info("Метод поиска вызван и в диапазоне " + powerFrom + "-"+powerTo +"W найдено " + counter+ " приборов(-а)");
    }


    public void setAppliance(Appliance appliance) {
        ApplianceHash.add(appliance);
        log.info("Через конструктор добавлен прибор" + appliance);
    }


    public void calculapeConsumption() {
        int numberForList = 1;
        int numberForCalculating = 1;
        double sumPower = 0;

        Iterator<Appliance> calculapeConsumptionIt = this.ApplianceHash.iterator();
        Iterator<Appliance> calculapeConsumptionIt_Calculation = this.ApplianceHash.iterator();

        System.out.println("\nИмеются следующие электроприборы: ");

        while (calculapeConsumptionIt.hasNext()) {
            System.out.print(calculapeConsumptionIt.next() + " -- Номер " + numberForList + " ");
            numberForList++;


        }

        System.out.println("\n\nВведие номера приборов из списка, разделяя пробелом: ");
        Scanner scanIndexesOfAppliance = new Scanner(System.in);

        //scanIndexesOfAppliance.hasNext()

        String lineOfIndexes = scanIndexesOfAppliance.nextLine();

        TreeSet<Integer> listOfIndexes = new TreeSet<Integer>();


        for (String s : lineOfIndexes.split(" ")) {

            listOfIndexes.add(Integer.parseInt(s));
        }


        for (int i : listOfIndexes) {


            while (calculapeConsumptionIt_Calculation.hasNext()) {

                if (i == numberForCalculating) {
                    sumPower = sumPower + calculapeConsumptionIt_Calculation.next().getPowerW();

                    break;

                } else {
                    calculapeConsumptionIt_Calculation.next();

                }
                numberForCalculating++;

            }

        }
        System.out.println("Суммарное энергопотребление приборов №" + listOfIndexes +
                " составляет " + sumPower + "W");
        log.info("Метод подсчета суммарного потребления приборов был вызван для "+ listOfIndexes.size() +" приборов");


    }

    public Set<String> getRoomHash() {
        log.info("Геттер комнат вызван");
        return roomHash;
    }
}

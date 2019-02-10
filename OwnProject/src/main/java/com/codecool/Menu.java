package com.codecool;

import java.util.*;
import java.lang.*;

public class Menu {

    Scanner scanner = new Scanner(System.in);


    //Methods

    public int handleInputInt(String outputMessage) {
        System.out.print(outputMessage + " ");
        int userInput = scanner.nextInt();
        System.out.println();
        return userInput;
    }

    public String handleInputString(String outputMessage) {
        System.out.print(outputMessage + " ");
        String userInput = scanner.next();
        System.out.println();
        return userInput;
    }


    public void start() {
        boolean notQuit = true;
        while (notQuit) {
            System.out.println();
            System.out.println("    1. Car park status!");
            System.out.println("    2. Vehicle shop!");
            System.out.println("    3. Sell Vehicle!");
            System.out.println("    4. Assignment generator!");
            System.out.println("    5. Quit\n\n");
            System.out.println("                          Money:");
            int menuOptions = handleInputInt("Pick one menu option!");

            switch (menuOptions) {
                case 1:
                    System.out.println("Car park status!");
                    //implement!
                    break;
                case 2:
                    System.out.println("Vehicle shop!\n");
                    Random rand = new Random();
                    while (true) {
                        String userInput = handleInputString("What type of vehicle do you want to buy?\n" +
                            "Truck, Car or Bus?\n").toLowerCase();
                        if (userInput.equals("truck")) {
                            String truckInput = handleInputString("What will be your Truck name?");
                            System.out.println("What type of fuel do you want to add?[DIESEL,GAS]");
                            Fuel truckInput2 = Fuel.valueOf(scanner.next().toUpperCase());
                            Vehicles truck = new Vehicles(truckInput, rand.nextInt(27) + 15, truckInput2, rand.nextInt(35) + 15, Craft.TRUCK);
                            System.out.println(truck);
                            Data data = new Data();
                            data.writeObjectToFile("src/main/resources/truck.csv",truck);
                            break;
                        } else if (userInput.equals("car")) {
                            String carInput = handleInputString("What will be your Car name?");
                            System.out.println("What type of fuel do you want to add?[DIESEL,GAS]");
                            Fuel carInput2 = Fuel.valueOf(scanner.next().toUpperCase());
                            Vehicles car = new Vehicles(carInput, rand.nextInt(5) + 10, carInput2, rand.nextInt(1) + 4, Craft.CAR);
                            System.out.println(car);
                            break;
                        } else if (userInput.equals("bus")) {
                            String busInput = handleInputString("What will be your Bus name?");
                            System.out.println("What type of fuel do you want to add?[DIESEL,GAS]");
                            Fuel busInput2 = Fuel.valueOf(scanner.next().toUpperCase());
                            Vehicles bus = new Vehicles(busInput, rand.nextInt(20) + 10, busInput2, rand.nextInt(20) + 10, Craft.BUS);
                            System.out.println(bus);
                            break;
                        } else if (userInput.equals("q")) {
                            break;
                        } else {
                            System.out.println("Wrong Input,if you didn't want to buy press q\n");
                        }
                    }
                    //implement!
                    break;
                case 3:
                    System.out.println("Sell Vehicle!");
                    //implement!
                    break;
                case 4:
                    System.out.println("Assignment generator!");
                    //implement!
                    break;
                case 5:
                    notQuit = false;
                    break;
            }
        }
    }
}

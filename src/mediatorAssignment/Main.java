package mediatorAssignment;

import mediatorAssignment.components.*;
import mediatorAssignment.mediator.Mediator;
import mediatorAssignment.mediator.Crossroads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static boolean goOn = true;
    static List<Road> roads;
    static Mediator crossing;

    public static void main(String[] args) {
        setup();

        do {
            //select a road at random to enter a new car
            int random = (int) (Math.random() * roads.size());
            Car.newCar(roads.get(random));

            for (Road r : roads){
                r.moveAllVehicles();
                System.out.println(r.display());
            }

            crossing.setGreenLight();

            System.out.print("Continue? ");
            String cont = input.nextLine();
            if (cont.equals("no")) goOn = false;
            System.out.println("greenlight: " + crossing.getGreenLight().toString());

        }while (goOn);
    }

    public static void setup(){
        crossing = new Crossroads();
        Road n = new North();
        Road e = new East();
        Road s = new South();
        Road w = new West();

        roads = new ArrayList<>();
        roads.add(n);
        roads.add(w);
        roads.add(e);
        roads.add(s);

        for (Road r: roads){
            crossing.setCrossroadPosition(r, 0);
            crossing.setTrafficLight(r);
            Car.newCar(r);
        }
    }
}

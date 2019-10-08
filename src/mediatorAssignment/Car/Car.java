package mediatorAssignment.Car;

import mediatorAssignment.components.Road;

import java.util.ArrayList;
import java.util.List;

public class Car {

    Road road;
    int position;

    private Car(Road road, int position){
        this.road = road;
        this.position = position;
        road.setPosition(position, this);
    }

    public void moveCar() {
        //check to see if the car is in front of a traffic light
        //if so, check if the light is green: cross
        //else move
        if (road.getMediator().checkCrossing(road, position)){
            if (road.getMediator().checkGreenLight(road, this)) cross();
        } else {
            position--;
            road.setPosition(position, this);
        }
    }

    private void cross() {
        //move onto the crossroads
        position --;
        road.setPosition(position, this);

        //select a random road
        List<Road> roads = new ArrayList<>();
        road.getMediator().getCrossroadMap().forEach((k,v) -> roads.add((Road) k));
        int random = (int) (Math.random() * roads.size());

        //move the car to the random road
        road.crossPosition(this, roads.get(random));
        road = roads.get(random);
    }

    public static void newCar (Road road) {
        //place a new car at the beginning of the road if position is empty: first position has mapKey lastKey
        if (road.getRoadMap().lastEntry().getValue() == null) {
            Car car = new Car(road, road.getRoadMap().lastKey());
            road.setPosition(road.getRoadMap().lastKey(), car);
        }
    }
}

package mediatorAssignment.components;

import mediatorAssignment.mediator.Mediator;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class Road {

    Mediator mediator;
    TreeMap<Integer, Car> roadMap;

    public abstract String display();

    Road(int pos) {
        //The road is initialized with pos positions
        // positive positions before the crossroads, 0 is the crossroads and negative positions after crossroads
        roadMap = new TreeMap();
        for (int i = 0 ; i < pos; i++) {
            roadMap.put(pos/2-i, null);
        }
    }

    public void setMediator (Mediator mediator){
        this.mediator = mediator;
    }

    public void moveAllVehicles(){
        for (int i = roadMap.lastKey(); i >= roadMap.firstKey(); i--) {
            // Check to see if the road position has a vehicle,
            // if so check if the road position before it is empty,
            // then call the vehicle's move method
            if (roadMap.get(i) != null && roadMap.get(i-1) == null) {
               roadMap.get(i).moveCar();
                i--; //do not move the same car twice
           }
        }
    }

    public int signal(){
        //method returns the number of cars waiting for the traffic light
        int signal = 0;
        for (int i = roadMap.lastKey(); i > mediator.getCrossroadPosition(this); i--)  {
            if (positionOccupied(i)) signal++;
        }
        return signal;
    }

    private boolean positionOccupied(int key){
        return roadMap.get(key) != null;
    }

    public void setPosition(int toPosition, Car car) {
        //remove the car from its previous position
        roadMap.replace(toPosition + 1, null);

        //check if the car moves off the map ? move to its new position
        if (roadMap.firstKey() <= toPosition){
            roadMap.replace(toPosition, car);
        }
    }

    public void crossPosition(Car car, Road toRoad){
        roadMap.replace(0, null);
        toRoad.getRoadMap().replace(0, car);
    }

    public TreeMap<Integer, Car> getRoadMap() {
        return roadMap;
    }

    public Mediator getMediator() {
        return mediator;
    }
}

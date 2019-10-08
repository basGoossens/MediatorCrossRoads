package mediatorAssignment.mediator;

import mediatorAssignment.Car.Car;
import mediatorAssignment.components.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crossroads implements Mediator {

    private Map<Road, Integer> crossroadPosition;
    private Map<Road, TrafficLight> trafficLights;
    private Road greenlight;

    public Crossroads(){
        this(null, 0);
    }

    public Crossroads(Road road, int pos){
        crossroadPosition = new HashMap<>();
        trafficLights = new HashMap<>();
        if (road != null) setCrossroadPosition(road, pos);
    }

    @Override
    public void setCrossroadPosition(Road road, int pos) {
        crossroadPosition.put(road, pos);
        road.setMediator(this);
    }

    @Override
    public void setTrafficLight(Road road) {
        TrafficLight light = new TrafficLight(road, crossroadPosition.get(road) + 1, this);
        trafficLights.put(road, light);
    }

    @Override
    public boolean checkCrossing(Road road, int pos) {
        //check to see if a car is in front of a TrafficLight
        return trafficLights.get(road).getPosition() == pos;
    }

    @Override
    public boolean checkGreenLight(Road road, Car car){
        //check to see if the traffic light is green
        boolean check = (road == greenlight);

        //check to see if the crossroads is empty
        List<Road> roads = new ArrayList<>();
        crossroadPosition.forEach((k,v) -> roads.add(k));
        for (Road r : roads) if (r.getRoadMap().get(0) != null && r.getRoadMap().get(0) != car) check = false;
        return check;
    }

    @Override
    public int getCrossroadPosition(Road road) {
        return crossroadPosition.get(road);
    }

    @Override
    public void setGreenLight(){
        //method checks to find the most crowded road
        int max = 0;
        for (Road r : trafficLights.keySet()){
           if (r.signal() > max){
               max = r.signal();

               //set all traffic lights on red, then set the traffic light on the crowded road to green
               for (TrafficLight t : trafficLights.values()) trafficLights.get(r).setGreenLight(false);
               trafficLights.get(r).setGreenLight(true);
               greenlight = r;
           }
       }
    }

    public Map getCrossroadMap(){
        return crossroadPosition;
    }

    @Override
    public Road getGreenLight() {
        return greenlight;
    }
}

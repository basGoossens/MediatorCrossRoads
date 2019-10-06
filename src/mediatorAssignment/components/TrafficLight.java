package mediatorAssignment.components;

import mediatorAssignment.components.Road;
import mediatorAssignment.mediator.Mediator;

public class TrafficLight {

    //TrafficLight is green only for greenLight and red for all others
    private boolean greenLight;
    private Road road;
    private int position;
    private Mediator mediator;

    public TrafficLight() {
    }

    public TrafficLight(Road road, int pos, Mediator mediator) {
        greenLight = false;
        this.road = road;
        this.position = pos;
        this.mediator = mediator;
    }

    public boolean isGreenLight() {
        return greenLight;
    }

    public void setGreenLight(boolean greenLight) {
        this.greenLight = greenLight;
    }

    public int getPosition(){
        return position;
    }
}

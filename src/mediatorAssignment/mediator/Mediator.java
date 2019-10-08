package mediatorAssignment.mediator;

import mediatorAssignment.Car.Car;
import mediatorAssignment.components.Road;

import java.util.Map;

public interface Mediator {

   void setTrafficLight(Road road);
   void setCrossroadPosition(Road road, int pos);

   //The notify methods
   boolean checkCrossing(Road road, int pos);
   boolean checkGreenLight(Road road, Car car);
   int getCrossroadPosition(Road road);
   Map getCrossroadMap();
   Road getGreenLight();

   void setGreenLight();
}

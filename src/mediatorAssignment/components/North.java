package mediatorAssignment.components;

import mediatorAssignment.mediator.Mediator;

import java.util.List;
import java.util.Map;

public class North extends Road{

    public North(){
        super(9);
    }

    @Override
    public String display() {
        StringBuilder display = new StringBuilder();
        int output = 0;
        //display a 0 if the road position is empty, or 1 if occupied by a vehicle

        for (int i = roadMap.size()/2; i > 0; i--) {
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append("     |").append(output).append("|");
            output = (roadMap.get(-i) == null) ? 0 : 1;
            display.append(output).append("|\n");
        }

        output = (roadMap.get(0) == null) ? 0 : 1;
        display.append("______ ").append(output).append(" ______");

        return display.toString();
    }

}

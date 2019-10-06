package mediatorAssignment.components;

import mediatorAssignment.mediator.Mediator;

import java.util.List;

public class South extends Road {

    public South(){
        super(9);
    }

    @Override
    public String display() {
        StringBuilder display = new StringBuilder();
        int output;
        //display a 0 if the road position is empty, or 1 if occupied by a vehicle

        output = (roadMap.get(0) == null) ? 0 : 1;
        display.append("¯¯¯¯¯¯ ").append(output).append(" ¯¯¯¯¯¯\n");

        for (int i = 1; i <= roadMap.size()/2; i++) {
            output = (roadMap.get(-i) == null) ? 0 : 1;
            display.append("     |").append(output).append("|");
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append(output).append("|\n");
        }

        return display.toString();
    }
}
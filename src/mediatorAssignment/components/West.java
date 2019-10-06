package mediatorAssignment.components;

import mediatorAssignment.mediator.Mediator;

import java.util.List;

public class West extends Road {

    public West() {
        super(11);
    }

    @Override
    public String display() {
        StringBuilder display = new StringBuilder();
        int output = 0;
        //display a 0 if the road position is empty, or 1 if occupied by a vehicle

        for (int i = -roadMap.size()/2; i < 0; i++) {
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append(output);
        }
        output = (roadMap.get(0) == null) ? 0 : 1;
        display.append("  ").append(output).append("\n");

        for (int i = roadMap.size()/2; i > 0; i--) {
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append(output);
        }
        return display.toString();
    }
}

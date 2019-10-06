package mediatorAssignment.components;


public class East extends Road {

    public East(){
        super(11);
    }

    @Override
    public String display() {
        StringBuilder display = new StringBuilder();
        int output = 0;
        //display a 0 if the road position is empty, or 1 if occupied by a vehicle

        output = (roadMap.get(0) == null) ? 0 : 1;
        display.append("       ").append(output).append(" ");

        for (int i = 1; i <= roadMap.size()/2; i++) {
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append(output);
        }
        display.append("\n         ");
        for (int i = -1; i >= -roadMap.size()/2; i--) {
            output = (roadMap.get(i) == null) ? 0 : 1;
            display.append(output);
        }
        return display.toString();
    }
//    @Override
//    public String display() {
//        StringBuilder display = new StringBuilder();
//        display.append("       ").append(roadMap.get(0))
//                .append(roadMap.get(1)).append(roadMap.get(2)).append(roadMap.get(3)).append(roadMap.get(4)).append(roadMap.get(5) + "\n");
//        display.append("        ").append(roadMap.get(-1)).append(roadMap.get(-2)).append(roadMap.get(-3)).append(roadMap.get(-4)).append(roadMap.get(-5));
//        return display.toString();
//    }
}

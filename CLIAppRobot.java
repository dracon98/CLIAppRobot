import java.util.Arrays;
import java.util.List;


public class CLIAppRobot{
  public static void main(String[] args){
    // parameter
    int x = 0; // x location (mapping)
    int y = 0; // y location (mapping)
    int state = 0; // for the direction of the robot || 0 = normal (front), 1 = right, 2 = back, 3 = left
    String output = "";

    // remove the first and the last quatation
    String text = args[0].substring(1, args[0].length() - 1);
    // split comma into array list
    List<String> items = Arrays.asList(text.split("\\s*,\\s*"));
    StringBuilder sb = new StringBuilder();
    // combining array into a single StringBuilder
     for (String ch : items) {
       String cd = ch.substring(0, 1);
       cd = cd.toUpperCase();
        if (cd.equals("R") || cd.equals("L") || cd.equals("F") || cd.equals("B")){
           String number = ch.substring(1, ch.length());

           if (isNumeric(number)){
               System.out.println("number: " + number);
               int num = Integer.parseInt(number);
               if (cd.equals("F")){
                 //from 0 to the <number>, the robot move forward depending on the state of the robot
                 for (int i = 0; i < num; i++){
                   // front/ north
                   if (state == 0){
                     y = y + 1;
                   }
                   // right/ east
                   else if (state == 1){
                     x = x + 1;
                   }
                   // left/ west
                   else if (state == 2){
                     y = y - 1;
                   }
                   // down/ bottom/ south
                   else if (state == 3){
                     x = x - 1;
                   }
                 }
               }
               // the same with forward but the way it moves is completely opposite
               else if (cd.equals("B")){
                 for (int i = 0; i < num; i++){
                   if (state == 0){
                     y = y - 1;
                   }
                   else if (state == 1){
                     x = x - 1;
                   }
                   else if (state == 2){
                     y = y + 1;
                   }
                   else if (state == 3){
                     x = x + 1;
                   }
                 }
               }
               else if (cd.equals("R")){
                 // the same as Forward and Backward but in here, the state is added because its clockwise
                 for (int i = 0; i < num; i++){
                   state = state + 1;
                 }
                 // since the state only has 4 side which are 0,1,2,3
                 // if state > 3 this will do a loop
                 while (state > 3){
                   // in here, -4 means that the state will become 0 which is the front
                   state = state - 4;
                 }
               }
             }
             else{
               output = "Number Error";
               break;
             }
           }
        else{
          output = "Command Error";
          break;
        }
      }
    System.out.println("input: " + args[0]);
    System.out.println("output: " + "("+ x +", "+ y +")" );
  }
  // public static function that check string is Integer
  public static boolean isNumeric(String strNum) {
    // try first
    try {
        int d = Integer.parseInt(strNum);
    }
    // if try failed
    catch (NumberFormatException | NullPointerException nfe) {
        return false;
    }
    return true;
  }

}

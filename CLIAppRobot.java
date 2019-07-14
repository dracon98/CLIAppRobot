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
       cd.toUpperCase();
        if (cd.equals("R") || cd.equals("L") || cd.equals("F") || cd.equals("B")){
           System.out.println("input: " + cd);
        }
        else{
          output = "Command Error";
          break;
        }
     }
    System.out.println("input: " + output);
  }
}

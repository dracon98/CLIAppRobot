import java.util.Arrays;
import java.util.List;


public class CLIAppRobot{
  public static void main(String[] args){
    // remove the first and the last quatation
    String text = args[0].substring(1, args[0].length() - 1);
    // split comma into array list
    List<String> items = Arrays.asList(text.split("\\s*,\\s*"));
    StringBuilder sb = new StringBuilder();
    // combining array into a single StringBuilder
     for (String ch : items) {
       sb.append(ch);
     }
    System.out.println("input: " + sb);
  }
}

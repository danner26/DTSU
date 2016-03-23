import TerminalIO.KeyboardReader;
import java.util.ArrayList;

/**
 * This is a simple class that takes a string inputted, then reverses it. ex: input > "Hello" output > "olleH"
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.0.0}
 */
public class Reverse
{
    public static void main(String args[]) {
        KeyboardReader reader = new KeyboardReader();
        
        String input = reader.readLine("\fEnter the string you'd like to reverse:     ");
        ArrayList<String> letters = new ArrayList<String>();
        
        for (int i = 0; i < input.length(); i++) {
            letters.add(input.substring(i, i+1));
        }
        
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + letters.get(i);
        }
        System.out.println("Your reversed string is: " +reversed);
    }
}

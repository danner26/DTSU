import java.util.ArrayList;
import TerminalIO.KeyboardReader;

/**
 * This is a simple class that will determin if an inputted word is a palindorme and output the result to the console.
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.0.0}
 */
public class Palindrome
{
    public static void main(String args[]) {
        KeyboardReader reader = new KeyboardReader();
        
        String input = reader.readLine("\fInput your possible plaindrome here:      ");
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < input.length(); i++) {
            list.add(input.substring(i, i+1));
        }
        
        String reversed = "";
        
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + list.get(i);
        }
        
        if (input.equalsIgnoreCase(reversed)) {
            System.out.println(input + " and " + reversed + " are palindromes.");
        } else {
            System.out.println(input + " and " + reversed + " are not palindromes.");
        }
    }
}

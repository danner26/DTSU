import TerminalIO.KeyboardReader;
import java.util.ArrayList;

/**
 * This is a simple word count program that accepts string input, and outputs to the console a word count.
 * 
 * @DTSU Development Team - Daniel Anner
 * @v.1.0.0
 */
public class Tracker
{
    public static void main(String args[]) {
        KeyboardReader reader = new KeyboardReader();
        ArrayList<String> words = new ArrayList<String>();
        String paragraph = reader.readLine("\fPlease type your paragraph here:    ");
        int wordCount = 0;
        int tempSpace = 0;
        
        while (paragraph.length() > 1) {
            String temp = paragraph.substring(0, 1);
            for (int i = 1; !temp.contains(" "); i++) {
                temp = paragraph.substring(0, i);
                tempSpace = i;
                if (paragraph.length() <= tempSpace) {
                    break;
                }
            }
            wordCount++;
            paragraph = paragraph.substring(tempSpace);
        }
        
        System.out.println("You have a total of " + wordCount + " words in the paragraph");
    }
}

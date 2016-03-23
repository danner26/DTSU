import TerminalIO.KeyboardReader;
import java.util.*;
public class lab6
{
        public static void main(String args[])
    {
          KeyboardReader reader = new KeyboardReader();
          int[] nines = {9,18,27,36,45,54,63,72,81,90,99,108};
          int multiple = reader.readInt("What multiple of 9 would you like?     ");
          System.out.print("9 times " + multiple + " is: ");
          multiple -= 1;
          System.out.print(nines[multiple]);
     }
}
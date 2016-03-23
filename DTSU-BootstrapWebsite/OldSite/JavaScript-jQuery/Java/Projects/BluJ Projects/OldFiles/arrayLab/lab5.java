import TerminalIO.*;
import java.util.*;
public class lab5
{
    public static void main(String args[])
    {
        int[] random = {0,0,0,0,0};
        int spot = 1, val = 0;
        for (int i = 0; i < random.length; i++)
        {
            random[i] = ((int) (Math.random() * 10) + 1);
        }
        for (int i = 0; i < random.length; i++)
        {
            val = (random[i] * random[i]);
            System.out.println("The square of random number " + spot + " is:  " + val);
            spot++;
        }
    }
}
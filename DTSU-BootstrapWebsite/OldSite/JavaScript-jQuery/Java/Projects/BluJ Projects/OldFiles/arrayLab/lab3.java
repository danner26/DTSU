import TerminalIO.*;
import java.util.*;
public class lab3
{
    public static void main(String args[])
    {
        KeyboardReader reader = new KeyboardReader();
        double[] spent = {0.0, 0.0, 0.0, 0.0};
        int person = 1;
        double sum = 0.0;
        for (int i = 0; i < spent.length; i++)
        {
            spent[i] = reader.readDouble("Please enter final cost for person " + person + ":    ");
            person++;
        }
        sum = ((double) spent[0] + spent[1] + spent[2] + spent[3]);
        System.out.println("The total spent on your family was " + sum + " dollars.");
    }
}
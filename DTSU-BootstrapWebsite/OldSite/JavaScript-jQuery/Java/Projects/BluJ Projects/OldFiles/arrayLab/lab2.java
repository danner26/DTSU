import TerminalIO.*;
import java.util.*;
public class lab2
{
    public static void main(String args[])
    {
        KeyboardReader reader = new KeyboardReader();
        boolean[] values = {true,true,true};
        String tempValue;
        int index = 1;
        boolean allValue;
        for (int i = 0; i < values.length; i++)
        {
            tempValue = reader.readLine("Please enter value " + index + ":    ");
            index++;
            if (tempValue.equalsIgnoreCase("true"))
                values[i] = true;
            else if (tempValue.equalsIgnoreCase("false"))
                values[i] = false;
            else
            {
                System.out.println("Please restart the program. Invalid value entered");
                break;
            }
        }
        if ( values[0] == true && values[1] == true && values[2] == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
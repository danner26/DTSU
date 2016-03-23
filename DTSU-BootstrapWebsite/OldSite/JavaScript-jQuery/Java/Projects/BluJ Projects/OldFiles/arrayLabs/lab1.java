import TerminalIO.*;
import java.util.*;
public class lab1
{
    public static void main(String args[])
    {
        KeyboardReader reader = new KeyboardReader();
        String[] names = {"","","","",""};
        int index = 1;
        for (int i = 0; i < names.length; i++)
        {
            index = i+1;
            names[i] = reader.readLine("Please enter name " + index + ":    ");
        }
        
        for (int i = 0; i < names.length; i++)
        {
            System.out.print(names[i] + " ");
        }
    }
}
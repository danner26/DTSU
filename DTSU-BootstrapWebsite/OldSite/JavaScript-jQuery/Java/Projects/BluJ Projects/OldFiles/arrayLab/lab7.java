import TerminalIO.KeyboardReader;
import java.util.*;
public class lab7
{
        public static void main(String args[])
    {
          KeyboardReader reader = new KeyboardReader();
          String[] invitees;
          int count = 1, YN = 0;
          String checkName;
          int num = reader.readInt("How many people are invited?    ");
          invitees = new String[num];
          for (int i = 0; i < invitees.length; i++)
          {
              invitees[i] = reader.readLine("What is person number " + count + "'s name?    ");
              count++;
          }
          checkName = reader.readLine("Who would you like to check for?     ");
          for (int i = 0; i < invitees.length; i++)
          {
              if (invitees[i].equalsIgnoreCase(checkName))
              {
                  System.out.print("INVITED");
                  YN = 1;
                  break;
              }
          }
          if (YN != 1)
              System.out.println("NOT INVITED");
     }
}
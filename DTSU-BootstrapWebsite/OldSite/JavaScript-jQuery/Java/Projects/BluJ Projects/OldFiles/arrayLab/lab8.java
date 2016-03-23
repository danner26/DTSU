import TerminalIO.KeyboardReader;
import java.util.*;
public class lab8
{
        public static void main(String args[])
    {
          KeyboardReader reader = new KeyboardReader();
          int[] binary;
          int binaryNum = 0;
          double testVal = 0;
          //int decimalValue;
          for (int i = 0; i < 11; i++)
          {
              binaryNum = ((int)((Math.random() * 10) + 1));
              if (binaryNum < 11)
                  break;
              else
                continue;
          }
          binary = new int[binaryNum];
          for (int i = 0; i < binary.length; i++)
          {
              testVal = Math.random();
              if (testVal >= .50)
                  binary[i] = 1;
              else
                  binary[i] = 0;
          }
          for (int i = 0; i < binary.length; i++)
          {
              System.out.print(binary[i]);
          }
          System.out.println('\n');
          //decimalValue = convertToDecimal(binary);
          //int[] powerVal;
          int sum=0;
          for (int i = 0; i < binary.length; i++)
          {
              if (binary[i] == 1)
              {
                 //System.out.println("Val:   " + Math.pow(2, binary.length - 1 - i));
                 sum += Math.pow(2, binary.length - 1 - i);
              }
          }
          System.out.println("The value of the binary number in decimal form is:    " + sum);
     }
     //public double convertToDecimal(int[] bin)
     //{
     //    
     //}
}
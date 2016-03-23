import TerminalIO.KeyboardReader;
import java.util.Random;
/**
 * Write a description of class test1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test1
{
    	public static void main(String args[])
	{
	  KeyboardReader reader = new KeyboardReader();
	  Random generator = new Random();
	  for (int i = 1; i <= 1; i++)
	  {
	      System.out.print(generator.nextInt(11) + " ");
	      int num = reader.readInt("Hello");
	  }
	}

}

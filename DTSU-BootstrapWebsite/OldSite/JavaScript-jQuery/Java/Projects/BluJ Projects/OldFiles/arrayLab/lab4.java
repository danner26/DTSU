import TerminalIO.*;
import java.util.*;
public class lab4
{
    public static void main(String args[])
    {
        KeyboardReader reader = new KeyboardReader();
        double[] grades = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        int grade = 1;
        double sum = 0.0, avg = 0.0;
        for (int i = 0; i < grades.length; i++)
        {
            grades[i] = reader.readDouble("Please enter grade " + grade + ":    ");
            grade++;
        }
        sum = (grades[0] + grades[1] + grades[2] + grades[3] + grades[4] + grades[5] + grades[6] + grades[7]); 
        avg = (sum / 8);
        System.out.print("The average is " + avg +".");
    }
}
import TerminalIO.*;
import java.util.*;
public class testStudent
{
    public static void main(String [] args)
    {
        KeyboardReader reader = new KeyboardReader();
        String sName;
        double t1, t2, t3;
        int numOfStudents = reader.readInt("How many students would you like to create?  ");
        Student[] group = new Student[numOfStudents];
        for (int i = 0; i < group.length; i++)
        {
            sName = reader.readLine("What is the students name?  ");
            t1 = reader.readDouble("Test 1's score:     ");
            t2 = reader.readDouble("Test 2's score:     ");
            t3 = reader.readDouble("Test 3's score:     ");
            group[i] = new Student(sName, t1, t2, t3);
        }
        //System.out.println(s1.getName() + " " + s1.getTest(1) + " " + s1.getTest(2) + " " + s1.getTest(3));
        //System.out.println(group[0].getName());
        for (int i = 0; i < group.length; i++)
            System.out.println(group[i].getName() + " " + group[i].getTest(1) + " " + group[i].getTest(2) + " " + group[i].getTest(3));
        double sum = 0;
        for (int i = 0; i < group.length; i++)
            sum += group[i].calcAvg();
        System.out.println("The sum of all students is: " + sum/group.length);
    }
}

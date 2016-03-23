import TerminalIO.*;
import java.util.*;
public class Student
{
    private String name;
    private double test1;
    private double test2;
    private double test3;
    
    public Student()
    {
        name = "";
        test1 = 0.0;
        test2 = 0.0;
        test3 = 0.0;
    }
    public Student(String n, double t1, double t2, double t3)
    {
        name = n;
        test1 = t1;
        test2 = t2;
        test3 = t3;
    }
    
    public double calcAvg()
    {
        return ((test1 + test2 + test3) / 3);
    }
    public String getName()
    {
        return name;
    }
    public double getTest(int t)
    {
        if ( t == 1 )
            return test1;
        else if ( t == 2 )
            return test2;
        return test3;
    }
}

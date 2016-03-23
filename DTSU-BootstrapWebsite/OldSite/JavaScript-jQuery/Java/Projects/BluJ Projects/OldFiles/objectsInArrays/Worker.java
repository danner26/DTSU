
public class Worker
{
    private String name;
    private double hours;
    private double hourlyWage;
    
    public Worker()
    {
        name = "";
        hours = 0.0;
        hourlyWage = 0.0;
    }
    public Worker(String n, double h, double hW)
    {
        name = n;
        hours = h;
        hourlyWage = hW;
    }
    
    public double weeklyWage()
    {
        return (hours * hourlyWage);
    }
    public double salary()
    {
        return ((hours * hourlyWage) * 52);
    }
}

import TerminalIO.*;
public class testWorker
{
    public static void main(String [] args)
    {
        KeyboardReader reader = new KeyboardReader();
        int workers = reader.readInt("How many workers are being created?   ");
        String[] names = new String[workers];
        String name;
        double hours, hourlyWage;
        Worker[] group = new Worker[workers];
        for (int i = 0; i < group.length; i++)
        {
            name = reader.readLine("Worker " + (i+1) + "'s name:     ");
            names[i] = name;
            hours = reader.readDouble("Worker " + (i+1) + "'s hours a week:     ");
            hourlyWage = reader.readDouble("Worker " + (i+1) + "'s hourly wage:     ");
            group[i] = new Worker(name, hours, hourlyWage);
        }
        for (int i = 0; i < group.length; i++)
            System.out.println("Worker " + (i+1) + ":  " + group[i].weeklyWage() + " " + group[i].salary());
        double sum = 0.0;
        for (int i = 0; i < group.length; i++)
            sum += group[i].salary();
        sum = (sum/group.length);
        System.out.println("The average sum is: " + sum);
        int index = 0;
        double highSalary = group[0].salary();
        for (int i = 1; i < group.length; i++)
        {
            if ( group[i].salary() > highSalary )
            {
                index = i;
                highSalary = group[i].salary();
            }
        }
        System.out.println(names[index] + " has the highest salary of " + highSalary + " dollars.");
    }
}

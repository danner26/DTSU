import TerminalIO.KeyboardReader;
import java.util.Random;

public class unluckySevens
{
    public static void main(String args[])
    {
        System.out.println('\f');
        KeyboardReader reader = new KeyboardReader();
        Random generator = new Random();
        int die1, die2, userGuess, sum;
        double wager, startAmount, userAmount, finalAmount;
        String enter, username;
        username = reader.readLine("What is your name user?  ");
        startAmount = reader.readDouble(username + ", How much money would you like to start with?  ");
        userAmount = startAmount;
        System.out.println("Okay " + username +", you will start with " + startAmount + " dollars.");
        while (userAmount > 0)
        {
            wager = reader.readDouble("How much would you like to wager?    ");
            if (wager > userAmount)
                System.out.println("You do not have enough money");
            else
            {
                userGuess = reader.readInt(username + ", please choose a sum of the two dice you wish to guess:     ");
              if (userGuess < 2 || userGuess > 12)
              {
                  System.out.println("Error. Please only choose between 2 and 12");
              }
              else if (userGuess != 7)
                {
                die1 = generator.nextInt(6) + 1;
                die2 = generator.nextInt(6) + 1;
                sum = die1 + die2;
                if (sum != 7)
                {
                   if (userGuess != sum)
                    {
                        userAmount -= wager;
                        System.out.println("You rolled a " + sum + ".");
                        System.out.println(username + ", you lost! Your total is now " + userAmount + ".");
                    }
                    else
                    {
                     if (sum == 2 || sum == 12)
                     {
                         wager *= 2.2;
                         userAmount += wager;
                         System.out.println("You rolled a " + sum + ".");
                         System.out.println(username + ", You won! Your new total is " + userAmount);
                     }
                     else if (sum == 3 || sum == 11)
                     {
                         wager *= 2.2;
                         userAmount += wager;
                         System.out.println("You rolled a " + sum + ".");
                         System.out.println(username + ", You won! Your new total is " + userAmount);
                     }
                     else if (sum == 4 || sum == 10)
                     {
                         wager *= 2.2;
                         userAmount += wager;
                         System.out.println("You rolled a " + sum + ".");
                         System.out.println(username + ", You won! Your new total is " + userAmount);
                     }
                     else if (sum == 5 || sum == 9)
                     {
                         wager *= 2.2;
                         userAmount += wager;
                         System.out.println("You rolled a " + sum + ".");
                         System.out.println(username + ", You won! Your new total is " + userAmount);
                     }
                     else if (sum == 6 || sum == 8)
                     {
                         wager *= 2.2;
                         userAmount += wager;
                         System.out.println("You rolled a " + sum + ".");
                         System.out.println(username + ", You won! Your new total is " + userAmount);
                     }
                   }
                }
                else
                {
                    finalAmount = userAmount; // sets final amount to the value of the user amount
                    userAmount = 0; //sets user amount to 0
                    System.out.println("You rolled a " + sum + ".");
                    if (startAmount > finalAmount)
                        System.out.println("You have lost with a final total of " + finalAmount + " dollars. You started with " + startAmount + " dollars.");
                    else if (startAmount == finalAmount)
                        System.out.println("You broke even! Nice try. Why dont you try again! ;)");
                    else
                        System.out.println("You won! With a final total of " + finalAmount + " dollars. You started with " + startAmount + " dollars.");
                    break; //ends while loop
                }
              }
              else
                  System.out.println("Please enter a number other than 7");
            }
            enter = reader.readLine("To continue please press 'ENTER'");
            System.out.println("\f");
        }
        
    }
}

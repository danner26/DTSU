import TerminalIO.KeyboardReader;
/*
 * By: Daniel Anner
 * 02/13/2014
 */
public class loveCalculator
{
    public static void main(String args[])
    {
        KeyboardReader reader = new KeyboardReader();
        String youLike, mutual, love, beTogether, together, yourName, theirName;
        int percent;
        boolean error;
        yourName = reader.readLine("Hello! What is your name?     ");
        System.out.println("Welcome " + yourName + "! Now we will being the Valentine's Love Chances Calculator!");
        theirName = reader.readLine("What is your partners name?      ");
        System.out.println("Aw! " + theirName + " and " + yourName + " sound like a cute couple!");
        together = reader.readLine("Are you two currently together? (yes or no)   ");
        percent = 25; //25
         error = false;
        while (error != true)
        {
            if (together.equalsIgnoreCase("yes"))
            {
              percent += 20; //45
              System.out.println(theirName + " and " + yourName + " are together. Good to know!");
              youLike = reader.readLine("Do you 'like' " + theirName + ", " + yourName + "? (yes or no)      ");
              System.out.println('\n');
              if (youLike.equalsIgnoreCase("yes"))
              {
                  percent += 15; // 60
                  System.out.println("Awwww. You like " + theirName + "!");
                  mutual = reader.readLine("Do they mutually like you? (yes or no)       ");
                  System.out.println('\n');
                  if (mutual.equalsIgnoreCase("yes"))
                  {
                      percent += 10; //70
                      System.out.println("That is great the feeling is mutual!");
                      love = reader.readLine("Ok " + yourName + ", Do you love " + theirName + "? (yes or no)     ");
                      System.out.println('\n');
                      if (love.equalsIgnoreCase("yes"))
                      {
                          percent += 15; //85
                          System.out.println("That is great! I hope your relationship lasts a long time.");
                          mutual = reader.readLine("Ok " + yourName + ", is the feeling mutual? (yes or no)     ");
                          System.out.println('\n');
                          if (mutual.equalsIgnoreCase("yes"))
                          {
                              percent += 10; //95
                              System.out.println("That is great the feeling is mutual!");
                              System.out.println('\n');
                              break;
                          }
                          else if (mutual.equalsIgnoreCase("no"))
                          {
                              percent += 5; // 90
                              System.out.println("That is okay! This happens all the time and im sure you will be fine!");
                              System.out.println('\n');
                              break;
                          }
                          else
                          {
                              System.out.println("Sorry you entered an incorrect value :( please try again!");
                              System.out.println('\n');
                              error = true;
                              break;
                          }
                      }
                      else if (love.equalsIgnoreCase("no"))
                      {
                          percent += 5; //75
                          System.out.println("Okay that is fine! It happens all the time. Keep trying my friend!");
                          System.out.println('\n');
                          break;
                      }
                      else
                      {
                          System.out.println("Sorry you entered an incorrect value :( please try again!");
                          System.out.println('\n');
                          error = true;
                          break;
                      }
                  }
                  else if (mutual.equalsIgnoreCase("no"))
                  {
                      percent += 3; //48
                      System.out.println("If " + theirName + " doesn't like you, then why are you still together?");
                      System.out.println('\n');
                      break;
                  }
                  else
                  {
                      System.out.println("Sorry you entered an incorrect value :( please try again!");
                      System.out.println('\n');
                      error = true;
                      break;
                  }
              }
              else if (youLike.equalsIgnoreCase("no"))
              {
                  System.out.println("Then why are you still together? It seems you will not go very far in your relationship.");
                  System.out.println('\n');
                  break;
              }
              else
              {
                  System.out.println("Sorry you entered an incorrect value :( please try again!");
                  System.out.println('\n');
                  error = true;
                  break;
              }
            }
            else if (together.equalsIgnoreCase("no"))
            {
              percent += 10; //30
              System.out.println(theirName + " and " + yourName + " are not together. Good to know.");
              youLike = reader.readLine("Do you 'like' " + theirName + ", " + yourName + "? (yes or no)      ");
              System.out.println('\n');
              if (youLike.equalsIgnoreCase("yes"))
              {
                  percent += 15; // 45
                  System.out.println("Awwww. You like " + theirName + "!");
                  mutual = reader.readLine("Do they mutually like you? (yes or no)       ");
                  System.out.println('\n');
                  if (mutual.equalsIgnoreCase("yes"))
                  {
                      percent += 10; //55
                      System.out.println("That is great the feeling is mutual!");
                      love = reader.readLine("Ok " + yourName + ", Do you love " + theirName + "? (yes or no)     ");
                      System.out.println('\n');
                      if (love.equalsIgnoreCase("yes"))
                      {
                          percent += 15; //85
                          System.out.println("That is great! I hope you get to experiance a relationship with " + theirName + ".");
                          mutual = reader.readLine("Ok " + yourName + ", is the feeling mutual? (yes or no)     ");
                          System.out.println('\n');
                          if (mutual.equalsIgnoreCase("yes"))
                          {
                              percent += 6; //91
                              System.out.println("That is great the feeling is mutual!");
                              System.out.println('\n');
                              break;
                          }
                          else if (mutual.equalsIgnoreCase("no"))
                          {
                              percent += 1; //86
                              System.out.println("That is okay! This happens all the time and im sure you will be fine! Just keep trying.");
                              System.out.println('\n');
                              break;
                          }
                          else
                          {
                              System.out.println("Sorry you entered an incorrect value :( please try again!");
                              System.out.println('\n');
                              error = true;
                              break;
                          }
                      }
                      else if (love.equalsIgnoreCase("no"))
                      {
                          percent += 5; //60
                          System.out.println("Okay that is fine! It happens all the time. Keep trying my friend!");
                          mutual = reader.readLine("Does " + theirName + " love you? (yes or no)      ");
                          System.out.println('\n');
                          if (mutual.equalsIgnoreCase("yes"))
                          {
                              percent += 10; //70
                             System.out.println("That is great! Hopefully in time you will love " + theirName + " too.");
                             System.out.println('\n');
                             break;
                          }
                           else if (mutual.equalsIgnoreCase("no"))
                          {
                               System.out.println("That is fine! Now that is the end of the program!");
                               System.out.println('\n');
                               break;
                           }
                           else
                           {
                               System.out.println("Sorry you entered an incorrect value :( please try again!");
                               System.out.println('\n');
                               error = true;
                               break;
                           }
                      }
                      else
                      {
                          System.out.println("Sorry you entered an incorrect value :( please try again!");
                          System.out.println('\n');
                          error = true;
                          break;
                      }
                  }
                  else if (mutual.equalsIgnoreCase("no"))
                  {
                      System.out.print("That is totally fine! That is the end of the program!");
                      System.out.println('\n');
                      break;
                  }
                  else
                  {
                      System.out.println("Sorry you entered an incorrect value :( please try again!");
                      System.out.println('\n');
                      error = true;
                      break;
                  }
              }
              else if (youLike.equalsIgnoreCase("no"))
              {
                  System.out.println("Then why do you want to be with them?");
                  System.out.println('\n');
                  break;
              }
              else
              {
                  System.out.println("Sorry you entered an incorrect value :( please try again!");
                  System.out.println('\n');
                  error = true;
                  break;
              }
            }
            else
            {
               System.out.println("Sorry you entered an incorrect value :( please try again!");
               System.out.println('\n');
               error = true;
               break;
            }
        }
        if (error == false)
            System.out.println("Okay " + yourName + ", according to my calculations, " + theirName + " and you, have a " + percent + " percent chance of success. \n Have a great Valentine's Day!! <3 \n Thank you for using our calculator! Have a great day and best of luck!");
        else
            System.out.println("It seems an error occured! Please restart the program!");
    }
}
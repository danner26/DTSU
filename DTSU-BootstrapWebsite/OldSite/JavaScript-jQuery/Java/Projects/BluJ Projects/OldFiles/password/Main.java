import TerminalIO.KeyboardReader;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Main
{
     public static void main(String args[])
     {
          KeyboardReader reader = new KeyboardReader();
          Timer timer = new Timer();
          int choice;
          String enter = "";
          boolean numVal = false, known = true, caps = false, punctuation = false, consec = true, working = true, running = true;
          Password password = new Password();
          System.out.println("Welcome to the Password Creator Ultimate v1.0 !");
          while (running = true)
          {
              System.out.println("Please choose an option to begin");
              System.out.println("1. Create New Password and Check");
              System.out.println("2. Exit and Clear Screen");
              choice = reader.readInt();
              if (choice == 1)
              {
                  working = true;
                  System.out.println("Okay, so let's create a password!");
                  password.setPassword(reader.readLine("First enter a password:       "));
                  while (working = true)
                  {
                      while (password.empty() == true)
                      {
                          password.setPassword(reader.readLine("Error. Blank password. Please Enter a password:       "));
                      }
                      while (password.indexOfSpace() != -1)
                      {
                           password.setPassword(reader.readLine("Error. No spaces allowed in the password:       "));
                      }
                      while (password.lengthOfPassword(password.getPassword()) <= 7)
                      {
                          password.setPassword(reader.readLine("Error. Please enter a password with at least 8 characters:       "));
                      }
                      while (known != false)
                      {
                          known = password.containsKnownWord();
                          if (known == false)
                              break;
                          else
                              password.setPassword(reader.readLine("Error. Please try a less common password:        "));   
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      while (numVal != true)
                      {
                          numVal = password.containsNum();
                          if (numVal == true)
                              break;
                          else
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 number:        "));
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      while (caps != true)
                      {
                          caps = password.containsCap();
                          if (caps == true)
                              break;
                          else
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 capital letter:        "));
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      while (punctuation != true)
                      {
                          punctuation = password.containsPunc();
                          if (punctuation == true)
                              break;
                          else
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 punctuation(!, @, #, $, %, ^, &, *, (, ), ,, ., /, :, ;, ', [, ], {, }, -, =, +, _, |):       "));
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      while (consec != false)
                      {
                          consec = Processes.containConsecCaps(password.getPassword());
                          if (consec == true)
                          {
                              password.setPassword(reader.readLine("Error. Please enter a password with no consecutive letters:        "));
                              continue;
                          }
                          else
                              break;
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      working = false;
                      break;
                  }
                  System.out.println("Congrats! You have created a sucessful password!" + '\n' + "Your password is: " + password.getPassword());
              }                                                                                                           
              else if (choice == 2)
              {
                  System.out.println("Please come back soon!");
                  int interval = 10;
		          long startTime = System.currentTimeMillis() / 1000;
                  long endTime = startTime + interval;
            	  while (System.currentTimeMillis() / 1000 < endTime) {
               	      while (startTime != System.currentTimeMillis() / 1000) {
            		      startTime += 1;
            			  if (endTime - startTime > 1)
            			  	  System.out.println(endTime - startTime + " seconds remaining.");
            			  else if (endTime - startTime == 1) {
            				  System.out.println("1 second remaining.");
            			  }
            		  }
            	  }
            	  System.out.print('\f');
            	  break;
              }
              else
              {
                  System.out.println("It seems you have entered an illegal character. Please try again!");
                  enter = reader.readLine("Please press enter to continue");
                  System.out.println('\f');
                  continue;
              }
          }
     }
}
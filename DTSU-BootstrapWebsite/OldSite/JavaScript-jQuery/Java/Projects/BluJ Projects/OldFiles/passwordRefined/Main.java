import TerminalIO.KeyboardReader;
public class Main
{
     public static void main(String args[])
     {
          KeyboardReader reader = new KeyboardReader();
          //Timer timer = new Timer();
          int choice;
          String enter = "";
          boolean working = true, running = true;
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
                      while (password.containsKnownWord() == true)
                      {
                              password.setPassword(reader.readLine("Error. Please try a less common password:        "));   
                      }
                      while (password.containsNum() != true)
                      {
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 number:        "));
                      }
                      System.out.println("Okay, so your password is: " + password.getPassword());
                      while (password.containsCap() != true)
                      {
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 capital letter:        "));
                      }
                      while (password.containsPunc() != true)
                      {
                              password.setPassword(reader.readLine("Error. Please enter a password with at least 1 punctuation(!, @, #, $, %, ^, &, *, (, ), ,, ., /, :, ;, ', [, ], {, }, -, =, +, _, |):       "));
                      }
                      while (Processes.containConsecCaps(password.getPassword()) != false)
                      {
                              password.setPassword(reader.readLine("Error. Please enter a password with no consecutive letters:        "));
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
		          long startTime = System.currentTimeMillis() / 1000;
                  long endTime = startTime + 10;
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
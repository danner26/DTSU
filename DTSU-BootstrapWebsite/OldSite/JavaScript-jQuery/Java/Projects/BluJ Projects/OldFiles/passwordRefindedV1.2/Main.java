import javax.swing.*;
import java.awt.*;
import TerminalIO.*;
import java.awt.event.*;
public class Main extends JFrame //implements ActionListener
{
    static JFrame frame;
    static Container pane;
    static JLabel titleL, oldL, currentL, enterL;
    static JTextField passwordTF;
    static JButton submit;
    static JTextArea errorTA, lastPW, currentPW;
    static String text;
    //add action listener
    
    public static void main(String args[])
    {
        //Set Look and Feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}

        //fonts
        Font font = new Font("Veranda", Font.BOLD, 15);
        //create frame
        frame = new JFrame ("Password Creator v2.0");
        frame.setSize(600,320);
        pane = frame.getContentPane();
        //insets = pane.getInsets();
        //layout
        pane.setLayout(null);
        //controls
        titleL = new JLabel("Ultimate Password Creator");
        oldL = new JLabel("Previous Password");
        currentL = new JLabel("Corrent Password");
        enterL = new JLabel("Enter Password:");
        
        passwordTF = new JTextField(10);
        
        submit = new JButton("Submit");
        
        errorTA = new JTextArea("Errors Displayed Here");
        lastPW = new JTextArea("Last Password");
        currentPW = new JTextArea("Current Password");
        //create component
        pane.add (titleL);
        pane.add (errorTA);
        pane.add (lastPW);
        pane.add (currentPW);
        pane.add (oldL);
        pane.add (currentL);
        pane.add (enterL);
        pane.add (passwordTF);
        pane.add (submit);
        //place components
        titleL.setBounds(205, 10, 190,20);
        titleL.setFont(font);
        errorTA.setBounds(50, 40, 480, 100);
        lastPW.setBounds(50, 150, 220, 20);
        currentPW.setBounds(310, 150, 220, 20);
        oldL.setBounds(115, 190, 90, 20);
        currentL.setBounds(375, 190, 90, 20);
        enterL.setBounds(50, 220, 100, 20);
        passwordTF.setBounds(160, 220, 370, 20);
        submit.setBounds(230, 240, 120, 25);
        frame.setVisible(true);
        
        //connect button
        //addWindowListener(this);
        
        //code to run program
        KeyboardReader reader = new KeyboardReader();
        String enter = "", choice = "";
        boolean working = true, running = true;
        Password password = new Password();
        errorTA.setText("Welcome to the Password Creator Ultimate v1.0 !");
        while (running = true)
        {
            errorTA.setText("Please choose an option to begin \n 1. Create New Password and Check \n 2. Exit and Clear Screen");
            
            choice = waitForInput("");
            System.out.println(choice);
            if (choice.contains("1"))
            {
                working = true;
                errorTA.setText("Okay, so let's create a password! \n First enter a password:       ");
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
            else if (choice.equals("2"))
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
    public static String waitForInput(String line)
    {
        KeyboardReader reader = new KeyboardReader();
        String answer;
        while (passwordTF.getText().isEmpty() == true)
        {
            System.out.println("The value:  " + passwordTF.getText());
            continue;
        }
        answer = passwordTF.getText().toString();
        System.out.println(answer);
        return text;
    }
}
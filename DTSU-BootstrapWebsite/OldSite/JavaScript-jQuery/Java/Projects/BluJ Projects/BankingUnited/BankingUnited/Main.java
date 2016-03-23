import java.util.ArrayList;
import TerminalIO.KeyboardReader;

/**
 * This is the main class that controls the Banking United System. Viewing of this code is restriced to authorized employees only. Leave now if you do not have the right permission.
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.2.1}
 */
public class Main
{
    private ArrayList<Integer> EmployeeIDList = new ArrayList<Integer>();
    
    public static void main(String args[]) {
        KeyboardReader reader = new KeyboardReader();
        String enter = "";
        int choice = 100;
        init();
        //System.out.println("Name:   " + Employees.getEmployees().get(0).getName() + "\n" + "ID:     " + Employees.getEmployees().get(0).getID() + "\n" + "DOB:      " + Employees.getEmployees().get(0).getDOB() + "\n" + "Address:    " + Employees.getEmployees().get(0).getAddress() + "\n" + "Secure Code:    " + Employees.getEmployees().get(0).getSecureCode());
        //System.out.println("\n");
        //System.out.println("Name:   " + Accounts.getAccounts().get(0).getName() + "\n" + "ID:    " + Accounts.getAccounts().get(0).getID() + "\n" + "DOB:     " + Accounts.getAccounts().get(0).getDOB() + "\n" + "Address:     " + Accounts.getAccounts().get(0).getAddress() + "\n" + "CC Number:     " + Accounts.getAccounts().get(0).getCCNumber() + "\n" + "Balance:      " + Accounts.getAccounts().get(0).getBalance() + "\n" + "Account Status:      " +  Accounts.getAccounts().get(0).getAccountStatus());
        //enter = reader.readLine("get ID then continue");
        clear();
        while (choice != 0) {
            System.out.println("\fWelcome to Banking United, where saving your money is thoughtless! \nBelow is a choice of options:");
            System.out.println("If you are a customer, type 1 \nIf you are a Banking United Employee, type 2");
            choice = reader.readInt("Enter choice here:     ");
            if (choice == 0) {// end system
                System.out.print("\f");clear();
                System.exit(0);
            } else if (choice == 1) { //customer
                while (choice != 0) {
                    clear();
                    System.out.println("\fHello valued banker! Thank you for choosing Banking United! We are happy to serve all your banking needs.");
                    System.out.println("To continue, we need you to enter your unique Bankers ID - Type -1 to exit to last menu.");
                    int ID = reader.readInt("Please enter it here:  ");
                    if (ID == -1) break;
                    int location = Accounts.getPosition(ID);
                    if (location != -1) {
                        clear();
                        System.out.println("\fGreat, we have found you in out databases! Is this customer managment or employee managment? \nCustomer?  Press 1 \nEmployee? Press 2 \nTo exit? Press 0");
                        choice = reader.readInt("Please choose here:    ");
                        while (choice != 0) {
                            if (choice == 1) { //customer
                                while (choice != 0) {
                                    clear();
                                    System.out.println("\fHello valued customer. What would you like to do today?\nTo deposit money, press 1\nTo withdraw money, press 2\nto acquire your account information, press 3\nTo exit, press 0");
                                    choice = reader.readInt("Pleas enter your choice now:   ");
                                    if (choice == 1) {
                                        double oldBal = Accounts.getAccounts().get(location).getBalance();
                                        double toAdd = reader.readDouble("\fHow much money would you like to deposit?    ");
                                        double newBal = Accounts.getAccounts().get(location).Deposit(toAdd);
                                        System.out.println("Your balance was: " + oldBal + " dollars. Your new balance is: " + newBal + " dollars.");
                                        enter = reader.readLine("Press enter to return to the last menu.");
                                    } else if (choice == 2) {
                                        double oldBal = Accounts.getAccounts().get(location).getBalance();
                                        double toRemove = reader.readDouble("\fHow much money would you like to deposit?    ");
                                        double newBal = Accounts.getAccounts().get(location).Withdraw(toRemove);
                                        System.out.println("Your balance was: " + oldBal + " dollars. Your new balance is: " + newBal + " dollars.");
                                        enter = reader.readLine("Press enter to return to the last menu.");
                                    } else if (choice == 3) {
                                        clear();
                                        System.out.println("\fHello " + Accounts.getAccounts().get(location).getName() + "! We will now pull up your information.");
                                        String lockStatus = "";
                                        if (Accounts.getAccounts().get(location).getAccountStatus()) lockStatus = "Locked";
                                        else lockStatus = "UnLocked";
                                        System.out.println("The name on this account is:    " + Accounts.getAccounts().get(location).getName() + "\nThe ID on this account is:  " + Accounts.getAccounts().get(location).getID() + "\nThe DOB on this account is:   " + Accounts.getAccounts().get(location).getDOB() + "\nThe CC Number on this account is:   " + Accounts.getAccounts().get(location).getCCNumber() + "\nThe Balance on this account is:  " + Accounts.getAccounts().get(location).getBalance() + "\nThe current lock status on this account is:  " + lockStatus + ".");
                                        enter = reader.readLine("Hit enter to continue when you are ready to go back to the last menu.");
                                    } else if (choice == 0) break;
                                    else {
                                        clear();
                                        System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                        enter = reader.readLine("Press enter to try again");
                                    }
                                }
                            } else if (choice == 2) { //employee
                                clear();
                                System.out.println("\fLoyal Employee, before you continue, please enter your employee ID below.");
                                int employeeID = reader.readInt("Please enter your ID here:     ");
                                if (Employees.checkForEmployee(employeeID)) {
                                    while (choice != 0) {
                                        clear();
                                        System.out.println("\fHello loyal employee. What needs to be taken care of today?\nType 1 to set name\nType 2 to set a new CC Number\nType 3 to set an address\nType 4 to lock or unlock an account\nType 0 to exit");
                                        choice = reader.readInt("Please enter your choice here:    ");
                                        if (choice == 1) {
                                            clear();
                                            System.out.println("\fOkay, the customer has requested a name change. Please make sure they are who they say they are before continuing.\nAre they legitiment? If so type 1, if not type 0.");
                                            choice = reader.readInt("Please enter here:    ");
                                            if (choice == 1) {
                                                clear();
                                                System.out.println("\fGreat! Let's continue.\n What is the customers new name going to be?");
                                                String newName = reader.readLine("Please enter it here:    ");
                                                System.out.println("Okay, last thing we need is your secure employee code");
                                                String SC = reader.readLine("Please enter your secure code here:    ");
                                                if (Accounts.getAccounts().get(location).setName(employeeID, SC, newName)) {
                                                    clear();
                                                    System.out.println("\fThe customers name has successfully been changed to " + newName + ". Congragulations!");
                                                    enter = reader.readLine("Hit enter to continue");
                                                } else {
                                                    clear();
                                                    System.out.println("\fThere seems to be a problem.. Please try again.");
                                                    enter = reader.readLine("Hit enter to continue.");
                                                }
                                            } 
                                            else if (choice == 0) break;
                                            else {
                                                clear();
                                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                                enter = reader.readLine("Press enter to try again");
                                            }
                                        } else if (choice == 2) {
                                            clear();
                                            System.out.println("\fOkay, the customer has requested Credit Card Number change. Please make sure they are who they say they are before continuing.\nAre they legitiment? If so type 1, if not type 0.");
                                            choice = reader.readInt("Please enter here:    ");
                                            if (choice == 1) {
                                                clear();
                                                System.out.println("\fGreat! Let's continue.");
                                                System.out.println("Last thing we need is your secure employee code");
                                                String SC = reader.readLine("Please enter your secure code here:    ");
                                                if (Employees.checkEmployeeSC(employeeID, SC)) {
                                                    clear();
                                                    System.out.println("\fThe customers credit card number has successfully been changed to " + Accounts.getAccounts().get(location).getNewCCNumber() + ". Congragulations!");
                                                    enter = reader.readLine("Hit enter to continue");
                                                } else {
                                                    clear();
                                                    System.out.println("\fThere seems to be a problem.. Please try again.");
                                                    enter = reader.readLine("Hit enter to continue.");
                                                }
                                            } 
                                            else if (choice == 0) break;
                                            else {
                                                clear();
                                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                                enter = reader.readLine("Press enter to try again");
                                            }
                                        } else if (choice == 3) {
                                            clear();
                                            System.out.println("\fOkay, the customer has requested an address change. Please make sure they are who they say they are before continuing.\nAre they legitiment? If so type 1, if not type 0.");
                                            choice = reader.readInt("Please enter here:    ");
                                            if (choice == 1) {
                                                clear();
                                                System.out.println("\fGreat! Let's continue. Now we need the new address of the customer.");
                                                String newADD = reader.readLine("Please enter it here:    ");
                                                System.out.println("Last thing we need is your secure employee code");
                                                String SC = reader.readLine("Please enter your secure code here:    ");
                                                if (Accounts.getAccounts().get(location).setAddress(employeeID, SC, newADD)) {
                                                    clear();
                                                    System.out.println("\fThe customers address has successfully been changed to " + newADD + ". Congragulations!");
                                                    enter = reader.readLine("Hit enter to continue");
                                                } else {
                                                    clear();
                                                    System.out.println("\fThere seems to be a problem.. Please try again.");
                                                    enter = reader.readLine("Hit enter to continue.");
                                                }
                                            } 
                                            else if (choice == 0) break;
                                            else {
                                                clear();
                                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                                enter = reader.readLine("Press enter to try again");
                                            }
                                        } else if (choice == 4) {
                                            clear();
                                            System.out.println("\fOkay, please know you are about to lock or unlock this bank account. Please make sure this is correct, as doing this without authorization is punishable by law..\nAre you sure? If so type 1 to lock the account, 2 to unlock the account, and 0 to quit and return to the lastscreen.");
                                            choice = reader.readInt("Please enter here:    ");
                                            if (choice == 1) {
                                                clear();
                                                System.out.println("\fOkay, here we will lock the account.");
                                                System.out.println("The last thing we need is your secure employee code");
                                                String SC = reader.readLine("Please enter your secure code here:    ");
                                                if (Accounts.getAccounts().get(location).lockAccount(employeeID, SC)) {
                                                    clear();
                                                    System.out.println("\fThe customers account has been locked.");
                                                    enter = reader.readLine("Hit enter to continue");
                                                } else {
                                                    clear();
                                                    System.out.println("\fThere seems to be a problem.. Please try again.");
                                                    enter = reader.readLine("Hit enter to continue.");
                                                }
                                            } else if (choice == 2) {
                                                clear();
                                                System.out.println("\fOkay, here we will unlock the account.");
                                                System.out.println("The last thing we need is your secure employee code");
                                                String SC = reader.readLine("Please enter your secure code here:    ");
                                                if (Accounts.getAccounts().get(location).unlockAccount(employeeID, SC)) {
                                                    clear();
                                                    System.out.println("\fThe customers account has been unlocked.");
                                                    enter = reader.readLine("Hit enter to continue");
                                                } else {
                                                    clear();
                                                    System.out.println("\fThere seems to be a problem.. Please try again.");
                                                    enter = reader.readLine("Hit enter to continue.");
                                                }
                                            }
                                            else if (choice == 0) break;
                                            else {
                                                clear();
                                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                                enter = reader.readLine("Press enter to try again");
                                            }
                                        }
                                    }
                                } else {
                                    clear();
                                    System.out.println("\fIt seems we cannot find that ID.. Please try again later or check our ID to make sure it is correct.");
                                }
                            } else { //error
                                clear();
                                System.out.println("\fError. Please try again, 1 for Customer, 2 for Employee, 0 to Exit");
                                choice = reader.readInt("Please enter now:  ");
                                System.out.print("\f");
                            }
                        }
                    } else {
                        clear();
                        System.out.println("\f Error. Invalid account number entered.");
                        enter = reader.readLine("Press enter to return to the previous menu");
                    }
                }
                clear();
                System.out.println("\fThank you for banking with us!");
                enter = reader.readLine("Please hit enter to return to the main menu");
                choice = 100;
            } else if (choice == 2) { //employee
                clear();
                System.out.println("\fHello loyal employee! Lets start by entering you unique ID.");
                int ID = reader.readInt("Please enter it here:    ");
                int location = Employees.getPosition(ID);
                if (Employees.checkForEmployee(ID)) {
                    clear();
                    System.out.println("\fGreat we have found you " + Employees.getEmployees().get(location).getName() + ".\nWhat would you like to do?");
                    choice = 100;
                    while (choice != 0) {
                        clear();
                        System.out.println("\fTo retrieve your information, press 1\nTo set info, press 2\nTo create a customer, press 3\nTo create an employee, press 4\nTo exit, press 0");
                        choice = reader.readInt("Please choose now:     ");
                        if (choice == 1) {
                            while (choice != 0) {
                                clear();
                                System.out.println("\fOkay, we can retrieve your informaton momentarily.\nWould you like to see general info? Press 1\nOr, would you like to see secure information? Press 2");
                                choice = reader.readInt("Please choose now:     ");
                                if (choice == 1) {
                                    clear();
                                    System.out.println("\fHello " + Employees.getEmployees().get(location).getName() + ", here we will list your general informaton.\nEmployee ID: " + Employees.getEmployees().get(location).getID() + "\nEmployee Name: " + Employees.getEmployees().get(location).getName() +"\nEmployee Address: " + Employees.getEmployees().get(location).getAddress() + "\nThat is all the information we have on you. Thank you for working with us!");
                                    enter = reader.readLine("Press enter when ready to return to the last menu.");
                                } else if (choice == 2) {
                                    clear();
                                    System.out.println("\fOkay, we will need one thing before providing your secure code. Upon joining our family of bankers, you set a recovery code.");
                                    String rc = reader.readLine("Please enter it now:   ");
                                    String sc = Employees.getEmployees().get(location).getSecureCode(rc);
                                    if (sc == null) {
                                        clear();
                                        System.out.println("\fError. It appears your recover code does not match pur records.. If you feel this is a mistake, contact a manager after trying again.");
                                        enter = reader.readLine("Press enter to return to the last menu.");
                                    } else {
                                        clear();
                                        System.out.println("\fGreat, your recovery code was a match.\nYour secure code is: " + sc);
                                        enter = reader.readLine("Press enter to continue to the last menu.");
                                    }
                                } else if (choice == 0) break;
                                else {
                                    clear();
                                    System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                    enter = reader.readLine("Press enter to try again");
                                }
                           }
                        } else if (choice == 2) {
                            clear();
                            System.out.println("\fOkay, we can gladly reset your information. We just need you to enter your secure code.\nIf you do not know your secure code, go get it in the first option to recover it with your reovery code.");
                            String secureCode = reader.readLine("Please enter it here:   ");
                            if (Employees.checkEmployeeSC(ID, secureCode)) {
                                System.out.println("We have found and matched your secure code in the system. Now we can continue securely.");
                                enter = reader.readLine("Please press enter when you are ready to continue.");
                                while (choice != 0) {
                                    clear();
                                    System.out.println("\fWould you like to set a new secure code? Press 1\nWould you like to set your name? Press 2\nWould you like to set your address? Press 3\nTo exit, press 0");
                                    choice = reader.readInt("Please choose now:     ");
                                    if (choice == 1) {
                                        clear();
                                        System.out.println("\fOkay, all we will need to reset your secure password is your recovery password.");
                                        String rc = reader.readLine("Please enter it now:     ");
                                        String newCode = Employees.getEmployees().get(location).newSecureCode(rc);
                                        if (newCode == null) {
                                            clear();
                                            System.out.println("\fThere seems to be a problem.. Please check that code and try again.");
                                            enter = reader.readLine("Press enter to try again");
                                        } else {
                                            clear();
                                            System.out.println("\fSucess! Your new code is:\n" + newCode);
                                            enter = reader.readLine("Copy this somewhere safe, then press enter to continue.");
                                        }
                                    } else if (choice == 2) {
                                        clear();
                                        System.out.println("\fOkay, what would you like to change your name to?");
                                        Employees.getEmployees().get(location).setName(reader.readLine("Please enter it now:     "));
                                        System.out.println("Great, your name has been changed.");
                                        enter = reader.readLine("Press enter to continue");
                                    } else if (choice == 3) {
                                        clear();
                                        System.out.println("\fOkay, what should your new address be?");
                                        Employees.getEmployees().get(location).setName(reader.readLine("Please enter it now:    "));
                                        System.out.println("Great, your address has been changed.");
                                        enter = reader.readLine("Press enter to continue");
                                    } else if (choice == 0) break;
                                    else {
                                        clear();
                                        System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                        enter = reader.readLine("Press enter to try again");
                                    }
                                }
                            } else {
                                clear();
                                System.out.println("\fError. There seems to be a problem with your secure code.. please try again, and if that fails, try recovering it.");
                                enter = reader.readLine("Press enter to return to the prevous menu");
                            }
                        } else if (choice == 3) {
                            clear();
                            System.out.println("\fGreat! We love when new customers join our bank. Lets get started right now.");
                            String name = reader.readLine("Please enter the new customers name:     ");
                            String DOB = reader.readLine("Now, please enter their Date Of Birth (mm/dd/yyyy):    ");
                            double bal = reader.readDouble("If the customer is making a deposit, please enter the amount, if not enter 0:     ");
                            String address = reader.readLine("Lastly, please enter their address:     ");
                            System.out.println("Does all this information look correct? If so, type 1, if not, type 2");
                            choice = reader.readInt("Please enter it here:      ");
                            if (choice == 1) {
                                if (bal != 0) {
                                    System.out.println("Okay, perfect. We will enter this information now.");
                                    Account temp = new Account(name, DOB, bal, address);
                                    System.out.println("Account created successfully!\nAccount ID: " + temp.getID() + "\nCredit Card Number: " + temp.getCCNumber() + "\nCongragulations and thank you for banking with Banking United!");
                                    enter = reader.readLine("Press enter to continue");
                                } else {
                                    System.out.println("Okay, perfect. We will enter this information now.");
                                    Account temp = new Account(name, DOB, address);
                                    System.out.println("Account created successfully!\nAccount ID: " + temp.getID() + "\nCredit Card Number: " + temp.getCCNumber() + "\nCongragulations and thank you for banking with Banking United!");
                                    enter = reader.readLine("Press enter to continue");
                                }
                            } else if (choice == 2) {
                                clear();
                                System.out.println("\fOkay, you can go back and restart.");
                                enter = reader.readLine("Press enter to continue");
                            } else {
                                clear();
                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                enter = reader.readLine("Press enter to try again");
                            }
                        } else if (choice == 4) {
                            clear();
                            System.out.println("\fA new employee? Great! Welcome to the Banking United team! Let's get you started right away.");
                            String name = reader.readLine("New employee. What is your name?     ");
                            String address = reader.readLine("What is your address?     ");
                            String DOB = reader.readLine("What is your Date Of Birth (mm/dd/yyyy)?      ");
                            System.out.println("Please enter a secure recovery password, this is used to recover your account if you forget the assigned password.");
                            String rc = reader.readLine("Please enter it now:");
                            System.out.println("Does this all look correct? If so, press 1, if not, press 2");
                            choice = reader.readInt("Please choose now:     ");
                            if (choice == 1) {
                                System.out.println("Great, we are very happy to hear you are joining us!");
                                Employee temp = new Employee(name, DOB, address, rc);
                                System.out.println("Employee account created successfully!\nEmployee ID: " + temp.getID() + "\nEmployee Secure Code: " + temp.getSecureCode() + "\nCongragulations and welcome to the team!");
                                enter = reader.readLine("Press enter to continue");
                            } else if (choice == 2) {
                                clear();
                                System.out.println("\fOkay, you can go back and restart.");
                                enter = reader.readLine("Press enter to continue");
                            } else {
                                clear();
                                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                                enter = reader.readLine("Press enter to try again");
                            }
                        } else if (choice == 0) break;
                        else {
                            clear();
                            System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                            enter = reader.readLine("Press enter to try again");
                        }
                        choice = 100;
                    }
                    choice = 100;
                } else {
                    clear();
                    System.out.println("\fThere seems to be some issue with your ID.. You entered " + ID + " and we cannot find you in the database. Please review your ID and try again.");
                    enter = reader.readLine("Press enter to continue.");
                }
            } else { //error
                clear();
                System.out.println("\fError. " + choice + " is and invalid choce. Please try again.");
                enter = reader.readLine("Press enter to try again");
            }            
        }
    }

    public static void init() {
         new Employee("Admin", "00/00/00", "**Admin Account**", "adminRecovery");
         new Account("AdminTest", "00/00/00", 1000000.01, "**Test Account**");
         new Employee(1, "Admin1", "kcbosco", "12/12/1212", "adminAddress", "kcbosco");
    }
    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
/*
 * Customers
 *      Input ID, search if valid, if so next menu, if not return error message and try again -- 0 to exit to last menu
 *          Customer Managment
 *              get account info [ID, name, DOB, address, CC Number, Balance, lock status]
 *              deposit money
 *              withdraw money
 *          Employee Managment
 *              set name
 *              set newCC number
 *              lock account
 *              unlock account
 *              set address
 *          
 * Employees
 *      Input ID, search if valid, if so next menu, if not return error message
 *          Get Info
 *              get general info [ID, Name, Address]
 *              get secure info [Secure Code]
 *          Set Info
 *              set new secure code
 *              set name
 *              set address
 */
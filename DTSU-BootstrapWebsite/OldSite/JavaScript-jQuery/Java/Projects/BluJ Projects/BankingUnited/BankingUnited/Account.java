import java.util.ArrayList;
import java.util.Random;

/**
 * This is a general class that will contain all account information and will be stored in the main class or a customer class.
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.1.0}
 */
public class Account
{
    private static Random generator = new Random();
    private static String name;
    private static String DOB;
    private static int ccNumber;
    private static double balance;
    private static ArrayList<Integer> routingNumbers = new ArrayList<Integer>();
    private static boolean isLocked;
    private static String address;
    private static int ID;
    
    public Account(String n, String dob, String add) {
        name = n;
        DOB = dob;
        ccNumber = getNewCCNumber();
        balance = 0;
        isLocked = false;
        address = add;
        ID = Accounts.getNewID();
        Accounts.addAccount(this);
    }
    public Account(String n, String dob, double bal, String add) {
        name = n;
        DOB = dob;
        ccNumber = getNewCCNumber();
        balance = bal;
        isLocked = false;
        address = add;
        ID = Accounts.getNewID();
        Accounts.addAccount(this);
    }
    
    public static String getName() {
        return name;
    }
    public static String getDOB() {
        return DOB;
    }
    public static int getCCNumber() {
        return ccNumber;
    }
    public static int getNewCCNumber() {
        boolean exists = true;
        int finalCC = 0;
        
        while (exists) {
            String finalCCS = Integer.toString(generator.nextInt(10000)) + Integer.toString(generator.nextInt(10000));
            finalCC = Integer.parseInt(finalCCS);
            exists = Accounts.checkCCNumber(finalCC);
        }
        
        ccNumber = finalCC;
        return finalCC;
    }
    public static double getBalance() {
        return balance;
    }
    public int getRoutingNumnber() {
        int routingNumber = Integer.parseInt(Integer.toString(generator.nextInt(100)) + Integer.toString(generator.nextInt(100)) + Integer.toString(generator.nextInt(100)) + Integer.toString(generator.nextInt(100)));
        return routingNumber;
    }
    public ArrayList<Integer> getAllRoutingNumbers() {
        return routingNumbers;
    }
    public static boolean getAccountStatus() {
        return isLocked;
    }
    public static String getAddress() {
        return address;
    }
    public static int getID() {
        return ID;
    }
    
    public boolean setName(int EmployeeID, String secureCode, String newName) {  
          if (!isLocked) {
              if (Employees.checkForEmployee(EmployeeID)) {
                  if (Employees.checkEmployeeSC(EmployeeID, secureCode)) {
                      name = newName;
                      return true;
                  }
              }
          }
          return false;
    }
    public boolean setCCNum(int EmployeeID, String secureCode, int newCCNumber) {
          if (!isLocked) {
              if (Employees.checkForEmployee(EmployeeID)) {
                  if (Employees.checkEmployeeSC(EmployeeID, secureCode)) {
                      ccNumber = newCCNumber;
                      return true;
                  }
              }
          }
          return false;
    }
    public boolean setAddress(int EmployeeID, String secureCode, String newAddress) {
          if (!isLocked) {
              if (Employees.checkForEmployee(EmployeeID)) {
                  if (Employees.checkEmployeeSC(EmployeeID, secureCode)) {
                      address = newAddress;
                      return true;
                  }
              }
          }
          return false;
    }
    public double Withdraw(double amount) {
        if (!isLocked) {
            balance -= amount;
        }   
        return balance;
    }
    public double Deposit(double amount) {
        if (!isLocked) {
            balance += amount;
        }
        return balance;
    }
    
    public boolean lockAccount(int EmployeeID, String secureCode) {
          if (Employees.checkForEmployee(EmployeeID)) {
              if (Employees.checkEmployeeSC(EmployeeID, secureCode)) {
                  isLocked = true;
                  return true;
              }
          }
          return false;
    }
    public boolean unlockAccount(int EmployeeID, String secureCode) {
          if (Employees.checkForEmployee(EmployeeID)) {
              if (Employees.checkEmployeeSC(EmployeeID, secureCode)) {
                  isLocked = false;
                  return true;
              }
          }
          return false;
    }
}

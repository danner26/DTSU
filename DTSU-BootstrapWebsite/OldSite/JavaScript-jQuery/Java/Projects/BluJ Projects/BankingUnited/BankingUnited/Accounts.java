import java.util.ArrayList;

/**
 * Holds all accounts as well as have methods required by other classes. This is all for the account holders, no employee data is here. 
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.1.3}
 * 
 */
public class Accounts
{
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    
    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
    public static void addAccount(Account a) {
        accounts.add(a);
    }
    public static boolean checkIfAccountExists(int ID) {
        for (Account a: accounts) {
           if (a.getID() == ID) {
               return true;
           }
        }
        return false;
    }
    public static int getNewID() {
        int newID = 0;
        
        if (newID == 0) {
            for (Account a: accounts) {
                newID += 1;
            }
        }
        return newID;
    }
    public static boolean checkCCNumber(int ccNum) {
        for (Account a: accounts) {
            if (a.getCCNumber() == ccNum) {
                return true;
            }
        }
        return false;
    }
    public static int getPosition(int id) {
        int location = 0;
        boolean exists = false;
        for (Account a: accounts) {
            if (a.getID() == id) {
                exists = true;
                break;
            } else location++;
        }
        if (exists) return location;
        else return -1;
    }
}

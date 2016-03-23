import java.util.Random;

/**
 * Holds employees class, which will be stored in system Employees class. Highly confidential data.
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.4.6}
 * 
 */
public class Employee
{
    private Random generator = new Random();
    private final int id;
    private String secureCode;
    private String name;
    private final String DOB;
    private String address;
    private String recoverCode;
    
    public Employee(String newName, String newDOB, String newAddress, String rc) {
        id = newID();
        secureCode = newSecureCode();
        name = newName;
        DOB = newDOB;
        address = newAddress;
        recoverCode = rc;
        Employees.addEmployee(this);
    }
    public Employee(int ID, String newName, String SC, String newDOB, String newAddress, String rc) {
        id = ID;
        secureCode = SC;
        name = newName;
        DOB = newDOB;
        address = newAddress;
        recoverCode = rc;
        Employees.addEmployee(this);
    }
    
    public int getID() {
        return id;
    }
    public String getSecureCode(String rc) {
        if (rc.equals(recoverCode))  return secureCode; 
        return null;
    }
    public String getSecureCode() {
    return secureCode;    
    }
    public String getName() {
        return name;
    }
    public String getDOB() {
        return DOB;
    }
    public String getAddress() {
        return address;
    }
    public String getRecoverCode() {
        return recoverCode;
    }
    
    public int newID() {
        boolean exists = true;
        int newID = 0;
        while (exists) {
            newID = generator.nextInt(1000000000);
            if (!Employees.checkForEmployee(newID)) exists = false;
        }
        return newID;
    }
    public String newSecureCode(String rc) {
        String newCode = "E";
        if (rc.equals(recoverCode)) {
            while (newCode.length() < 12) {
                if (generator.nextInt(2) == 0){ //letter
                    newCode = newCode + getLetter(generator.nextInt(26));
                } else { //number
                    newCode = newCode + Integer.toString(generator.nextInt(10));
                }
            }
            secureCode = newCode;
        } else return null;
        return newCode;
    }
    private String newSecureCode() {
        String newCode = "E";
        while (newCode.length() < 12) {
            if (generator.nextInt(2) == 0){ //letter
                newCode = newCode + getLetter(generator.nextInt(26));
            } else { //number
                newCode = newCode + Integer.toString(generator.nextInt(10));
            }
        }
        secureCode = newCode;
        return newCode;
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    
    public String getLetter(int num) {
        if (num == 0) {
            return "A";
        } else if (num == 1) {
            return "B";
        } else if (num == 2) {
            return "C";
        } else if (num == 3) {
            return "D";
        } else if (num == 4) {
            return "E";
        } else if (num == 5) {
            return "F";
        } else if (num == 6) {
            return "G";
        } else if (num == 7) {
            return "H";
        } else if (num == 8) {
            return "I";
        } else if (num == 9) {
            return "J";
        } else if (num == 10) {
            return "K";
        } else if (num == 11) {
            return "L";
        } else if (num == 12) {
            return "M";
        } else if (num == 13) {
            return "N";
        } else if (num == 14) {
            return "O";
        } else if (num == 15) {
            return "P";
        } else if (num == 16) {
            return "Q";
        } else if (num == 17) {
            return "R";
        } else if (num == 18) {
            return "S";
        } else if (num == 19) {
            return "T";
        } else if (num == 20) {
            return "U";
        } else if (num == 21) {
            return "V";
        } else if (num == 22) {
            return "W";
        } else if (num == 23) {
            return "X";
        } else if (num == 24) {
            return "Y";
        }
        return "Z";
    }
}

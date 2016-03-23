import java.util.ArrayList;

/**
 * Holds employees class, which stores exteremly confidential data. Do not access without proper authorization.
 * 
 * @author {Daniel William Anner}
 * @development-group {DTSU Development Team}
 * @version [V. 1.4.7}
 * 
 */
public class Employees
{
    private static ArrayList<Employee> employees = new ArrayList<Employee>();
    
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
    public static void addEmployee(Employee n) {
        employees.add(n);
    }
    public static boolean checkForEmployee(int ID) {
        for (Employee e: employees) {
            if (e.getID() == ID) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkEmployeeSC(int ID, String SC) {
        for (Employee e: employees) {
            if (e.getID() == ID) {
                if (e.getSecureCode().equals(SC)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int getPosition(int id) {
        int location = 0;
        boolean exists = false;
        for (Employee e: employees) {
            if (e.getID() == id) {
                exists = true;
                break;
            } else location++;
        }
        if (exists) return location;
        else return -1;
    }
}

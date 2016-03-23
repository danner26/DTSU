import java.security.MessageDigest;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.io.File.*;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Write a description of class Hash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hash
{
    private static String fileName = run.getFileName();
    
    public static boolean createHashedFile(String u, String l, String m) throws Exception {
        String hashMD5 = "", hashSHA256 = "";
        String password = u + "|" + l + "|" + m;
       
        MessageDigest shMD = MessageDigest.getInstance("SHA-256");
        shMD.update(password.getBytes());
       
        byte byteData[] = shMD.digest();
       
        //method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }      
        
        String hash = sb.toString();
       
        if (OSValidator.isWindows()){
             try {
                 File file = new File(System.getenv("APPDATA") + "/" + fileName + "/testImp.txt");
                 
                 if (file.createNewFile()) {
                     FileWriter fw = new FileWriter(file.getAbsoluteFile());
                     BufferedWriter bw = new BufferedWriter(fw);
                     
                     bw.write(hash);
                     
                     bw.close();
                     
                     Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
                     p.waitFor();
                     
                     fw.close();
                     return true;
                 } else {
                     return false;
                }
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                 JOptionPane.showMessageDialog(null, e.getStackTrace());
                 System.exit(0);
             }
         } else if (OSValidator.isMac()) {
             try {
                 File file = new File(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName + "/.ImpFile.txt");
                                
                 if (file.createNewFile()) {
                     FileWriter fw = new FileWriter(file.getAbsoluteFile());
                     BufferedWriter bw = new BufferedWriter(fw);
                     
                     bw.write(hash);
                     
                     bw.close();
                     
                     fw.close();
                     return true;
                 } else {
                     return false;
                 }
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                 JOptionPane.showMessageDialog(null, e.getStackTrace());
                 System.exit(0);
             }
         } else if (OSValidator.isUnix()) {
             try {
                 File file = new File(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName + "/.ImpFile.txt");
                                
                 if (file.createNewFile()) {
                     FileWriter fw = new FileWriter(file.getAbsoluteFile());
                     BufferedWriter bw = new BufferedWriter(fw);
                    
                     bw.write(hash);
                     
                     bw.close();
                     
                     fw.close();
                     return true;
                 } else {
                     return false;
                 }
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                 JOptionPane.showMessageDialog(null, e.getStackTrace());
                 System.exit(0);
             }
         } else {
             JOptionPane.showMessageDialog(null, "This system is not compatible with this program. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
         }
        
        return false;
    }
    public static boolean checkHashedFile(String u, String l) throws Exception {
        String m = run.getMAC();
        
        String hashToCheck = u + "|" + l + "|" + m;
        
        String hashMD5 = "", hashSHA256 = "";;
        MessageDigest shMD = MessageDigest.getInstance("SHA-256");
        shMD.update(hashToCheck.getBytes());
        byte byteData[] = shMD.digest();
        
        //method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }      
        
        String hash = sb.toString();
        
        if (OSValidator.isWindows()){
            File file = new File(System.getenv("APPDATA") + "/" + fileName + "/testImp.txt");
            if (file.exists()) {
                Scanner s = new Scanner(new BufferedReader (new FileReader(System.getenv("APPDATA") + "/" + fileName + "/testImp.txt")));
            
                String fileHash = s.next();
                s.close();
                if (hash.equals(fileHash)) return true;
                return false;
            }
            return false;
        } else if (OSValidator.isMac()) {
            File file = new File(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName + "/.ImpFile.txt");
            if (file.exists()) {
                Scanner s = new Scanner(new BufferedReader (new FileReader(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName + "/.ImpFile.txt")));
            
                String fileHash = s.next();
                s.close();
                if (hash.equals(fileHash)) return true;
                return false;
            }
            return false;
        } else if (OSValidator.isUnix()) {
            File file = new File(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName + "/.ImpFile.txt");
            if (file.exists()) {
                Scanner s = new Scanner(new BufferedReader (new FileReader(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName + "/.ImpFile.txt")));
                
                String fileHash = s.next();
                s.close();
                if (hash.equals(fileHash)) return true;
                return false;
            }
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "This system is not compatible with this program. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
        }
        return false;
    }
}

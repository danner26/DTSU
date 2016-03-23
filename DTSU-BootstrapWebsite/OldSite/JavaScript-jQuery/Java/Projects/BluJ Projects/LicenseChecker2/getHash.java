import java.security.MessageDigest;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.io.File.*;
import java.io.FileWriter;
import TerminalIO.KeyboardReader;

/**
 * Write a description of class getHash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class getHash
{
    public static void main(String args[]) throws Exception {
        KeyboardReader reader = new KeyboardReader();
        
        String u = reader.readLine("user:    ");
        String l = reader.readLine("License:  ");
        String m = reader.readLine("MAC:  ");
        
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
        
        System.out.println(hash);
    }
}

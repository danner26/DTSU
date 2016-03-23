import TerminalIO.KeyboardReader;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.File.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * This is the main class for checking and executing the licensing process for the application. DO NOT MODIFY OR USE ANY CODE.
 * 
 * @Daniel W. Anner (Dan's Tech Support Unlimited - Owner)
 * @version (3.7.4)
 */
public class run
{
    private static KeyboardReader reader = new KeyboardReader();
    public static String fileName = "TestPHP";
    public static String user, license;

    public static void main(String args[]) {
        if (networkConnectivity()) {
            boolean status = alreadyRegistered();
            if (status) {
                if (checkLicense()) {
                    run();
                } else {
                    JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                }
            } else {
                getLicensed();
            }
        } else {
            boolean status = alreadyRegistered();
            if (status) run();
            else getLicensed();
        }
    }

    public static void getLicensed() {
        String username, lic;
        //System.out.println("It seems we need your username and license. Please enter them as prompted below.");
        String values = JOptionPaneMultiInput.getValues();
        //username = reader.readLine("Please enter your user name:    ");
        //lic = reader.readLine("Please enter your valid license:     ");
        if ((values.length() > 29 || values.length() < 29) || values.contains("error")) {
            JOptionPane.showMessageDialog(null, "Invalid username or license. Try again, and if you've forgot your information contact the DTSU support. Email: support@danstechsupport.com");
            invalid();
        }
        
        username = values.substring(0, 5).toUpperCase();
        lic = values.substring(6).toUpperCase();

        try {
            URL url = new URL("http://danstechsupport.com/LicenseCheck_Cue.php?uid=" + username + "&lice=" + lic + "&pname=cue137914");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = null;
            boolean ret = false;
            while ((str = in.readLine()) != null) {
                str = str.toLowerCase();
                if (str.contains("true")) {
                    ret = true;
                    break;
                }
            }
            in.close();
            if (ret) newRegistration(username, lic);
            else {
                JOptionPane.showMessageDialog(null, "Invalid username or license. Try again, and if you've forgot your information contact the DTSU support. Email: support@danstechsupport.com");
                invalid();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There seems to be some errors occuring. Include the following text in your contact. Contact the DTSU support team for more information. Email: support@danstechsupport.com");
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            //e.printStackTrace();
        }

    }

    public static void run() {
        System.out.println("Program Running.");
        //run program here
    }

    public static boolean alreadyRegistered() {
        Scanner s = null;
        String u = "", l = "", m = "";
        int i = 1;
        if (OSValidator.isWindows()) {
            try {
                s = new Scanner(new BufferedReader (new FileReader(System.getenv("APPDATA") + "/" + fileName + "/config.txt"))).useDelimiter("!Zod!");
                while(s.hasNext()) {
                    if (i > 3) {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        s.close();
                        invalid();
                        return false;
                    } else {
                        if (i == 1) {
                            u = s.next();
                            i++;
                        } else if (i == 2) {
                            l = s.next();
                            i++;
                        } else {
                            m = s.next();
                            i++;
                        }
                    }
                }
                
                s.close();
                
                if (u.length() != 5 || l.length() != 23 || m.length() != 17) {
                    JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                } else {
                    boolean properHash = false;
                    boolean macVal = false;
                    try {
                        properHash = Hash.checkHashedFile(u, l);
                        macVal = checkMAC(m);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy following text and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        invalid();
                    }
                    if (properHash && macVal) {
                        user = u;
                        license = l;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        invalid();
                    }
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                }
            } catch(FileNotFoundException ex) {
                return false;
            }
        } else if (OSValidator.isMac()) {
            try {
                s = new Scanner(new BufferedReader (new FileReader(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName + "/config.txt"))).useDelimiter("!Zod!");

                while(s.hasNext()) {
                    if (i > 3) {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        s.close();
                        invalid();
                        return false;
                    } else {
                        if (i == 1) {
                            u = s.next();
                            i++;
                        } else if (i == 2) {
                            l = s.next();
                            i++;
                        } else {
                            m = s.next();
                            i++;
                        }
                    }
                }
                
                s.close();
                
                if (u.length() != 5 || l.length() != 23 || m.length() != 17) {
                    JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                } else {
                    boolean properHash = false;
                    boolean macVal = false;
                    try {
                        properHash = Hash.checkHashedFile(u, l);
                        macVal = checkMAC(m);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        invalid();
                    }
                    if (properHash && macVal) {
                        user = u;
                        license = l;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        invalid();
                    }
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                }
            } catch(FileNotFoundException ex) {
                return false;
            }
        } else if (OSValidator.isUnix()){
            try {
                s = new Scanner(new BufferedReader (new FileReader(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName + "/config.txt"))).useDelimiter("!Zod!");

                while(s.hasNext()) {
                    if (i > 3) {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        s.close();
                        invalid();
                        return false;
                    } else {
                        if (i == 1) {
                            u = s.next();
                            i++;
                        } else if (i == 2) {
                            l = s.next();
                            i++;
                        } else {
                            m = s.next();
                            i++;
                        }
                    }
                }
                
                s.close();
                
                if (u.length() != 5 || l.length() != 23 || m.length() != 17) {
                    JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                } else {
                    boolean properHash = false;
                    boolean macVal = false;
                    try {
                        properHash = Hash.checkHashedFile(u, l);
                        macVal = checkMAC(m);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        invalid();
                    }
                    if (properHash && macVal) {
                        user = u;
                        license = l;
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "The program has been detected as cracked or malformed. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        invalid();
                    }
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                    return false;
                }
            } catch(FileNotFoundException ex) {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "This system is not compatible with this program. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
        }
        return false;
    }
    public static boolean checkLicense() {
        try {
            URL url = new URL("http://danstechsupport.com/LicenseCheck_Cue_178937.php?uid=" + user + "&lice=" + license + "&pname=cue137914");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = null;
            while ((str = in.readLine()) != null) {
                str = str.toLowerCase();
                if (str.contains("true")) {
                    in.close();
                    return true;
                }
            }
            in.close();
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void newRegistration(String user, String lice) {
        if (OSValidator.isWindows()){
            try {
                File dir = new File(System.getenv("APPDATA") + "/" + fileName);

                try {
                    dir.mkdirs();
                } catch (SecurityException se) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    JOptionPane.showMessageDialog(null, se.getStackTrace());
                    System.exit(0);
                }

                String mac = getMAC();
                if (mac.contains("error")) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }

                File file = new File(System.getenv("APPDATA") + "/" + fileName + "/config.txt");
                boolean hashed = false;

                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(user + "!Zod!" + lice + "!Zod!" + mac);

                    bw.close();
                    try {
                        hashed = Hash.createHashedFile(user, lice, mac);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        bw.close();
                        fw.close();
                        invalid();
                    }
                    fw.close();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                }

                if (hashed) {
                    run();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured while hashing. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                JOptionPane.showMessageDialog(null, e.getStackTrace());
                System.exit(0);
            }
        } else if (OSValidator.isMac()) {
            try {
                File dir = new File(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName);

                try {
                    dir.mkdirs();
                } catch (SecurityException se) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    JOptionPane.showMessageDialog(null, se.getStackTrace());
                    System.exit(0);
                }

                String mac = getMAC();
                if (mac.contains("error")) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }

                File file = new File(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName + "/config.txt");
                boolean hashed = false;

                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(user + "!Zod!" + lice + "!Zod!" + mac);

                    bw.close();
                    try {
                        hashed = Hash.createHashedFile(user, lice, mac);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        bw.close();
                        fw.close();
                        invalid();
                    }

                    fw.close();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                }

                if (hashed) {
                    run();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured while hashing. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                JOptionPane.showMessageDialog(null, e.getStackTrace());
                System.exit(0);
            }
        } else if (OSValidator.isUnix()) {
            try {
                File dir = new File(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName);

                try {
                    dir.mkdirs();
                } catch (SecurityException se) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    JOptionPane.showMessageDialog(null, se.getStackTrace());
                    System.exit(0);
                }

                String mac = getMAC();
                if (mac.contains("error")) {
                    JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }

                File file = new File(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName + "/config.txt");
                boolean hashed = false;

                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(user + "!Zod!" + lice + "!Zod!" + mac);

                    bw.close();
                    try {
                        hashed = Hash.createHashedFile(user, lice, mac);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                        JOptionPane.showMessageDialog(null, e.getStackTrace());
                        bw.close();
                        fw.close();
                        invalid();
                    }

                    fw.close();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured.Rerun the program, and if it still fails please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    invalid();
                }

                if (hashed) {
                    run();
                } else {
                    JOptionPane.showMessageDialog(null, "A system error occured while hashing. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                    System.exit(0);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
                JOptionPane.showMessageDialog(null, e.getStackTrace());
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "This system is not compatible with this program. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
        }
    }

    public static void invalid(){
        if (OSValidator.isWindows()) {
            File dir = new File(System.getenv("APPDATA") + "/" + fileName);

            if (dir.exists()) {
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    if (files != null) {
                        for (File f: files) {
                            f.delete();
                        }
                    }

                    dir.delete();
                } else dir.delete();
            }
            System.exit(0);
        } else if (OSValidator.isMac()) {
            File dir = new File(System.getProperty("user.home") + "/Documents/SavedInformation/" + fileName);

            if (dir.exists()) {
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    if (files != null) {
                        for (File f: files) {
                            f.delete();
                        }
                    }

                    dir.delete();
                } else dir.delete();
            }
            System.exit(0);
        } else if (OSValidator.isUnix()) {
            File dir = new File(System.getProperty("user.home") + "/ProgramFiles/DTSU/" + fileName);

            if (dir.exists()) {
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    if (files != null) {
                        for (File f: files) {
                            f.delete();
                        }
                    }

                    dir.delete();
                } else dir.delete();
            }
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "This system is not compatible with this program. Please contact the DTSU support team for more information. Email: support@danstechsupport.com");
        }
    }

    public static String getMAC() {
        try {
            String firstInterface = null;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()) {
                NetworkInterface network = networkInterfaces.nextElement();

                byte[] mac = network.getHardwareAddress();
                if(mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }

                    if (sb.toString().isEmpty() == false) {
                        return sb.toString();
                    }
                }
            }
            return "error";
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Possible no adapter found. Email: support@danstechsupport.com");
            JOptionPane.showMessageDialog(null, se.getStackTrace());
            return "error";
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "A system error occured. Copy message and please contact the DTSU support team for more information. Email: support@danstechsupport.com");
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            return "error";
        }
    }

    public static boolean checkMAC(String mac) {
        if (getMAC().equals(mac)) return true;
        return false;
    }
    public static boolean networkConnectivity() {
        try {
            URL url = new URL("http://www.danstechsupport.com/LicenseCheck_Cue.php");
            
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            
            Object objData = connection.getContent();
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static String getFileName() {
        return fileName;
    }
}

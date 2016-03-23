import javax.swing.*;

public class JOptionPaneMultiInput {
    public static String getValues() {
        JTextField username = new JTextField(50);
        JTextField license = new JTextField(50);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Username:"));
        myPanel.add(username);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("License:"));
        myPanel.add(license);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Your Username and License", JOptionPane.OK_CANCEL_OPTION);
        //if (username.equals(null) || license.equals(null) /*|| username. == 0 || license.length() == 0*/) return "none";
        String values = username.getText() + "&" + license.getText();
        if (result == JOptionPane.OK_OPTION) {
            return values;
        } else return "none";

    }
}
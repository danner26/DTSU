import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * This program was written by Daniel W. Anner of Dan's Tech Support
 * Unlimited and is Free-Ware, but not to be distributed as your own.
 * Please do not distribute.
 */
 public class CueUI extends JFrame {
    private ArrayList<String> cueList = new ArrayList<>();
    private ArrayList<String> cueNum = new ArrayList<>();
    int currentNum = 1;
    private boolean justSaved = false;
    
    /**
     * Creates new form CueUI
     */
    public CueUI() {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setMinWidth(50);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(75);
        number.setText("1");
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code.
     */
    @SuppressWarnings("unchecked")                     
    private void initComponents() {
        jTable1 = new JTable();
        fileChooser = new JFileChooser();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        addCueButton = new JButton();
        removeButton = new JButton();
        lastCueLabel = new JLabel();
        saveButton = new JButton();
        reloadButton = new JButton();
        exitButton = new JButton();
        cueDetails = new JTextField();
        number = new JTextField();
        removeTextBox = new JTextField();
        jScrollPane1 = new JScrollPane();
        
        fileChooser.setCurrentDirectory(new java.io.File("C:\\"));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Cue List"));

        jLabel1.setText("Cue Number:");
        jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);

        jLabel3.setText("Details:");
        jLabel3.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {{null, null}},new String [] {"Cue", "Cue Details"})
        {
              Class[] types = new Class [] {
                  java.lang.Integer.class, java.lang.String.class
              };
              boolean[] canEdit = new boolean [] {
                  false, true
              };
              public Class getColumnClass(int columnIndex) {
                  return types [columnIndex];
              }
              public boolean isCellEditable(int rowIndex, int columnIndex) {
                  return canEdit [columnIndex];
              }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        addCueButton.setText("Add Cue");
        addCueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCueButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Last Cue Entered:");

        lastCueLabel.setText("NONE");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cueDetails).addGroup(jPanel1Layout.createSequentialGroup().addComponent(number, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jLabel5).addGap(18, 18, 18).addComponent(lastCueLabel).addGap(0, 0, Short.MAX_VALUE)))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)).addGroup(jPanel1Layout.createSequentialGroup().addGap(150, 150, 150).addComponent(addCueButton).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jLabel5).addComponent(lastCueLabel))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(cueDetails).addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(addCueButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE).addGap(20, 20, 20)));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Remove Cue");

        removeButton.setText("Update");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        removeTextBox.setText("LAST");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        reloadButton.setText("Reload");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Type LAST to remove top cue");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel4)).addGroup(layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(removeTextBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(removeButton).addGap(18, 18, 18).addComponent(reloadButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(saveButton).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(exitButton))).addGap(0, 8, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(exitButton).addComponent(jLabel2).addComponent(removeButton).addComponent(removeTextBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(saveButton).addComponent(reloadButton)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4)));

        pack();
        }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (!justSaved) {
            int answer = JOptionPane.showConfirmDialog(null, "Would you like to save before quitting?", "Save Before Exit", JOptionPane.YES_NO_CANCEL_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                saveCueList();
            } else if (answer == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (answer == JOptionPane.CANCEL_OPTION) {
                answer = 10;
            } else {
                System.exit(0);
            }
            answer = 10;
        }
    }                                          

    /*getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            int answers1 = JOptionPane.showConfirmDialog(frame, "Do you want to save before quitting?", "Save Before Quitting?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (answers1 == JOptionPane.YES_OPTION) {
                saveCueList();
            } else if (answers1 == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (answers1 == JOptionPane.CANCEL_OPTION) {
                JFrame.DO_NOTHING_ON_CLOSE;
            } else {
                window
            }
        }
    });*/
    
    private void updateTable() {
        int i = 0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (String item : cueList) {
            model.addRow(new Object[]{cueNum.get(i), item});
            i++;
            //currentNum--;
            currentNum = cueList.size() + 1;
        }
        
    }
    
    private void addCueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (cueDetails.getText().length() > 0) {
            if (taken(number.getText())) {
                JOptionPane.showMessageDialog(null, "Error. Cue name already taken!");
            } else {
                if (number.getText().contains(" ")) {
                    JOptionPane.showMessageDialog(null, "Error, please retype cue number. Already Taken.");
                    number.setText("");
                } else {
                    cueList.add(cueDetails.getText());
                    cueNum.add(number.getText());
                    //currentNum += 1;
                    currentNum = cueList.size() + 1;
                    number.setText(Integer.toString(currentNum));
                    updateTable();
                    cueDetails.setText(""); 
                    lastCueLabel.setText(cueNum.get(cueNum.size() - 1));
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have not entered any details. Please try again.");
            cueDetails.setText("");
        }
        justSaved = false;
    }                                            

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int lastNum = (currentNum - 1);
        int testNum = lastNum + 1;
        String lastNumString = Integer.toString(lastNum);
        if (testNum != 1 || testNum != 0 || testNum != -1) {
            String toRemove = removeTextBox.getText();
            boolean isInList = taken(toRemove);
            if (removeTextBox.getText().equalsIgnoreCase("LAST")) {
                    if (!cueNum.isEmpty()) {
                        cueList.remove(0);
                        cueNum.remove(0);
                        number.setText(Integer.toString(cueNum.size() + 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Error. There are no cues in the list.");
                    }

            } else {
                if (isInList) {
                    for (int i = 0; i < cueList.size(); i++) {
                        if (cueNum.get(i).equalsIgnoreCase(toRemove)) {
                            cueList.remove(i);
                            cueNum.remove(i);
                            removeTextBox.setText("LAST");
                            number.setText(Integer.toString(cueNum.size() + 1));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error. " + removeTextBox.getText() + " is not a valid cue number.");
                }  
            }
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "There are no cues! Please add a cue before removing.");
        }
        justSaved = false;
    }                                            

    private boolean taken(String test) {
        for (String toTest: cueNum) {
            if (toTest.equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        saveCueList();
        justSaved = true;
    }                                          

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        loadCueList();
        justSaved = true;
    }                                            
       
    private void saveCueList() {
        try {
            File file;
            if (JOptionPane.showConfirmDialog(null, "Would you like to customize the save name? Default: cueDetails.txt", "Custom Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                JFrame frame = new JFrame("Save Name");
                String saveName1 = JOptionPane.showInputDialog(frame, "What would you like to call it?");
                String saveNameFinal = "C:/" + saveName1 + ".txt";
                file = new File(saveNameFinal);
                int answer = 10;
                
                while (file.exists() && answer != JOptionPane.YES_OPTION) {
                    answer = JOptionPane.showConfirmDialog(null, "This file name already exists. Would you like to overwrite it or change the name? Yes to overwrite, no to change the name.", "Filename already exists", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (answer == JOptionPane.NO_OPTION) {
                        saveName1 = JOptionPane.showInputDialog(frame, "What would you like to call it?");
                        saveNameFinal = "C:/" + saveName1 + ".txt";
                        file = new File(saveNameFinal);
                    } else if (answer == JOptionPane.CANCEL_OPTION) {
                        break;   
                    }
                }
                
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (String cueList1 : cueList) {
                     bw.write(cueList1);
                     bw.write("FZDBACIE");
                }
                bw.close();
                
            } else {
                file = new File("C:/cueDetails.txt");
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (String cueList1 : cueList) {
                     bw.write(cueList1);
                     bw.write("FZDBACIE");
                }
                bw.close();
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file;

            if (JOptionPane.showConfirmDialog(null, "Would you like to customize the save name? Default: cueNums.txt", "Custom Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                JFrame frame = new JFrame("Save Name");
                String saveName1 = JOptionPane.showInputDialog(frame, "What would you like to call it?");
                String saveNameFinal = "C:/" + saveName1 + ".txt";
                file = new File(saveNameFinal);
                int answer = 10;
                
                while (file.exists() && answer != JOptionPane.YES_OPTION) {
                    answer = JOptionPane.showConfirmDialog(null, "This file name already exists. Would you like to overwrite it or change the name? Yes to overwrite, no to change the name.", "Filename already exists", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (answer == JOptionPane.NO_OPTION) {
                        saveName1 = JOptionPane.showInputDialog(frame, "What would you like to call it?");
                        saveNameFinal = "C:/data/" + saveName1 + ".txt";
                        file = new File(saveNameFinal);
                    } else if (answer == JOptionPane.CANCEL_OPTION) {
                        break;   
                    }
                }
                
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (String cueNums1 : cueNum) {
                     bw.write(cueNums1);
                     bw.write("FZDBACIE");
                }
                bw.close();
                
            } else {
                file = new File("C:/cueNums.txt");
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                for (String cueNums1 : cueNum) {
                     bw.write(cueNums1);
                     bw.write("FZDBACIE");
                }
                bw.close();
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadCueList() {
        Scanner s = null;
        if (JOptionPane.showConfirmDialog(null, "Would you like to load a custom list file? NO loads default, if available", "Custom Load", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                try {
                    s = new Scanner(new BufferedReader(new FileReader(file.getAbsolutePath()))).useDelimiter("FZDBACIE");
                    cueList.clear();
                    while (s.hasNext()) {
                    cueList.add(s.next());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CueUI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (s!=null) {
                        s.close();
                    }
                }
            }
        } else {
            try {
                s = new Scanner(new BufferedReader(new FileReader("C:/cueDetails.txt"))).useDelimiter("FZDBACIE");
                cueList.clear();
                while (s.hasNext()) {
                    cueList.add(s.next());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CueUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (s!=null) {
                    s.close();
                }
            }
        }
        if (JOptionPane.showConfirmDialog(null, "Would you like to load a custom number file? NO loads default, if available", "Custom Load", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                try {
                    s = new Scanner(new BufferedReader(new FileReader(file.getAbsolutePath()))).useDelimiter("FZDBACIE");
                    cueNum.clear();
                    while (s.hasNext()) {
                    cueNum.add(s.next());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CueUI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (s!=null) {
                        s.close();
                    }
                }
            }
        } else {
            try {
                s = new Scanner(new BufferedReader(new FileReader("C:/cueNums.txt"))).useDelimiter("FZDBACIE");
                cueNum.clear();
                while (s.hasNext()) {
                    cueNum.add(s.next());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CueUI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (s!=null) {
                    s.close();

                }
            }
            
        }
        number.setText(Integer.toString(cueNum.size()+1));
        currentNum = cueNum.size()+1;
        lastCueLabel.setText(cueNum.get(cueNum.size() - 1));
        updateTable();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CueUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CueUI().setVisible(true);
            }
        });
    }
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel lastCueLabel;
    private JButton addCueButton;
    private JButton exitButton;
    private JButton reloadButton;
    private JButton removeButton;
    private JButton saveButton;
    private JTextField cueDetails;
    private JTextField number;
    private JTextField removeTextBox;
    private JFileChooser fileChooser;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
}

/*
 * TODO:
 *      save and load special directory in appdata - see test for code
 * 
 * 
 * 
 */
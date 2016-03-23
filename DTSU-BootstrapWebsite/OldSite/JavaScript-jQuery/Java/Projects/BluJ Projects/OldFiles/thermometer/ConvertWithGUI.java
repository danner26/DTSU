import javax.swing.*;
import BreezySwing.*;
    public class ConvertWithGUI extends GBFrame
    {
    private JLabel          fahrenheitLabel;
    private JLabel          celsiusLabel;
    private DoubleField     fahrenheitField;
    private DoubleField     celsiusField;
    private JButton         fahrenheitButton;
    private JButton         celsiusButton;
    
        public ConvertWithGUI()
        {
            fahrenheitLabel = addLabel       ("Fahrenheit" ,1,1,1,1);
            celsiusLabel    = addLabel       ("Celsius"    ,1,2,1,1);
            
            fahrenheitField = addDoubleField (32.0         ,2,1,1,1);
            celsiusField    = addDoubleField (0.0          ,2,2,1,1);
            fahrenheitButton= addButton      (">>>>>>"     ,3,1,1,1);
            celsiusButton   = addButton      ("<<<<<<"     ,3,2,1,1);
        }
        
        public void buttonClicked (JButton buttonObj)
        {
            Thermometer thermo = new Thermometer();
        
            if (buttonObj == fahrenheitButton)
            {
                thermo.setFahrenheit(fahrenheitField.getNumber());
                celsiusField.setNumber (thermo.getCelsius());
            }
            else
            {
                thermo.setCelsius(celsiusField.getNumber());
                fahrenheitField.setNumber (thermo.getFahrenheit());
            }
        }
        public static void main(String[] args)
        {
                ConvertWithGUI theGUI = new ConvertWithGUI();
            theGUI.setSize(250, 100);
            theGUI.setVisible(true);
            
        }
}
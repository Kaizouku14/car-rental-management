package Utils;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JTextField;

public class Utils {
    
     public boolean fieldChecker(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField jTextField) {
                String text = jTextField.getText().trim();
                if (text.isEmpty()) {
                    return true; // Found an empty text field
                }
            }
        }
        return false; // No empty text fields found
     }
     
      public void clearFields(Container container){
         for (Component c : container.getComponents()) {
            if (c instanceof JTextField jTextField) {
                 jTextField.setText("");
            }
        }
     }
       
}

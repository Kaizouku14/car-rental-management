package Utils;

import MainForms.Panels.AdminCarPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Helper {
    
     public boolean fieldChecker(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField jTextField) {
                String text = jTextField.getText().trim();
                if (text.isEmpty()) {
                    return true; // Found an empty text field
                }
            }
        }
        return false; 
     }
     
      public void clearFields(Container container){
         for (Component c : container.getComponents()) {
            if (c instanceof JTextField jTextField) {
                 jTextField.setText("");
            }
        }
     }
       
    public String browseImage(Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Set the file filter to accept PNG, JPEG, JPG, and WAV files
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPEG, JPG, and WAV files",
                "png", "jpeg", "jpg", "wav");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            if (path.toLowerCase().endsWith(".png") || path.toLowerCase().endsWith(".jpeg") || path.toLowerCase().endsWith(".jpg")) {
                  return path;
            }else{
                JOptionPane.showMessageDialog(parent, "Selected file is not a supported image format.", "Invalid File", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return null;
    }  
      
}

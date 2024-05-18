package Main.Dialogs;

import Main.Panels.AdminCarPanel;
import Service.Database;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Utils.EventListener;
import Utils.Helper;

public class ManageCarDialog extends javax.swing.JDialog {
        
    private EventListener listener; 
    private Database db;
    private int id;
    private String path;

    public ManageCarDialog(java.awt.Frame parent, boolean modal, int car_id ,String car_name ,int no_of_seats ,
                           double rent_price ,String availability , EventListener listener) {
       super(parent, modal);
       this.listener = listener;
       this.id = car_id;
       db = new Database();
         
       initComponents();
       setComponentsData(car_id, car_name, no_of_seats, rent_price, availability);
       getImage(car_id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        edit_button = new javax.swing.JButton();
        rent_price_txt = new javax.swing.JTextField();
        car_name_txt = new javax.swing.JTextField();
        No_of_seats_txt = new javax.swing.JTextField();
        CAR_ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        available_cb = new javax.swing.JCheckBox();
        photoHolder_lbl = new javax.swing.JLabel();
        uploadImage = new javax.swing.JButton();

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CAR NAME");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CAR NAME");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Car");
        setResizable(false);

        update_button.setText("UPDATE");
        update_button.setEnabled(false);
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("DELETE");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        edit_button.setText("EDIT");
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
            }
        });

        rent_price_txt.setEnabled(false);

        car_name_txt.setEnabled(false);

        No_of_seats_txt.setEnabled(false);

        CAR_ID.setEnabled(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CAR ID");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NO. OF SEATS");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CAR NAME");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RENT PRICE");

        available_cb.setText("Available");
        available_cb.setEnabled(false);

        photoHolder_lbl.setBackground(new java.awt.Color(153, 153, 153));
        photoHolder_lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        photoHolder_lbl.setIconTextGap(0);
        photoHolder_lbl.setPreferredSize(new java.awt.Dimension(134, 172));

        uploadImage.setText("Upload ");
        uploadImage.setEnabled(false);
        uploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(available_cb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rent_price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(No_of_seats_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(car_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CAR_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(edit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CAR_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(car_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No_of_seats_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addComponent(rent_price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uploadImage)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(available_cb))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setComponentsData(int car_id, String car_name, int no_of_seats, double rent_price, String availability){
       CAR_ID.setText(String.valueOf(car_id));
       car_name_txt.setText(car_name);
       No_of_seats_txt.setText(String.valueOf(no_of_seats));
       rent_price_txt.setText(String.valueOf(rent_price));
       
       if(availability.equals("available")){
           available_cb.setSelected(true);
       }
    }
    
    private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageActionPerformed
      try {
            Helper helper = new Helper();
            path = helper.browseImage(this);
            
            if(path == null){
               JOptionPane.showMessageDialog(this,"Please select a photo!","Error", JOptionPane.ERROR_MESSAGE); 
            }else{
               BufferedImage bi = ImageIO.read(new File(path)); 
               Image image = bi.getScaledInstance(150, 172, Image.SCALE_SMOOTH); //Set the size of image
               ImageIcon icon = new ImageIcon(image); 
               photoHolder_lbl.setIcon(icon);
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminCarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uploadImageActionPerformed
    
    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_buttonActionPerformed
         int result = JOptionPane.showConfirmDialog(this,"Are you sure you want to toggle edit?", "Edit",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
      
        if(result ==  JOptionPane.YES_NO_OPTION){       
            JOptionPane.showMessageDialog(this,"Edit enabled");
            setEnable();
        }
    }//GEN-LAST:event_edit_buttonActionPerformed
    
    private void setEnable(){
        car_name_txt.setEnabled(true);
        No_of_seats_txt.setEnabled(true);
        rent_price_txt.setEnabled(true);
        available_cb.setEnabled(true);
        uploadImage.setEnabled(true);
        update_button.setEnabled(true);
    }
    
    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
       int result = JOptionPane.showConfirmDialog(this,"Are you sure you want to toggle edit?", "Edit",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
       
       if(result == JOptionPane.YES_NO_OPTION){
           removeVehicle(id);
       }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void removeVehicle(int id){
        String sqlQuery = "DELETE FROM CARS WHERE CAR_ID = ?";
        
        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            
            if(rowsAffected > 0){
                 if (listener != null) {
                     listener.onEventListenerClicked("Car Info Example");
                     JOptionPane.showMessageDialog(this,"Car successfully removed!");
                    }
                dispose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
       int result = JOptionPane.showConfirmDialog(this,"Are you sure you want to Update car information?", "Update",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
       
       if(result == JOptionPane.YES_NO_OPTION){
           
           try {
               String car_name = car_name_txt.getText();
               int no_of_seats = Integer.parseInt(No_of_seats_txt.getText());
               double rent_price = Double.parseDouble(rent_price_txt.getText());
               boolean availability = available_cb.isSelected();
               String path = this.path;
               
               updateVehicle(id ,car_name ,no_of_seats ,rent_price ,availability , path);
           } catch (IOException ex) {
               Logger.getLogger(ManageCarDialog.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_update_buttonActionPerformed
    
   private void updateVehicle(int id, String car_name, int no_of_seats, double rent_price, boolean availability, String path) throws IOException {      
      String sqlQueryWithImage = "UPDATE CARS SET CAR_NAME = ?, NO_OF_SEATS = ?, RENT_PRICE = ?, AVAILABILITY = ?, CAR_IMAGE = ? WHERE CAR_ID = ?";
      String sqlQueryWithoutImage = "UPDATE CARS SET CAR_NAME = ?, NO_OF_SEATS = ?, RENT_PRICE = ?, AVAILABILITY = ? WHERE CAR_ID = ?";

      if (path == null) {
            updateVehicleInfo(sqlQueryWithoutImage, id, car_name, no_of_seats, rent_price, availability, null);
      } else {
            updateVehicleInfo(sqlQueryWithImage, id, car_name, no_of_seats, rent_price, availability, path);
      }
   }

   private void updateVehicleInfo(String sqlQuery, int id, String car_name, int no_of_seats, double rent_price, boolean availability, String path) throws IOException {
      try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
           PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            InputStream is = new FileInputStream(new File(path));
            statement.setString(1, car_name);
            statement.setInt(2, no_of_seats);
            statement.setDouble(3, rent_price);
            statement.setBoolean(4, availability);
            
        if (is != null) {
            statement.setBlob(5, is);
            statement.setInt(6, id);
        } else {
            statement.setNull(5, java.sql.Types.BLOB);
            statement.setInt(5, id);
        }
        
        if (statement.executeUpdate() > 0) {
            if (listener != null) {
                JOptionPane.showMessageDialog(this, "Car info updated successfully!");
                listener.onEventListenerClicked("Success");
                dispose();
            }
        } 
        
      } catch (SQLException e) {
        Logger.getLogger(ManageCarDialog.class.getName()).log(Level.SEVERE, "Database error during update.", e);
      }
    }
    
   private void getImage(int id){
        String sqlQuery = "SELECT car_image FROM CARS WHERE CAR_ID = ?";

        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    Blob car_image = result.getBlob("car_image");
                    byte[] imageData = car_image.getBytes(1, (int) car_image.length());
                    ImageIcon imageIcon = new ImageIcon(imageData);

                    Image image = imageIcon.getImage().getScaledInstance(150, 172, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(image);

                    photoHolder_lbl.setIcon(scaledImageIcon); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CAR_ID;
    private javax.swing.JTextField No_of_seats_txt;
    private javax.swing.JCheckBox available_cb;
    private javax.swing.JTextField car_name_txt;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton edit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel photoHolder_lbl;
    private javax.swing.JTextField rent_price_txt;
    private javax.swing.JButton update_button;
    private javax.swing.JButton uploadImage;
    // End of variables declaration//GEN-END:variables
}

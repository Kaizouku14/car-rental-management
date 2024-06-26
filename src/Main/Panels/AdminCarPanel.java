package Main.Panels;

import Components.tabbed.TabbedForm;
import Main.Dialogs.ManageCarDialog;
import Service.Database;
import Utils.Helper; 
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Utils.EventListener;

public class AdminCarPanel extends TabbedForm implements EventListener{
    
    private String car_name, carImage_path;
    private int no_of_seats;
    private double rent_price;
    private JFrame parentFrame;
    private Database db;
    private Helper helper;
    
    public AdminCarPanel(){
        //default constructor
    }

    public AdminCarPanel(JFrame frame) {
        this.parentFrame = frame;
        db = new Database();
        helper = new Helper();
        
        initComponents();
        renderDataToTable();
        registerTableRowSelectionListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photoHolder_lbl = new javax.swing.JLabel();
        add_btn = new javax.swing.JButton();
        carName_txt = new javax.swing.JTextField();
        noSeaters_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uploadImage = new javax.swing.JButton();
        rent_price_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        car_table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(903, 561));

        photoHolder_lbl.setBackground(new java.awt.Color(153, 153, 153));
        photoHolder_lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        photoHolder_lbl.setIconTextGap(0);
        photoHolder_lbl.setPreferredSize(new java.awt.Dimension(134, 172));

        add_btn.setText("ADD CAR");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        carName_txt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        noSeaters_txt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("No. of seaters");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Carl name");

        uploadImage.setText("Upload ");
        uploadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImageActionPerformed(evt);
            }
        });

        rent_price_txt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Rent price");

        car_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CAR ID", "CAR NAME", "NO. OF SEATS", "RENT PRICE", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        car_table.setRowHeight(30);
        car_table.setShowVerticalLines(true);
        jScrollPane1.setViewportView(car_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(224, 224, 224)
                                        .addComponent(jLabel3))
                                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noSeaters_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 175, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(60, 60, 60)
                                .addComponent(rent_price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(uploadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uploadImage)
                            .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rent_price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noSeaters_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    @Override
    public void onEventListenerClicked(String carInfo) {
        if(carInfo.trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Updating car info failed");
        }else{
           renderDataToTable();  
           registerTableRowSelectionListener();
        }
    }

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
      String sqlQuery = "INSERT INTO CARS (CAR_NAME, NO_OF_SEATS ,RENT_PRICE ,AVAILABILITY, CAR_IMAGE) VALUES(?,?,?,?,?)";

        if(helper.fieldChecker(this)){
           JOptionPane.showMessageDialog(this,"Please fill up all the textfields!","Required", JOptionPane.ERROR_MESSAGE);
        }else if(photoHolder_lbl.getIcon() == null){
           JOptionPane.showMessageDialog(this,"Please add a picture before adding the car!","Required", JOptionPane.ERROR_MESSAGE);
        }else{
            car_name = carName_txt.getText();   
            no_of_seats = Integer.parseInt(noSeaters_txt.getText());
            rent_price = Double.parseDouble(rent_price_txt.getText()); 
            
          try {
              InputStream carImage = new FileInputStream(new File(carImage_path));      
              int rowsAffected = insertData(sqlQuery, car_name, no_of_seats, rent_price,carImage);
           
                if(rowsAffected > 0){
                    photoHolder_lbl.setIcon(null);
                    helper.clearFields(this);
                    renderDataToTable();
                    registerTableRowSelectionListener();
                    
                 JOptionPane.showMessageDialog(this,"Added Successfully!");  
               }else{
                 JOptionPane.showMessageDialog(this,"Insertion failed!","Error", JOptionPane.ERROR_MESSAGE); 
               }
    
          } catch (FileNotFoundException ex) {
             Logger.getLogger(AdminCarPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageActionPerformed
        try {
            carImage_path = helper.browseImage(this);
            
            if(carImage_path == null){
               JOptionPane.showMessageDialog(this,"Please select a photo!","Error", JOptionPane.ERROR_MESSAGE); 
            }else{
               BufferedImage bi = ImageIO.read(new File(carImage_path));
               Image image = bi.getScaledInstance(150, 172, Image.SCALE_SMOOTH);
               ImageIcon icon = new ImageIcon(image); 
               photoHolder_lbl.setIcon(icon);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(AdminCarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uploadImageActionPerformed
  
    public int insertData(String sqlQuery, String car_name, int no_of_seats, double rent_price, InputStream imageStream){
        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {
             
            statement.setString(1, car_name);
            statement.setInt(2, no_of_seats);
            statement.setDouble(3, rent_price);
            statement.setBoolean(4, true);
            statement.setBlob(5, imageStream);
            
            return statement.executeUpdate();
        
        }catch(SQLException e) {
            e.printStackTrace();
        }    
        
        return -1;
    }
    
    public void renderDataToTable(){
         String rent_status, sqlQuery = "SELECT * FROM CARS";
        
         try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery);
             ResultSet result = statement.executeQuery()) {
             DefaultTableModel model = (DefaultTableModel) car_table.getModel();
             model.setRowCount(0);
             
             while(result.next()){ 
                if(result.getBoolean("AVAILABILITY")) rent_status = "available";
                else rent_status = "rented";    
                
              if(result.getBoolean("AVAILABILITY")){
                Object[] row = {result.getInt("CAR_ID"), result.getString("CAR_NAME"), result.getInt("NO_OF_SEATS"), 
                                result.getDouble("RENT_PRICE"), rent_status};
             
                model.addRow(row);
              }  
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }  
    }   

    
    private void registerTableRowSelectionListener() {
        ListSelectionModel selectionModel = car_table.getSelectionModel();
        EventListener listener = this;
        
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()) {  // Check if the event is not in the process of changing
                 int selectedRow = car_table.getSelectedRow();
                    if (selectedRow != -1) {  
                     Object[] data = new Object[5];

                    for(int i = 0; i < data.length; i++){
                        data[i] = car_table.getValueAt(selectedRow, i);
                    }
                        
                    new ManageCarDialog(parentFrame ,true ,(int) data[0] ,(String) data[1] ,(int) data[2] ,
                            (double) data[3], listener)
                                .setVisible(true);
                    }
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField carName_txt;
    private javax.swing.JTable car_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField noSeaters_txt;
    private javax.swing.JLabel photoHolder_lbl;
    private javax.swing.JTextField rent_price_txt;
    private javax.swing.JButton uploadImage;
    // End of variables declaration//GEN-END:variables


 
}

package MainForms.Dialogs;

import static javax.swing.JOptionPane.showMessageDialog;
import Service.Database;
import Utils.EventListener;
import Utils.Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.ImageIcon;

public class TransactionDialog extends javax.swing.JDialog {
    
     private Helper util;
     private Database db;
     private int car_id;
     private boolean availability;
     private EventListener listener;
  
    public TransactionDialog(java.awt.Frame parent, boolean modal, 
        ImageIcon image,String car_name , int no_of_seats, double price_txt,
        int car_id, boolean availability, EventListener listener ) {
        super(parent, modal);
        initComponents();
        
     
        util = new Helper();
        db = new Database();
        photoHolder_lbl.setIcon(image);
        car_name_lbl.setText(car_name);
        no_of_seats_lbl.setText(String.valueOf(no_of_seats));
        price_lbl.setText(String.valueOf(price_txt));
        this.car_id = car_id;
        this.listener = listener;
    }
                 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        no_of_days_txt = new javax.swing.JTextField();
        rent_btn = new javax.swing.JButton();
        photoHolder_lbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        no_of_seats_lbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        price_lbl = new javax.swing.JLabel();
        car_name_lbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phoneno_txt = new javax.swing.JTextField();
        name_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rent car");

        jLabel5.setText("No. of days to rent");

        rent_btn.setText("Rent Now");
        rent_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rent_btnActionPerformed(evt);
            }
        });

        photoHolder_lbl.setBackground(new java.awt.Color(153, 153, 153));
        photoHolder_lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        photoHolder_lbl.setIconTextGap(0);
        photoHolder_lbl.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel6.setText("No . of seats  :");

        jLabel1.setText("Price  : ");

        no_of_seats_lbl.setText("0");

        jLabel2.setText("Car name  : ");

        price_lbl.setText("00000");

        car_name_lbl.setText("car name");

        jLabel3.setText("Name  : ");

        jLabel4.setText("Phone number  :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(phoneno_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(name_txt))
                    .addComponent(no_of_days_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(car_name_lbl))
                    .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(no_of_seats_lbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price_lbl))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneno_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(car_name_lbl))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(no_of_seats_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(price_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(rent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(no_of_days_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void rent_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rent_btnActionPerformed
        // TODO add your handling code here:
         if(util.fieldChecker(jPanel1)){
            showMessageDialog(jPanel1, "Please fill up all the required fields!");
        }else{
             
            String client_name = name_txt.getText();
            String car_name = car_name_lbl.getText();
            String phone_number = phoneno_txt.getText();
            int no_of_days = Integer.parseInt(no_of_days_txt.getText());
            double total_amount = Double.parseDouble(price_lbl.getText()) * Integer.parseInt(no_of_days_txt.getText());
             
            if(insertTransaction(no_of_days , total_amount, client_name , phone_number, car_name, car_id ,availability )){
               rentCar(car_id);
               listener.onEventListenerClicked("Success");
               dispose();
            }
         }
    }//GEN-LAST:event_rent_btnActionPerformed

    public boolean insertTransaction(int no_of_days ,double total_amount, String client_name , String phone_number, 
                                     String car_name, int car_id, boolean availability ){
        
          String sqlQuery = "INSERT INTO TRANSACTION (RENT_START, NO_OF_DAYS ,"
                    + " AMOUNT_TO_PAY , CLIENT_NAME , CLIENT_"
                    + "PHONENUM , CAR_TO_RENT, PLATE_NO, STATUS) VALUES (?,?,?,?,?,?,?,?)";
          
            try(Connection con = DriverManager.getConnection(db.getUrl(), db.getUser() , db.getUser());
                PreparedStatement statement = con.prepareStatement(sqlQuery)){
                LocalDate currentDate = LocalDate.now();
                
               statement.setDate(1, java.sql.Date.valueOf(currentDate));
               statement.setInt(2, no_of_days);
               statement.setDouble(3, total_amount); 
               statement.setString(4, client_name);
               statement.setString(5, phone_number);
               statement.setString(6, car_name);
               statement.setInt(7, car_id);
               statement.setBoolean(8,!availability);   
               
              return statement.executeUpdate() > 0;
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        
        return false;
    }
    
    private void rentCar(int car_id){
       String sqlQuery  = "UPDATE CARS SET AVAILABILITY = ? WHERE CAR_ID = ?";
       
       try(Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
           PreparedStatement statement = con.prepareStatement(sqlQuery)){
          
           statement.setBoolean(1, false);
           statement.setInt(2,car_id);
           statement.executeUpdate();
           
       }catch(SQLException e){
           e.printStackTrace();
       }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel car_name_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField no_of_days_txt;
    private javax.swing.JLabel no_of_seats_lbl;
    private javax.swing.JTextField phoneno_txt;
    private javax.swing.JLabel photoHolder_lbl;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JButton rent_btn;
    // End of variables declaration//GEN-END:variables
}

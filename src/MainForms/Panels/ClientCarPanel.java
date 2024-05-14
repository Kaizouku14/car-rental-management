package MainForms.Panels;

import Components.tabbed.TabbedForm;
import Service.Database;
import Utils.EventListener;
import java.awt.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.*;

public class ClientCarPanel extends TabbedForm implements EventListener {

    private Database db;
    private JPanel mainPanel;
    
    public ClientCarPanel() {
        initComponents();
        db = new Database();
        
        mainPanel = new JPanel();  
        mainPanel = new JPanel(new GridLayout(0, 4 ,10 , 10)); 
        renderCars();
        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setPreferredSize(new Dimension(830, 400));
        jPanel1.add(scrollPane); 
    }
    
       @Override
    public void onEventListenerClicked(String carInfo) {
         if(carInfo.trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"transaction failed!");
        }else{             
           JOptionPane.showMessageDialog(this, "Proceed to Pagzone Car store");
           renderCars();
        }
    }

    private ArrayList<Object[]> getCars(String sqlQuery, Object values) {
          ArrayList<Object[]> temp = new ArrayList<>();

          try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
               PreparedStatement statement = con.prepareStatement(sqlQuery)) {

              if(values instanceof Boolean){
                statement.setBoolean(1, (boolean) values);
              }else{
                statement.setString(1, (String) values);
              }
           
              try (ResultSet result = statement.executeQuery()) {
                  while (result.next()) {
                      Object[] carData = new Object[6];
                        carData[0] = result.getString("CAR_NAME");
                        carData[1] = result.getInt("NO_OF_SEATS");
                        carData[2] = result.getDouble("RENT_PRICE");
                        carData[3] = result.getBoolean("AVAILABILITY");

                        Blob imageBlob = result.getBlob("CAR_IMAGE");
                        carData[4] = imageBlob.getBytes(1, (int) imageBlob.length());
                        carData[5] = result.getInt("CAR_ID"); 
                        
                    temp.add(carData);
                  }
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }

          return temp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        search_bar_txt = new javax.swing.JTextField();

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(757, 392));

        search_bar_txt.setText("Search car...");
        search_bar_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_bar_txtFocusGained(evt);
            }
        });
        search_bar_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_bar_txtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_bar_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_txtKeyTyped
        // TODO add your handling code here:
        if(search_bar_txt.getText().trim().isEmpty()){
            renderCars();
        }else{
           filterSearch(search_bar_txt.getText());
        }
    }//GEN-LAST:event_search_bar_txtKeyTyped

    private void search_bar_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_bar_txtFocusGained
        search_bar_txt.setText("");
    }//GEN-LAST:event_search_bar_txtFocusGained

    public void renderCars() {
       ArrayList<Object[]> cars = getCars("SELECT * FROM CARS WHERE AVAILABILITY = ?", true);
       renderData(cars);
    }
    
    private void filterSearch(String str) {
      String sqlQuery = "SELECT * FROM cars WHERE car_name LIKE ?";
      ArrayList<Object[]> searchedCars = getCars(sqlQuery, "%" + str.trim() + "%");
      renderData(searchedCars);
    }

    private void renderData(ArrayList<Object[]> data) {
     clearPanel();
 
     for (Object[] carData : data) {
         JPanel prodPanel = new JPanel();
         prodPanel.setSize(181, 248);
         
        byte[] imageData = (byte[]) carData[4];
        ImageIcon imageIcon = new ImageIcon(imageData);
       
       if((boolean) carData[3]){
          EventListener listener = this;
         prodPanel.add(new ProdPanel(imageIcon, (String) carData[0], (double) carData[2], 
                                    (int) carData[1], (int) carData[5], (boolean) carData[3], listener));
         mainPanel.add(prodPanel);
        }
      }
    }
     
    private void clearPanel() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField search_bar_txt;
    // End of variables declaration//GEN-END:variables


}

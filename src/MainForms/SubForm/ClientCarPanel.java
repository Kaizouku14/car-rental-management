package MainForms.SubForm;

import Components.tabbed.TabbedForm;
import Service.Database;
import java.awt.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.*;

public class ClientCarPanel extends TabbedForm {

    private Database db;
    private JPanel mainPanel;
    
    public ClientCarPanel() {
        initComponents();
        db = new Database();
        
        mainPanel = new JPanel();   
        renderCars();
        mainPanel = new JPanel(new GridLayout(0, 4 ,10 , 10)); 
        renderCars();
        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setPreferredSize(new Dimension(830, 400));
        jPanel1.add(scrollPane); 
    }

    private ArrayList<Object[]> getCars() {
        ArrayList<Object[]> temp = new ArrayList<>();
        String sqlQuery = "SELECT * FROM CARS";

        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                Object[] carData = new Object[5]; 
                carData[0] = result.getString("CAR_NAME");
                carData[1] = result.getInt("NO_OF_SEATS");
                carData[2] = result.getDouble("RENT_PRICE");
                carData[3] = result.getBoolean("AVAILABILITY");
                
                Blob imageBlob = result.getBlob("CAR_IMAGE");
                carData[4] = imageBlob.getBytes(1, (int) imageBlob.length());

                temp.add(carData);
            }

            return temp;

        } catch (SQLException e) {
            e.printStackTrace();
        }

      return null;
   }
    
  private void renderCars() {
    ArrayList<Object[]> cars = getCars();

    for (Object[] carData : cars) {
        JPanel carPanel = new JPanel(new BorderLayout());
        carPanel.setBorder(BorderFactory.createTitledBorder((String) carData[0])); // Set car name as border title

        try {
            byte[] imageData = (byte[]) carData[4];
            ImageIcon imageIcon = new ImageIcon(imageData);

            Image scaledImage = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(imageIcon);
            carPanel.add(imageLabel, BorderLayout.NORTH);

        } catch (Exception e) {
            e.printStackTrace();
            JLabel placeholderLabel = new JLabel("Image not available");
            carPanel.add(placeholderLabel, BorderLayout.NORTH);
        }

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        
        JLabel rent_price = new JLabel("RENT PRICE : " + carData[2]);
        JLabel seatsLabel = new JLabel("NO OF SEATS : " + carData[1]);
        JLabel availableLabel = new JLabel("Available : " + carData[3]);
        JButton rentButton = new JButton("Rent");
        rentButton.setForeground(Color.WHITE);
   
        infoPanel.add(rent_price);
        infoPanel.add(seatsLabel);
        infoPanel.add(availableLabel);
        infoPanel.add(rentButton);

        carPanel.add(infoPanel, BorderLayout.SOUTH);
        
        mainPanel.add(carPanel); // Add car panel to main panel
       }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(757, 392));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

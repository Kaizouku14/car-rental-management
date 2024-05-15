package Main.MainForms;

import Components.chart.models.ModelData;
import Components.chart.models.ModelChart;
import Utils.*;
import Components.drawer.AdminDrawerBuilder;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import Components.tabbed.WindowsTabbed;
import Service.Database;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

 //TODO : Update total of cars and total of avail cars when a car is added.

public class AdminForm extends javax.swing.JFrame {
    
    private Database db;
  
    public AdminForm(){
      //Default Constructor
    }
  
    public AdminForm(String username, String email) {
        
        GlassPanePopup.install(this);
        AdminDrawerBuilder drawerBuilder = new AdminDrawerBuilder();  
        Drawer.getInstance().setDrawerBuilder(drawerBuilder);
        CurrentFormHolder.getInstance().setCurrentForm(this);
        drawerBuilder.updateHeaderData(username, email);
        
        initComponents();
        WindowsTabbed.getInstance().install(this, body);
        
        chart.setTitle("Profit Per Month");
        chart.addLegend("Profit", Color.decode("#0099F7"), Color.decode("#F11712"));
        
        db = new Database();
        setData();
        countAllCar();
        countAvailableCars();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        totalCars_panel = new javax.swing.JPanel();
        totalOfCars_lbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        availableCar_lbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        charPanel = new javax.swing.JPanel();
        chart = new Components.chart.CurveLineChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.LINE_AXIS));

        totalCars_panel.setBackground(new java.awt.Color(102, 102, 102));
        totalCars_panel.setForeground(new java.awt.Color(102, 102, 102));

        totalOfCars_lbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalOfCars_lbl.setForeground(new java.awt.Color(255, 255, 255));
        totalOfCars_lbl.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL OF  CARS");

        javax.swing.GroupLayout totalCars_panelLayout = new javax.swing.GroupLayout(totalCars_panel);
        totalCars_panel.setLayout(totalCars_panelLayout);
        totalCars_panelLayout.setHorizontalGroup(
            totalCars_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalCars_panelLayout.createSequentialGroup()
                .addGroup(totalCars_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(totalCars_panelLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(totalOfCars_lbl))
                    .addGroup(totalCars_panelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel4)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        totalCars_panelLayout.setVerticalGroup(
            totalCars_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalCars_panelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOfCars_lbl)
                .addGap(30, 30, 30))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        availableCar_lbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        availableCar_lbl.setForeground(new java.awt.Color(255, 255, 255));
        availableCar_lbl.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CARS AVAILABLE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(84, 84, 84))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(availableCar_lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableCar_lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        charPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        chart.setForeground(new java.awt.Color(246, 246, 246));

        javax.swing.GroupLayout charPanelLayout = new javax.swing.GroupLayout(charPanel);
        charPanel.setLayout(charPanelLayout);
        charPanelLayout.setHorizontalGroup(
            charPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        charPanelLayout.setVerticalGroup(
            charPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(charPanelLayout.createSequentialGroup()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(charPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalCars_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalCars_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(charPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public void countAllCar(){
        int totalOfCars = 0;
        String sqlQuery = "SELECT COUNT(*) AS car_count FROM cars";
        
         try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery);
             ResultSet result = statement.executeQuery()) {
             
                if (result.next()) {
                    int carCount = result.getInt("car_count");
                    totalOfCars += carCount;
                }
         
                totalOfCars_lbl.setText(String.valueOf(totalOfCars));
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void countAvailableCars() {
        int total_of_carAvailable = 0;
        String sqlQuery = "SELECT COUNT(*) AS available_car_count FROM cars WHERE availability = ?";

            try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
                 PreparedStatement statement = con.prepareStatement(sqlQuery)) {

                statement.setBoolean(1, true);  
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        int availableCarCount = result.getInt("available_car_count");
                        total_of_carAvailable += availableCarCount;
                    }
                }

               availableCar_lbl.setText(String.valueOf(total_of_carAvailable));
            } catch (SQLException e) {
                e.printStackTrace();
            }    
    }

     public void setData() {
        List<ModelData> lists = new ArrayList<>();

        String sql = "SELECT rent_start, " +
                     "SUM(amount_to_pay) AS total_amount " +
                     "FROM transaction " +
                     "GROUP BY MONTH(rent_start), YEAR(rent_start) " +
                     "ORDER BY rent_start ASC LIMIT 7";

        try (Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                LocalDate date = resultSet.getDate("rent_start").toLocalDate();
                double amount = resultSet.getDouble("total_amount");
        
                String monthName = date.format(DateTimeFormatter.ofPattern("MMMM"));
                lists.add(new ModelData(monthName,amount));
            }

            for (ModelData d : lists) {
                chart.addData(new ModelChart(d.getMonth(), new double[] {d.getValue()}));
            }

            chart.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void adminForm(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }
    
    public void showMainForm() {
        WindowsTabbed.getInstance().showTabbed(true);
        WindowsTabbed.getInstance().removeAllTabbed();
        setContentPane(body);
        revalidate();
        repaint();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableCar_lbl;
    private javax.swing.JPanel body;
    private javax.swing.JPanel charPanel;
    private Components.chart.CurveLineChart chart;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel totalCars_panel;
    private javax.swing.JLabel totalOfCars_lbl;
    // End of variables declaration//GEN-END:variables

}

package Main.Panels;

import Components.chart.models.ModelChart;
import Components.chart.models.TransactionModel;
import Components.tabbed.TabbedForm;
import Service.Database;
import java.awt.Color;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AdminRentedCars extends TabbedForm {

    private Database db;
    
    public AdminRentedCars() {
        db = new Database();
        initComponents();
        
        transaction_chart.setTitle("Transaction Per Month");
        transaction_chart.addLegend("Costumers", Color.decode("#0099F7"), Color.decode("#F11712"));
        transaction_chart.addLegend("Rented Cars", Color.decode("#7b4397"), Color.decode("#dc2430"));
        
        renderDataToTable("SELECT * FROM TRANSACTION", "");
        registerTableRowSelectionListener();
        setData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        transaction_table = new javax.swing.JTable();
        search_bar_txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        transaction_chart = new Components.chart.CurveLineChart();

        transaction_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRANSACTION ID", "CLIENT NAME", "CONTACT NO.", "CAR RENTED", "PLATE  NO.", "RENT START", "NO. OF DAYS", "PAID AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transaction_table.setRowHeight(30);
        transaction_table.setShowVerticalLines(true);
        jScrollPane1.setViewportView(transaction_table);

        search_bar_txt.setText("Search client...");
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

        transaction_chart.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaction_chart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaction_chart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_bar_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_bar_txtFocusGained
        search_bar_txt.setText("");
    }//GEN-LAST:event_search_bar_txtFocusGained

    private void search_bar_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_txtKeyTyped
        String searchText = search_bar_txt.getText().trim();
        
        if(searchText.isEmpty()){
            renderDataToTable("SELECT * FROM TRANSACTION", "");
        } else {
            filterSearch("SELECT * FROM transaction WHERE client_name LIKE ?", searchText);
        }
    }//GEN-LAST:event_search_bar_txtKeyTyped

    private void renderDataToTable(String sqlQuery, String searchParam) {
      populateTable(sqlQuery, searchParam);
    }

    private void filterSearch(String sqlQuery, String searchParam) {
        populateTable(sqlQuery, "%" + searchParam + "%");
    }

    private void populateTable(String sqlQuery, String searchParam){
        DefaultTableModel model = (DefaultTableModel) transaction_table.getModel();
        model.setRowCount(0);

        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            if(!searchParam.isEmpty()){
                statement.setString(1, searchParam);
            }

            try (ResultSet result = statement.executeQuery()) {
                 while (result.next()) {
                    if(result.getBoolean("STATUS")){
                       Object[] row = {
                                        result.getInt("TRANSACTION_ID"),
                                        result.getString("CLIENT_NAME"),
                                        result.getString("CLIENT_PHONENUM"),
                                        result.getInt("PLATE_NO"),
                                        result.getString("CAR_TO_RENT"),
                                        result.getDate("RENT_START"),
                                        result.getInt("NO_OF_DAYS"),
                                        result.getDouble("AMOUNT_TO_PAY")
                                      };
                      model.addRow(row);
                 }
               }          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void registerTableRowSelectionListener() {
        ListSelectionModel selectionModel = transaction_table.getSelectionModel();
        
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()) {  // Check if the event is not in the process of changing
                int selectedRow = transaction_table.getSelectedRow();
                  if (selectedRow != -1) {  
                    Object id =  transaction_table.getValueAt(selectedRow, 0);
                    Object car_id = transaction_table.getValueAt(selectedRow,3);
                    manageTransaction((int) id , (int) car_id);  
                 }
               }
            }
        });
    }
    
    private void manageTransaction(int transaction_id, int car_id){
      int result = JOptionPane.showConfirmDialog(this,"Return this car?", "Transaction",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
      
        if(result ==  JOptionPane.YES_NO_OPTION){
           updateCarAvailability(car_id);
           updateTransactionStatus(transaction_id);
           renderDataToTable("SELECT * FROM TRANSACTION", "");
        }
    }
        
    private void updateCarAvailability(int car_id){
      String sqlQuery  = "UPDATE CARS SET AVAILABILITY = ? WHERE CAR_ID = ?";
       returnCar(sqlQuery ,true , car_id);
    }
    
    private void updateTransactionStatus(int transaction_id){
        String sqlQuery  = "UPDATE TRANSACTION SET STATUS = ? WHERE TRANSACTION_ID = ?";
        returnCar(sqlQuery ,false , transaction_id);
    }
    
    private void returnCar(String sqlQuery ,boolean value,  int id){
      try(Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
           PreparedStatement statement = con.prepareStatement(sqlQuery)){
           statement.setBoolean(1, value);
           statement.setInt(2,id);
           statement.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       } 
    } 
    
    public void setData() {
        List<TransactionModel> lists = new ArrayList<>();

        String sql = "SELECT rent_start, " +
             "COUNT(*) AS transaction_id, " +
             "COUNT(DISTINCT car_to_rent) AS total_cars_borrowed " +
             "FROM transaction " +
             "GROUP BY MONTH(rent_start), YEAR(rent_start) " +
             "ORDER BY rent_start ASC LIMIT 7";

        try (Connection connection = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                LocalDate date = resultSet.getDate("rent_start").toLocalDate();
                double total_of_costumers = resultSet.getDouble("transaction_id");
                double total_cars_borrowed = resultSet.getDouble("total_cars_borrowed");
        
                String monthName = date.format(DateTimeFormatter.ofPattern("MMMM"));
                lists.add(new TransactionModel(monthName,total_of_costumers,total_cars_borrowed));
            }

            for (TransactionModel d : lists) {
                transaction_chart.addData(new ModelChart(d.getMonth(), new double[] {d.getTotal_of_costumers(), d.getTotal_cars_borrowed()}));
            }

            transaction_chart.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_bar_txt;
    private Components.chart.CurveLineChart transaction_chart;
    private javax.swing.JTable transaction_table;
    // End of variables declaration//GEN-END:variables
}

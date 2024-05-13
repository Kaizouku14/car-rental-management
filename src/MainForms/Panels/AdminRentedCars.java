package MainForms.Panels;

import Components.tabbed.TabbedForm;
import Service.Database;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class AdminRentedCars extends TabbedForm{

    private Database db;
    
    public AdminRentedCars() {
        db = new Database();
        initComponents();
        renderDataToTable();
        registerTableRowSelectionListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        transaction_table = new javax.swing.JTable();
        search_bar_txt = new javax.swing.JTextField();

        transaction_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRANSACTION ID", "CLIENT NAME", "CONTACT NO.", "CAR RENTED", "RENT START", "NO. OF DAYS", "PAID AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(search_bar_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_bar_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_bar_txtFocusGained
        // TODO add your handling code here:
        search_bar_txt.setText("");
    }//GEN-LAST:event_search_bar_txtFocusGained

    private void search_bar_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_bar_txtKeyTyped
        // TODO add your handling code here:
        if(search_bar_txt.getText().trim().isEmpty()){
            renderDataToTable();
        }else{
           filterSearch(search_bar_txt.getText());
        }
    }//GEN-LAST:event_search_bar_txtKeyTyped

    private void renderDataToTable() {
       String sqlQuery = "SELECT * FROM TRANSACTION";

        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery);
             ResultSet result = statement.executeQuery()) {

             populateTable(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
     
    private void filterSearch(String str) {
       String sqlQuery = "SELECT * FROM transaction WHERE client_name LIKE ?";

        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {
             String searchQuery = "%" + str.trim() + "%";
             statement.setString(1, searchQuery);

            try (ResultSet result = statement.executeQuery()) {
                populateTable(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    private void populateTable(ResultSet result) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) transaction_table.getModel();
        model.setRowCount(0);
    
        while (result.next()) {
            Object[] row = {
                result.getInt("TRANSACTION_ID"),
                result.getString("CLIENT_NAME"),
                result.getString("CLIENT_PHONENUM"),
                result.getString("CAR_TO_RENT"),
                result.getDate("RENT_START"),
                result.getInt("NO_OF_DAYS"),
                result.getDouble("AMOUNT_TO_PAY")
            };
            model.addRow(row);
        }
    }
    
    private void registerTableRowSelectionListener() {
        ListSelectionModel selectionModel = transaction_table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()) {  // Check if the event is not in the process of changing
                int selectedRow = transaction_table.getSelectedRow();
                 if (selectedRow != -1) {  
                   int id = (int) transaction_table.getValueAt(selectedRow, 0);
                   String car_name = (String) transaction_table.getValueAt(selectedRow,3);
                   
                   
                 }
               }
            }
        });
    }
    
    private void manageTransaction(int transaction_id){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_bar_txt;
    private javax.swing.JTable transaction_table;
    // End of variables declaration//GEN-END:variables
}

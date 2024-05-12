package MainForms.Panels;

import Components.tabbed.TabbedForm;
import Service.Database;
import java.sql.*;
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
        jScrollPane1.setViewportView(transaction_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void renderDataToTable(){
         String sqlQuery = "SELECT * FROM TRANSACTION";
        
        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery);
             ResultSet result = statement.executeQuery()) {
             DefaultTableModel model = (DefaultTableModel) transaction_table.getModel();
             
             while(result.next()){        
                Object[] row = {result.getInt("TRANSACTION_ID"), result.getString("CLIENT_NAME"), result.getString("CLIENT_PHONENUM"), 
                                result.getString("CAR_TO_RENT"), result.getDate("RENT_START"), result.getInt("NO_OF_DAYS"),
                                result.getDouble("AMOUNT_TO_PAY")};
                model.addRow(row);
             }
             
        }catch(SQLException e) {
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
                     
                   
                 }
               }
             }
          });
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable transaction_table;
    // End of variables declaration//GEN-END:variables
}

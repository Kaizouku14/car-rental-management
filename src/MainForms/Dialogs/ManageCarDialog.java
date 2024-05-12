package MainForms.Dialogs;

import MainForms.Panels.AdminCarPanel;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ManageCarDialog extends javax.swing.JDialog{
    
    private boolean availability = false;

    public ManageCarDialog(java.awt.Frame parent, boolean modal, int car_id ,String car_name ,int no_of_seats ,
            double rent_price ,String availability , ImageIcon image) {
        super(parent, modal);
        initComponents();
        
       Image scaledImage = image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
       image = new ImageIcon(scaledImage);
       
       if(availability.equals("available")){
           this.availability = true;
       }
        
       photoHolder_lbl.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photoHolder_lbl = new javax.swing.JLabel();
        uploadImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Car");
        setResizable(false);

        photoHolder_lbl.setBackground(new java.awt.Color(153, 153, 153));
        photoHolder_lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        photoHolder_lbl.setIconTextGap(0);
        photoHolder_lbl.setPreferredSize(new java.awt.Dimension(134, 172));

        uploadImage.setText("Upload ");
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
                .addContainerGap(299, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(uploadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadImage)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageActionPerformed
        // TODO add your handling code here:
        new AdminCarPanel().browseImage();
    }//GEN-LAST:event_uploadImageActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel photoHolder_lbl;
    private javax.swing.JButton uploadImage;
    // End of variables declaration//GEN-END:variables
}

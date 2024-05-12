package MainForms.Panels;

import MainForms.Dialogs.TransactionDialog;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ProdPanel extends javax.swing.JPanel {
    
    private int no_of_seats;
    private ImageIcon image2;

    public ProdPanel(ImageIcon image, String car_name, double price, int no_of_seats) {
        initComponents();
        
       Image scaledImage = image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
       image = new ImageIcon(scaledImage);
       image2 = new ImageIcon(scaledImage);
        
       photoHolder_lbl.setIcon(image);
       car_name_txt.setText(car_name);
       price_txt.setText(String.valueOf(price)); 
       this.no_of_seats = no_of_seats;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photoHolder_lbl = new javax.swing.JLabel();
        rent_btn = new javax.swing.JButton();
        car_name_txt = new javax.swing.JLabel();
        price_txt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));

        photoHolder_lbl.setBackground(new java.awt.Color(255, 255, 255));
        photoHolder_lbl.setForeground(new java.awt.Color(255, 255, 255));
        photoHolder_lbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        photoHolder_lbl.setIconTextGap(0);
        photoHolder_lbl.setPreferredSize(new java.awt.Dimension(150, 150));

        rent_btn.setForeground(new java.awt.Color(255, 255, 255));
        rent_btn.setText("RENT");
        rent_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rent_btnActionPerformed(evt);
            }
        });

        car_name_txt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        car_name_txt.setForeground(new java.awt.Color(255, 255, 255));
        car_name_txt.setText("CAR NAME");

        price_txt.setForeground(new java.awt.Color(255, 255, 255));
        price_txt.setText("price");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("₱");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price_txt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(car_name_txt)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rent_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(photoHolder_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photoHolder_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(car_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_txt)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rent_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rent_btnActionPerformed
        // TODO add your handling code here:
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        new TransactionDialog(parentFrame, true, image2, car_name_txt.getText(), no_of_seats,Double.parseDouble(price_txt.getText()))
                           .setVisible(true);
    }//GEN-LAST:event_rent_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel car_name_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel photoHolder_lbl;
    private javax.swing.JLabel price_txt;
    private javax.swing.JButton rent_btn;
    // End of variables declaration//GEN-END:variables
}

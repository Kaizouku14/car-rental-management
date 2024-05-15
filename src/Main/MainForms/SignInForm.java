package Main.MainForms;

import Service.*;
import Utils.*;
import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SignInForm extends javax.swing.JPanel {

    private String username , email , password;
    private Helper util;
    private Database db;
    private Authentication auth;
    
    public SignInForm() {
        initComponents();
        util = new Helper();
        db = new Database();
        auth = new Authentication();
    }

    public void addEventBackLogin(ActionListener event) {
       singup_link.addActionListener(event);
    }

    private boolean passwordMatchChecker(){
        return password_txt.getText().equals(confirmpass_txt.getText());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signinPanel = new javax.swing.JPanel();
        register_button = new javax.swing.JButton();
        register_type = new javax.swing.JLabel();
        email_txt = new Components.textfields.TextField();
        password_txt = new Components.textfields.PasswordField();
        jLabel1 = new javax.swing.JLabel();
        confirmpass_txt = new Components.textfields.PasswordField();
        singup_link = new javax.swing.JButton();
        username_txt = new Components.textfields.TextField();
        exit_button = new javax.swing.JButton();

        signinPanel.setBackground(new java.awt.Color(255, 255, 255));
        signinPanel.setForeground(new java.awt.Color(255, 255, 255));
        signinPanel.setPreferredSize(new java.awt.Dimension(312, 374));

        register_button.setBackground(new java.awt.Color(153, 102, 255));
        register_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        register_button.setForeground(new java.awt.Color(255, 255, 254));
        register_button.setText("SIGN IN");
        register_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        register_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });

        register_type.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        register_type.setForeground(new java.awt.Color(0, 0, 0));
        register_type.setText("SIGN IN");

        email_txt.setBackground(new java.awt.Color(255, 255, 255));
        email_txt.setForeground(new java.awt.Color(0, 0, 0));
        email_txt.setCaretColor(new java.awt.Color(0, 0, 0));
        email_txt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        email_txt.setLabelText("EMAIL OR PHONE NUMBER");

        password_txt.setBackground(new java.awt.Color(255, 255, 255));
        password_txt.setForeground(new java.awt.Color(0, 0, 0));
        password_txt.setLabelText("PASSWORD");
        password_txt.setShowAndHide(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Already have an account ?");

        confirmpass_txt.setBackground(new java.awt.Color(255, 255, 255));
        confirmpass_txt.setForeground(new java.awt.Color(0, 0, 0));
        confirmpass_txt.setLabelText("CONFIRM PASSWORD");
        confirmpass_txt.setShowAndHide(true);

        singup_link.setBackground(new java.awt.Color(255, 255, 255));
        singup_link.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        singup_link.setForeground(new java.awt.Color(102, 102, 255));
        singup_link.setText("Sign up");
        singup_link.setBorder(null);

        username_txt.setBackground(new java.awt.Color(255, 255, 255));
        username_txt.setForeground(new java.awt.Color(0, 0, 0));
        username_txt.setCaretColor(new java.awt.Color(0, 0, 0));
        username_txt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        username_txt.setLabelText("USERNAME");

        exit_button.setBackground(new java.awt.Color(255, 255, 255));
        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-x-24.png"))); // NOI18N
        exit_button.setBorder(null);
        exit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signinPanelLayout = new javax.swing.GroupLayout(signinPanel);
        signinPanel.setLayout(signinPanelLayout);
        signinPanelLayout.setHorizontalGroup(
            signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinPanelLayout.createSequentialGroup()
                .addGroup(signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signinPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(register_type)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(exit_button))
                    .addGroup(signinPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, signinPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(singup_link))
                            .addComponent(register_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(email_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(password_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmpass_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(username_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        signinPanelLayout.setVerticalGroup(
            signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signinPanelLayout.createSequentialGroup()
                .addGroup(signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signinPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(register_type, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(signinPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exit_button)))
                .addGap(22, 22, 22)
                .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmpass_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(register_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(signinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(singup_link))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        // TODO add your handling code here:
        if(util.fieldChecker(signinPanel)){
            JOptionPane.showMessageDialog(signinPanel, "Please fill up all the required fields!");
        }else{  
            
            if(passwordMatchChecker()){
                username = username_txt.getText();
                email = email_txt.getText();
                password = password_txt.getText();
                
                if(auth.checkEmail(email)){    
                  JOptionPane.showMessageDialog(signinPanel, "This email is alredy in use, please try other email!");
                }else{
                   if(insertData(username, email, password)){
                      util.clearFields(signinPanel);
                      Main mainFrame = (Main) SwingUtilities.getWindowAncestor(this); // switch to login form
                      mainFrame.switchToLoginForm();
                   }
                }
            }else{
             JOptionPane.showMessageDialog(signinPanel, "password does not match!"); 
            }
        }
    }//GEN-LAST:event_register_buttonActionPerformed

    private boolean insertData(String username ,String email ,String password){
        
       String sqlQuery = "INSERT INTO ACCOUNTS(USERNAME , EMAIL , PASSWORD, ROLE) VALUES(?,?,?,?)";
 
        try (Connection con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPass());
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {
             
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, "Client");
            
            return statement.executeUpdate() > 0;
        
        }catch(SQLException e) {
            e.printStackTrace();
        }    
        
        return false;
    }
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.textfields.PasswordField confirmpass_txt;
    private Components.textfields.TextField email_txt;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private Components.textfields.PasswordField password_txt;
    private javax.swing.JButton register_button;
    private javax.swing.JLabel register_type;
    private javax.swing.JPanel signinPanel;
    private javax.swing.JButton singup_link;
    private Components.textfields.TextField username_txt;
    // End of variables declaration//GEN-END:variables
}

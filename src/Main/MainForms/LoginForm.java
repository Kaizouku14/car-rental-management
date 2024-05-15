package Main.MainForms;

import Service.Authentication;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import Utils.Helper;

public class LoginForm extends javax.swing.JPanel {

    private String email , password;
    private final Helper util;
    
    public LoginForm() {
        initComponents();
        util = new Helper();
    }
    
    public void addEventRegister(ActionListener event) {
        signin.addActionListener(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        login_button = new javax.swing.JButton();
        register_type = new javax.swing.JLabel();
        email_txt = new Components.textfields.TextField();
        password_txt = new Components.textfields.PasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signin = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(312, 374));

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.setForeground(new java.awt.Color(255, 255, 255));
        loginPanel.setPreferredSize(new java.awt.Dimension(312, 374));

        login_button.setBackground(new java.awt.Color(153, 102, 255));
        login_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        login_button.setForeground(new java.awt.Color(255, 255, 254));
        login_button.setText("LOGIN");
        login_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        login_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        register_type.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        register_type.setForeground(new java.awt.Color(0, 0, 0));
        register_type.setText("WELCOME BACK!");

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
        jLabel1.setText("Don't have an account ?");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Login in to your account ");

        signin.setBackground(new java.awt.Color(255, 255, 255));
        signin.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        signin.setForeground(new java.awt.Color(102, 102, 255));
        signin.setText("Sign in");
        signin.setBorder(null);
        signin.setMargin(new java.awt.Insets(2, 1, 3, 14));
        signin.setPreferredSize(new java.awt.Dimension(20, 14));

        exit_button.setBackground(new java.awt.Color(255, 255, 255));
        exit_button.setForeground(new java.awt.Color(255, 255, 255));
        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-x-24.png"))); // NOI18N
        exit_button.setBorder(null);
        exit_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(72, 282, Short.MAX_VALUE)
                        .addComponent(exit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(loginPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(signin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(email_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                        .addComponent(password_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel2))
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(register_type)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit_button)
                .addGap(3, 3, 3)
                .addComponent(register_type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(signin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        String sqlQuery = "SELECT * FROM ACCOUNTS";
        
        if(util.fieldChecker(loginPanel)){
            JOptionPane.showMessageDialog(loginPanel, "Please fill up all the required fields!");
        }else{
            Authentication auth = new Authentication();
            email = email_txt.getText();
            password = password_txt.getText();
            
           if(auth.authentication(sqlQuery, email, password)){
               SwingUtilities.getWindowAncestor(loginPanel).dispose(); //Dispose of the current frame containing the loginPanel   
               
               if(auth.getRole().equals("Admin")){
                  AdminForm admin = new AdminForm(auth.getUsername(), auth.getEmail());
                  admin.setVisible(true);
               }else{
                  ClientForm client = new ClientForm(auth.getUsername(), auth.getEmail());
                  client.setVisible(true);
               }
           }else{
              JOptionPane.showMessageDialog(loginPanel, "Login Failed : Incorrect username or password");
           }
        } 
    }//GEN-LAST:event_login_buttonActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
         System.exit(0); //Exit program
    }//GEN-LAST:event_exit_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.textfields.TextField email_txt;
    private javax.swing.JButton exit_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JButton login_button;
    private Components.textfields.PasswordField password_txt;
    private javax.swing.JLabel register_type;
    private javax.swing.JButton signin;
    // End of variables declaration//GEN-END:variables
}

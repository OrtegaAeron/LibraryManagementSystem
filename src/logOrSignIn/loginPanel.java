/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logOrSignIn;

import java.awt.Color;
import javax.swing.SwingUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import staff.staffDashboard;
import users.memberDashboard;


public class loginPanel extends javax.swing.JFrame {

    public loginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userIdField = new javax.swing.JTextField();
        roleToggleButton = new javax.swing.JToggleButton();
        role = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOG IN PAGE");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(220, 215, 201));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 52)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("<html>LIBRARY<br>LOGIN</html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 10, 230, 160);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libraryLogin.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 270, 450);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(63, 79, 68));
        jPanel2.setLayout(null);

        userIdField.setBackground(new java.awt.Color(220, 215, 201));
        userIdField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        userIdField.setText("Enter Email...");
        userIdField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        userIdField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        userIdField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        userIdField.setForeground(Color.GRAY);
        userIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userIdFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userIdFieldFocusLost(evt);
            }
        });
        jPanel2.add(userIdField);
        userIdField.setBounds(50, 180, 230, 30);

        roleToggleButton.setBackground(new java.awt.Color(63, 79, 68));
        roleToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log-in.png"))); // NOI18N
        roleToggleButton.setBorder(null);
        roleToggleButton.setBorderPainted(false);
        roleToggleButton.setContentAreaFilled(false);
        roleToggleButton.setFocusPainted(false);
        roleToggleButton.setFocusable(false);
        roleToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleToggleButtonActionPerformed(evt);
            }
        });
        jPanel2.add(roleToggleButton);
        roleToggleButton.setBounds(130, 70, 70, 70);

        role.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        role.setForeground(new java.awt.Color(220, 215, 201));
        role.setText("MANAGEMENT LOGIN");
        role.setVisible(false);
        jPanel2.add(role);
        role.setBounds(78, 145, 180, 20);

        passwordField.setBackground(new java.awt.Color(220, 215, 201));
        passwordField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        passwordField.setText("Enter Password...");
        passwordField.setActionCommand("<Not Set>");
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
        jPanel2.add(passwordField);
        passwordField.setBounds(50, 240, 230, 30);

        loginButton.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(220, 215, 201));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log-in-button.png"))); // NOI18N
        loginButton.setText("LOGIN");
        loginButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        SwingUtilities.invokeLater(() -> loginButton.requestFocusInWindow());
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loginButton);
        loginButton.setBounds(180, 300, 100, 40);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 215, 201));
        jLabel3.setText("NO ACCOUNT YET?");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 387, 110, 15);

        signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sign-up.png"))); // NOI18N
        signUpButton.setBorder(null);
        signUpButton.setBorderPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel2.add(signUpButton);
        signUpButton.setBounds(111, 383, 70, 20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roleToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleToggleButtonActionPerformed
        if (roleToggleButton.isSelected()) {
            role.setVisible(true);
        } else {       
            role.setVisible(false);
        }
    }//GEN-LAST:event_roleToggleButtonActionPerformed

    private void userIdFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userIdFieldFocusLost
        if (userIdField.getText().isEmpty()) {
            userIdField.setText("Enter Email...");
            userIdField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_userIdFieldFocusLost
    private void userIdFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userIdFieldFocusGained
        if (userIdField.getText().equals("Enter Email...")) {
            userIdField.setText("");
            userIdField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_userIdFieldFocusGained
    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (passwordField.getPassword().length == 0) {
            passwordField.setText("Enter Password...");
            passwordField.setForeground(Color.GRAY);
            passwordField.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_passwordFieldFocusLost
    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if (String.valueOf(passwordField.getPassword()).equals("Enter Password...")) {
            passwordField.setText("");
            passwordField.setForeground(Color.BLACK);
            passwordField.setEchoChar('•');
        }
    }//GEN-LAST:event_passwordFieldFocusGained
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String email = userIdField.getText();
        String password = new String(passwordField.getPassword());
        String role = "Member";
    
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both email and password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(roleToggleButton.isSelected()){role = "Staff";}
        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root"; 
        String pass = ""; 
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                if(roleToggleButton.isSelected()){new staffDashboard().setVisible(true);}
                else{new memberDashboard(email).setVisible(true);}
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        new signinPanel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signUpButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel role;
    private javax.swing.JToggleButton roleToggleButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField userIdField;
    // End of variables declaration//GEN-END:variables
}

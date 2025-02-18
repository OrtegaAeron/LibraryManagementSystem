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
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class signinPanel extends javax.swing.JFrame {

    /**
     * Creates new form signinPanel
     */
    public signinPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        nameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        numberField = new javax.swing.JTextField();
        brgyField = new javax.swing.JTextField();
        signUpButton = new javax.swing.JButton();
        cityField = new javax.swing.JTextField();
        provinceField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEW USER");
        setBackground(new java.awt.Color(44, 57, 48));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setForeground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(220, 215, 201));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 70)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("SIGN UP");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 10, 370, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/librarySignin.jpg"))); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, -50, 400, 266);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(63, 79, 68));
        jPanel4.setLayout(null);

        passwordField.setBackground(new java.awt.Color(220, 215, 201));
        passwordField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        passwordField.setText("PASSWORD");
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
        passwordField.setEchoChar((char) 0);
        jPanel4.add(passwordField);
        passwordField.setBounds(190, 220, 170, 30);

        nameField.setBackground(new java.awt.Color(220, 215, 201));
        nameField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        nameField.setText("FULL NAME");
        nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFieldFocusLost(evt);
            }
        });
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel4.add(nameField);
        nameField.setBounds(30, 40, 330, 30);

        emailField.setBackground(new java.awt.Color(220, 215, 201));
        emailField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        emailField.setText("EMAIL ADDRESS");
        emailField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        emailField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        jPanel4.add(emailField);
        emailField.setBounds(30, 160, 330, 30);

        numberField.setBackground(new java.awt.Color(220, 215, 201));
        numberField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        numberField.setText("CONTACT NUMBER");
        numberField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        numberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numberField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        numberField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numberFieldFocusLost(evt);
            }
        });
        numberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberFieldKeyTyped(evt);
            }
        });
        jPanel4.add(numberField);
        numberField.setBounds(30, 220, 140, 30);

        brgyField.setBackground(new java.awt.Color(220, 215, 201));
        brgyField.setColumns(3);
        brgyField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        brgyField.setText("BARANGAY");
        brgyField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        brgyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        brgyField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        brgyField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brgyFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brgyFieldFocusLost(evt);
            }
        });
        jPanel4.add(brgyField);
        brgyField.setBounds(30, 100, 100, 30);

        signUpButton.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(220, 215, 201));
        signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sign-up-button.png"))); // NOI18N
        signUpButton.setText("SIGN UP");
        signUpButton.setBorder(null);
        signUpButton.setBorderPainted(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setFocusCycleRoot(true);
        signUpButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel4.add(signUpButton);
        signUpButton.setBounds(120, 280, 130, 40);

        cityField.setBackground(new java.awt.Color(220, 215, 201));
        cityField.setColumns(3);
        cityField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cityField.setText("CITY");
        cityField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        cityField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cityField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        cityField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityFieldFocusLost(evt);
            }
        });
        cityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityFieldActionPerformed(evt);
            }
        });
        jPanel4.add(cityField);
        cityField.setBounds(140, 100, 110, 30);

        provinceField.setBackground(new java.awt.Color(220, 215, 201));
        provinceField.setColumns(3);
        provinceField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        provinceField.setText("PROVINCE");
        provinceField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 1));
        provinceField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        provinceField.setMargin(new java.awt.Insets(2, 1, 2, 6));
        provinceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                provinceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                provinceFieldFocusLost(evt);
            }
        });
        jPanel4.add(provinceField);
        provinceField.setBounds(260, 100, 100, 30);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if (String.valueOf(passwordField.getPassword()).equals("PASSWORD")) {
            passwordField.setText("");
            passwordField.setEchoChar('•');
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (passwordField.getPassword().length == 0) {
            passwordField.setText("PASSWORD");
            passwordField.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
        if (nameField.getText().equals("FULL NAME")) {
            nameField.setText("");
        }
    }//GEN-LAST:event_nameFieldFocusGained

    private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
        if (nameField.getText().isEmpty()) {
            nameField.setText("FULL NAME");
        }
    }//GEN-LAST:event_nameFieldFocusLost

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if (emailField.getText().equals("EMAIL ADDRESS")) {
            emailField.setText("");
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (emailField.getText().isEmpty()) {
            emailField.setText("EMAIL ADDRESS");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void numberFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberFieldFocusGained
       if (numberField.getText().equals("CONTACT NUMBER")) {
            numberField.setText("");
        }
    }//GEN-LAST:event_numberFieldFocusGained

    private void numberFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberFieldFocusLost
        if (numberField.getText().isEmpty()) {
            numberField.setText("CONTACT NUMBER");
        }
    }//GEN-LAST:event_numberFieldFocusLost

    private void brgyFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brgyFieldFocusGained
        if (brgyField.getText().equals("BARANGAY")) {
            brgyField.setText("");
        }
    }//GEN-LAST:event_brgyFieldFocusGained

    private void brgyFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brgyFieldFocusLost
        if (brgyField.getText().isEmpty()) {
            brgyField.setText("BARANGAY");
        }
    }//GEN-LAST:event_brgyFieldFocusLost

    private void numberFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberFieldKeyTyped
       char c = evt.getKeyChar();
        if (!Character.isDigit(c) || numberField.getText().length() >= 11) { 
            evt.consume(); 
        }
    }//GEN-LAST:event_numberFieldKeyTyped

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        String name = nameField.getText().trim();
        String brgy = brgyField.getText().trim();
        String city = brgyField.getText().trim();
        String prov = brgyField.getText().trim();
        String address = brgy + ", " + city + ", " + prov;
        String email = emailField.getText().trim();
        String contact = numberField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (name.isEmpty() || address.isEmpty() || email.isEmpty() || contact.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Contact number must contain only digits!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String url = "jdbc:mysql://localhost:3306/lms_db";
        String user = "root"; 
        String pass = "";  

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO users (name, email, password, address, contact_info, role) VALUES (?, ?, ?, ?, ?, 'Member')";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, address);
            pstmt.setString(5, contact);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Sign-up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);  
                loginPanel dashboard = new loginPanel();
                dashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Sign-up failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        signUpButton.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void cityFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusGained
        if (cityField.getText().equals("CITY")) {
            cityField.setText("");
        }
    }//GEN-LAST:event_cityFieldFocusGained

    private void cityFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusLost
        if (cityField.getText().isEmpty()) {
            cityField.setText("CITY");
        }
    }//GEN-LAST:event_cityFieldFocusLost

    private void provinceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_provinceFieldFocusGained
        if (provinceField.getText().equals("PROVINCE")) {
            provinceField.setText("");
        }
    }//GEN-LAST:event_provinceFieldFocusGained

    private void provinceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_provinceFieldFocusLost
        if (provinceField.getText().isEmpty()) {
            provinceField.setText("PROVINCE");
        }
    }//GEN-LAST:event_provinceFieldFocusLost

    private void cityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityFieldActionPerformed

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
            java.util.logging.Logger.getLogger(signinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signinPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signinPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brgyField;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numberField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField provinceField;
    private javax.swing.JButton signUpButton;
    // End of variables declaration//GEN-END:variables
}

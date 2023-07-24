
package app.views.login;

import app.controllers.login.LoginController;
import app.dao.exceptions.DAOException;
import components.ButtonGradient;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public LoginFrame() throws DAOException {
        initComponents();
        init();
        setBackground(new Color(0, 0, 0 , 0));
        new LoginController(this);
        
    }
    
    
    private void init() {
       headerLogin.initMoving(this);
       headerLogin.initEvent(this, panelBackground);
    } 

    public JPasswordField getLoginPasswordInput() {
        return loginPasswordInput;
    }

    public JTextField getLoginUserNameInput() {
        return loginUserNameInput;
    }

    public ButtonGradient getLoginBtnValidateUser() {
        return loginBtnValidateUser;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new components.mainComponents.swing.PanelBackground();
        panelmain = new javax.swing.JPanel();
        cardForm = new javax.swing.JPanel();
        cardForm1 = new javax.swing.JPanel();
        cardForm2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        loginUserNameInput = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        loginPasswordInput = new javax.swing.JPasswordField();
        loginBtnValidateUser = new components.ButtonGradient();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        headerLogin = new components.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1140, 760));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBackground.setBackground(new java.awt.Color(39, 37, 37));

        panelmain.setBackground(new java.awt.Color(39, 37, 37));
        panelmain.setOpaque(false);
        panelmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardForm.setBackground(new java.awt.Color(39, 37, 37));
        cardForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardForm1.setBackground(new java.awt.Color(255, 255, 255));

        cardForm2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Usuario ");

        loginUserNameInput.setBackground(new java.awt.Color(255, 255, 255));
        loginUserNameInput.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        loginUserNameInput.setForeground(new java.awt.Color(204, 204, 204));
        loginUserNameInput.setText("Ingrese el Nombre de Usuario ");
        loginUserNameInput.setBorder(null);
        loginUserNameInput.setSelectionColor(new java.awt.Color(30, 30, 30));
        loginUserNameInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginUserNameInputMousePressed(evt);
            }
        });
        loginUserNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserNameInputActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Contraseña ");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        loginPasswordInput.setBackground(new java.awt.Color(255, 255, 255));
        loginPasswordInput.setForeground(new java.awt.Color(204, 204, 204));
        loginPasswordInput.setText("jPasswordField1");
        loginPasswordInput.setBorder(null);
        loginPasswordInput.setSelectionColor(new java.awt.Color(255, 255, 255));
        loginPasswordInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginPasswordInputMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginPasswordInputMousePressed(evt);
            }
        });
        loginPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordInputActionPerformed(evt);
            }
        });

        loginBtnValidateUser.setBorder(null);
        loginBtnValidateUser.setText("Iniciar ");
        loginBtnValidateUser.setGradientColor1(new java.awt.Color(191, 131, 214));
        loginBtnValidateUser.setGradientColor2(new java.awt.Color(150, 128, 213));
        loginBtnValidateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnValidateUserActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        javax.swing.GroupLayout cardForm2Layout = new javax.swing.GroupLayout(cardForm2);
        cardForm2.setLayout(cardForm2Layout);
        cardForm2Layout.setHorizontalGroup(
            cardForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(loginUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(loginPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardForm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(64, 64, 64))
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(loginBtnValidateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        cardForm2Layout.setVerticalGroup(
            cardForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardForm2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(54, 54, 54)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(loginUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(loginPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(loginBtnValidateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardForm1Layout = new javax.swing.GroupLayout(cardForm1);
        cardForm1.setLayout(cardForm1Layout);
        cardForm1Layout.setHorizontalGroup(
            cardForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardForm1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(cardForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        cardForm1Layout.setVerticalGroup(
            cardForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardForm.add(cardForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 480));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ellipse.png"))); // NOI18N
        cardForm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -70, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ellipse.png"))); // NOI18N
        cardForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 230, -1, -1));

        panelmain.add(cardForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 370, 500));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Unio2.png"))); // NOI18N
        panelmain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 670, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ellipse.png"))); // NOI18N
        panelmain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, -1, -1));

        headerLogin.setBackground(new java.awt.Color(39, 37, 37));
        headerLogin.setOpaque(false);
        panelmain.add(headerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, -1));

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
            .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackgroundLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(panelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginUserNameInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginUserNameInputMousePressed
        // TODO add your handling code here:
        loginUserNameInput.setText("");
        loginUserNameInput.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_loginUserNameInputMousePressed

    private void loginUserNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserNameInputActionPerformed

    private void loginPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordInputActionPerformed

    private void loginPasswordInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordInputMouseClicked
        // TODO add your handling code h
    }//GEN-LAST:event_loginPasswordInputMouseClicked

    private void loginPasswordInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordInputMousePressed
        // TODO add your handling code here:
        loginPasswordInput.setText("");
        loginPasswordInput.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_loginPasswordInputMousePressed

    private void loginBtnValidateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnValidateUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnValidateUserActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginFrame().setVisible(true);
                } catch (DAOException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardForm;
    private javax.swing.JPanel cardForm1;
    private javax.swing.JPanel cardForm2;
    private components.Header headerLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private components.ButtonGradient loginBtnValidateUser;
    private javax.swing.JPasswordField loginPasswordInput;
    private javax.swing.JTextField loginUserNameInput;
    private components.mainComponents.swing.PanelBackground panelBackground;
    private javax.swing.JPanel panelmain;
    // End of variables declaration//GEN-END:variables
}

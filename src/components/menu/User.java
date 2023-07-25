
package components.menu;

import javax.swing.JLabel;


public class User extends javax.swing.JPanel {


    public User() {
        initComponents();
    }

    public JLabel getMainUsername() {
        return mainUsername;
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mainUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Jlabel2 = new javax.swing.JLabel();

        setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/User.png"))); // NOI18N

        mainUsername.setBackground(new java.awt.Color(0, 0, 0));
        mainUsername.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 13)); // NOI18N
        mainUsername.setForeground(new java.awt.Color(0, 0, 0));
        mainUsername.setText("Nombre ");
        mainUsername.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 149, 255));
        jLabel5.setText("Hola!");

        Jlabel2.setBackground(new java.awt.Color(0, 0, 0));
        Jlabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 13)); // NOI18N
        Jlabel2.setForeground(new java.awt.Color(0, 0, 0));
        Jlabel2.setText("User:");
        Jlabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(mainUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mainUsername)
                            .addComponent(Jlabel2))
                        .addGap(4, 4, 4))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel mainUsername;
    // End of variables declaration//GEN-END:variables
}

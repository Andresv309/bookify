package app.views.shoppingCart;

import app.models.CardType;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ShoppingCartUserInfoPanel extends javax.swing.JPanel {

    public ShoppingCartUserInfoPanel() {
        initComponents();
    }

    public JTextField getDetailsCardNumber() {
        return detailsCardNumber;
    }

    public JComboBox<CardType> getDetailsCardType() {
        return detailsCardType;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailsCardType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        detailsCardNumber = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setOpaque(false);

        detailsCardType.setBackground(new java.awt.Color(255, 255, 255));
        detailsCardType.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsCardType.setForeground(new java.awt.Color(204, 204, 204));
        detailsCardType.setBorder(null);
        detailsCardType.setFocusable(false);
        detailsCardType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCardTypeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setText("Documento");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Documento");

        detailsCardNumber.setBackground(new java.awt.Color(255, 255, 255));
        detailsCardNumber.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsCardNumber.setForeground(new java.awt.Color(204, 204, 204));
        detailsCardNumber.setText("Ingrse N° Documento");
        detailsCardNumber.setBorder(null);
        detailsCardNumber.setSelectionColor(new java.awt.Color(30, 30, 30));
        detailsCardNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                detailsCardNumberMousePressed(evt);
            }
        });
        detailsCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCardNumberActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setText("Tipo de ");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("N° de ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(detailsCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsCardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsCardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsCardNumberActionPerformed

    private void detailsCardNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailsCardNumberMousePressed
        // TODO add your handling code here:
        detailsCardNumber.setText("");
        detailsCardNumber.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_detailsCardNumberMousePressed

    private void detailsCardTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCardTypeActionPerformed

    }//GEN-LAST:event_detailsCardTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField detailsCardNumber;
    private javax.swing.JComboBox<CardType> detailsCardType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}

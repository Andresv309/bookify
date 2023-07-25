
package app.views.customer;

import javax.swing.JTextField;
import app.models.CardType;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;


public class CustomerDetailsPanel extends javax.swing.JPanel {

    public CustomerDetailsPanel() {
        initComponents();
        detailsCardNumber.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12) );
        
    }

    public JTextField getDetailsName() {
        return detailsName;
    }

    public JFormattedTextField getDetailsCardNumber() {
        return detailsCardNumber;
    }

    public JComboBox<CardType> getDetailsCardType() {
        return detailsCardType;
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        detailsName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        detailsCardNumber = new javax.swing.JFormattedTextField();
        detailsCardType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Nombre Cliente");

        detailsName.setBackground(new java.awt.Color(255, 255, 255));
        detailsName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsName.setForeground(new java.awt.Color(204, 204, 204));
        detailsName.setText("Ingrese el Nombre del Cliente");
        detailsName.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 8));
        detailsName.setSelectionColor(new java.awt.Color(30, 30, 30));
        detailsName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detailsNameFocusGained(evt);
            }
        });
        detailsName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                detailsNameMousePressed(evt);
            }
        });
        detailsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsNameActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        detailsCardNumber.setBackground(new java.awt.Color(255, 255, 255));
        detailsCardNumber.setBorder(null);
        detailsCardNumber.setForeground(new java.awt.Color(0, 0, 0));
        detailsCardNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        detailsCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCardNumberActionPerformed(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("N° Documento");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("Tipo de Documento");

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addComponent(detailsName)
                        .addComponent(detailsCardNumber)
                        .addComponent(detailsCardType, 0, 262, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addComponent(detailsName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailsNameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsNameMousePressed

    private void detailsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsNameActionPerformed

    private void detailsNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detailsNameFocusGained
        // TODO add your handling code here:
        detailsName.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_detailsNameFocusGained

    private void detailsCardTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCardTypeActionPerformed

    }//GEN-LAST:event_detailsCardTypeActionPerformed

    private void detailsCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsCardNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField detailsCardNumber;
    private javax.swing.JComboBox<CardType> detailsCardType;
    private javax.swing.JTextField detailsName;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}

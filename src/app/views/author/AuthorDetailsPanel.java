
package app.views.author;

import javax.swing.JTextField;


public class AuthorDetailsPanel extends javax.swing.JPanel {
    
    public AuthorDetailsPanel() {
        initComponents();
    }

    public String getDetailsNameField() {
        return detailsName.getText();
    }
    
    public JTextField getDetailsName() {
        return detailsName;
    }

    public void setDetailsNameField(String detailsName) {
        this.detailsName.setText(detailsName);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        detailsName = new javax.swing.JTextField();

        jLabel1.setText("Nombre:");

        detailsName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsNameActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField detailsName;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}


package components.bookView.formSteps;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Step2 extends javax.swing.JPanel {

    
    public Step2() {
        initComponents();
    }
    

    public JTextArea getDetailsDescription() {
        return detailsDescription;
    }

    public JFormattedTextField getDetailsPrice() {
        return detailsPrice;
    }

       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardStep1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsDescription = new javax.swing.JTextArea();
        detailsPrice = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();

        setOpaque(false);

        cardStep1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Precio Libro ");

        detailsDescription.setBackground(new java.awt.Color(255, 255, 255));
        detailsDescription.setColumns(20);
        detailsDescription.setForeground(new java.awt.Color(0, 0, 0));
        detailsDescription.setRows(5);
        detailsDescription.setBorder(null);
        detailsDescription.setOpaque(false);
        jScrollPane1.setViewportView(detailsDescription);

        detailsPrice.setBackground(new java.awt.Color(255, 255, 255));
        detailsPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detailsPrice.setForeground(new java.awt.Color(0, 0, 0));
        detailsPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        detailsPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsPriceActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Descripción Libro ");

        javax.swing.GroupLayout cardStep1Layout = new javax.swing.GroupLayout(cardStep1);
        cardStep1.setLayout(cardStep1Layout);
        cardStep1Layout.setHorizontalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(detailsPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addComponent(jLabel7))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        cardStep1Layout.setVerticalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailsPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardStep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cardStep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardStep1;
    private javax.swing.JTextArea detailsDescription;
    private javax.swing.JFormattedTextField detailsPrice;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

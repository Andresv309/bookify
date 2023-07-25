
package components.bookView.formSteps;

import app.models.Author;
import app.models.Category;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class Step1 extends javax.swing.JPanel {

    
    public Step1() {
        initComponents();
    }

    public JComboBox<Author> getDetailsAuthor() {
        return detailsAuthor;
    }

    public JComboBox<Category> getDetailsCategory() {
        return detailsCategory;
    }

    public JTextField getDetailsName() {
        return detailsName;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardStep1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        detailsName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        detailsCategory = new javax.swing.JComboBox<>();
        detailsAuthor = new javax.swing.JComboBox<>();

        setOpaque(false);

        cardStep1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setText("Categoria ");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Nombre libro");

        detailsName.setBackground(new java.awt.Color(255, 255, 255));
        detailsName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsName.setForeground(new java.awt.Color(204, 204, 204));
        detailsName.setText("Ingrese del Libro  ");
        detailsName.setBorder(null);
        detailsName.setSelectionColor(new java.awt.Color(30, 30, 30));
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

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setText("Nombre Autor");

        detailsCategory.setBackground(new java.awt.Color(255, 255, 255));
        detailsCategory.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsCategory.setForeground(new java.awt.Color(204, 204, 204));
        detailsCategory.setBorder(null);
        detailsCategory.setFocusable(false);
        detailsCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCategoryActionPerformed(evt);
            }
        });

        detailsAuthor.setBackground(new java.awt.Color(255, 255, 255));
        detailsAuthor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsAuthor.setForeground(new java.awt.Color(204, 204, 204));
        detailsAuthor.setBorder(null);
        detailsAuthor.setFocusable(false);
        detailsAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardStep1Layout = new javax.swing.GroupLayout(cardStep1);
        cardStep1.setLayout(cardStep1Layout);
        cardStep1Layout.setHorizontalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailsAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsCategory, 0, 230, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(detailsName))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        cardStep1Layout.setVerticalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardStep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardStep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void detailsNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsNameActionPerformed

    private void detailsNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailsNameMousePressed
        // TODO add your handling code here:
        detailsName.setText("");
        detailsName.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_detailsNameMousePressed

    private void detailsCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCategoryActionPerformed

    }//GEN-LAST:event_detailsCategoryActionPerformed

    private void detailsAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsAuthorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardStep1;
    private javax.swing.JComboBox<Author> detailsAuthor;
    private javax.swing.JComboBox<Category> detailsCategory;
    private javax.swing.JTextField detailsName;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}

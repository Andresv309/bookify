
package components.bookView.formSteps;


import components.ButtonGradient;
import javax.swing.JLabel;


public class Step3 extends javax.swing.JPanel {

    
    public Step3() {
        initComponents();
    }

    public ButtonGradient getDetailsBtnLoadImage() {
        return detailsBtnLoadImage;
    }

    public JLabel getDetailsItemBookPortrait() {
        return detailsItemBookPortrait;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardStep1 = new javax.swing.JPanel();
        detailsBtnLoadImage = new components.ButtonGradient();
        detailsItemBookPortrait = new javax.swing.JLabel();
        pagesPlaceholder = new javax.swing.JLabel();

        setOpaque(false);

        cardStep1.setBackground(new java.awt.Color(255, 255, 255));

        detailsBtnLoadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/UpdateImage.png"))); // NOI18N
        detailsBtnLoadImage.setText("Selecione Imagen ");
        detailsBtnLoadImage.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        detailsBtnLoadImage.setGradientColor1(new java.awt.Color(54, 149, 255));
        detailsBtnLoadImage.setGradientColor2(new java.awt.Color(54, 149, 255));
        detailsBtnLoadImage.setIconTextGap(10);
        detailsBtnLoadImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBtnLoadImageActionPerformed(evt);
            }
        });

        detailsItemBookPortrait.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\portadas\\el-instituto.jpg"));

        pagesPlaceholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/portadas/bordeLibro.png"))); // NOI18N

        javax.swing.GroupLayout cardStep1Layout = new javax.swing.GroupLayout(cardStep1);
        cardStep1.setLayout(cardStep1Layout);
        cardStep1Layout.setHorizontalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardStep1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagesPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailsItemBookPortrait)))
                    .addGroup(cardStep1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(detailsBtnLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        cardStep1Layout.setVerticalGroup(
            cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardStep1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detailsBtnLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(cardStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pagesPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardStep1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(detailsItemBookPortrait, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void detailsBtnLoadImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBtnLoadImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsBtnLoadImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardStep1;
    private components.ButtonGradient detailsBtnLoadImage;
    private javax.swing.JLabel detailsItemBookPortrait;
    private javax.swing.JLabel pagesPlaceholder;
    // End of variables declaration//GEN-END:variables
}

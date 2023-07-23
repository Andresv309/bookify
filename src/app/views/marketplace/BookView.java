package app.views.marketplace;

import app.views.*;
import components.mainComponents.theme.SystemTheme;
import java.awt.Cursor;
import javax.swing.JLabel;


public class BookView extends javax.swing.JPanel {


    public BookView() {
        initComponents();
        paintButton();
        btnBuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    
    public BookView(String relativeImgPath) {
        initComponents();
        btnBuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(relativeImgPath)));
    }
    
    
    public void paintButton() {
        btnBuy.setColor(SystemTheme.mainColor);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuy = new components.ButtonGradient();

        setOpaque(false);

        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/portadas/portadaLibro_0.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/portadas/bordeLibro.png"))); // NOI18N

        btnBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shop.png"))); // NOI18N
        btnBuy.setText("Add");
        btnBuy.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnBuy.setGradientColor1(new java.awt.Color(54, 149, 255));
        btnBuy.setGradientColor2(new java.awt.Color(54, 149, 255));
        btnBuy.setIconTextGap(2);
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        System.out.println("Compra Exitosa");
    }//GEN-LAST:event_btnBuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ButtonGradient btnBuy;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

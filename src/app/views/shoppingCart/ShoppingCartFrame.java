package app.views.shoppingCart;

import app.controllers.marketplace.MarketplaceController;
import app.controllers.shoppingCart.ShoppingCartController;
import app.dao.exceptions.DAOException;
import app.models.Book;
import components.ButtonGradient;
import components.components.mainComponents.swing.scrollbar.ScrollBarCustom;
import components.mainComponents.swing.PanelBackground;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class ShoppingCartFrame extends javax.swing.JFrame {
    
    public ShoppingCartFrame() throws DAOException {
        initComponents();
        init();
        addScroll();
        setBackground(new Color(0, 0, 0 , 0));
        
    }
    
    public ShoppingCartFrame(MarketplaceController marketplaceController) throws DAOException {
        initComponents();
        init();
        addScroll();
        setBackground(new Color(0, 0, 0 , 0));
        
        new ShoppingCartController(this, marketplaceController);
    } 
    
    private void init() {
       headerShoppingCardView.initMoving(this);
       headerShoppingCardView.initEvent(this, panelBackground);
    } 
    
    private void addScroll() {
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public ButtonGradient getDetailsBtnConfirmSale() {
        return detailsBtnConfirmSale;
    }

    public ButtonGradient getDetailsBtnConsultClient() {
        return detailsBtnConsultClient;
    }

    public JLabel getDetailsCustomerName() {
        return detailsCustomerName;
    }

    public PanelBackground getDetailsPortraitItemsInShopCart() {
        return detailsPortraitItemsInShopCart;
    }

    public JLabel getDetailsTotalPrice() {
        return detailsTotalPrice;
    }

    public ShoppingCartUserInfoPanel getDetailsUserInfoShopCartPanel() {
        return detailsUserInfoShopCartPanel;
    }

    public ButtonGradient getDetailsBtnCleanCart() {
        return detailsBtnCleanCart;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new components.mainComponents.swing.PanelBackground();
        headerShoppingCardView = new components.Header();
        detailsUserInfoShopCartPanel = new app.views.shoppingCart.ShoppingCartUserInfoPanel();
        scroll = new javax.swing.JScrollPane();
        detailsPortraitItemsInShopCart = new components.mainComponents.swing.PanelBackground();
        jLabel8 = new javax.swing.JLabel();
        detailsTotalPrice = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        detailsCustomerName = new javax.swing.JLabel();
        detailsBtnConsultClient = new components.ButtonGradient();
        detailsBtnConfirmSale = new components.ButtonGradient();
        detailsBtnCleanCart = new components.ButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        headerShoppingCardView.setOpaque(false);

        detailsPortraitItemsInShopCart.setBackground(new java.awt.Color(221, 221, 221));
        detailsPortraitItemsInShopCart.setLayout(new java.awt.GridLayout(0, 1, 20, 0));
        scroll.setViewportView(detailsPortraitItemsInShopCart);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(54, 149, 255));
        jLabel8.setText("Total:");

        detailsTotalPrice.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        detailsTotalPrice.setForeground(new java.awt.Color(0, 0, 0));
        detailsTotalPrice.setText("Total de la compra ");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(54, 149, 255));
        jLabel9.setText("Cliente:");

        detailsCustomerName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        detailsCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        detailsCustomerName.setText("Nombre Cliente");

        detailsBtnConsultClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/Book.png"))); // NOI18N
        detailsBtnConsultClient.setText("Consultar Cliente");
        detailsBtnConsultClient.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        detailsBtnConsultClient.setGradientColor1(new java.awt.Color(54, 149, 255));
        detailsBtnConsultClient.setGradientColor2(new java.awt.Color(54, 149, 255));
        detailsBtnConsultClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBtnConsultClientActionPerformed(evt);
            }
        });

        detailsBtnConfirmSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/Book.png"))); // NOI18N
        detailsBtnConfirmSale.setText("Confimar ");
        detailsBtnConfirmSale.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        detailsBtnConfirmSale.setGradientColor1(new java.awt.Color(54, 149, 255));
        detailsBtnConfirmSale.setGradientColor2(new java.awt.Color(54, 149, 255));
        detailsBtnConfirmSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBtnConfirmSaleActionPerformed(evt);
            }
        });

        detailsBtnCleanCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/4.png"))); // NOI18N
        detailsBtnCleanCart.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        detailsBtnCleanCart.setGradientColor1(new java.awt.Color(54, 149, 255));
        detailsBtnCleanCart.setGradientColor2(new java.awt.Color(54, 149, 255));
        detailsBtnCleanCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBtnCleanCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerShoppingCardView, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(detailsUserInfoShopCartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detailsTotalPrice))
                                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detailsCustomerName))))
                            .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(detailsBtnConfirmSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                                        .addComponent(detailsBtnConsultClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(detailsBtnCleanCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(headerShoppingCardView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsUserInfoShopCartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailsBtnConsultClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsBtnCleanCart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(detailsTotalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(detailsCustomerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailsBtnConfirmSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(1600, 95, 300, 845);
    }// </editor-fold>//GEN-END:initComponents

    private void detailsBtnConsultClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBtnConsultClientActionPerformed
//
//        ShoppingCartBookPanel book = new ShoppingCartBookPanel("blue-el-campamento-jeans.jpg");
//        ShoppingCartBookPanel book2 = new ShoppingCartBookPanel("crimes-of-grindelwald.jpg");
//        detailsProductsPortrait.add(book);
//        detailsProductsPortrait.add(book2);
//        System.out.println("si estoy funcionando");
//        
//        detailsProductsPortrait.updateUI();
    }//GEN-LAST:event_detailsBtnConsultClientActionPerformed

    private void detailsBtnConfirmSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBtnConfirmSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsBtnConfirmSaleActionPerformed

    private void detailsBtnCleanCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBtnCleanCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsBtnCleanCartActionPerformed

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
            java.util.logging.Logger.getLogger(ShoppingCartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingCartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ShoppingCartFrame().setVisible(true);
                } catch (DAOException ex) {
                    Logger.getLogger(ShoppingCartFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ButtonGradient detailsBtnCleanCart;
    private components.ButtonGradient detailsBtnConfirmSale;
    private components.ButtonGradient detailsBtnConsultClient;
    private javax.swing.JLabel detailsCustomerName;
    private components.mainComponents.swing.PanelBackground detailsPortraitItemsInShopCart;
    private javax.swing.JLabel detailsTotalPrice;
    private app.views.shoppingCart.ShoppingCartUserInfoPanel detailsUserInfoShopCartPanel;
    private components.Header headerShoppingCardView;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private components.mainComponents.swing.PanelBackground panelBackground;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}

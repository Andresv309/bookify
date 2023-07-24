package app.views.marketplace;

import app.controllers.marketplace.MarketplaceController;
import app.dao.exceptions.DAOException;
import app.views.shoppingCart.ShoppingCartFrame;
import components.components.mainComponents.swing.scrollbar.ScrollBarCustom;
import components.mainComponents.swing.PanelBackground;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class MarketPlacePanel extends javax.swing.JPanel {

    private List<BookView> books;
    private int index;
//    private ShoppingCartFrame shoppingCartFrameInstance = null;
//    private boolean isShowing = false;
    
   
    public MarketPlacePanel() throws DAOException{
        initComponents();
        addScroll();
        books = new ArrayList<>();
        index = 0;
        new MarketplaceController(this);
        btnOpenShopCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }
        
    private void addScroll() {
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public PanelBackground getPortrait() {
        return portrait;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new components.mainComponents.swing.PanelBackground();
        btnOpenShopCart = new components.BadgeButton();
        scroll = new javax.swing.JScrollPane();
        portrait = new components.mainComponents.swing.PanelBackground();

        setBackground(new java.awt.Color(204, 204, 204));

        btnOpenShopCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/shopCart.png"))); // NOI18N
        btnOpenShopCart.setBadgeColor(new java.awt.Color(54, 149, 255));
        btnOpenShopCart.setOpaque(false);
        btnOpenShopCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenShopCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap(835, Short.MAX_VALUE)
                .addComponent(btnOpenShopCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnOpenShopCart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        portrait.setLayout(new java.awt.GridLayout(0, 4, 6, 23));
        scroll.setViewportView(portrait);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll)
                    .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenShopCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenShopCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpenShopCartActionPerformed

    public JButton getBtnOpenShopCart() {
        return btnOpenShopCart;
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.BadgeButton btnOpenShopCart;
    private components.mainComponents.swing.PanelBackground panelBackground1;
    private components.mainComponents.swing.PanelBackground portrait;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}

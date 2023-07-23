package app.views.marketplace;

import app.controllers.marketplace.MarketplaceController;
import app.dao.exceptions.DAOException;
import components.components.mainComponents.swing.scrollbar.ScrollBarCustom;
import components.mainComponents.swing.PanelBackground;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;


public class MarketPlacePanel extends javax.swing.JPanel {

    private List<BookView> books;
    private int index;
    
   
    public MarketPlacePanel() throws DAOException{
        initComponents();
        addScroll();
        books = new ArrayList<>();
        index = 0;
        
        new MarketplaceController(this);
        
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
        btnNewBook = new components.ButtonGradient();
        scroll = new javax.swing.JScrollPane();
        portrait = new components.mainComponents.swing.PanelBackground();

        setBackground(new java.awt.Color(204, 204, 204));

        btnNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/Book.png"))); // NOI18N
        btnNewBook.setText("Generar Libro");
        btnNewBook.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        btnNewBook.setGradientColor1(new java.awt.Color(54, 149, 255));
        btnNewBook.setGradientColor2(new java.awt.Color(54, 149, 255));
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnNewBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(814, Short.MAX_VALUE))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(btnNewBook, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        portrait.setLayout(new java.awt.GridLayout(0, 4, 6, 23));
        scroll.setViewportView(portrait);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll)
                    .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        BookView book = new BookView("/Images/portadas/portadaLibro_" + index + ".jpg");
        portrait.add(book);
        portrait.updateUI();

        System.out.println("si estoy funcionando");
        index ++;
    }//GEN-LAST:event_btnNewBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ButtonGradient btnNewBook;
    private components.mainComponents.swing.PanelBackground panelBackground1;
    private components.mainComponents.swing.PanelBackground portrait;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}

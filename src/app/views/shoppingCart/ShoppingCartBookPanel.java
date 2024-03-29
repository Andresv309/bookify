package app.views.shoppingCart;

import app.models.Book;
import java.awt.Cursor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JSpinner;



public class ShoppingCartBookPanel extends javax.swing.JPanel {

    private Book book = null;
    
    public ShoppingCartBookPanel() {
        initComponents();
    }
    
    public ShoppingCartBookPanel(Book bookItem) {
        initComponents();
        this.book = bookItem;
        
        drawBookPortrait( bookItem.getImgPath());

        detailsItemBookName.setText(bookItem.getName());
        detailsItemBookPrice.setText(String.format("$%,.2f", bookItem.getPrice()));
    }

        public void drawBookPortrait(String imgName) {
        detailsBtnRemoveBookItem.setCursor(new Cursor(Cursor.HAND_CURSOR));

        String imgPath = System.getProperty("user.dir") +
                            "\\src\\Images\\portadas\\" +
                            imgName;
        
        Path path = Paths.get(imgPath);
        
        if (Files.exists(path) && !imgName.isBlank()){
            detailsItemBookPortrait.setIcon(
                new javax.swing.ImageIcon(imgPath)
            );
        } else {
            System.out.println("no existe imagen");
            detailsItemBookPortrait.setIcon(
                new javax.swing.ImageIcon(
                    System.getProperty("user.dir") +
                    "\\src\\Images\\portadas\\" +
                    "placeholder.jpg"
                )
            );
        }
    }
    
    
    
    
    
    
    public JSpinner getDetailsItemAmount() {
        return detailsItemAmount;
    }

    public Book getBook() {
        return book;
    }

    public JButton getDetailsBtnRemoveBookItem() {
        return detailsBtnRemoveBookItem;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        detailsItemBookName = new javax.swing.JLabel();
        detailsItemBookPrice = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        detailsItemAmount = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        detailsItemBookPortrait = new javax.swing.JLabel();
        pagesPlaceholder = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        detailsBtnRemoveBookItem = new components.mainComponents.swing.buttons.Button();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(54, 149, 255));
        jLabel9.setText("Nombre:  ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        detailsItemBookName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        detailsItemBookName.setForeground(new java.awt.Color(0, 0, 0));
        detailsItemBookName.setText("Nombre Libro ");
        add(detailsItemBookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, 20));

        detailsItemBookPrice.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        detailsItemBookPrice.setForeground(new java.awt.Color(0, 0, 0));
        detailsItemBookPrice.setText("Precio Libro");
        add(detailsItemBookPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(54, 149, 255));
        jLabel10.setText("Cantidad:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 20));

        detailsItemAmount.setValue(1);
        add(detailsItemAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 60, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(54, 149, 255));
        jLabel11.setText("Precio:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 20));

        detailsItemBookPortrait.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\portadas\\el-instituto.jpg"));
        add(detailsItemBookPortrait, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 229));

        pagesPlaceholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/portadas/bordeLibro.png"))); // NOI18N
        add(pagesPlaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 160, 268));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 190, 20));

        detailsBtnRemoveBookItem.setBackground(new java.awt.Color(255, 102, 102));
        detailsBtnRemoveBookItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon/Delete.png"))); // NOI18N
        detailsBtnRemoveBookItem.setPreferredSize(new java.awt.Dimension(25, 25));
        detailsBtnRemoveBookItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBtnRemoveBookItemActionPerformed(evt);
            }
        });
        add(detailsBtnRemoveBookItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 25, 25));
    }// </editor-fold>//GEN-END:initComponents

    private void detailsBtnRemoveBookItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBtnRemoveBookItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsBtnRemoveBookItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.mainComponents.swing.buttons.Button detailsBtnRemoveBookItem;
    private javax.swing.JSpinner detailsItemAmount;
    private javax.swing.JLabel detailsItemBookName;
    private javax.swing.JLabel detailsItemBookPortrait;
    private javax.swing.JLabel detailsItemBookPrice;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel pagesPlaceholder;
    // End of variables declaration//GEN-END:variables
}

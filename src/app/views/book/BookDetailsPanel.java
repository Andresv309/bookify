
package app.views.book;

import app.models.Author;
import app.models.Category;
import components.register.formSteps.Step1;
import components.register.formSteps.Step2;
import components.register.formSteps.Step3;
import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class BookDetailsPanel extends javax.swing.JPanel {
    
    private int currentIndexStepView = 1;
    
    private Step1 bookDetailsStep1 = null; 
    private Step2 bookDetailsStep2 = null; 
    private Step3 bookDetailsStep3 = null; 


    public BookDetailsPanel() {
        initComponents();
        transparentButtons();
        this.bookDetailsStep1 = new Step1();
        this.bookDetailsStep2 = new Step2();
        this.bookDetailsStep3 = new Step3();
        
        Component[] components = new Component[]{bookDetailsStep1, bookDetailsStep2, bookDetailsStep3};
        panelSlider.setSliderComponent(components);
        progressIndicator.initSlider(panelSlider);
        
    }
    
    
    public JComboBox<Author> getDetailsAuthor() {
        return bookDetailsStep1.getDetailsAuthor();
    }

    public JComboBox<Category> getDetailsCategory() {
        return bookDetailsStep1.getDetailsCategory();
    }
    
    public JFormattedTextField getDetailsPrice() {
        return bookDetailsStep2.getDetailsPrice();
    }

    public JTextArea getDetailsDescription() {
        return bookDetailsStep2.getDetailsDescription();
    }

    public JTextField getDetailsName() {
        return bookDetailsStep1.getDetailsName();
    }

    public JButton getDetailsBtnLoadImage() {
        return bookDetailsStep3.getDetailsBtnLoadImage();
    }
    
    public JLabel getDetailsImgPath() {
        return bookDetailsStep3.getDetailsItemBookPortrait();
    }
    
        
    private void transparentButtons(){
        btnFirstStep.setBackground(new Color(0, 0, 0 , 0));
        btnSecondStep.setBackground(new Color(0, 0, 0 , 0));
        btnThirdStep.setBackground(new Color(0, 0, 0 , 0));  
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressIndicator = new components.progressindicator.ProgressIndicator();
        btnFirstStep = new components.mainComponents.swing.buttons.Button();
        btnSecondStep = new components.mainComponents.swing.buttons.Button();
        btnThirdStep = new components.mainComponents.swing.buttons.Button();
        panelSlider = new components.progressindicator.PanelSlider();

        setOpaque(false);

        progressIndicator.setForeground(new java.awt.Color(204, 204, 204));
        progressIndicator.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Detalles", "Caracteristicas ", "Imagen" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        progressIndicator.setOpaque(false);
        progressIndicator.setProgress(0.0F);
        progressIndicator.setProgressColor(new java.awt.Color(51, 153, 255));
        progressIndicator.setProgressColorGradient(new java.awt.Color(102, 206, 198));
        progressIndicator.setProgressFont(new java.awt.Font("Segoe UI Symbol", 1, 17)); // NOI18N

        btnFirstStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstStepActionPerformed(evt);
            }
        });

        btnSecondStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecondStepActionPerformed(evt);
            }
        });

        btnThirdStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThirdStepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout progressIndicatorLayout = new javax.swing.GroupLayout(progressIndicator);
        progressIndicator.setLayout(progressIndicatorLayout);
        progressIndicatorLayout.setHorizontalGroup(
            progressIndicatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressIndicatorLayout.createSequentialGroup()
                .addComponent(btnFirstStep, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSecondStep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnThirdStep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        progressIndicatorLayout.setVerticalGroup(
            progressIndicatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressIndicatorLayout.createSequentialGroup()
                .addGroup(progressIndicatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFirstStep, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnSecondStep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThirdStep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelSlider.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(progressIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(progressIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void changeStepView(int stepIndex) {
        
        int stepsDistance = Math.abs(currentIndexStepView - stepIndex);
        
        if(currentIndexStepView < stepIndex){
            
            for(int i = 0; i < stepsDistance; i++){
                 CompletableFuture.delayedExecutor( i*700, TimeUnit.MILLISECONDS).execute(() -> {
                     progressIndicator.next();
                 });
                 System.out.println("me movi a la derecha");
            }
         
        }else{
            for(int i = 0; i < stepsDistance; i++){
                
                CompletableFuture.delayedExecutor( i*700, TimeUnit.MILLISECONDS).execute(() -> {
                     progressIndicator.previous();
                });
                
                System.out.println("me movi a la Izquierda");
            }
        }  
        
        currentIndexStepView = stepIndex;
 
    }  
    
    
    private void btnFirstStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstStepActionPerformed
        // TODO add your handling code here:
        changeStepView(1);
        System.out.println("soy el boton  1");
    }//GEN-LAST:event_btnFirstStepActionPerformed

    private void btnSecondStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecondStepActionPerformed
        // TODO add your handling code here:
        changeStepView(2);
        System.out.println("soy el boton 2");
    }//GEN-LAST:event_btnSecondStepActionPerformed

    private void btnThirdStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThirdStepActionPerformed
        // TODO add your handling code here:
        changeStepView(3);
        System.out.println("soy el boton 3");
    }//GEN-LAST:event_btnThirdStepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.mainComponents.swing.buttons.Button btnFirstStep;
    private components.mainComponents.swing.buttons.Button btnSecondStep;
    private components.mainComponents.swing.buttons.Button btnThirdStep;
    private components.progressindicator.PanelSlider panelSlider;
    private components.progressindicator.ProgressIndicator progressIndicator;
    // End of variables declaration//GEN-END:variables
}

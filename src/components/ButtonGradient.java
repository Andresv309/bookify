package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Cristian Vega
 */
public class ButtonGradient extends JButton{
    
    private Color gradientColor1 = new Color(255, 90, 90);
    private Color gradientColor2 = new Color(42, 199, 80);
    
    
    public Color getGradientColor1() {
        return gradientColor1;
    }

    public void setGradientColor1(Color gradientColor1) {
        this.gradientColor1 = gradientColor1;
        repaint();
    }

    public Color getGradientColor2() {
        return gradientColor2;
    }

    public void setGradientColor2(Color gradientColor2) {
        this.gradientColor2 = gradientColor2;
        repaint();
    }
    

    public ButtonGradient() { 
        
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10,20,10,20));
        
    }
    
    @Override
    protected void paintComponent( Graphics grphcs){
        
        int width = getWidth();
        int heigth = getHeight();
        BufferedImage img = new BufferedImage(width,heigth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint gra = new GradientPaint(0,0,gradientColor1,width,0,gradientColor2);
        g2.setPaint(gra);
        g2.fillRoundRect(0,0, width, heigth,heigth, heigth);
        grphcs.drawImage(img,0,0,null); 
        super.paintComponent(grphcs);
        
    }

    public void setColor(Color mainColor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

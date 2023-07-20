package components;

import utils.Colors;
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
public class ButtonGradient_blue extends JButton{
    

    
    private Color color1 = Color.decode(Colors.PRIMARY_COLOR_BLUE.toString());
    private Color color2 = Color.decode(Colors.SECONDARY_COLOR_BLUE.toString()); 

    public ButtonGradient_blue() { 
        
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
        
        GradientPaint gra = new GradientPaint(0,0,color1,width,0,color2);
        g2.setPaint(gra);
        g2.fillRoundRect(0,0, width, heigth,heigth, heigth);
        grphcs.drawImage(img,0,0,null); 
        super.paintComponent(grphcs);
        
    }
    
    
    
}

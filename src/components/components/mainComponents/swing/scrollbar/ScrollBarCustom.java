/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.components.mainComponents.swing.scrollbar;

/**
 *
 * @author Cristian Vega
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(7, 8));
        setForeground(new Color(142, 206, 255));
        setUnitIncrement(20);
        setOpaque(false);
    }
}
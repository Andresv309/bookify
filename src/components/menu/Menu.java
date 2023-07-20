package components.menu;

import components.mainComponents.swing.MenuButton;
import components.mainComponents.theme.SystemTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Menu extends javax.swing.JPanel {

    public int getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(int selectedLocation) {
        this.selectedLocation = selectedLocation;
        repaint();
    }

    public void addEventMenu(EventMenu event) {
        this.events.add(event);
    }

    private int selectedIndex = 0;
    private Animator animator;
    private TimingTarget target;
    private int selectedLocation = 168;
    private int targetLocation;
    private List<EventMenu> events = new ArrayList<>();

    public Menu() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
        menu.setLayout(new MigLayout("fillx, wrap, inset 0", "[fill]", "[fill, 36!]0[fill, 36!]"));
        initMenu();
    }

    private void initMenu() {
        addMenu("Categorias", "4", 0);
        addMenu("Salas", "3", 1);
        addMenu("Autores", "2", 2);
        addMenu("Libros", "1", 3);
        addMenu("Inventario", "5", 4);
        addMenu("Clientes", "6", 5);
        addMenu("Venta", "8", 6);
        addMenu("Ganancias", "9", 7);
        addMenu("Configuración", "7", 8);
        menu.repaint();
        menu.revalidate();
        setSelectedMenu(0);
        animator = new Animator(300);
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void begin() {
                clearSelected();
            }

            @Override
            public void end() {
                setSelectedMenu(selectedIndex);
                runEvent();
            }
        });
        animator.setDeceleration(.5f);
        animator.setAcceleration(.5f);
        animator.setResolution(0);
    }

    private void addMenu(String menuName, String icon, int index) {
        MenuButton m = new MenuButton();
        m.setIcoName(icon);
        m.setIcon(new ImageIcon(getClass().getResource("/Images/icon/" + icon + ".png")));
        m.setFont(m.getFont().deriveFont(Font.BOLD, 12));
        m.setForeground(new Color(127, 127, 127));
        m.setHorizontalAlignment(JButton.LEFT);
        m.setText("  " + menuName);
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index != selectedIndex) {
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    int y = m.getY() + menu.getY();
                    targetLocation = y;
                    selectedIndex = index;
                    animator.removeTarget(target);
                    target = new PropertySetter(Menu.this, "selectedLocation", selectedLocation, targetLocation);
                    animator.addTarget(target);
                    animator.start();
                }
            }
        });
        menu.add(m);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int y = selectedLocation;
        g2.setColor(SystemTheme.mainColor);
        g2.fill(createShape(y));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Shape createShape(int y) {
        int width = getWidth() - 12;
        int r = 20;
        Area area = new Area(new RoundRectangle2D.Float(6, y, width, 35, r, r));
        area.add(new Area(new RoundRectangle2D.Float(width - r + 6, y, r, r, 5, 5)));
        area.add(new Area(new RoundRectangle2D.Float(6, y + 35 - r, r, r, 5, 5)));
        return area;
    }

    private void clearSelected() {
        for (Component com : menu.getComponents()) {
            if (com instanceof MenuButton) {
                MenuButton c = (MenuButton) com;
                c.setForeground(new Color(127, 127, 127));
                c.setEffectColor(new Color(173, 173, 173));
                if (!c.getIcoName().contains("_s")) {
                    c.setIcon(new ImageIcon(getClass().getResource("/Images/icon/" + c.getIcoName() + ".png")));
                }
            }
        }
    }

    public void setSelectedMenu(int index) {
        MenuButton cmd = (MenuButton) menu.getComponent(index);
        cmd.setForeground(Color.WHITE);
        cmd.setEffectColor(Color.WHITE);
        cmd.setIcon(new ImageIcon(getClass().getResource("/Images/icon/" + cmd.getIcoName() + "_s.png")));
    }

    private void runEvent() {
        for (EventMenu event : events) {
            event.selectedMenu(selectedIndex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        systemTheme1 = new components.mainComponents.theme.SystemTheme();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoTheme1 = new components.mainComponents.theme.logoTheme();

        menu.setOpaque(false);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 117, 117));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bookify");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 154, 154));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin");

        logoTheme1.setGradientColor1(new java.awt.Color(65, 188, 255));
        logoTheme1.setGradientColor2(new java.awt.Color(161, 221, 255));
        logoTheme1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoTheme1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoTheme1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private components.mainComponents.theme.logoTheme logoTheme1;
    private javax.swing.JPanel menu;
    private components.mainComponents.theme.SystemTheme systemTheme1;
    // End of variables declaration//GEN-END:variables
}

package app.views.category;

import components.components.mainComponents.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian Vega
 */
public class Table extends JTable{
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setSelectionBackground(new Color(65,188,255 ));
        setRowHeight(28);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                
                if(column >= 2) {
                    
                    header.setHorizontalAlignment(JLabel.CENTER);
                    
                }
                
                return header;
            }
        });
    }
    
    
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel)getModel();
        model.addRow(row);
    } 
    
    
    public void fixTable (JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
    
}

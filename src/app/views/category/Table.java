package app.views.category;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Cristian Vega
 */
public class Table extends JTable{
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setSelectionBackground(new Color(255,255,0 ));
        setRowHeight(28);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                
                if(column == 4) {
                    
                    header.setHorizontalAlignment(JLabel.CENTER);
                    
                }
                
                return header;
            }
        });
    }
    
    
    
//    public void fixTable (JScrollBar scroll) {
//        scroll.get
//    }
    
    
}

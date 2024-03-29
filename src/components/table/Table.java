package components.table;

import components.components.mainComponents.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Cristian Vega
 */
public class Table extends JTable {
    
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
                
                if(column <= 2) {
                    
                    header.setHorizontalAlignment(JLabel.CENTER);
                    
//                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//                    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//                    table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
//                    table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
                    
                }
                
//                TableColumnModel tcm = table.getColumnModel();
//                tcm.removeColumn( tcm.getColumn(0) );
                
                return header;
            }
        });
        
//        this.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 5));
        
        
        // Create a custom table header renderer for the left-aligned column
//        DefaultTableCellRenderer leftAlignedHeaderRenderer = new DefaultTableCellRenderer();
//        leftAlignedHeaderRenderer.setHorizontalAlignment(SwingConstants.LEFT);
//        getColumn().setHeaderRenderer(leftAlignedHeaderRenderer);
        
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


package app.controllers.stock;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.StockDAO;
import app.models.Stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class StockTableModel extends AbstractTableModel {
    private StockDAO entityDAO;
    private List<Stock> tableData = new ArrayList<>();
    
    public StockTableModel(StockDAO entity) {
        this.entityDAO = entity;
    }
    
    public void updateView () throws DAOException {
        tableData = entityDAO.getAll();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id";
            case 1: return "No.";
            case 2: return "Cantidad";
            case 3: return "Estante";
            case 4: return "Libro";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stock requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getQuantity();
            case 3: return requestedEntity.getShelveName();
            case 4: return requestedEntity.getBookName();
            default: return "";
        }
    }
}


package app.controllers.category;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CategoryDAO;
import app.models.Category;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CategoryTableModel extends AbstractTableModel {
    private CategoryDAO entityDAO;
    private List<Category> tableData = new ArrayList<>();
    
    public CategoryTableModel(CategoryDAO entity) {
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
            case 2: return "Nombre";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getName();
            default: return "";
        }
    }
}

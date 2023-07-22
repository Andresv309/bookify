
package app.controllers.author;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.models.Author;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AuthorTableModel extends AbstractTableModel {
    private AuthorDAO entityDAO;
    private List<Author> tableData = new ArrayList<>();
    
    public AuthorTableModel(AuthorDAO entity) {
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
        Author requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getName();
            default: return "";
        }
    }
}


package app.controllers.author;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.models.Author;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AuthorTableModel extends AbstractTableModel {
    private AuthorDAO author;
    private List<Author> tableData = new ArrayList<>();
    
    public AuthorTableModel(AuthorDAO author) {
        this.author = author;
    }
    
    public void updateView () throws DAOException {
        tableData = author.getAll();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id";
            case 1: return "Name";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author requestedAuthor = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedAuthor.getId();
            case 1: return requestedAuthor.getName();
            default: return "";
        }
    }
}

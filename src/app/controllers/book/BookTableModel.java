
package app.controllers.book;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.BookDAO;
import app.models.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class BookTableModel extends AbstractTableModel {
    private BookDAO entityDAO;
    private List<Book> tableData = new ArrayList<>();
    
    public BookTableModel(BookDAO entity) {
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
            case 3: return "Categoria";
            case 4: return "Author";
            case 5: return "Precio";
            case 6: return "Descripción";
            case 7: return "Ruta";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getName();
            case 3: return requestedEntity.getCategoryName();
            case 4: return requestedEntity.getAuthorName();
            case 5: return "$ " + requestedEntity.getPrice();
            case 6: return requestedEntity.getDescription();
            case 7: return requestedEntity.getImgPath();
            default: return "";
        }
    }
}

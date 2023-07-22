
package app.controllers.shelve;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.ShelveDAO;
import app.models.Shelve;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ShelveTableModel extends AbstractTableModel {
    private ShelveDAO entityDAO;
    private List<Shelve> tableData = new ArrayList<>();
    
    public ShelveTableModel(ShelveDAO entity) {
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
        Shelve requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getName();
            default: return "";
        }
    }
}

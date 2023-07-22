
package app.controllers.customer;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.CustomerDAO;
import app.models.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CustomerTableModel extends AbstractTableModel {
    private CustomerDAO entityDAO;
    private List<Customer> tableData = new ArrayList<>();
    
    public CustomerTableModel(CustomerDAO entity) {
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
            case 3: return "Tipo de Documento";
            case 4: return "No. de Documento";
            case 5: return "Fecha de Creación";
            default: return "";
        }
    }
    
    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer requestedEntity = tableData.get(rowIndex);
        switch (columnIndex) {
            case 0: return requestedEntity.getId();
            case 1: return rowIndex + 1;
            case 2: return requestedEntity.getName();
            case 3: return requestedEntity.getCardType();
            case 4: return requestedEntity.getCardNumber();
            case 5: return requestedEntity.getCreatedAt();
            default: return "";
        }
    }
}

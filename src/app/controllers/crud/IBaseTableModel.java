
package app.controllers.crud;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.DAO;
import java.io.Serializable;
import java.util.List;
import javax.swing.table.TableModel;
//import javax.swing.table.AbstractTableModel;

//public interface IBaseTableModel<T> extends AbstractTableModel {
//    final DAO<T, Long> entity = null;
//    private List<T> tableData = new ArrayList<>();
//    
//    public IBaseTableModel(DAO<T, Long> author);
//    
//    public void updateView () throws DAOException;
//
// 
//    public String getColumnName(int column);
//    public int getRowCount();
//    public int getColumnCount();
//    public Object getValueAt(int rowIndex, int columnIndex);
//}

public interface IBaseTableModel<T> extends TableModel, Serializable {
    DAO<T, Long> getEntity();
    List<T> getTableData(); 
    void updateView() throws DAOException;
    
}
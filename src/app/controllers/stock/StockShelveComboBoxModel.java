
package app.controllers.stock;

import app.dao.exceptions.DAOException;
import app.dao.interfaces.ShelveDAO;
import app.models.Shelve;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class StockShelveComboBoxModel extends DefaultComboBoxModel<Shelve> {
    private ShelveDAO shelveDAO;
    private List<Shelve> shelveSelectData = new ArrayList<>();

    public StockShelveComboBoxModel(ShelveDAO shelveDAO) throws DAOException {
        this.shelveDAO = shelveDAO;
        update();
    }
    
    public void update() throws DAOException {
        if (shelveDAO != null) {
            shelveSelectData = shelveDAO.getAll();
            removeAllElements();
            for (Shelve shelve : shelveSelectData) {
                addElement(shelve);
            }
        }
    }
    
}

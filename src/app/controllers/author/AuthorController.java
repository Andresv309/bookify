
package app.controllers.author;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.AuthorDAO;
import app.views.author.AuthorPanel;


public class AuthorController {
    private AuthorPanel authorPanel;
    private AuthorDAO authorDAO;
    
    private AuthorTableModel tableModel;
    private AuthorDetailsController detailsModel;

    public AuthorController(AuthorPanel view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        this.authorDAO = DAOManager.getDAOinstance().getAuthorDAO();
        this.authorPanel = view;
        
        this.tableModel = new AuthorTableModel(this.authorDAO);
        this.tableModel.updateView();
        this.authorPanel.getTable().setModel(this.tableModel);
        
        this.detailsModel = new AuthorDetailsController(this.authorPanel);
        
        this.authorPanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            boolean validSelection = (this.authorPanel.getTable().getSelectedRow() != -1);
            authorPanel.getBtnEdit().setEnabled(validSelection);
            authorPanel.getBtnDelete().setEnabled(validSelection);
        
        });
    }
}

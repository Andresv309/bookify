
package app.dao;

import app.dao.sqlite.SQLiteDAOManager;
import app.dao.interfaces.IDAOManager;

public final class DAOManager {
    private IDAOManager DAOinstance;
    
    public DAOManager() {
        this.DAOinstance = new SQLiteDAOManager();
    }

    public IDAOManager getDAOinstance() {
        return DAOinstance;
    }

    public void setDAOinstance(IDAOManager DAOinstance) {
        this.DAOinstance = DAOinstance;
    }
    
    
}

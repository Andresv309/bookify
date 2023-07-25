
package app;

import app.dao.exceptions.DAOException;
import app.views.login.LoginFrame;


public class app {
    public static void main(String[] args) throws DAOException {
        
        LoginFrame login = new LoginFrame(); 
        login.setVisible(true);

    }
    
}

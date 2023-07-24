
package app.controllers.login;

import app.dao.DAOManager;
import app.dao.exceptions.DAOException;
import app.dao.interfaces.UserDAO;
import app.models.User;
import app.views.login.LoginFrame;
import app.views.main.Index;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;


public class LoginController {
    private LoginFrame loginFrame;
    private UserDAO entityDAO;  
    
    private JTextField loginUserNameInput;
    private JTextField loginPasswordInput;
    private JButton btnValidateUser;

    
    public LoginController(LoginFrame view) throws DAOException {
        DAOManager DAOManager = new DAOManager();
        
        /*** Specific dao manager ***/
        this.entityDAO = DAOManager.getDAOinstance().getUserDao();
        
        this.loginFrame = view;
        
        this.loginUserNameInput = loginFrame.getLoginUserNameInput();
        this.loginPasswordInput = loginFrame.getLoginPasswordInput();
        this.btnValidateUser = loginFrame.getLoginBtnValidateUser();

        this.initEvents();
    }
    

    public void initEvents() {

        btnValidateUser.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {  
                try {
                    String username = loginUserNameInput.getText();
                    String password = loginPasswordInput.getText();
                    User user = entityDAO.valitate(username, password);
                    
                    System.out.println(username);
                    System.out.println(password);
                    
                    if (user != null) {
                        System.out.println("entre");
                        Index index = new Index(user);
                        index.setVisible(true);
                        
                        loginFrame.dispose();
                    }
                } catch (DAOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }  

}

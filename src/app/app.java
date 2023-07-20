/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import app.views.login.LoginFrame;
import javax.xml.transform.Source;

/**
 *
 * @author Cristian Vega
 */
public class app {
    public static void main(String[] args) {
        
        LoginFrame login = new LoginFrame();
        
        login.setVisible(true);
        
        DBConnection con  = new DBConnection();
        con.getConnection();
    }
    
}

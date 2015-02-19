/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftViews.Login;
import cassoftViews.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sun.security.util.Password;

/**
 *
 * @author Israel Agyeman-Premp
 */
public class LoginController {

    private Login login;
    private Database database;
    private ActionListener actionListener;
    private MainController mc;
    private MainView mv;

    /**
     * Constructor
     *
     * @param login represents the login view.
     * @param mv
     * @param database represents the database.
     */
    public LoginController(Login login, MainView mv, Database database) {
        this.login = login;
        this.database = database;
        this.mv = mv;
        if (!database.isConnected()) {            
            JOptionPane.showMessageDialog(login, "Please connect the database and start again.");
            System.exit(0);
        }
        login.setVisible(true);
        control();
    }

    /**
     * This method initiates the listeners.
     */
    private void control() {
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == login.login()) {                                      
                    login();
                }
            }
        };

        login.login().addActionListener(actionListener);
    }

    public void login() {
        if(database.checkPassword(login.userName().getText(), login.password().getText())){
            login.dispose();
            UIAnimations ui = new UIAnimations(mv);
            MainController mc = new MainController(mv,database);
        }else{
            JOptionPane.showMessageDialog(login, "Wrong Username or Password");
//            System.exit(0);
        }
        
    }

}

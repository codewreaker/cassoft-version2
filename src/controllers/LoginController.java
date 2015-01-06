/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Database;
import views.Login;
import views.MainView;

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
     * @param database represents the database.
     */
    public LoginController(Login login,MainView mv, Database database) {
        this.login = login;
        this.database = database;
        this.mv = mv;        
        login.setVisible(true);
        if (!database.initComponents()) {
            JOptionPane.showMessageDialog(login, "Please connect the database and start again.");
            //System.exit(0);
        }
    }

    /**
     * This method initiates the listeners.
     */
    public void control() {
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

    /**
     * This method checks if user is in the database.
     */
    public void login() {
        JTextField userName = login.userName();
        JPasswordField passField = login.password();
        System.out.println(passField);
        System.out.println(userName);
        char[] p = passField.getPassword();
        String pass = "";
        for (int i = 0; i < p.length; i++) {
            pass = pass + p[i];
        }

        if (database.checkPassword(userName.getText(), pass)) {            
            JOptionPane.showMessageDialog(login, "Login Successful");
            login.dispose();
            mc = new MainController(mv,database);
            mc.control();
        } 
        else //System.out.println("Login is failed");
        {
            JOptionPane.showMessageDialog(login, "Login Failed");
        }
    }

    
   

}

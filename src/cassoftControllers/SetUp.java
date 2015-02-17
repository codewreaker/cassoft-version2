/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftViews.SetUpUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 **
 *
 * @author Prophet
 */
public class SetUp {

    SetUpUI dbLogin;
    ActionListener actionListener;

    public SetUp() {
        FileInputStream FS = null;
        try {
            FS = new FileInputStream("credentials.txt");
        } catch (FileNotFoundException ex) {
            connect();
        }

    }

    private boolean connect() {
        boolean state = false;
        dbLogin = new SetUpUI();
        dbLogin.setVisible(true);
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == dbLogin.getDoneBtn()) {
                    authenticate();
                }
            }
        };

        /**
         * Registering the components
         */
        dbLogin.getDoneBtn().addActionListener(actionListener);
        return state;
    }

    private void authenticate() {
        try {
            FileInputStream FS = new FileInputStream("credentials.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

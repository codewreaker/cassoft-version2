/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftViews.SetUpUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 **
 *
 * @author Prophet
 */
public class SetUp {
    private boolean state; 
    SetUpUI dbLogin;
    ActionListener actionListener;

    public SetUp() {
        FileInputStream FS = null;
        try {
            FS = new FileInputStream("credentials.txt");
            state = true;
            /**
             * TODO authenticate the file
             */
        } catch (FileNotFoundException ex) {
            state = false;
            createCredentials();
        }
    }    
    
    /**
     * This private method displays a form that takes your details and create
     * a credentials file
     * @return 
     */
    private boolean createCredentials() {
        dbLogin = new SetUpUI();
        dbLogin.setVisible(true);
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == dbLogin.getDoneBtn()) {
                    FileOutputStream FOS = null;
                    try {
                        /**
                         * I take the values fromthe text file and I insert it
                         * into a text file create a file with specified details
                         */
                        File fout = new File("credentials.txt");
                        FOS = new FileOutputStream(fout);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(FOS));                        
                        String userDetails = dbLogin.username().getText() + ":" + dbLogin.password().getText();
                        String dbPass = dbLogin.mysqlPassword().getText();
                        if(dbLogin.mysqlPassword().getText().isEmpty()){ 
                            dbPass = "e";
                        }
                        String mysqlDetails = dbLogin.mysqlUsername().getText() + ":" + dbPass;                        
                        bw.write(userDetails);
                        bw.newLine();
                        bw.write(mysqlDetails);
                        bw.close();
                        JOptionPane.showMessageDialog(dbLogin, "Succesfully Created Details");                        
                        dbLogin.dispose();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(dbLogin, "Failed to create SetUp Details");
                    } catch (IOException ex) {
                        Logger.getLogger(SetUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };

        /**
         * Registering the components
         */
        dbLogin.getDoneBtn().addActionListener(actionListener);
        return state;
    }
    
    /**
     * Informs if the text file for credentials have been created
     * @return 
     */
    public boolean hasCredentials(){
        return state;
    }
  

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cassoftControllers;

import cassoftModels.Database;
import cassoftViews.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 *
 * @author Seamus
 */
public class SettingsController {
    private Settings settings;
    private Database database;
    private ActionListener actionListener;
    private Border border;
    
    public SettingsController(Settings settings, Database database){
        this.settings = settings;
        this.database = database;
    }
    
    public void control(){
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        };
        settings.getAdminSaveBtn().addActionListener(actionListener);
        settings.getFeedingTextField().getBorder();
    }
            
 
    
   
}
    
    


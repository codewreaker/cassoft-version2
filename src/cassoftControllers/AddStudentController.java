/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftModels.Operations;
import cassoftViews.AddStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Israel Agyeman-Prempeh
 */
public class AddStudentController {
    Database database;
    AddStudent addStud;
    Operations op;
    ActionListener actionListener;
    
    
    /*
    *A constructor that instantiates an instance of the db, mainview
    *actionListener, AddStudent Class etc
    */
    public AddStudentController( AddStudent addNew ,Database database,Operations op){
        this.database = database;
        this.op = op;
        addStud = addNew;
        addStud.setVisible(true);
    }

   
   public void control(){        
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {            
            }
        };
        
        
        
    }

    
    
}

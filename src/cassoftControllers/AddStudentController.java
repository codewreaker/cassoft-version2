/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cassoftControllers;

import cassoftModels.Database;
import cassoftViews.AddStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


/**
 *
 * @author Sheamus Punch Yebisi
 */
public class AddStudentController {
    Database database;
    AddStudent addStud;
    ActionListener actionListener;
    
    
    /*
    *A constructor that instantiates an instance of the db, mainview
    *actionListener, AddStudent Class etc
    */
    public AddStudentController( AddStudent addNew ,Database database){
        this.database = database;
        addStud = addNew;
        addStud.setVisible(true);
    }

   
   public void control(){        
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addStud.getSaveBtn()){
                    addStudent();
                }else if(e.getSource() == addStud.getExitBtn()){
                    addStud.dispose();
                }
            }
        };
    }
   
   public void addStudent(){
       
       String surname = addStud.getSurnameText().getText();
       String firstname = addStud.getFirstnameText().getText();
       int gradYear = (12- addStud.getClassComboBox().getSelectedIndex() + Calendar.getInstance().get(Calendar.YEAR));
       boolean addNewStudent = true;
       
       if(surname.isEmpty()){
           
           addNewStudent = false;
       }
       if(firstname.isEmpty()){
           
           addNewStudent = false;
       }
       
       if(gradYear == -1){
           
           addNewStudent = false;
       }
       
       if(addNewStudent){
           this.database.addStudent(surname,firstname,gradYear);
       }
   }
}

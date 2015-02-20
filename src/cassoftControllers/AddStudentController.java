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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Sheamus Punch Yebisi
 */
public class AddStudentController {

    Database database;
    AddStudent addStud;
    ActionEvent actionEvent;
    ActionListener actionListener;
    MainController mc;

    /*
     *A constructor that instantiates an instance of the db, mainview
     *actionListener, AddStudent Class etc
     */
    public AddStudentController(AddStudent addNew, Database database,MainController mc) {
        this.database = database;
        addStud = addNew;
        this.mc = mc;
        addStud.setVisible(true);
        control();
    }

    private void control() {
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStud.getSaveBtn()) {
                    addStudent();
                } else if (e.getSource() == addStud.getExitBtn()) {
                    addStud.dispose();
                }
            }
        };
        addStud.getSaveBtn().addActionListener(actionListener);
        addStud.getExitBtn().addActionListener(actionListener);

    }

    public void addStudent() {
        String surname = addStud.getSurnameText().getText();
        String firstname = addStud.getFirstnameText().getText();
        int gradYear = (12 - addStud.getClassComboBox().getSelectedIndex() + Calendar.getInstance().get(Calendar.YEAR));
        boolean addNewStudent = true;        
        if (database.addStudent(surname, firstname, gradYear)) {            
            mc.home();
            JOptionPane.showMessageDialog(addStud, "Student Added");
            clear();
        }else{
            JOptionPane.showMessageDialog(addStud, "Failed to Add");
        }
    }
    
    
     private void clear(){        
       addStud.getFirstnameText().setText("");
       addStud.getSurnameText().setText("");      
   }
     
     public void reveal(){
         addStud.setVisible(true);
     }
    
    
}

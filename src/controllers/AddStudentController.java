/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import models.Database;
import models.Operations;
import models.Student;
import views.AddStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Israel Agyeman-Prempeh
 */
public class AddStudentController {
    private Database database;
    private Operations op;
    private Student student;
    private AddStudent addStud;
    private ActionListener actionListener;
    private javax.swing.JComboBox combo;
    private Connection conn;
    private Calendar now = Calendar.getInstance();
    
    
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
                if(e.getSource() == addStud.getSaveBtn()){
                    simpleSave();
                    clear();
                }                    
                else if(e.getSource() == addStud.getExitBtn()){
                    addStud.dispose();
                }              
            }
        };
        
        addStud.getSaveBtn().addActionListener(actionListener);
        addStud.getExitBtn().addActionListener(actionListener);
        
    }
   
   /*
   *A method that saves with the simply into the database without 
   *a complex entry
   *@param database
   */
   
   private void simpleSave(){
       combo = addStud.getClassComboBox();
       String firstName = addStud.getFirstnameText().getText();
       String surName = addStud.getSurnameText().getText();
       int studClass = getStudentClass();      
       if(database.addStudent(surName,firstName,studClass)){
           op.updateTable();
           JOptionPane.showMessageDialog(addStud,"Added Succesfully");           
       }else{
           JOptionPane.showMessageDialog(addStud,"Failed to Add");
       }
   }
   
   private void clear(){
       combo = addStud.getClassComboBox();
       addStud.getFirstnameText().setText("");
       addStud.getSurnameText().setText("");
      
   }
   
   private int getStudentClass(){
       int currYear = now.get(Calendar.YEAR);
       int classNo = combo.getSelectedIndex();
       int currClass = ((12-classNo)+currYear);      
       return currClass;
   }
   
    
    
}

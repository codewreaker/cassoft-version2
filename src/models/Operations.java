/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.AddStudentController;
import controllers.SettingsController;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import views.AddStudent;
import views.MainView;
import views.Settings;

/**
 *
 * @author Israel Agyeman-Premp
 */
public class Operations {
    
    private KeyAdapter keyAdapter;
    private MainView mainView;
    private Database database;
    private ActionListener actionListener;
    private DefaultTableModel mainTableModel;
    private AddStudent newStudent;
    private AddStudentController addStudentControl;
    
      /**
     * This method initiates the listeners.
     */
    
    public Operations(MainView mv, Database db){
        this.mainView = mv;
        this.database = db;
        
    }
//    public void control() {
//        final JTextField text = (JTextField) mainView.searchComboBox().getEditor().getEditorComponent();
//        final JTextField search = (JTextField) mainView.searchComboBox().getEditor().getEditorComponent();
//        keyAdapter = new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (e.getSource() == text) {
//                    autoComplete(text);
//                }
//
//                if (e.getSource() == search) {
//                    search(search);
//                }
//            }
//        };      
//    }
    
                

    /**
     * This
     *
     * @param text represents the text field to be completed
     */
    public void autoComplete(final JTextField text) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                String request = text.getText();
                if (request.length() < 1) {
                    mainView.searchComboBox().hidePopup();
                    return;
                }
                ArrayList<String> suggest = database.suggest(request);
                if (suggest.size() > 0) {
                    mainView.searchComboBox().setModel(new DefaultComboBoxModel(suggest.toArray()));
                    mainView.searchComboBox().setSelectedItem(request);
                    mainView.searchComboBox().showPopup();
                } else {
                    mainView.searchComboBox().hidePopup();
                }

            }
        });
    }

    /*public void update(){
        
    }*/
    
    /** 
     * This saves the transaction added.
     */
    public void save(){
        String name = (String)mainView.studName().getText();
        if(name == null){
                Toolkit.getDefaultToolkit().beep();   
        }
        else{  
        String firstName = name.substring(0,name.indexOf(" ")).trim();
        String surname = name.substring(name.indexOf(" ")).trim();
        String feeType = (String)mainView.getCategoryComboBox().getSelectedItem();
        
        Double amount;
        try{
            amount = Double.parseDouble(mainView.getAmountPaidField().getText());
            
             if(!database.addTransaction(firstName,surname,amount,feeType)){
            JOptionPane.showMessageDialog(mainView, "You have not entered the fees for the term. Please go to settings.");
        }
        updateTable();
        refresh();
        }catch(NumberFormatException e){
            Border border = BorderFactory.createLineBorder(Color.red);
            mainView.getAmountPaidField().setBorder(border);
            Toolkit.getDefaultToolkit().beep();
        }
        }
       
    }

    public void addStudent() {
        newStudent = new AddStudent();
        addStudentControl = new AddStudentController(newStudent, database,this);
        addStudentControl.control();
    }
    
     public void settings(){
        Settings setting = new Settings();
        SettingsController sc = new SettingsController(setting, database);
        sc.control();
    }

    public void search(final JTextField search) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                String request = search.getText();
                if (request.length() < 1) {
                    mainView.searchComboBox().hidePopup();
                    updateTable();
                    return;
                }
                ArrayList search = database.suggestSearch(request);
                ArrayList suggestions = (ArrayList) search.get(0);
                Vector columns = (Vector) search.get(1);

                Vector v1 = new Vector();
                /*Vector v2 = (Vector)search.get(1).get(1);
                 Vector v3 = (Vector)search.get(1).get(2);
                 Vector v4 = (Vector)search.get(1).get(3);
                
                
                      //v1.setColumnCount(0); */
                v1.add("Date");
                v1.add("Surname");
                v1.add("First Name");
                v1.add("Amount Paid");
                v1.add("Type of Fee");
                      
                
                mainTableModel = new DefaultTableModel(columns,v1);
                mainView.mainTable().setModel(mainTableModel);
                if (suggestions.size() > 0) {
                    mainView.searchComboBox().setModel(new DefaultComboBoxModel(suggestions.toArray()));
                    mainView.searchComboBox().setSelectedItem(request);
                    mainView.searchComboBox().showPopup();
                } else {
                    mainView.searchComboBox().hidePopup();
                }

            }
        });

    }

    /* public void enableUpdate(){
        
    }*/
    
   
    
    /**
     * This updates the table in the main view.
     */
    public void updateTable() {
        JTable mainTable = mainView.mainTable();
        //mainTable.setEnabled(false);
        Vector<Object> v = new Vector<Object>();
        v.add("Full Name");
        v.add("Class");
        v.add("School Fees");
        v.add("Total Paid");
        mainTableModel = new DefaultTableModel(database.getAllStudent(), v);
        //mainTableModel = new DefaultTableModel(database.getTransactionInfo(), v);
        mainTable.setModel(mainTableModel);
        
    }
    
     /**
     * This updates the table in the main view.
     */
    public void studHistory() {
                ArrayList search = database.populateHistory();
                ArrayList suggestions = (ArrayList) search.get(0);
                Vector columns = (Vector) search.get(1);

                Vector v1 = new Vector();
                /*Vector v2 = (Vector)search.get(1).get(1);
                 Vector v3 = (Vector)search.get(1).get(2);
                 Vector v4 = (Vector)search.get(1).get(3);
                
                
                      //v1.setColumnCount(0); */
                v1.add("Date");
                v1.add("Surname");
                v1.add("First Name");
                v1.add("Amount Paid");
                v1.add("Type of Fee");
                
                
                      
                
                mainTableModel = new DefaultTableModel(columns,v1);
                mainView.mainTable().setModel(mainTableModel);        

    }
        
    
    /*
    * A method that initialises the summary view
    */
    public void summarize() {
        //SummaryView summaryView = new SummaryView();
        //SummaryController sc = new SummaryController(summaryView, database);
        //sc.control();        
    }
    
  

    /**
     * This refreshes the view.
     */
    public void refresh() {
        mainView.getAmountPaidField().setText("");
        mainView.getAmountPaidField().setBorder(mainView.getAmountPaidField().getBorder());
    }

    

    public void studView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void studDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 

    
}

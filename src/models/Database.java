/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.MainController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Israel Agyeman-Prempeh
 */
public class Database {

    Connection conn;
    private Vector v1;
    private Vector v2;
    private Vector v3;
    private Vector v4;
    private Calendar now = Calendar.getInstance();

    /**
     * public ArrayList<Vector> getVector(){ ArrayList<Vector> a = new
     * ArrayList<Vector>(); a.add(v1); a.add(v2); a.add(v3); a.add(v4); return
     * a; }
     */
    /**
     * Default constructor
     */
    public Database() {
    }

    /**
     * Initializes connection to the database
     *
     * @return represents successful or unsuccessful connection
     */
    public boolean initComponents() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/cassoft?user=root&password=");

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * This method validates user credentials.
     *
     * @param name represents username.
     * @param password represents users password.
     * @return represent correct or incorrect credentials.
     */
    public boolean checkPassword(String name, String password) {
        ResultSet set = null;
        try {
            Statement statement = conn.createStatement();
            set = statement.executeQuery("select * from credentials");
            while (set.next() != false) {
                if (set.getString(2).equals(name) && set.getString(3).equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * This method looks for all possible outcomes of given text.
     *
     * @param s represents the entered text.
     * @return represents list of possible strings.
     */
    public ArrayList<String> suggest(String s) {
        ArrayList<String> suggestions = new ArrayList<>();

        String query = "";

        try {

            query = "select * from students WHERE CONCAT(students.firstname, ' ', students.surname) LIKE'" + s + "%' OR students.surname LIKE '" + s + "%'";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                suggestions.add(result.getString("firstname") + " " + result.getString("surname"));
            }
            //Collections.sort(suggestions);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suggestions;
    }

    public ArrayList suggestSearch(String s) {
        Vector allRows = new Vector();
        Vector row;
        ArrayList<String> search = new ArrayList<>();
        ArrayList rslt = new ArrayList();

        String query = "";

        try {

            query = "SELECT students.surname, students.firstname, amount_paid, type, Transactions.date FROM students join transactions on students.student_Id = transactions.student_Id WHERE CONCAT(TRIM(students.firstname), ' ', TRIM(students.surname)) LIKE'%" + s + "%'  ORDER BY Transactions.date DESC";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                row = new Vector();
                String name = result.getString("firstname") + " " + result.getString("surname");
                if (!search.contains(name)) {
                    search.add(name);
                }
                row.add(result.getString("date"));
                row.add(result.getString("firstname"));
                row.add(result.getString("surname"));
                row.add(result.getString("amount_paid"));
                row.add(result.getString("type"));

                allRows.add(row);
            }
            //values.add(search);
            //values.add(columns);
            rslt.add(search);
            rslt.add(allRows);
            //Collections.sort(suggestions);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rslt;
    }

    /**
     * This method adds an new transaction.
     *
     * @param firstName represents student's first name.
     * @param surname represents student's surname.
     * @param amount represents amount deposited by student.
     * @param feeType represents the category of fees added
     * @return represent whether transaction was successful or not.
     */
    public boolean addTransaction(String firstName, String surname, Double amount, String feeType) {
        int id = getId(firstName, surname);
        System.out.println(firstName);
        System.out.println(surname);
        int settingId = getSettingId();
        if (id == -1) {
            System.out.println("error studId");
            return false;
        }
        if (settingId == -1) {
            System.out.println("error setting Id");
            return false;
        }
        String query = "";
        try {
            query = ("INSERT INTO Transactions(student_Id, setting_id, amount_paid, date, type) VALUES"
                    + "(" + id + ", " + settingId + ", " + amount + ", CURDATE(), '" + feeType + "')");
            Statement stmt = conn.createStatement();
            System.out.println("O");
            stmt.executeUpdate(query);
            System.out.println("OOO");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    
    
     public ArrayList populateHistory(){
        Vector allRows = new Vector();
        Vector row;
        ArrayList<String> search = new ArrayList<>();
        ArrayList rslt = new ArrayList();
        String s = MainController.surName+MainController.firstName;
        
        System.out.println("What they are looking for:"+s);
        
        
        
        String query="";
        
        try {
            
            query = "SELECT students.surname, students.firstname, amount_paid, type, Transactions.date FROM students join transactions on students.student_Id = transactions.student_Id WHERE CONCAT(TRIM(students.surname), '', TRIM(students.firstname)) LIKE'%" + s + "%' ORDER BY Transactions.date DESC";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                row = new Vector();
                String name = result.getString("firstname") + " " + result.getString("surname");
                System.out.println("What was found:"+result.getString("surname")+result.getString("firstname"));
                if(!search.contains(name))
                    search.add(name);
                row.add(result.getString("date"));
                row.add(result.getString("firstname"));
                row.add(result.getString("surname"));
                row.add(result.getString("amount_paid"));
                row.add(result.getString("type"));
                
                
                allRows.add(row);
            }
            //values.add(search);
            //values.add(columns);
            rslt.add(search);
            rslt.add(allRows);
                //Collections.sort(suggestions);
                        
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rslt;
    }

    /**
     * This method gets a summary of all current transactions
     *
     * @return represents the items in a row
     */
    public Vector getTransactionInfo() {
        String query = "";
        Vector<Vector> vector = new Vector<>();
        Vector<Object> items;
        try {
            query = ("SELECT CONCAT(students.firstname, ' ', students.surname)as 'Full Name', settings.school_fee, sum(transactions.amount_paid)as 'Total amount paid', (settings.school_fee-sum(transactions.amount_paid))as 'Balance' FROM Transactions INNER JOIN Settings ON transactions.setting_Id = Settings.setting_Id and transactions.setting_id = (SELECT setting_id FROM Settings ORDER BY setting_id DESC LIMIT 1) and transactions.type='School Fees' JOIN students ON students.student_Id =transactions.student_Id Group by students.student_Id");
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            while (rslt.next()) {
                items = new Vector<>();
                items.add(rslt.getString(1));
                items.add(rslt.getDouble(2));
                items.add(rslt.getDouble(3));
                items.add(rslt.getDouble(4));
                vector.add(items);
            }

        } catch (SQLException e) {
            return vector;
        }
        return vector;
    }

    /**
     * A method that does a simple add student to the database It also by
     * default adds a transaction id and a default school fees of 0
     *
     * @param surname
     * @param firstname
     * @param studClass
     * @return
     */
    public boolean addStudent(String surname, String firstname, int studClass) {
        int amount = 0;
        String feeType = "School Fees";
        /**
         * Setting the default values
         */
              
        /*End*/
        String query = "";
        try {
            query = ("INSERT INTO students(surname, firstname,graduation_year)"
                    + "VALUES('" + surname + "',  '" + firstname + "', '" + studClass + "')");
            Statement stmt = conn.createStatement();
            System.out.println("Statement sucessfully created");
            stmt.executeUpdate(query);
            System.out.println("Add query succesfully created");
            query = "";
            int id = getId(firstname, surname);
        int settingId = getSettingId();
        if (id == -1) {
            System.out.println("error studId");
            return false;
        }
        if (settingId == -1) {
            System.out.println("error setting Id");
            return false;
        } 
            query = ("INSERT INTO Transactions(student_Id, setting_id, amount_paid, date, type) VALUES"
                    + "(" + id + ", " + settingId + ", " + amount + ", CURDATE(), '" + feeType + "')");
            System.out.println("Default transaction created");
            stmt.executeUpdate(query);
            System.out.println("Default amount succesfully added");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateSettings(int year, int term, double schoolFee,
            double feedingFee, double classesFee) {
        String query = "";
        try {
            query = ("INSERT INTO `settings`(year,term,school_fee,classes_fee,feeding_fee)VALUES"
                    + "(" + year + "," + term + "," + schoolFee + "," + feedingFee + "," + classesFee + ")");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    /**
     * This method gets the ID of a student.
     *
     * @param firstName represents student's first name.
     * @param surname represents student's surname.
     * @return represents student's ID
     */
    private int getId(String firstName, String surname) {
        int id = -1;
        System.out.println(firstName);
        System.out.println(surname);
        String query = "";
        try {
            query = ("SELECT * FROM students WHERE firstname ='" + firstName + "' AND surname ='" + surname + "'");
            Statement stmt = conn.createStatement();
            System.out.println("I");
            ResultSet rslt = stmt.executeQuery(query);
            System.out.println("IQ" + id);
            rslt.next();
            System.out.println("IQQ" + id);
            id = rslt.getInt(1);
            System.out.println("IQQQ" + id);
        } catch (SQLException e) {
            return id;
        }
        return id;
    }

    /**
     * This method gets the ID for the current settings.
     *
     * @return represents the id of the current settings.
     */
    private int getSettingId() {
        int id = -1;
        String query = "";
        try {
            query = ("SELECT setting_id FROM Settings ORDER BY setting_id DESC LIMIT 1");
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            rslt.next();
            id = rslt.getInt(1);
        } catch (SQLException e) {
            return id;
        }
        return id;

    }

    public ArrayList getSetting() {

        ArrayList settings = new ArrayList();
        String query = "";
        try {
            query = ("SELECT * FROM Settings ORDER BY setting_id DESC LIMIT 1");
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            rslt.next();
            settings.add(rslt.getInt("year"));
            settings.add(rslt.getInt("term"));
            settings.add(rslt.getInt("school_fee"));
            settings.add(rslt.getInt("classes_fee"));
            settings.add(rslt.getInt("feeding_fee"));
        } catch (SQLException e) {
            return settings;
        }
        return settings;

    }

    public Vector getAllStudent() {
        String query = "";
        Vector<Vector> vector = new Vector<>();
        Vector<Object> items;
        try {
            String a,b;
            double c,d;
            query = ("SELECT CONCAT(students.surname, ' ', students.firstname)as 'Full Name',students.graduation_year, settings.school_fee, sum(transactions.amount_paid)as 'Total amount paid' FROM Transactions INNER JOIN Settings ON Transactions.setting_Id = Settings.setting_Id and transactions.setting_id = (SELECT setting_id FROM Settings ORDER BY setting_id DESC LIMIT 1) and transactions.type='School Fees' JOIN students ON students.student_Id =transactions.student_Id Group by students.surname");
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            while (rslt.next()) {
                items = new Vector<>();
                a = rslt.getString(1);
                b = getStudentClass(rslt.getInt(2));
                c = rslt.getDouble(3);
                d = rslt.getDouble(4);
                items.add(a);
                items.add(b);
                items.add(c);
                items.add(d);
                vector.add(items);
            }

        } catch (SQLException e) {
            System.out.println(e);
            return vector;
        }
        return vector;
    }
    
    private String  getStudentClass(int year){
       String currClass;
       int classNo;
       int currYear = now.get(Calendar.YEAR);
       classNo = ((currYear - year)+12);
       if(classNo == 0){currClass = "Nursery 1";}
       else if(classNo == 1){currClass = "Nursery 2";}
       else if(classNo == 2){currClass = "KG 1";}
       else if(classNo == 3){currClass = "KG 2";}
       else if(classNo == 4){currClass = "Class 1";}
       else if(classNo == 5){currClass = "Class 2";}
       else if(classNo == 6){currClass = "Class 3";}
       else if(classNo == 7){currClass = "Class 4";}
       else if(classNo == 8){currClass = "Class 5";}
       else if(classNo == 9){currClass = "Class 6";}
       else if(classNo == 10){currClass = "JHS 1";}
       else if(classNo == 11){currClass = "JHS 2";}
       else if(classNo == 12){currClass = "JHS 3";}
       else{currClass = "Graduated";}
       return currClass;
   }
    
   
}

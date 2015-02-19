package cassoftModels;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

public class Database {

    public boolean initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    Connection conn;
    private Vector v1;
    private Vector v2;
    private Vector v3;
    private Vector v4;
    private Calendar now = Calendar.getInstance();
    private boolean status;

    public Database() {
        
    }

    /**
     * Initializes connection to the database
     *
     * @return represents successful or unsuccessful connection
     */
    public boolean isConnected() {        
        try {
            String[] mysqlDetails = getMysqlDetails();
            String mysqlUsername = mysqlDetails[0];
            String mysqlPassword = mysqlDetails[1];
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/cassoft?user=" + mysqlUsername + "&password=" + mysqlPassword + "");
        } catch (Exception e) {            
            System.exit(0);
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
     * A method that returns the mysqlUsername and password If the mysql
     * password is empty it converts the 'e' string created by the getSQL method
     * into an empty text
     *
     * @return String[] an array of size 2 with array[0]being username and
     * array[1] being the password
     *
     */
    private String[] getMysqlDetails() throws FileNotFoundException {
        String[] arr = new String[2];
        String mysqlDetails = readSQL();
        String[] temp = mysqlDetails.split(":");
        arr[0] = temp[0];
        arr[1] = temp[1];
        if (arr[1].equals("e")) {
            arr[1] = "";
        }
        return arr;
    }

    /**
     * A method that gets the USER username and password The username and
     * password area cannot be empty for now
     *
     * @return String[] an array with the user details array[0] username and
     * array[1] password
     */
    private String[] getUserTextDetails() throws FileNotFoundException {
        String[] arr = new String[2];
        String userDetails = readUSER();
        String[] temp = userDetails.split(":");
        arr[0] = temp[0];
        arr[1] = temp[1];
        return arr;
    }

    /**
     * This method reads the user details from the credentials.txt file This
     * method primarily reads the user details
     *
     * @return String with user details
     */
    private String readUSER() {
        String details = null;
        try (FileInputStream FIS = new FileInputStream("credentials.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(FIS))) {
            details = reader.readLine();
            System.out.println("This is the USER details: " + details);
        } catch (IOException x) {
            System.err.println(x);
        }
        return details;
    }

    /**
     * This method reads the SQL details of the of the credentials.txt
     *
     * @return string with user password
     */
    private String readSQL() {
        String details = "";
        try (FileInputStream FIS = new FileInputStream("credentials.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(FIS))) {
            /* A first readline that I do not need */
            reader.readLine();
            details = reader.readLine();
            System.out.println("This is the SQL details: " + details);
        } catch (IOException x) {
            System.err.println(x);
        }
        return details;
    }

    /**
     * This method stores the credentials.txt username and password into the
     * database initially after first use. The user can still create another
     * password later on
     * @return 
     */
    public boolean createInitialPassword() {
        try {
            String query = "";
            String arr[] = getUserTextDetails();
            String uName = arr[0];
            String passW = arr[1];

            query = ("INSERT INTO `credentials`(name,password) VALUES " + "('"+ uName +"','"+ passW +"')");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);            
            return true;
        } catch (SQLException |FileNotFoundException e) {
            System.out.println(e);
            return false;
        }

    }
    
    public boolean addStudent(String surname, String firstname, int studClass) {
        String query = "";
        try {
            query = ("INSERT INTO students(surname, firstname, graduation_year)"
                    + "VALUES('" + surname + "',  '" + firstname + "', '" + studClass + "')");
            Statement stmt = conn.createStatement();
            System.out.println("Statement sucessfully created");
            stmt.executeUpdate(query);
            System.out.println("Add query succesfully created");
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
public Vector getStudents() {
        String query = "";
        Vector<Student> students = new Vector<>();
        try {
            String a,b;
            int c;
            double d,e;
            query = ("SELECT students.surname, students.firstname,students.graduation_year, settings.school_fee, sum(transactions.amount_paid)as 'Total amount paid' FROM Transactions INNER JOIN Settings ON Transactions.setting_Id = Settings.setting_Id and transactions.setting_id = (SELECT setting_id FROM Settings ORDER BY setting_id DESC LIMIT 1) and transactions.type='School Fees' JOIN students ON students.student_Id =transactions.student_Id Group by students.surname");
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            while (rslt.next()) {
                a = rslt.getString(1);
                b = rslt.getString(2);
                c = rslt.getInt(3);
                d = rslt.getDouble(4);
                e = rslt.getDouble(5);
                Student newStud = new Student();
                
                
                newStud.setFirstName(a);
                
                newStud.setSurname(b);
                
                newStud.setStudentClass(getStudentClass(c));
                
                newStud.setFees(d);
                
                newStud.setBalance(e);
                
                students.add(newStud);
            }

        } catch (SQLException e) {
            System.out.println(e);
            return students;
        }
        return students;
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

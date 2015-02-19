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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     *
     * @return
     */
    public boolean createInitialPassword() {
        boolean state = false;
        
        try {
            isConnected();
            String query = "";
            String arr[] = getUserTextDetails();
            String uName = arr[0];
            String passW = arr[1];
            if (!containsDetailsAlready()) {
                query = ("INSERT IGNORE INTO `credentials`(name,password) VALUES " + "('" + uName + "','" + passW + "')");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                state = true;
            }
            return state;
        } catch (SQLException | FileNotFoundException e) {
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
            int c, f;
            double d,e;
            query = ("SELECT students.surname, students.firstname,students.graduation_year, settings.school_fee, sum(transactions.amount_paid)as 'Total amount paid', students.student_id FROM transactions INNER JOIN Settings ON transactions.setting_Id = settings.setting_Id and transactions.setting_id = (SELECT setting_id FROM Settings ORDER BY setting_id DESC LIMIT 1) and transactions.type='School Fee' JOIN students ON students.student_Id =transactions.student_Id Group by students.surname");
            Statement stmt = conn.createStatement();
            System.out.println("getStudents statement created");
            ResultSet rslt = stmt.executeQuery(query);
            System.out.println("-----------------get students -------------------");
            while (rslt.next()) {
                a = rslt.getString(1);
                System.out.println("Surname:"+a);
                b = rslt.getString(2);
                System.out.println("Firstname:"+b);
                c = rslt.getInt(3);
                System.out.println("Graduation Year:"+c);
                d = rslt.getDouble(4);
                System.out.println("Fees:"+d);
                e = rslt.getDouble(5);
                System.out.println("Total:"+e);
                f = rslt.getInt(6);
                System.out.println("Balance:"+f);
                Student newStud = new Student();                
                newStud.setFirstName(a);                
                newStud.setSurname(b);                
                newStud.setStudentClass(getStudentClass(c));                
                newStud.setFees(d);
                
                newStud.setBalance(e);
                
                newStud.setId(f);
                
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
    
    public boolean addTransaction(int id, String category, double amountPaid){
        String query = "";
        try{
            query = ("");            
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
        }catch(SQLException e){
            return false;
        }
        
        return false;
    }
    
    public Vector getTransactionByStudent(int id){
        return null;
    }
    public boolean deleteStudent(int id){
        String query = "";
        try{
            query = ("DELETE FROM students WHERE student_Id = '" + id +"'");
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    /**
     * This method checks if the password and username is already in the database before it adds the password
     * @return 
     */
    private boolean containsDetailsAlready() {
        boolean state = false;
        try {            
            String arr[] = getUserTextDetails();
            String uName = arr[0];
            String passW = arr[1];            
            String query = "";
            query = "SELECT * FROM credentials";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                String name = result.getString("name");
                String passWord = result.getString("password");
                System.out.println("Your UserName and DB Username:"+uName+":"+name+"\nYour Password and DB PAssword:"+passW+":"+passWord);
                if (uName.equals(name) && passW.equals(passWord)) {
                    state = true;
                }
            }
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }
    
     public static void main(String[] args){
        Database db = new Database();
        db.isConnected();
        Vector students = db.getStudents();
        System.out.println("Contents of Vector: "+students.toString());
       
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
}

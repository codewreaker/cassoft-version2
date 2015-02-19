/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cassoftModels;

import java.sql.Date;

/**
 *
 * @author Seamus
 */
public class Student extends Person {
    Date birthdate;
    String studClass;
    double fees;
    double balance;
    int id;
    
    public Student(String surname, String firstName, int age, char gender, Date birthdate, String studClass){
        super(surname,firstName,age,gender);
        this.birthdate = birthdate;
        this.studClass = studClass;
    }
    public Student(){
        super();
        this.birthdate = null;
        this.studClass = null;
    }
    
    public void setBirthday(Date birthdate){
        this.birthdate = birthdate;
    }
    
    public void setStudentClass(String studClass){
        this.studClass = studClass;
    }
    
    public void setFees(double fees){
        this.fees = fees;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Date getBirthDate(){
        return birthdate;
    }
    
    public String getStudentClass(){
        return studClass;
    }
    
    public double getFees(){
        return this.fees;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public int getId(){
        return this.id;
    }
    
    
}

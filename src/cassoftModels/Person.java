/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cassoftModels;

/**
 *
 * @author Seamus
 */
public class Person {
    String surname;
    String firstName;
    int age;
    char gender;
    
    public Person(String surname, String firstName,int age, char gender){
        this.surname = surname;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;        
    }
    
    public Person(){
        this(null,null,0,'-');
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public int getAge(){
        return age;
    }
    
    public char getGender(){
        return gender;
    }
    
}

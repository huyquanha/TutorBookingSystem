/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class User {
    
    protected String username;
    protected String password;
    protected String fName, lName, address, city, state;
    protected int postcode;
    protected String phoneNumber;
    
    public User(String username, String password,String fName, String lName, String address, String city, String state, int postcode, String phoneNumber) {
        this.username=username;
        this.password=password;
        this.fName=fName;
        this.lName=lName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.postcode=postcode;
        this.phoneNumber=phoneNumber;
    }
    
    
    //GET methods
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFirstName() {
        return fName;
    }
    
    public String getLastName() {
        return lName;
    }
    
    public String getName() {
        return fName+" "+lName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {  
        return state;
    }
    
    public int getPostcode() {
        return postcode;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //SET methods
    public void setPassword(String newPassword) {
        password=newPassword;
    }
    
}

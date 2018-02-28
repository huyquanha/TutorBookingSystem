/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class ServiceProvider extends User {
    
    private double rating;
    private double amount; //money received from customers
    
    public ServiceProvider(String username, String password,  String fName, String lName, String address, String city, String state, int postcode, String phoneNumber, double rating, double amount) {
        super(username, password, fName, lName, address, city, state, postcode, phoneNumber);
        this.rating=rating;
        this.amount=amount;
    }
    
    public ServiceProvider(String username, String password,  String fName, String lName, String address, String city, String state, int postcode, String phoneNumber,double amount) {
        super(username, password, fName, lName, address, city, state, postcode, phoneNumber);
        rating=5.0;
        this.amount=amount;
    }
    
    public ServiceProvider(User user, double amount) { //create Provider from existing User
        this(user.username,user.password,user.fName,user.lName,user.address,user.city,user.state,user.postcode,user.phoneNumber,amount);
        rating=5.0;
    }
    
    //GET METHODS
    
    public double getProviderRating() {
        return rating;
    }
    
    public double getAmount() {
        return amount;
    }
    
    
    //SET METHODS
    
    public void setProviderRating(double newRating) {
        rating=newRating;
    }
    
    public void increaseAmount(double addedAmount) {
        amount+=addedAmount;
    }
    
    public void decreaseAmount(double decreasedAmount) {
        amount-=decreasedAmount;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDateTime;
import java.sql.Timestamp;
/**
 *
 * @author ASUS
 */



public class CreditCard {
    public static enum Type {VISA, MASTERCARD}
    
    private String cardNumber;
    private String nameOnCard;
    private LocalDateTime expiryDate;
    private int cvv;
    private String username;
    private Type type;
    private double amount;
    
    public CreditCard(String cardNumber, String type, String nameOnCard, Timestamp expiryDate, int cvv, String username, double amount) {
        this.cardNumber=cardNumber;
        this.type=Type.valueOf(type.toUpperCase());
        this.nameOnCard=nameOnCard;
        this.expiryDate=expiryDate.toLocalDateTime();
        this.cvv=cvv;
        this.username=username;
        this.amount=amount;
    }
    
    public CreditCard(String cardNumber, String type, String nameOnCard, LocalDateTime expiryDate, int cvv, String username, double amount) {
        this.cardNumber=cardNumber;
        this.type=Type.valueOf(type.toUpperCase());
        this.nameOnCard=nameOnCard;
        this.expiryDate=expiryDate;
        this.cvv=cvv;
        this.username=username;
        this.amount=amount;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public String getNameOnCard() {
        return nameOnCard;
    }
    
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }
    
    public int getCvv() {
        return cvv;
    }
    
    public String getUsername() {
        return username;
    }
    
    public Type getType() {
        return type;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public boolean decreaseAmount(double deduction) {
        if (amount<deduction) {
            return false;
        }
        amount-=deduction;
        return true;
    }
  
}

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
public class Transaction {
    private int transactionID;
    private int requestID;
    private LocalDateTime transactionTime;
    private String payee; //references User's username who is a customer
    private String payer; //references User's username who is a provider
    private double payAmount;
    
    public Transaction(int transactionID, int requestID, Timestamp time,String payee, String payer, double payAmount) {
        this.transactionID=transactionID;
        this.requestID=requestID;
        transactionTime=time.toLocalDateTime();
        this.payee=payee;
        this.payer=payer;
        this.payAmount=payAmount;
    }
    
    //GET METHODS
    
    public int getTransactionID() {
        return transactionID;
    }
    
    public String getPayee() {
        return payee;
        
    }
    
    public String getPayer() {
        return payer;
    }
    
    public int getRequestID() {
        return requestID;
    }
    
    public double getPayAmount() {
        return payAmount;
    }
}

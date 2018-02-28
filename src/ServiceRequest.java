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
public class ServiceRequest {
    protected int requestID;
    protected int serviceID; //references serviceOffering's serviceID
    protected String requester; //references User's username
    protected LocalDateTime requestTime, serviceTime;
    protected int durationHour;
    protected int durationMinute;
    protected String address;
    
    public ServiceRequest(int requestID, int serviceID, String requester, Timestamp requestTime, Timestamp serviceTime, int durHour, int durMinute, String address) {
        this.requestID=requestID;
        this.serviceID=serviceID;
        this.requester=requester;
        this.requestTime=requestTime.toLocalDateTime();
        this.serviceTime=serviceTime.toLocalDateTime();
        durationHour=durHour;
        durationMinute=durMinute;
        this.address=address;
    }
    
    public ServiceRequest(int requestID, int serviceID, String requester, LocalDateTime requestTime, LocalDateTime serviceTime, int durHour, int durMinute, String address) {
        this.requestID=requestID;
        this.serviceID=serviceID;
        this.requester=requester;
        this.requestTime=requestTime;
        this.serviceTime=serviceTime;
        durationHour=durHour;
        durationMinute=durMinute;
        this.address=address;
    }
    
    //GET METHODS
    
    public int getID() {
        return requestID;
    }
    
    public int getServiceID() {
        return serviceID;
    }
    
    public String getRequester() {
        return requester;
    }
    
    public LocalDateTime getRequestTime() { //the time a service is requested
        return requestTime;
    }
    
    public LocalDateTime getServiceTime() { //the time a service needs to be served to customer
        return serviceTime;
    }
    
    public int getHour() {
        return durationHour;
    }
    
    public int getMinute() {
        return durationMinute;
    }
    
    public String getAddress(){
        return address;
    }
    
    //SET METHODS
    public void editServiceTime(LocalDateTime newTime) {
        serviceTime=newTime;
    }
    
    public void editDuration(int newHour, int newMinute) {
        durationHour=newHour;
        durationMinute=newMinute;
    }
    
    public void setAddress(String newAddress){
        address=newAddress;
    }
}

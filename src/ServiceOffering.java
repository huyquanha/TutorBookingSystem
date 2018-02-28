/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */
public class ServiceOffering {
    
    private int serviceID;
    private String serviceName;
    private String serviceLocation;
    private String serviceDescription;
    private double serviceCost;
    private double serviceRating;
    private int ratingOccur;
    private String providerName;
    
    public ServiceOffering(int id, String name,String location, String description, double cost, String providerName){
        serviceID = id;
        serviceName = name;
        serviceLocation=location;
        serviceDescription=description;
        serviceCost = cost;
        serviceRating  = 5.0; 
        ratingOccur=1;
        this.providerName=providerName;
    }
    
    public ServiceOffering(int id, String name,  String location, String description, double cost, double rating, int ratingOccur, String providerName){
        serviceID = id;
        serviceName = name;
        serviceLocation=location;
        serviceDescription=description;
        serviceCost = cost;
        serviceRating  = rating; 
        this.ratingOccur=ratingOccur;
        this.providerName=providerName;
    }
    
    public String toString(){
        return serviceID + " " + serviceName  + " " +serviceLocation+" "+serviceCost+" "+ serviceRating;
    }
    
    //GET methods
    public int getServiceID() {
        return serviceID;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public String getDescription() {
        return serviceDescription;
    }
    
    public double getServiceRating() {
        return serviceRating;
    }
    
    public double getServiceCost() {
        return serviceCost;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public String getLocation() {
        return serviceLocation;
    }
    
    public int getRatingOccur() {
        return ratingOccur;
    }
    
    
    //SET methods
    
    public void setName(String newName) {
        serviceName=newName;
    }
    
    public void setDescription(String newDescription) {
        serviceDescription=newDescription;
    }
    
    public void setCost(double newCost) {
        serviceCost=newCost;
    }
    
    public void setRating(double newRating) {
        serviceRating=newRating;
    }
    
    public void setLocation (String newLocation) {
        serviceLocation=newLocation;
    }
    
    public void increaseRatingOccur() {
        ratingOccur++;
    }
    
}

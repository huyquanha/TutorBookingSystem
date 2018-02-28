/*
 * 
 */
import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ASUS
 */
public class ServiceDatabase {
    
    private User currentUser;
    private ServiceProvider currentProvider;
    private ServiceOffering currentService;
    private int currentRequestID;
    private int currentTransactionID;
    
    private HashMap<String, User> userMap;
    private HashMap<String, ServiceProvider> providerMap;
    private HashMap <Integer, ServiceOffering> serviceMap;
    private HashMap <Integer, ServiceRequest> requestMap;
    private HashMap<Integer,CompletedRequest> completedRequestMap;
    private HashMap <Integer, Transaction> transactionMap;
    private HashMap <String, CreditCard> cardMap;
    
    public ServiceDatabase (){
        serviceMap = new HashMap<>();
        userMap=new HashMap<>();
        providerMap=new HashMap<>();
        requestMap=new HashMap<>();
        completedRequestMap=new HashMap<>();
        transactionMap=new HashMap<>();
        cardMap=new HashMap<>();
    }
    
    public void loadServiceOfferings (ResultSet set) throws SQLException {
        while (set.next()) {
            int serviceID=set.getInt("serviceID");
            String serviceName=set.getString("serviceName");
            String serviceLocation = set.getString("serviceLocation");
            String serviceDescription=set.getString("serviceDescription");
            double serviceCost=set.getDouble("serviceCost");
            double serviceRating=set.getDouble("serviceRating");
            int ratingOccur = set.getInt("ratingOccur");
            String providerName=set.getString("providerName");
            
            ServiceOffering newService=new ServiceOffering(serviceID, serviceName,serviceLocation, serviceDescription, serviceCost, serviceRating, ratingOccur, providerName);
            if (!serviceMap.containsKey(serviceID)) {
                serviceMap.put(serviceID, newService);
            }
            currentService=newService;
        }
    }
    
    public void loadUsers(ResultSet set) throws SQLException {
        while (set.next()) {
            String username=set.getString("username");
            String password=set.getString("password");
            String fName=set.getString("fName");
            String lName=set.getString("lName");
            String address=set.getString("address");
            String city=set.getString("city");
            String state=set.getString("state");
            int postcode=set.getInt("postcode");
            String phoneNumber=set.getString("phoneNumber");
            
            User newUser =new User(username,password,fName,lName,address,city,state,postcode,phoneNumber);
            if (!userMap.containsKey(username)) {
                userMap.put(username, newUser);
            }
            currentUser=newUser;
        }
    }
    
    public void loadProviders(ResultSet set) throws SQLException {
        while (set.next()) {
            String username=set.getString("username");
            String password=set.getString("password");
            String fName=set.getString("fName");
            String lName=set.getString("lName");
            String address=set.getString("address");
            String city=set.getString("city");
            String state=set.getString("state");
            int postcode=set.getInt("postcode");
            String phoneNumber=set.getString("phoneNumber");
            double rating = set.getDouble("rating");
            double amount = set.getDouble ("amount");
            
            ServiceProvider provider = new ServiceProvider(username,password,fName,lName,address,city,state,postcode,phoneNumber,rating,amount);
            if (!providerMap.containsKey(username)) {
                providerMap.put(username, provider);
            }
        }
    }
    
    public void loadRequests(ResultSet set) throws SQLException {
        while (set.next()) {
            int requestID=set.getInt("requestID");
            int serviceID=set.getInt("serviceID");
            String requester=set.getString("requester");
            Timestamp requestTime=set.getTimestamp("requestTime");
            Timestamp serviceTime=set.getTimestamp("serviceTime");
            int durHour = set.getInt("durationHour");
            int durMinute=set.getInt("durationMinute");
            String address=set.getString("address");
             
            ServiceRequest newRequest = new ServiceRequest(requestID,serviceID,requester,requestTime,serviceTime,durHour,durMinute,address);
            if (!requestMap.containsKey(requestID)) {
                requestMap.put(requestID,newRequest);
            }
            currentRequestID=requestID;
        }
    }
    
    public void loadCompletedRequests(ResultSet set) throws SQLException {
        while (set.next()) {
            int requestID=set.getInt("requestID");
            int serviceID=set.getInt("serviceID");
            String requester=set.getString("requester");
            Timestamp requestTime=set.getTimestamp("requestTime");
            Timestamp serviceTime=set.getTimestamp("serviceTime");
            Timestamp finishTime=set.getTimestamp("finishTime");
            int durHour = set.getInt("durationHour");
            int durMinute=set.getInt("durationMinute");
            String address=set.getString("address");
            
            String feedback =set.getString("feedback");
            int requestRating=set.getInt("requestRating");
            
            CompletedRequest finishedRequest = new CompletedRequest(requestID,serviceID,requester,requestTime,serviceTime, finishTime,durHour, durMinute,address, feedback,requestRating);
            if (!completedRequestMap.containsKey(requestID)) {
                completedRequestMap.put(requestID,finishedRequest);
            }
        }
    }
    
    public void loadTransactions (ResultSet set) throws SQLException {
        while (set.next()) {
            int transactionID=set.getInt("transactionID");
            int requestID=set.getInt("requestID");
            Timestamp transactionTime=set.getTimestamp("transactionTime");
            String payee=set.getString("payee");
            String payer=set.getString("payer");
            double payAmount=set.getDouble("payAmount");
            
            Transaction newTransaction=new Transaction(transactionID,requestID,transactionTime,payee,payer,payAmount);
            
            if (!transactionMap.containsKey(transactionID)) {
                transactionMap.put(transactionID,newTransaction);
            }
            currentTransactionID=transactionID;
        }
    }
    
    public void loadCards (ResultSet set) throws SQLException {
        while (set.next()) {
            String cardNumber=set.getString("cardNumber");
            String type=set.getString("type");
            String nameOnCard=set.getString("nameOnCard");
            Timestamp expiryDate=set.getTimestamp("expiryDate");
            int cvv=set.getInt("cvv");
            String username=set.getString("username");
            double amount=set.getDouble("amount");
            
            CreditCard newCard = new CreditCard(cardNumber,type,nameOnCard,expiryDate,cvv,username,amount);
            
            if (!cardMap.containsKey(cardNumber)) {
                cardMap.put(cardNumber,newCard);
            }
        }
    }
    
    //Validations
    public boolean checkUser(String username, String password) {
        if (userMap.containsKey(username)) {
            User user = userMap.get(username);
            if (user.getPassword().equals(password)) {
                return true; //user with password validated
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    public boolean checkProvider(String username,String password) {
        if (providerMap.containsKey(username)) {
            ServiceProvider provider=providerMap.get(username);
            if (provider.getPassword().equals(password)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
    
    //GET ServiceOffering
    
    public ServiceOffering getServiceOffering(int serviceID) {
        if (serviceMap.containsKey(serviceID)) {
            ServiceOffering service = serviceMap.get(serviceID);
            return service;
        }
        return null;
    }
    
    public Object[][] getServiceOfferings() {
        Object[][] serviceData = new Object[serviceMap.size()][5];
        int index=0;
        for (int i=0; i< serviceMap.size();i++) {
            ServiceOffering service=serviceMap.get(i+1);
            serviceData[index][0]=service.getServiceID();
            serviceData[index][1]=service.getServiceName();
            serviceData[index][2]=service.getLocation();
            serviceData[index][3]=service.getServiceCost();
            serviceData[index][4]=service.getServiceRating();
            index++;
        }
        return serviceData;
    }
    
    public Object[][] getServiceOfferingsByKeyword(String keyword) {
        Object[][] serviceData = new Object[serviceMap.size()][5];
        int index=0;
        for (int i=0; i< serviceMap.size();i++) {
            ServiceOffering service=serviceMap.get(i+1);
            if (service.toString().toUpperCase().contains(keyword.toUpperCase())) {
                serviceData[index][0]=service.getServiceID();
                serviceData[index][1]=service.getServiceName();
                serviceData[index][2]=service.getLocation();
                serviceData[index][3]=service.getServiceCost();
                serviceData[index][4]=service.getServiceRating();
                index++;
            }
        }
        return serviceData;
    }
    
    public Object[][] getServiceOfferingsByLocation(String location) {
        Object[][] serviceData = new Object[serviceMap.size()][5];
        int index=0;
        for (int i=0; i< serviceMap.size();i++) {
            ServiceOffering service=serviceMap.get(i+1);
            if (service.getLocation().toUpperCase().contains(location.toUpperCase())) {
                serviceData[index][0]=service.getServiceID();
                serviceData[index][1]=service.getServiceName();
                serviceData[index][2]=service.getLocation();
                serviceData[index][3]=service.getServiceCost();
                serviceData[index][4]=service.getServiceRating();
                index++;
            }
        }
        return serviceData;
    }
    
    public Object[][] getServiceOfferingsByProvider() {
        Object[][] serviceData = new Object[serviceMap.size()][5];
        int index=0;
        for (int i=0; i< serviceMap.size(); i++) {
            ServiceOffering service=serviceMap.get(i+1);
            if (service.getProviderName().equals(currentUser.getUsername())) {
                serviceData[index][0]=service.getServiceID();
                serviceData[index][1]=service.getServiceName();
                serviceData[index][2]=service.getLocation();
                serviceData[index][3]=service.getServiceCost();
                serviceData[index][4]=service.getServiceRating();
                index++;
            }
        }
        return serviceData;
    }
    
    public int getCurrentServiceID() {
        return currentService.getServiceID();
    }
    
    //SET ServiceOffering
    public void addServiceOffering(ServiceOffering newService) {
        if (!serviceMap.containsKey(newService.getServiceID())) {
            serviceMap.put(newService.getServiceID(),newService);
            currentService=newService;
        }
    }
    
    public boolean removeServiceOffering(int serviceID) {
        if (serviceMap.containsKey(serviceID)) {
            serviceMap.remove(serviceID);
            return true;
        }
        return false;
    }
    
    //GET User
    public User getCurrentUser() {
        return currentUser;
    }
    
    public User getUser(String username) {
        return userMap.get(username);
    }
    
    public void setCurrentUser(User user) {
        currentUser=user;
    }
    
    public void addUser(User user) {
        userMap.put(user.getUsername(),user);
    }
    
    // Provider
    public ServiceProvider getProvider(ServiceOffering service) {
        if (providerMap.containsKey(service.getProviderName())) {
            return providerMap.get(service.getProviderName());
        }
        return null;
    }
    
    public boolean isProvider(User user) {
        return providerMap.containsKey(user.getUsername());
    }
    
    public double calculateProviderRating(ServiceProvider provider) {
        int numberOfServices=0;
        double totalRating=0;
        for (int serviceID : serviceMap.keySet()) {
            ServiceOffering service=serviceMap.get(serviceID);
            if (service.getProviderName().equals(provider.getUsername())) {
                numberOfServices++;
                totalRating+=service.getServiceRating();
            }
        }
        return totalRating/(double)numberOfServices;
    }
    
    public void addProvider(ServiceProvider provider) {
        providerMap.put(provider.getUsername(),provider);
    }
    
    public ServiceProvider getProvider(User user) {
        if (providerMap.containsKey(user.getUsername())) {
            return providerMap.get(user.getUsername());
        }
        return null;
    }
    
    // Service Request
    public void addRequest(ServiceRequest request) {
        requestMap.put(request.getID(),request);
        currentRequestID=request.getID();
    }
    
    public Object[][] getRequestByUser() {
        Object[][] requestData= new Object[requestMap.size()][6]; //reuqestID, serviceName,requestTime, serviceTime, duration, address
        int row=0;
        for (int i=0; i< requestMap.size();i++) {
            ServiceRequest request =  requestMap.get(i+1);
            if (request.getRequester().equals(currentUser.getUsername()) && !completedRequestMap.containsKey(request.getID())) { //still a pending request
                requestData[row][0]=request.getID();
                requestData[row][1]=getServiceOffering(request.getServiceID()).getServiceName();
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String requestTime=request.getRequestTime().format(formatter);
                String serviceTime=request.getServiceTime().format(formatter);
                requestData[row][2]=requestTime;
                requestData[row][3]=serviceTime;
                requestData[row][4]=request.getHour()+": "+request.getMinute();
                requestData[row][5]=request.getAddress();
                row++;
            }
        }
        return requestData;
    }
    
    public Object[][] getProviderPendingRequests() {
        Object[][] requestData= new Object[requestMap.size()][6];
        int row=0;
        for (int i=0; i< requestMap.size();i++) {
            ServiceRequest request =  requestMap.get(i+1);
            ServiceOffering service=serviceMap.get(request.getServiceID());
            if (service.getProviderName().equals(currentUser.getUsername()) && !completedRequestMap.containsKey(request.getID())) { //still a pending request
                requestData[row][0]=request.getID();
                requestData[row][1]=getServiceOffering(request.getServiceID()).getServiceName();
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String requestTime=request.getRequestTime().format(formatter);
                String serviceTime=request.getServiceTime().format(formatter);
                requestData[row][2]=requestTime;
                requestData[row][3]=serviceTime;
                requestData[row][4]=request.getHour()+": "+request.getMinute();
                requestData[row][5]=request.getAddress();
                row++;
            }
        }
        return requestData;
    }
    
    public int getCurrentRequestID() {
        return currentRequestID;
    }
    
    public ServiceRequest getServiceRequest(int requestID) {
        return requestMap.get(requestID);
    }
    
    //CompletedRequest
    public void addCompletedRequest(CompletedRequest compRequest) {
        if (!completedRequestMap.containsKey(compRequest.getID())) {
            completedRequestMap.put(compRequest.getID(),compRequest);
        }
    }
    
    public Object[][] getCompletedRequests() {
        Object[][] data= new Object[completedRequestMap.size()][5];
        int row=0;
        for (Integer i : completedRequestMap.keySet()) { //compRequestID taken from serviceRequest ID so have to check with requestMap, not compRequestMap
            CompletedRequest compRequest=completedRequestMap.get(i);
            if (compRequest !=null) { //compRequestID taken from serviceRequestID so some might not be completed yet and missing
                if (compRequest.getRequester().equals(currentUser.getUsername())) {
                    data[row][0]=compRequest.getID();
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String finishTime=compRequest.getFinishTime().format(formatter);
                    String serviceTime=compRequest.getServiceTime().format(formatter);
                    data[row][1]=serviceTime;
                    data[row][2]=finishTime;
                    data[row][3]=compRequest.getFeedback();
                    data[row][4]=compRequest.getRequestRating();
                    row++;
                }
            }
        }
        return data;
    }
    
    public Object[][] getProviderCompletedRequests() {
        Object[][] data= new Object[completedRequestMap.size()][5];
        int row=0;
        for (Integer i : completedRequestMap.keySet()) { //compRequestID taken from serviceRequest ID so have to check with requestMap, not compRequestMap
            CompletedRequest compRequest=completedRequestMap.get(i);
            ServiceOffering service=serviceMap.get(compRequest.getServiceID());
            if (compRequest !=null) { //compRequestID taken from serviceRequestID so some might not be completed yet and missing
                if (service.getProviderName().equals(currentUser.getUsername())) {
                    data[row][0]=compRequest.getID();
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String finishTime=compRequest.getFinishTime().format(formatter);
                    String serviceTime=compRequest.getServiceTime().format(formatter);
                    data[row][1]=serviceTime;
                    data[row][2]=finishTime;
                    data[row][3]=compRequest.getFeedback();
                    data[row][4]=compRequest.getRequestRating();
                    row++;
                }
            }
        }
        return data;
    }
    
    //Transaction
    public void addTransaction(Transaction transaction) {
        if (!transactionMap.containsKey(transaction.getTransactionID())) {
            transactionMap.put(transaction.getTransactionID(),transaction);
        }
        currentTransactionID=transaction.getTransactionID();
    }
    
    public int getCurrentTransactionID() {
        return currentTransactionID;
    }
    
    //Credit Card
    public CreditCard getCreditCard(String username) {
        for (String cardNumber : cardMap.keySet()) {
            if (cardMap.get(cardNumber).getUsername().equals(username)) {
                return cardMap.get(cardNumber);
            }
        }
        return null;
    }
    
    public void addCard(CreditCard card) {
        if (!userMap.containsKey(card.getUsername())) {
            cardMap.put(card.getCardNumber(), card);
        }
    }
}

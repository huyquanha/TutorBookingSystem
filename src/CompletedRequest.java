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
public class CompletedRequest extends ServiceRequest {
    private LocalDateTime finishTime;
    private String feedback;
    private int requestRating;
    
    public CompletedRequest(int requestID, int serviceID, String requester, Timestamp requestTime, Timestamp serviceTime, Timestamp finishTime, int durHour, int durMinute, String address, String feedback, int requestRating) {
        super(requestID,serviceID,requester,requestTime, serviceTime, durHour, durMinute,address);
        this.finishTime=finishTime.toLocalDateTime();
        this.feedback=feedback;
        this.requestRating=requestRating;
    }
    
    public CompletedRequest(int requestID, int serviceID, String requester, LocalDateTime requestTime, LocalDateTime serviceTime, LocalDateTime finishTime, int durHour, int durMinute, String address, String feedback, int requestRating)
    {
        super(requestID,serviceID,requester,requestTime, serviceTime, durHour, durMinute,address);
        this.finishTime=finishTime;
        this.feedback=feedback;
        this.requestRating=requestRating;
    }
    
    public CompletedRequest(ServiceRequest request, LocalDateTime finishTime, int requestRating, String feedback) {
        this(request.requestID, request.serviceID, request.requester,request.requestTime,request.serviceTime,finishTime,request.durationHour, request.durationMinute, request.address,feedback, requestRating);
    }
    //GET METHODS
    public LocalDateTime getFinishTime() {
        return finishTime;
    }
    
    public String getFeedback() {
        return feedback;
    }
    
    public int getRequestRating() {
        return requestRating;
    }
    
    //SET METHODS
}

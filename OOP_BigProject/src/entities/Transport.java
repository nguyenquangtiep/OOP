package entities;

import java.util.Calendar;

public class Transport 
{
    private Sender sender;
    private Receiver receiver;
    private float fee;
    private String transportType;
    private Calendar sendDate;
    private Calendar receiveDateEstimation;
    private String status;
    private float distance;
    private Package packageTransport;
    
    public Transport(Sender sender, Receiver receiver, float fee, String transportType, 
    Calendar sendDate, Calendar receiveDateEstimation, String status, float distance, 
    Package packageTransport) 
    {
        this.sender = sender;
        this.receiver = receiver;
        this.fee = fee;
        this.transportType = transportType;
        this.sendDate = sendDate;
        this.receiveDateEstimation = receiveDateEstimation;
        this.status = status;
        this.distance = distance;
        this.packageTransport = packageTransport;
    }
    public Sender getSender() 
    {
        return sender;
    }
    public void setSender(Sender sender) 
    {
        this.sender = sender;
    }
    public Receiver getReceiver() 
    {
        return receiver;
    }
    public void setReceiver(Receiver receiver) 
    {
        this.receiver = receiver;
    }
    public float getFee() 
    {
        return fee;
    }
    public void setFee(float fee) 
    {
        this.fee = fee;
    }
    public String getTransportType() 
    {
        return transportType;
    }
    public void setTransportType(String transportType) 
    {
        this.transportType = transportType;
    }
    public Calendar getSendDate() 
    {
        return sendDate;
    }
    public void setSendDate(Calendar sendDate) 
    {
        this.sendDate = sendDate;
    }
    public Calendar getReceiveDateEstimation() 
    {
        return receiveDateEstimation;
    }
    public void setReceiveDateEstimation(Calendar receiveDateEstimation) 
    {
        this.receiveDateEstimation = receiveDateEstimation;
    }
    public String getStatus() 
    {
        return status;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }
    public float getDistance() 
    {
        return distance;
    }
    public void setDistance(float distance) 
    {
        this.distance = distance;
    }
    public Package getPackageTransport() 
    {
        return packageTransport;
    }
    public void setPackageTransport(Package packageTransport) 
    {
        this.packageTransport = packageTransport;
    }
}

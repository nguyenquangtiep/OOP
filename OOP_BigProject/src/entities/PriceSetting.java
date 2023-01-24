package entities;

public class PriceSetting 
{
    private String transportType;

    private String priceSetting;

    public PriceSetting(String transportType, String priceSetting) 
    {
        this.transportType = transportType;
        this.priceSetting = priceSetting;
    }    

    public String getTransportType() 
    {
        return transportType;
    }

    public void setTransportType(String transportType) 
    {
        this.transportType = transportType;
    }

    public String getPriceSetting() 
    {
        return priceSetting;
    }

    public void setPriceSetting(String priceSetting) 
    {
        this.priceSetting = priceSetting;
    }
}

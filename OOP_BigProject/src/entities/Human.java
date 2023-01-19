package entities;

public class Human 
{
    private int id;
    private String name;
    private String phoneNumber;
    private Address address;
    protected enum roles {sender,receiver};
    protected String role;

    public Human(int id, String name, String phoneNumber, Address address) 
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }
    public Address getAddress() 
    {
        return address;
    }
    public void setAddress(Address address) 
    {
        this.address = address;
    }
    public String getRole() 
    {
        return role;
    }
    public void setRole(String role) 
    {
        this.role = role;
    }
}

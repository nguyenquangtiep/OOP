package entities;

import java.util.ArrayList;
import java.util.List;

public class Receiver extends Human
{
    public List<Integer> packageReceive = new ArrayList<>();
    
    public Receiver(int id, String name, String phoneNumber, Address address)
    {
        super(id,name,phoneNumber,address);
        this.role = roles.receiver.toString();
    }
}

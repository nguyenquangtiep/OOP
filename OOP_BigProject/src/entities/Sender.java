package entities;

import java.util.ArrayList;
import java.util.List;

public class Sender extends Human
{
    public List<Integer> packageSend = new ArrayList<>();
    
    public Sender(int id, String name, String phoneNumber, Address address)
    {
        super(id,name,phoneNumber,address);
        this.role = roles.sender.toString();
    }

	public List<Integer> getPackageSend() {
		return packageSend;
	}

	public void setPackageSend(List<Integer> packageSend) {
		this.packageSend = packageSend;
	}
    
    
}

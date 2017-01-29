package phoneservice;

import java.sql.Date;

public class Phone {
	
	private final int phone_ID;
    private final String phoneNumber;
    private final String phoneType;
    private final Date activationDate; 
    private final Date deactivationDate;
    private final int user_ID;
	
    public Phone(int phone_ID,String phoneNumber, String phoneType, Date activationDate, Date deactivationDate,int user_ID) 
    {
        this.phone_ID = phone_ID;
        this.phoneNumber = phoneNumber;
        this.phoneType=phoneType;
        this.activationDate=activationDate;
        this.deactivationDate=deactivationDate;
        this.user_ID=user_ID;
    }

    public int getPhone_Id() {
        return phone_ID;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public Date getActivationDate() {
        return activationDate;
    }
    
    public Date getDeactivationDate() {
        return deactivationDate;
    }
    
    public int getUser_Id() {
        return user_ID;
    }

}

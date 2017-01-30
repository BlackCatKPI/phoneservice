package phoneservice.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PhoneEntity {
	
	@Id
  	@GeneratedValue(strategy = GenerationType.AUTO)
  	private long phone_ID;

	@NotNull
  	@Size(min = 2, max = 80)
    private String phoneNumber;
	
	@NotNull
  	@Size(min = 2, max = 80)
    private String phoneType;
	
	@NotNull
  	private Date activationDate;
	
	@NotNull
    private Date deactivationDate;
 	
    public PhoneEntity(String phoneNumber, String phoneType, Date activationDate, Date deactivationDate) 
    {
        this.phoneNumber = phoneNumber;
        this.phoneType=phoneType;
        this.activationDate=activationDate;
        this.deactivationDate=deactivationDate;
    }

    public long getPhone_Id() 
    {
        return phone_ID;
    }
    
    public void setPhone_Id(long phone_ID) 
    {
    	this.phone_ID = phone_ID;
    }
    
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
    	this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneType() 
    {
        return phoneType;
    }

    public void setPhoneType(String phoneType) 
    {
    	this.phoneType=phoneType;
    }
    
    public Date getActivationDate() 
    {
        return activationDate;
    }
    
    public void setActivationDate(Date activationDate) 
    {
    	this.activationDate=activationDate;
    }
    
    public Date getDeactivationDate() 
    {
        return deactivationDate;
    }
    
    public void setDeactivationDate(Date deactivationDate) 
    {
    	this.deactivationDate=deactivationDate;
    }
}

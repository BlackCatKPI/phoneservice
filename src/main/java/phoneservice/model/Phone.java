package phoneservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
  	@GeneratedValue(strategy = GenerationType.AUTO)
  	private long id;
	
	private String phoneId;

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
 	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;
	
	public Phone(){}
	
	public Phone(String phoneId)
	{
		this.phoneId = phoneId;
	}

	
    public Phone(String phoneNumber, String phoneType, Date activationDate, Date deactivationDate) 
    {
        this.phoneNumber = phoneNumber;
        this.phoneType=phoneType;
        this.activationDate=activationDate;
        this.deactivationDate=deactivationDate;
    }

    public long getId() 
    {
        return id;
    }
    
    public void setPhoneId(String phoneId) 
    {
    	this.phoneId = phoneId;
    }
    
    public String getPhoneId() 
    {
    	return phoneId;
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
    
    public User getUser() 
    {
        return user;
    }
    
    public void setUser(User user) 
    {
    	this.user=user;
    }

}

package phoneservice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.sql.Date;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
  	@GeneratedValue(strategy = GenerationType.AUTO)
  	private long user_ID;
	  
  	@NotNull
  	@Size(min = 2, max = 80)
  	private String firstName;
	  
  	@NotNull
  	@Size(min = 2, max = 80)
  	private String lastName;

  	@NotNull
  	private Date birthDate;
	
  	@NotNull
  	@Size(min = 2, max = 80)
  	private String phoneNumber;
  	
  	public UserEntity(String firstName, String lastName, String phoneNumber) 
  	{
        this.firstName = firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
    }

    public long getId() 
    {
        return user_ID;
    }

    public void setId(long user_ID) 
    {
    	this.user_ID=user_ID;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName=firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName=lastName;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) 
    {
    	this.birthDate=birthDate;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
    	this.phoneNumber=phoneNumber;
    }
    
}
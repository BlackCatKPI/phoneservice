package phoneservice.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	@Id
  	@GeneratedValue(strategy = GenerationType.AUTO)
  	private long id;
	private String userId;
	  
  	@NotNull
  	@Size(min = 2, max = 80)
  	private String firstName;
	  
  	@NotNull
  	@Size(min = 2, max = 80)
  	private String lastName;

 	@NotNull
  	private Date birthDate;
	
 	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL) 
  	private Set<Phone> phones;
  	
 	public User() {}
 	
 	public User(String userId)
 	{ 
 		this.userId=userId;
 	}
 	
 	public User(String firstName, String lastName,Date birthDate) 
  	{
        this.firstName = firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;       
    }
  

    public long getId() 
    {
        return id;
    }

    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
 	{ 
 		this.userId=userId;
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
    
    public Date getBirthDate() 
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) 
    {
        this.birthDate=birthDate;
    }
    
    
    
    public void addPhone(Phone phone)
    {
    	phone.setUser(this);
    	phones.add(phone);
    }
    
    public Set<Phone> getPhones()
    {
    	return phones;
    }
     
}
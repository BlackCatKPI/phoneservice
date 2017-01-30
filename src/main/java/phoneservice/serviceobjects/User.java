package phoneservice.serviceobjects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {

	
	  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
	  
  @NotNull
  private String email;
	  
  @NotNull
  private String name;

	
	
    private final int user_ID;
    private final String firstName;
    private final String lastName;
    private final Date birthDate; 
    
    
    public User(int u_id,String firstName, String lastName, Date birthDate) 
    {
        this.user_ID = u_id;
        this.firstName = firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
    }

    public int getId() {
        return user_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    
}
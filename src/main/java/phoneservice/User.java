package phoneservice;

import java.sql.Date;

public class User {

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
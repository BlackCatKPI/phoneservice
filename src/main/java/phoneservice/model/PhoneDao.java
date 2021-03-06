package phoneservice.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is used to access data for the UserEnity entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exception translation.
 * As setPackagesToScan and transaction manager are configured on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class PhoneDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(Phone phone) {
    entityManager.persist(phone);
    return;
  }
  
  /**
   * Delete the user from the database.
   */
  public void delete(Phone phone) {
    if (entityManager.contains(phone))
      entityManager.remove(phone);
    else
      entityManager.remove(entityManager.merge(phone));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<User> getAll() {
    return entityManager.createQuery("from phone").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public Phone getByPhoneNumber(String phoneNumber) {
    return (Phone) entityManager.createQuery(
        "from phone where phoneNumber = :phoneNumber")
        .setParameter("phoneNumber", phoneNumber)
        .getSingleResult();
  }

  /**
   * Return the user having the passed id.
   */
  public Phone getById(long phone_ID) {
    return entityManager.find(Phone.class, phone_ID);
  }

  /**
   * Update the passed user in the database.
   */
  public void update(Phone phone) {
    entityManager.merge(phone);
    return;
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} 

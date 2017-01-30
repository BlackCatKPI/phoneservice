package phoneservice.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
public class UserDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(UserEntity user) {
    entityManager.persist(user);
    return;
  }
  
  /**
   * Delete the user from the database.
   */
  public void delete(UserEntity user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<UserEntity> getAll() {
    return entityManager.createQuery("from user").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public UserEntity getByPhoneNumber(String phoneNumber) {
    return (UserEntity) entityManager.createQuery(
        "from user where phoneNumber = :phoneNumber")
        .setParameter("phoneNumber", phoneNumber)
        .getSingleResult();
  }

  /**
   * Return the user having the passed id.
   */
  public UserEntity getById(long user_ID) {
    return entityManager.find(UserEntity.class, user_ID);
  }

  /**
   * Update the passed user in the database.
   */
  public void update(UserEntity user) {
    entityManager.merge(user);
    return;
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} // class UserDao

package model.hibernate;
 
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
 
public class HibernateUtil {
    
    private static EntityManagerFactory entityManagerFactory;
     
    public static EntityManagerFactory getSessionFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence");          
        }
         
        return entityManagerFactory;
    }
}
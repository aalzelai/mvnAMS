package domain.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.*;
import hibernate.util.*;

/**
 * Class of DaoUserHibernate.
 * @author PBL5
 *
 */
public class DaoUser extends HibernateUtil {
	
	Session session;

    /**
     * Constructor.
     */
    public DaoUser() {
    	super();
    }

    public Object loadUser(String username, String password){
         session =
        		HibernateUtil.getSessionFactory().openSession();
        Object usuario = null;
        try{
            Query query = session.createQuery("from User where username = :username and password = :password ");
            query.setParameter("username", username);
            query.setParameter("password", password);
            usuario = (User) query.getSingleResult();
            
            switch(((User) usuario).getUserType().getDescription()){
            case "Passenger":
            	query = session.createQuery("from UserPassenger where id_user = :idUser ");
                query.setParameter("idUser", ((User) usuario).getIdUser());
                usuario = (UserPassenger) query.getSingleResult();
            	break;
            	
            case "Airline":
            	query = session.createQuery("from UserAirline where id_user = :idUser ");
                query.setParameter("idUser", ((User) usuario).getIdUser());
                usuario = (UserAirline) query.getSingleResult();
            	break;
            	
            case "Airport_Controller":
            	query = session.createQuery("from UserAirportController where id_user = :idUser ");
                query.setParameter("idUser", ((User) usuario).getIdUser());
                usuario = (UserAirportController) query.getSingleResult();
            	break;
            	
        	default:
        		break;
            
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NoResultException e1){
        	usuario = null;
        }
        return usuario;
    }
    
    public boolean registerPassenger(String username, String password, String telephone, String email){
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		
		try{
			session.beginTransaction();
			String sql = String.format("INSERT INTO user_passenger(username, password, id_user_type, telephone, email) VALUES ('%s', '%s', 1, '%s', '%s') ;", username, password, telephone, email);
			session.createSQLQuery(sql).executeUpdate();//has no effect. Query doesn't execute.
			session.getTransaction().commit();
			result = true;
		} catch(HibernateException e){
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
    	return result;
    }
    
    public boolean registerAirlineUser(String username, String password, int idAirline){
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		
		try{
			session.beginTransaction();
			String sql = String.format("INSERT INTO user_airline(username, password, id_user_type, id_airline) VALUES ('%s', '%s', 2, %s) ;", username, password, idAirline);
			session.createSQLQuery(sql).executeUpdate();//has no effect. Query doesn't execute.
			session.getTransaction().commit();
			result = true;
		} catch(HibernateException e){
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
    	return result;    	
    }
    
    public boolean registerAirportController(String username, String password, int idAirport){
		session = HibernateUtil.getSessionFactory().openSession();
		boolean result = false;
		
		try{
			session.beginTransaction();
			String sql = String.format("INSERT INTO user_airport_controller(username, password, id_user_type, id_airport) VALUES ('%s', '%s', 3, %s) ;", username, password, idAirport);
			session.createSQLQuery(sql).executeUpdate();//has no effect. Query doesn't execute.
			session.getTransaction().commit();
			result = true;
		} catch(HibernateException e){
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
    	return result;    	
    }
    

    /*
     // For adding items in the Items table.
     public ItemMaster add(ItemMaster item) {
        Session session = HibernateUtil.
                          createSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        return item;
    }

    // For deleting item from Items table.

    public ItemMaster delete(Long id) {
        Session session = HibernateUtil.
                          createSessionFactory().getCurrentSession();
        session.beginTransaction();
        ItemMaster item = (ItemMaster) session.
                          load(ItemMaster.class, id);
        if (null != item) {
            session.delete(item);
        }
        session.getTransaction().commit();
        return item;
    }
    // For generating , executing hibernate
     * select query and returns items as a
    // list.
*/

}
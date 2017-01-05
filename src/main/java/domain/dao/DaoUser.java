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

    /**
     * Constructor.
     */
    public DaoUser() {
    	super();
    }

    public User loadUser(String username, String password){
        Session session =
        		HibernateUtil.getSessionFactory().openSession();
        User usuario = null;
        try{
            Query query = session.createQuery("from User where username = :username and password = :password ");
            query.setParameter("username", username);
            query.setParameter("password", password);
            usuario = (User) query.getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NoResultException e1){
        	usuario = null;
        }
        return usuario;
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
    /**
     * Function to load the list of the users.
     * @return the list of the users.
     */
    public List<User> loadUserList() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> items = null;
        System.out.println("LLEGA 4");

        try {
            items = (List<User>) session.
                    createQuery("from User ").getResultList();
            System.out.println("LLEGA 5");

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return items;
    }
}
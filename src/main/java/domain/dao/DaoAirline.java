package domain.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.Airline;
import hibernate.util.HibernateUtil;

/**
 * The Class DaoAirline.
 */
public class DaoAirline {
	
	/**
	 * Instantiates a new dao airline.
	 */
	public DaoAirline() {
		
	}
	
	/**
	 * Load airlines.
	 *
	 * @return the list
	 */
	public List<Airline> loadAirlines() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Airline> items = null;

        try {
            items = (List<Airline>) session.
                                   createQuery("from Airline ").getResultList();

        } catch (HibernateException e) {
        	java.util.logging.Logger.getLogger("Test").log(null, "Hibernate error", e);
            session.getTransaction().rollback();
        }
        session.close();
        return items;
    }

}

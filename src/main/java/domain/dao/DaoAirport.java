package domain.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.Airport;
import hibernate.util.HibernateUtil;

/**
 * The Class DaoAirport.
 */
public class DaoAirport {
	
	/**
	 * Instantiates a new dao airport.
	 */
	public DaoAirport(){
		
	}

	/**
	 * Load airports.
	 *
	 * @return the list
	 */
	public List<Airport> loadAirports() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Airport> items = null;

        try {
            items = (List<Airport>) session.
                                   createQuery("from Airport ").getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return items;
    }
}

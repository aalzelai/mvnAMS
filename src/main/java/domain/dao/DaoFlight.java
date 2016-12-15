package domain.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.*;
import hibernate.util.HibernateUtil;

/**
 * Class DaoFlight.
 * @author PBL5
 *
 */
public class DaoFlight {

    /**
     * Constructor.
     */
    public DaoFlight() {

    }

    /**
     * Function to load the list of the flights.
     * @return the list of the flights.
     */
    @SuppressWarnings("unchecked")
    public List<Flight> loadFlights() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Flight> items = null;

        try {
            items = (List<Flight>) session.
                                   createQuery("from Flight ").getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return items;
    }

}

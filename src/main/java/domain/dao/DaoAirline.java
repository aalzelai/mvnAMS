package domain.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.Airline;
import hibernate.util.HibernateUtil;

public class DaoAirline {
	
	public DaoAirline() {
		
	}
	
	public List<Airline> loadAirlines() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Airline> items = null;

        try {
            items = (List<Airline>) session.
                                   createQuery("from Airline ").getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return items;
    }

}
package domain.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import domain.model.*;
import hibernate.util.HibernateUtil;

public class DaoFlight {
	
	public DaoFlight(){
		
	}
	
	public List<Flight> loadFlights() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Flight> items = null;

		try {
			items = (List<Flight>) session.createQuery("from Flight ").getResultList();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return items;
	}

}

/**
 * @author Gopikrishna Putti - May 1, 2017
 * Developed by Gopi for personal use.
 * this class provides persistence to objects created. 
 * 
 */
package com.yaams.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.yaams.dataobj.Contact;

public class PersistenceService {

	private static final String PU_NAME = "derby";
	private static EntityManagerFactory factory = null;

	public static PersistenceService service = new PersistenceService();

	public EntityManager entityManager = null;


	private PersistenceService() {
		factory = Persistence.createEntityManagerFactory(PU_NAME);			
	}

	public static PersistenceService get() {
		return service;
	}
	
	public void persist(Object obj) {
		if(obj == null ) return ;
		
		if(entityManager == null) {
			entityManager = factory.createEntityManager();			
		}		
		entityManager.persist(obj);
	}
	
	public void close() {
		if(entityManager != null && entityManager.isOpen() ) {
			entityManager.clear();
			entityManager.close();
		}
		if(factory != null && factory.isOpen() ) {
			factory.close();
		}
		entityManager = null;
		factory = null;
	}
	
	public static void main( String[] args ) throws Exception    {    	
		
		
//		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        java.sql.Connection  conn = java.sql.DriverManager.getConnection("jdbc:derby:.\\BD\\nombrebasededatos.db");
        
		Contact con = Contact.create("gopi@gg.com");
		PersistenceService ps = new PersistenceService();		
		ps.persist(con);
		ps.close();
				
	}

}

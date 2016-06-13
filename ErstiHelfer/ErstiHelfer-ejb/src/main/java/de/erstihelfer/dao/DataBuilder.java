package de.erstihelfer.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.erstihelfer.entities.User;

/**
 * Session Bean implementation class DataBuilder
 */
@Singleton
@Startup
public class DataBuilder {

	private static final Logger logger = Logger.getLogger(DataBuilder.class);

	@PersistenceContext
	EntityManager em;

	@EJB
	ErstiHelferDAOLocal dao;

	@Resource
	private String username1;
	private int groupNr1;

	
	/**
	 * //erzeugt ein paar Beispieldaten zu User, falls sie noch nicht in der DB vorhanden sind.
	 */
	 @PostConstruct
	private void createTestData() {
		User user1 = dao.findUserByName(username1);
		// User user1=null;
		if (user1 == null) {
			user1 = new User(username1, groupNr1);
			em.persist(user1);
			logger.info("Neu angelegt:" + user1);
		}
	}

}

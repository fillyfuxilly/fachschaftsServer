package de.erstihelfer.dao;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.erstihelfer.entities.Appointment;
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
	@Resource
	private Integer groupNr1;
	@Resource
	private String title1;
	@Resource
	private String description1;
	@Resource
	private String location1;

	
	/**
	 * erzeugt ein paar Beispieldaten, falls sie noch nicht in der DB vorhanden sind.
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
		
		Appointment app = dao.findAppointmentByTitle(title1);
		if(app == null) {
			app = new Appointment(title1,location1,new Date(),location1);
			app.getUsers().add(user1);
			em.persist(app);
			logger.info("Neu angelegt:" + app);
		}
	}

}

package de.erstihelfer.erstihelfer;


import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


import de.erstihelfer.entities.User;
import de.erstihelfer.dao.*;

@RunWith(Arquillian.class)
public class DAOTest {
	
	@EJB
	ErstiHelferOnlineIntegration bean;
	@EJB
	ErstiHelferDAOLocal dao;
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/erstihelfer")
               .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")               
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
	}
	
	
	
	/**
	 * Testet ob ein User sich einloggt hat
	 */
	
	@Test
	public void testFindByName() throws Exception {
		User joe = dao.findUserByName("joe");
		assert joe!=null : "Joe nicht gefunden.";
		assert joe.getGroupNr()==1 : "GroupNr ist falsch.";
	}
	
	/**
	 * Testet, ob Sessions unterschiedliche IDs bekommen.
	 */
	@Test
	public void testSession() throws Exception {
		User joe = dao.findUserByName("joe");
		int session1 = dao.createSession(joe);
		int session2 = dao.createSession(joe);
		assert session1 != session2 : "Session-IDs nicht unterschiedlich!";
	}


}
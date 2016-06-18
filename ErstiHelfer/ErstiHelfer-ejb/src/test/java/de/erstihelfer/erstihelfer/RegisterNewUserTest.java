package de.erstihelfer.erstihelfer;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.erstihelfer.dao.ErstiHelferDAOLocal;
import de.erstihelfer.dto.UserLoginResponse;
import de.erstihelfer.entities.User;
import de.erstihelfer.erstihelfer.*;

/**
 * 
 * @author Amayda Dominguez
 * @author Malte Evers
 *
 */
@RunWith(Arquillian.class)
public class RegisterNewUserTest {

	@EJB
	ErstiHelferOnlineIntegration bean;
	@EJB
	ErstiHelferDAOLocal dao;

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackages(true, "de/erstihelfer")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
	}

	@Test
	/**
	 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
	 */
	public void testRegistration() throws Exception {
		UserLoginResponse loginResponse = bean.registerNewUser("Pepe", 4);
		assertEquals(loginResponse.getReturnCode(), 0);
		int sessionId = loginResponse.getSessionId();
		bean.logout(sessionId);
	}

	@Test // (expected=ErstiHelferException.class)
	/**
	 * Prueft, ob zwei User mit gleichem Namen registriert werden können
	 */
	public void testRegistrationCollision() throws Exception {
		bean.registerNewUser("Hans", 4);
		UserLoginResponse loginResponse2 = bean.registerNewUser("Hans", 5);
		assertEquals("Returncode sollte 30 sein, wenn username bereits vorhanden", loginResponse2.getReturnCode(), 30);
	}
}

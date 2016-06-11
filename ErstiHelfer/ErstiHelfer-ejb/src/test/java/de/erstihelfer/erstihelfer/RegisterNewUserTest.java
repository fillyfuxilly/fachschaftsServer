package de.erstihelfer.erstihelfer;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.erstihelfer.dto.UserLoginResponse;
@RunWith(Arquillian.class)
public class RegisterNewUserTest {

	
	@EJB
	ErstiHelferOnlineIntegration bean;
	@Deployment
    public static WebArchive createDeployment() {
    	return ShrinkWrap.create(WebArchive.class, "test.war")
               .addPackages(true,"de/erstihelfer")
               .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")               
               .addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
	}
	
	@Test
	/**
	 * Prueft, ob ein neuer Kunde erfolgreich registriert werden kann.
	 */
	public void testRegistration() throws Exception {
	    UserLoginResponse loginResponse = bean.registerNewUser("amayda", 1);
	    assertEquals(loginResponse.getReturnCode(), 0);
	 	
	    int sessionId = loginResponse.getSessionId();
		bean.logout(sessionId);
	}

}

package de.erstihelfer.erstihelfer;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.erstihelfer.dao.ErstiHelferDAOLocal;
import de.erstihelfer.entities.*;

/**
 * @author Malte Evers
 */
@RunWith(Arquillian.class)
public class AppointmentTest {

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


	private Integer groupNr1;
	private String title1;
	private String description1;
	private String location1;

	private Integer groupNr2;
	private String title2;
	private String description2;
	private String location2;

	
	/**
	 * Diese Testdaten müssen mit den Testdaten aus der ejb-jar.xml übereinstimmen.
	 */
	@Before
	public void setUp(){
		// für testGetAppointments()
		this.groupNr1 = 1;
		this.title1 = "Test-Title";
		this.description1 = "Dieser Termin ist zum Testen da";
		this.location1 = "Testumgebung";
		// für testCreateAppointments()
		this.groupNr2 = 8;
		this.title2 = "Test-Title2";
		this.description2 = "Dieser Termin ist auch zum Testen da";
		this.location2 = "Testumgebung";
		
	}
	
	@Test
	/**
	 * Prueft, ob ein Termin gefunden werden kann.
	 */
	public void testGetAppointments() throws Exception {
		dao.createAppointment(new Appointment(title1, location1, new Date(), description1));
		List<Appointment> apps = bean.getAppointments(50, groupNr1);
		if(apps.size() < 1) {
		boolean found = false;
		for (Appointment appointment : apps) {
			if(appointment.getTitel().equals(title1) && appointment.getLocation().equals(description1));
				found = true;
		}
		assert found : "Der Testtermin konnte mit getAppointments nicht gefunden werden.";
		}else { fail("Kein Termin vorhanden");}
		
	}

	@Test
	/**
	 * Prueft, ob ein Termin gefunden werden kann.
	 */
	public void testCreateAppointment() throws Exception {
		Date startTermin = new Date();
		bean.createAppointment(title2, location2, startTermin, description2, groupNr2);
		Appointment app = dao.findAppointmentByTitle(title2);
		assertEquals( "Der Titel wurde nicht richtig erstellt", app.getTitel(), title2);
		assertEquals("Der Ort wurde nicht richtig erstellt", app.getLocation(), location2);
		assertEquals("Die Beschreibung wurde nicht richtig erstellt", app.getDescription(), description2);
		assertTrue("Der Zeitpunkt wurde nicht richtig erstellt", app.getCreateAt().getTime() - startTermin.getTime() < 5);
	}
}

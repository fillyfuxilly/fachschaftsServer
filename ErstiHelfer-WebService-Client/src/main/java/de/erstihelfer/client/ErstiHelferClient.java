package de.erstihelfer.client;

import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import de.erstihelfer.erstihelfer.ErstiHelferOnlineIntegration;
import de.erstihelfer.erstihelfer.ErstiHelferOnlineIntegrationService;
import de.erstihelfer.erstihelfer.*;

/**
 * 
 * @author Malte Evers
 */
public class ErstiHelferClient {

	private static ErstiHelferOnlineIntegration remoteSystem;

	/**
	 * In dieser Main-Methode werden Requests an den Server abgeschickt.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ErstiHelferOnlineIntegrationService service = new ErstiHelferOnlineIntegrationService();
			remoteSystem = service.getErstiHelferOnlineIntegrationPort();

			System.out.println("Client hat folgendes Server-Objekt erhalten:");
			System.out.println("remoteSystem.toString(): \n" + remoteSystem.toString());
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		// test_LoginRegister();
		try {
			test_CreateAndGetAppointments();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test-Szenario: Es wird registriert und eingeloggt
	 */
	@SuppressWarnings("unused")
	private static void test_LoginRegister() {
		String username = "Malte";
		// String password = "12345";
		int groupNr = 1;
		System.out.println("============================================================");
		UserLoginResponse registerResponse = remoteSystem.registerNewUser(username, groupNr);
		// ReturnCodeResponse CODE_OK
		if (registerResponse.getReturnCode() == 0) {
			int sessionId = registerResponse.getSessionId();
			System.out.println("Registrierung von " + username + " in der Gruppe " + groupNr + " erfolgreich.");

			remoteSystem.logout(sessionId);
		} else {
			System.out.println(registerResponse.getMessage());
		}
	}

	private static void test_CreateAndGetAppointments() throws DatatypeConfigurationException {
		// erzeuge Datum als XMLGregorianCalendar
		GregorianCalendar startTime = new GregorianCalendar(2015, 9, 1, 12, 0);
		XMLGregorianCalendar xmlCal;
		xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(startTime);
		// Erstelle Test-Termin
		remoteSystem.createAppointment("Schlacht um Helms Klamm", "Helms Klamm", xmlCal,
				"Orks gegen Menschen. Seid pünktlich!(ErstiHelftClient.main)", 1);
		// Hole Termine
		List<Appointment> apps = remoteSystem.getAppointments(xmlCal, 5, 1);
		// print Ergebnis
		System.out.println("size: " + apps.size());
		String listString = "Folgende Termine passen zu Gruppe 1\n";
		for (Appointment s : apps) {
			listString += s.getTitel() + "\n";
		}
		System.out.println(listString);
	}

}

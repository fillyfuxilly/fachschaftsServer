package de.erstihelfer.erstihelfer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.erstihelfer.dao.ErstiHelferDAOLocal;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.util.DtoAssembler;
import de.erstihelfer.dto.UserLoginResponse;
import de.erstihelfer.entities.User;
import de.erstihelfer.erstihelfer.erstiHelferException;




/**
 * @author Amayda Dominguez
 *  
 * Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */

@Stateless 
@WebService
@WebContext(contextRoot="/erstihelfer")


public class ErstiHelferOnlineIntegration {
	
	private static final Logger logger = Logger.getLogger(ErstiHelferOnlineIntegration.class);
	/**
	 * EJB für den Datenzugriff
	 */
	
	@EJB
	private ErstiHelferDAOLocal dao;
	
	/**
	 * EJB zur Erzeugung von DataTranferObjects
	 */
	@EJB
	private DtoAssembler dtoAssembler;
	
	@EJB
	private OutputRequesterBean outputRequester;
	
	/**
	 * Holt anhand der Session-ID das zugehörige Session-Objekt.
	 * @param sessionId
	 * @return
	 * @throws NoSessionException
	 */
	private ErstiHelferSession getSession(int sessionId) throws NoSessionException{
		ErstiHelferSession session = dao.findSessionById(sessionId);
		if (session==null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}
	
	public UserLoginResponse login(String username, String password) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = this.dao.findUserByName(username);		
			if (user != null ) {
				int sessionId = dao.createSession(user);
				response.setSessionId(sessionId);
				response.setUser(this.dtoAssembler.makeDTO(user));
				logger.info("Login erfolgreich.");				
			}
			else {
				logger.info("Login fehlgeschlagen, da Username unbekannt. username=" + username);
				throw new InvalidLoginException("Login fehlgeschlagen, da User unbekannt. username="+username);
			}
		}
		catch (erstiHelferException e) {
			//Eine Exception wird dem Webservice-Client über einen Errorcode mitgeteilt:
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	
}

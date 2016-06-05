package de.erstihelfer.erstihelfer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.erstihelfer.dao.ErstiHelferDAOLocal;
import de.erstihelfer.entities.ErstiHelferSession;
import de.erstihelfer.util.DtoAssembler;




/**
 * @author Amayda Dominguez
 *  
 * Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */

@Stateless 

@WebService
@WebContext(contextRoot="/erstihelfer")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ErtiHelferOnlineIntegration {
	private static final Logger logger = Logger.getLogger(ErtiHelferOnlineIntegration.class);
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
}

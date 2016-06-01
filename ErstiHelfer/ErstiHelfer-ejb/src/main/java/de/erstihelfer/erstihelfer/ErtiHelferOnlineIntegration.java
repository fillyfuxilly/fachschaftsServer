package de.erstihelfer.erstihelfer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import de.erstihelfer.dao.ErstiHelferDAOLocal;
import de.erstihelfer.util.DtoAssembler;

/**
 * @author Amayda Dominguez
 *  
 * Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */

@Stateless 

@WebService

public class ErtiHelferOnlineIntegration {

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
}

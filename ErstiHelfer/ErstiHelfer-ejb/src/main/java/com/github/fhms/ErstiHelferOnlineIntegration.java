package com.github.fhms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.github.fhm.dao.ErstiHelferDAOLocal;
import com.github.fhm.interfaces.FachschaftService;
import com.github.fhm.util.DtoAssembler;

/**
 * @author Amayda Dominguez
 * @author Malte Evers
 * 
 *         Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */
@Stateless

@WebService

public class ErstiHelferOnlineIntegration {

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
	private OutPutRequesterBean outputRequester;
}
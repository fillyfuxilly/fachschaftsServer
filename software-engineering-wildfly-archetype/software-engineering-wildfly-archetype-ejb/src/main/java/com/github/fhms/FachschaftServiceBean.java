package com.github.fhms;




import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.github.fhm.dao.FachschaftDAOLocal;
import com.github.fhm.interfaces.FachschaftService;
import com.github.fhm.util.DtoAssembler;




/**
 * @author Amayda Dominguez
 *  
 * Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */
@Stateless 

@WebService


public class FachschaftServiceBean implements FachschaftService {

	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return "My Name ist"+ name+".";
	}

	/**
	 * EJB für den Datenzugriff
	 */
	
	@EJB
	private FachschaftDAOLocal dao;
	/**
	 * EJB zur Erzeugung von DataTranferObjects
	 */
	@EJB
	private DtoAssembler dtoAssembler;
  
}
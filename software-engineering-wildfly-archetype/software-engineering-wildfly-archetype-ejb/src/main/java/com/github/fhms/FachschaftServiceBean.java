package com.github.fhms;




import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


import com.github.fhm.interfaces.FachschaftService;
import com.github.fhm.util.DtoAssembler;




/**
 * @author Amayda Dominguez
 * 
 * 
 * Session Beans als Web Service veröffentlicht(Annotation @WebService)
 */
@Stateless 


@WebService


public class FachschaftServiceBean implements FachschaftService {

	
	//Implementierung von Methoden der FachschaftService, Aufruf und implementierung der Methoden
	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return "My Name ist"+ name+".";
	}

	/**
	 * 
	 */
	@EJB
	private DtoAssembler dtoAssembler;
  
}
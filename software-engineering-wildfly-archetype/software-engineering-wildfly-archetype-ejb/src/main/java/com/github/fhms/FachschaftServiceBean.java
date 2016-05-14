package com.github.fhms;



import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.github.fhm.interfaces.FachschaftService;



/**
 * @author Amayda Dominguez
 * Session Bean implementation class FachschaftServiceBean
 */
@Stateless
@WebService
@Local(FachschaftService.class)
public class FachschaftServiceBean implements FachschaftService {

	
	//Implementierung von Methoden der FachschaftService, Aufruf und implementierung der Methoden
	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return "My Name ist"+ name+".";
	}

  
}
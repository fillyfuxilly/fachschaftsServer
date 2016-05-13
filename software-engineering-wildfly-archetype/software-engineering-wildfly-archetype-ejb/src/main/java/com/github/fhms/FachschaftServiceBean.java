package com.github.fhms;



import javax.ejb.Local;
import javax.ejb.Stateless;

import com.github.fhm.interfaces.FachschaftService;



/**
 * @author Amayda Dominguez
 * Session Bean implementation class FachschaftServiceBean
 */
@Stateless
@Local(FachschaftService.class)
public class FachschaftServiceBean implements FachschaftService {

	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return "My Name ist"+ name+".";
	}

  
}
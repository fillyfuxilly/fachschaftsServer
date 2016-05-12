package com.github.fhms;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;


/**
 * @author Amayda Dominguez
 * Session Bean implementation class FachschaftServiceBean
 */
@Stateless
@Local(FachschaftService.class)
public class FachschaftServiceBean {

    /**
     * Default constructor. 
     */
    public FachschaftServiceBean() {
        // TODO Auto-generated constructor stub
    }

}

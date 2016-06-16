package de.erstihelfer.dao;

import javax.ejb.ApplicationException;

import de.erstihelfer.erstihelfer.ErstiHelferException;

@ApplicationException(rollback=false) 
public class SomeProblemOccuredException extends ErstiHelferException{
	private static final long serialVersionUID = 1L;

	public SomeProblemOccuredException(int errorCode, String message) {
		super(errorCode, message);
	}
}

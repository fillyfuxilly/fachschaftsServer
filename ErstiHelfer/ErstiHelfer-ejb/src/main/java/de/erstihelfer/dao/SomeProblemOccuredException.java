package de.erstihelfer.dao;

import javax.ejb.ApplicationException;

import de.erstihelfer.erstihelfer.erstiHelferException;

@ApplicationException(rollback=false) 
public class SomeProblemOccuredException extends erstiHelferException{
	private static final long serialVersionUID = 1L;

	public SomeProblemOccuredException(int errorCode, String message) {
		super(errorCode, message);
	}
}

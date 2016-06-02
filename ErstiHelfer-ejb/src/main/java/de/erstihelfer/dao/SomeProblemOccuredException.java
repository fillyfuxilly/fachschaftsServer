package de.erstihelfer.dao;

import de.erstihelfer.erstihelfer.erstiHelferException;

public class SomeProblemOccuredException extends erstiHelferException {
	private static final long serialVersionUID = 1L;

	public SomeProblemOccuredException(int errorCode, String message) {
		super(errorCode, message);
	}
}

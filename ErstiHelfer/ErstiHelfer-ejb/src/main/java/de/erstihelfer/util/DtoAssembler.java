package de.erstihelfer.util;

import javax.ejb.Stateless;

import de.erstihelfer.dto.UserTO;
import de.erstihelfer.entities.User;
/**
 * 
 * @author Amayda Dominguez
 * Klasse DTO Assembler für die Übersetzung zwischen DTOs und Entities
 *
 */
@Stateless
public class DtoAssembler {

	public UserTO makeDTO(User user){
		UserTO dto= new UserTO();
		dto.setUsername(user.getUsername());
		return dto;
	}

}

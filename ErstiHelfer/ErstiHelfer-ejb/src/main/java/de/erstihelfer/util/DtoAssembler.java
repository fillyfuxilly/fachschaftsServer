package de.erstihelfer.util;

import javax.ejb.Stateless;

import de.erstihelfer.dto.UserTO;
import de.erstihelfer.entities.User;
/**
 * 
 * @author Amayda Dominguez
 * Klasse DTO Assembler für die Übersetzung zwischen DTOs und Entities
 * Der Assembler ist dafür zuständig, DTOs aus Modellobjekten  zu  erstellen  bzw.  bestehende  Modellobjekte anhand der DTO-Daten zu verändern
 * 
 * Diese stateless session bean stellt Operationen für Generierung der data transfer objects 
 * 
 *
 */
@Stateless
public class DtoAssembler {

	public UserTO makeDTO(User user){
		UserTO dto= new UserTO();
		dto.setUsername(user.getUsername());
		dto.setGroupNr(user.getGroupNr());
		return dto;
	}

}

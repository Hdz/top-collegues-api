package dev.topcolleguesapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.topcolleguesapi.dto.ParticipantDTO;
import dev.topcolleguesapi.dto.Vote;
import dev.topcolleguesapi.exception.BadRequestException;
import dev.topcolleguesapi.service.ParticipantService;

/**
 * Controlleur gérant les requêtes HTTP vers l'extérieur de l'API
 * 
 * @author Nicolas
 *
 */
@RestController
@RequestMapping("/top-collegues")
public class TopCollegueController {

	@Autowired
	ParticipantService service;
	
	/**
	 * Récupère les infos des collègues participants
	 * 
	 * @return List<ParticipantDTO>
	 */
	@GetMapping
	@Secured("ROLE_USER")
    public List<ParticipantDTO> findAllParticipant() {

        return service.findAllParticipants();
    }
	
	/**
	 * Récupère un vote et retourne la liste des participants
	 * avec le classement mis à jour
	 * 
	 * @param vote
	 * @return
	 */
	@PostMapping
	@Secured("ROLE_USER")
    public ResponseEntity<List<ParticipantDTO>> vote(@RequestBody @Valid Vote vote, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			throw new BadRequestException();
		}

		List<ParticipantDTO> listesAJour = service.voteForParticipant(vote);
        
        return ResponseEntity.status(HttpStatus.OK).body(listesAJour);
    }
	
}
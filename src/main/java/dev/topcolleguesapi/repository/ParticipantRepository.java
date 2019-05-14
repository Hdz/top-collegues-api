package dev.topcolleguesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.topcolleguesapi.entite.Participant;

/**
 *  
 * 
 * CRUD relatif aux participants
 *
 */
public interface ParticipantRepository extends JpaRepository<Participant, String> {

	@Query("select p from Participant p order by p.score desc")
	public Optional<Participant> findAllOrderByScore();
	
}
package dev.topcolleguesapi.entite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "participants")
public class Participant {

	@Id
	@Email
	@Size(min = 3)
	@NotEmpty(message = "L'email ne peut pas être null ou vide.")
	private String email;
	
	@Size(min = 3)
	@NotEmpty(message = "Le nom ne peut pas être vide ou null")
	private String nom;
	
	@Size(min = 3)
	@NotEmpty(message = "Le prénom ne peut pas être vide ou null")
	private String prenoms;

	private String photoUrl;
	
	private Integer score = 0;
	
	public Participant(){
		/**
		 * Constructeur par défaut
		 */
	}

	public Participant(String email, String nom, String prenoms, String photoUrl){
		this.email = email;
		this.nom = nom;
		this.prenoms = prenoms;
		this.photoUrl = photoUrl;
}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}

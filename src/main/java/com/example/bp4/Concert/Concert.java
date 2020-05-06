package com.example.bp4.Concert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="concerten")
public class Concert {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer concert_id;
	
	@Column(name = "concert_naam", nullable = false, unique = false)
    private String concert_naam;
	@Column(name = "genre", nullable = false, unique = false)
    private String genre;
	@Column(name = "artiest", nullable = false, unique = false)
    private String artiest;
	
    public Concert(String concert_naam, String genre, String artiest) {
    	this.concert_naam = concert_naam;
    	this.genre = genre;
    	this.artiest = artiest;
    }
    
    public Concert() {
    	
    }

	public Integer getConcert_id() {
		return concert_id;
	}

	public void setConcert_id(Integer concert_id) {
		this.concert_id = concert_id;
	}

	public String getConcert_naam() {
		return concert_naam;
	}

	public void setConcert_naam(String concert_naam) {
		this.concert_naam = concert_naam;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtiest() {
		return artiest;
	}

	public void setArtiest(String artiest) {
		this.artiest = artiest;
	}      

}

package com.example.bp4.Theaterzaal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theaterzalen")
public class Theaterzaal {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theaterzaalID;
    private Integer theaterID;
    private Integer zitplaatsen;
    
    @Column(name = "zaalnaam", nullable = false, unique = false)
    private String zaalnaam;
    
    public Theaterzaal(Integer theaterID, String zaalnaam, Integer zitplaatsen) {
    	this.theaterID = theaterID;
    	this.zaalnaam = zaalnaam;
    	this.zitplaatsen = zitplaatsen;
    }
    
    public Theaterzaal() {
    	
    }

	public Integer getTheaterzaalID() {
		return theaterzaalID;
	}

	public void setTheaterzaalID(Integer theaterzaalID) {
		this.theaterzaalID = theaterzaalID;
	}

	public Integer getTheaterID() {
		return theaterID;
	}

	public void setTheaterID(Integer theaterID) {
		this.theaterID = theaterID;
	}

	public Integer getZitplaatsen() {
		return zitplaatsen;
	}

	public void setZitplaatsen(Integer zitplaatsen) {
		this.zitplaatsen = zitplaatsen;
	}

	public String getZaalnaam() {
		return zaalnaam;
	}

	public void setZaalnaam(String zaalnaam) {
		this.zaalnaam = zaalnaam;
	}
	
}

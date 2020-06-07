package com.example.bp4.Concert;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

//Geeft aan dat de class Concert een entiteit is
@Entity
//Hier geef je aan welke class de ID/PK class
@IdClass(ConcertPK.class)
//Naam van de tabel in de database
@Table(name="concerten")
public class Concert extends Voorstelling {
	
	//Variabelen declareren
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer concert_id;
	
	public Integer voorstelling_id;
	
	@Column(name = "concert_naam", nullable = true, unique = false)
    public String concert_naam;
	@Column(name = "genre", nullable = true, unique = false)
    public String genre;
	@Column(name = "artiest", nullable = true, unique = false)
    public String artiest;
	
	//Constructor voor een voorstelling in te plannen
    public Concert(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, Integer concert_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, concert_id);

        this.concert_id = concert_id;
	}
    
    //Constructor voor het toevoegen van concert
    public Concert(String concert_naam, String genre, String artiest, Integer voorstelling_id) {
		this.concert_naam = concert_naam;
		this.genre = genre;
		this.artiest = artiest;
		this.voorstelling_id = voorstelling_id;
	}
    
    public Concert() {
    	
    }
    
    //Getters & Setters van Concert
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

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public Integer getVoorstelling_id() {
		return voorstelling_id;
	}

	public void setVoorstelling_id(Integer voorstelling_id) {
		this.voorstelling_id = voorstelling_id;
	}

}

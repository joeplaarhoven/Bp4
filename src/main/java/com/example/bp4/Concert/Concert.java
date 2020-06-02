package com.example.bp4.Concert;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

@Entity
@Table(name="concerten")
@IdClass(ConcertPK.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Concert extends Voorstelling {
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

    public Concert(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, Integer concert_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, concert_id);

        this.concert_id = concert_id;
	}
    
    public Concert(Integer concert_id, String concert_naam, String genre, String artiest) {
    	this.concert_id = concert_id;
		this.concert_naam = concert_naam;
		this.genre = genre;
		this.artiest = artiest;
	}
    
    public Concert(String concert_naam, String genre, String artiest, Integer voorstelling_id) {
		this.concert_naam = concert_naam;
		this.genre = genre;
		this.artiest = artiest;
		this.voorstelling_id = voorstelling_id;
	}
    
//    public Concert(Integer theaterID, 
//    		String voorstellingSoort, 
//    		String theaterzaal, 
//    		String leeftijdsCat, 
//    		String afkomst, 
//    		String datum, 
//    		String tijd, 
//    		Integer concert_id) {
//        this.v_theaterzaal_id = theaterID;
//        this.voorstellingsoort = voorstellingSoort;
//        this.v_leeftijdscategorie = leeftijdsCat;
//        this.afkomst = afkomst;
//        this.datum = datum;
//        this.tijd = tijd;
//        this.concert_id = concert_id;
//    }
    
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

package com.example.bp4.Concert;

import com.example.bp4.Caberetier.CaberetierPK;
import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="concerten")
@IdClass(ConcertPK.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Concert extends Voorstelling {

	private Integer concert_id;
    private String concert;
    private String artiest, genre;


    public Concert(Integer theaterID, 
    		String voorstellingSoort, 
    		String theaterzaal, 
    		String leeftijdsCat, 
    		String afkomst, 
    		String datum, 
    		String tijd, 
    		Integer concert_id) {
        this.v_theaterzaal_id = theaterID;
        this.voorstellingsoort = voorstellingSoort;
        this.v_leeftijdscategorie = leeftijdsCat;
        this.afkomst = afkomst;
        this.datum = datum;
        this.tijd = tijd;
        this.concert_id = concert_id;
    }


    public Integer getConcert_id() {
        return concert_id;
    }

    public void setConcert_id(Integer concert_id) {
        this.concert_id = concert_id;
    }

    public String getConcert() {
        return concert;
    }

    public void setConcert(String concert) {
        this.concert = concert;
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

}

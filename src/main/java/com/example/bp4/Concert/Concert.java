package com.example.bp4.Concert;

import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="concerten")
public class Concert extends Voorstelling {

    private Integer concertId;
    private String concert;
    private String artiest, genre;

    public Concert(){}

    public Concert(Integer theaterID, String voorstellingSoort, String theaterzaal, String leeftijdsCat, String concert, String artiest,String genre) {
        this.theaterID = theaterID;
        this.voorstellingSoort = voorstellingSoort;
        this.theaterzaal = theaterzaal;
        this.leeftijdsCat = leeftijdsCat;
        this.concert = concert;
        this.artiest = artiest;
        this.genre = genre;
    }


    public Integer getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertID) {
        this.concertId = concertID;
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

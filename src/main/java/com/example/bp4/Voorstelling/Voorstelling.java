package com.example.bp4.Voorstelling;

import com.example.bp4.Caberetier.Caberetier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@MappedSuperclass
@Table(name="voorstellingen")
public class Voorstelling {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer voorstellingID;

    public Integer theaterID;
    public String voorstellingSoort;
    public String theaterzaal;
    public String leeftijdsCat;

    public Integer getVoorstellingID() {
        return voorstellingID;
    }

    public void setVoorstellingID(Integer voorstellingID) {
        this.voorstellingID = voorstellingID;
    }

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }


    public String getVoorstellingSoort() {
        return voorstellingSoort;
    }

    public void setVoorstellingSoort(String voorstellingSoort) {
        this.voorstellingSoort = voorstellingSoort;
    }

    public String getTheaterzaal() {
        return theaterzaal;
    }

    public void setTheaterzaal(String theaterzaal) {
        this.theaterzaal = theaterzaal;
    }

    public String getLeeftijdsCat() {
        return leeftijdsCat;
    }

    public void setLeeftijdsCat(String leeftijdsCat) {
        this.leeftijdsCat = leeftijdsCat;
    }

    public String getAfkomst() {
        return afkomst;
    }

    public void setAfkomst(String afkomst) {
        this.afkomst = afkomst;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getTijd() {
        return tijd;
    }

    public void setTijd(Time tijd) {
        this.tijd = tijd;
    }

    private String afkomst;
    private Date datum;
    private Time tijd;
}

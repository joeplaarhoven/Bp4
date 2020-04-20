package com.example.bp4.Voorstelling;

import java.sql.Time;
import java.util.Date;

public class Voorstelling {

    private Integer voorstellingID, theaterID, caberetierID, concertID, theaterVoorstellingID;
    private String voorstellingSoort;
    private String theaterzaal;
    private String leeftijdsCat;

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

    public Integer getCaberetierID() {
        return caberetierID;
    }

    public void setCaberetierID(Integer caberetierID) {
        this.caberetierID = caberetierID;
    }

    public Integer getConcertID() {
        return concertID;
    }

    public void setConcertID(Integer concertID) {
        this.concertID = concertID;
    }

    public Integer getTheaterVoorstellingID() {
        return theaterVoorstellingID;
    }

    public void setTheaterVoorstellingID(Integer theaterVoorstellingID) {
        this.theaterVoorstellingID = theaterVoorstellingID;
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

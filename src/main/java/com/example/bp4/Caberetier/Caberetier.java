package com.example.bp4.Caberetier;

import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.*;

@Entity
public class Caberetier extends Voorstelling {

    private Integer caberetierID;
    private Integer leeftijd;
    private String caberetieNaam, geslacht;
    public Caberetier(){};

    public Caberetier(Integer theaterID, String voorstellingSoort, String theaterzaal, String leeftijdsCat, Integer leeftijd, String caberetieNaam,String geslacht) {
        this.theaterID = theaterID;
        this.voorstellingSoort = voorstellingSoort;
        this.theaterzaal = theaterzaal;
        this.leeftijdsCat = leeftijdsCat;
        this.leeftijd = leeftijd;
        this.caberetieNaam = caberetieNaam;
        this.geslacht = geslacht;
    }

    public Integer getCaberetierID() {
        return caberetierID;
    }

    public void setCaberetierID(Integer caberetierID) {
        this.caberetierID = caberetierID;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getCaberetieNaam() {
        return caberetieNaam;
    }

    public void setCaberetieNaam(String caberetieNaam) {
        this.caberetieNaam = caberetieNaam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }
}

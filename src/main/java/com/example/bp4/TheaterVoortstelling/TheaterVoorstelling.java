package com.example.bp4.TheaterVoortstelling;

import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.*;

@Entity
public class TheaterVoorstelling extends Voorstelling {
    private Integer theatervoorstellingID;
    private String theatervoorstellingNaam, acteurs, productieAfkomst;

    public TheaterVoorstelling(){}

    public TheaterVoorstelling(Integer theaterID, String voorstellingSoort, String theaterzaal, String leeftijdsCat, String theatervoorstellingNaam, String acteurs,String productieAfkomst) {
        this.theaterID = theaterID;
        this.voorstellingSoort = voorstellingSoort;
        this.theaterzaal = theaterzaal;
        this.leeftijdsCat = leeftijdsCat;
        this.theatervoorstellingNaam = theatervoorstellingNaam;
        this.acteurs = acteurs;
        this.productieAfkomst = productieAfkomst;
    }

    public Integer getTheatervoorstellingID() {
        return theatervoorstellingID;
    }

    public void setTheatervoorstellingID(Integer theatervoorstellingID) {
        this.theatervoorstellingID = theatervoorstellingID;
    }

    public String getTheatervoorstellingNaam() {
        return theatervoorstellingNaam;
    }

    public void setTheatervoorstellingNaam(String theatervoorstellingNaam) {
        this.theatervoorstellingNaam = theatervoorstellingNaam;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    public String getProductieAfkomst() {
        return productieAfkomst;
    }

    public void setProductieAfkomst(String productieAfkomst) {
        this.productieAfkomst = productieAfkomst;
    }
}

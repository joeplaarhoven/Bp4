package com.example.bp4.TheaterVoortstelling;

import com.example.bp4.Voorstelling.Voorstelling;

public class TheaterVoorstelling extends Voorstelling {
    private Integer theatervoorstellingID;
    private String theatervoorstellingNaam, acteurs, productieAfkomst;

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

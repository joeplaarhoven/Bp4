package com.example.bp4.Theater;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theaterID;
    private Integer huisnummer;
    private String theaterNaam, straatNaam, vestiging;

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(Integer huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getTheaterNaam() {
        return theaterNaam;
    }

    public void setTheaterNaam(String theaterNaam) {
        this.theaterNaam = theaterNaam;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public String getVestiging() {
        return vestiging;
    }

    public void setVestiging(String vestiging) {
        this.vestiging = vestiging;
    }
}

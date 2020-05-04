package com.example.bp4.Theater;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theaterID;
    private Integer huisnummer;
    
    @Column(name = "theaterNaam", nullable = false, unique = false)
    private String theaterNaam;
    @Column(name = "straatNaam", nullable = false, unique = false)
    private String straatNaam;
    @Column(name = "vestiging", nullable = false, unique = false)
    private String vestiging;
    
    public Theater(String theaterNaam, String straatNaam, String vestiging, Integer huisnummer) {
    	this.theaterNaam = theaterNaam;
    	this.straatNaam = straatNaam;
    	this.vestiging = vestiging;
    	this.huisnummer = huisnummer;
    }
    
    public Theater() {
    	
    }

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

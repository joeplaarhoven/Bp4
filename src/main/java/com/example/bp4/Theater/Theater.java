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
    
    @Column(name = "theaternaam", nullable = false, unique = false)
    private String theaternaam;
    @Column(name = "straatnaam", nullable = false, unique = false)
    private String straatnaam;
    @Column(name = "vestiging", nullable = false, unique = false)
    private String vestiging;
    
    public Theater(String theaternaam, String straatnaam, String vestiging, Integer huisnummer) {
    	this.theaternaam = theaternaam;
    	this.straatnaam = straatnaam;
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

    public String getTheaternaam() {
        return theaternaam;
    }

    public void setTheaternaam(String theaternaam) {
        this.theaternaam = theaternaam;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getVestiging() {
        return vestiging;
    }

    public void setVestiging(String vestiging) {
        this.vestiging = vestiging;
    }
}

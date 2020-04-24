package com.example.bp4.Eigenaar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eigenaren")
public class Eigenaar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer eigenaarID;
    private String EigenaarNaam, woonplaats, telefoonnummer, email, wachtwoord;

    public Integer getEigenaarID() {
        return eigenaarID;
    }

    public void setEigenaarID(Integer eigenaarID) {
        this.eigenaarID = eigenaarID;
    }

    public String getEigenaarNaam() {
        return EigenaarNaam;
    }

    public void setEigenaarNaam(String eigenaarNaam) {
        EigenaarNaam = eigenaarNaam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}

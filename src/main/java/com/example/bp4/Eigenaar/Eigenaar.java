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
    private Integer eigenaar_id;
    private String eigenaar_voornaam, eigenaar_achternaam, woonplaats, telefoonnummer, emailadres, wachtwoord;
    private boolean verified;

    public Eigenaar(String eigenaar_voornaam, String eigenaar_achternaam, String woonplaats, String telefoonnummer, String emailadres, String wachtwoord, boolean verified) {
        this.eigenaar_achternaam = eigenaar_achternaam;
        this.eigenaar_voornaam = eigenaar_voornaam;
        this.woonplaats = woonplaats;
        this.telefoonnummer = telefoonnummer;
        this.emailadres = emailadres;
        this.wachtwoord = wachtwoord;
        this.verified = verified;
    }

    public Eigenaar() {

    }

    public Eigenaar(int id, boolean verified) {
        this.eigenaar_id = id;
        this.verified = verified;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Integer getEigenaar_id() {
        return eigenaar_id;
    }

    public void setEigenaar_id(Integer eigenaar_id) {
        this.eigenaar_id = eigenaar_id;
    }

    public String getEigenaar_voornaam() {
        return eigenaar_voornaam;
    }

    public void setEigenaar_voornaam(String eigenaar_voornaam) {
        this.eigenaar_voornaam = eigenaar_voornaam;
    }

    public String getEigenaar_achternaam() {
        return eigenaar_achternaam;
    }

    public void setEigenaar_achternaam(String eigenaar_achternaam) {
        this.eigenaar_achternaam = eigenaar_achternaam;
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

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
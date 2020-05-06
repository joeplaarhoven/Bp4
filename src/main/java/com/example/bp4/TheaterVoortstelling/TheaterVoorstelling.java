package com.example.bp4.TheaterVoortstelling;

import com.example.bp4.Concert.ConcertPK;
import com.example.bp4.Voorstelling.Voorstelling;

import javax.persistence.*;

@Entity
@Table(name="theatervoorstellingen")
@IdClass(TheatervoorstellingPK.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TheaterVoorstelling extends Voorstelling {
	private Integer theatervoorstelling_id;
    private String theatervoorstellingNaam, acteurs, productieAfkomst;

    public TheaterVoorstelling(){}

    public TheaterVoorstelling(Integer theaterID, 
    		String voorstellingSoort, 
    		String theaterzaal, 
    		String leeftijdsCat, 
    		String afkomst, 
    		String datum, 
    		String tijd, 
    		Integer theatervoorstelling_id) {
        this.v_theaterzaal_id = theaterID;
        this.voorstellingsoort = voorstellingSoort;
        this.v_leeftijdscategorie = leeftijdsCat;
        this.afkomst = afkomst;
        this.datum = datum;
        this.tijd = tijd;
        this.theatervoorstelling_id = theatervoorstelling_id;
    }

    public Integer getTheatervoorstelling_id() {
        return theatervoorstelling_id;
    }

    public void setTheatervoorstelling_id(Integer theatervoorstelling_id) {
        this.theatervoorstelling_id = theatervoorstelling_id;
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

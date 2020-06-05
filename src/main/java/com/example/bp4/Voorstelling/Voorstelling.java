package com.example.bp4.Voorstelling;


//imports
import com.example.bp4.Cabaretier.Cabaretier;
import com.example.bp4.Concert.ConcertPK;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//aangeven dat dit een entiteit is
@Entity
//de naam van de tabel in de database
@Table(name="voorstellingen")
//aangeven dat dit een klasse is waar data in gejoined wordt met een andere klasse
@Inheritance(strategy = InheritanceType.JOINED)
public class Voorstelling implements Serializable {

	//id identificeren
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer voorstelling_id;

    protected Integer v_theaterzaal_id;
    protected Integer cabaretier_id= null, concert_id = null, theatervoorstelling_id = null;
    
    protected String voorstellingsoort;
    protected String v_leeftijdscategorie;
    public String afkomst;
    public String datum;
    public String tijd;

    //constructors
	public Voorstelling(Integer v_theaterzaal_id, String voorstellingsoort, String v_leeftijdscategorie, String afkomst, String datum, String tijd, Integer cabaretier_id) {
		this.v_theaterzaal_id = v_theaterzaal_id;
		this.voorstellingsoort = voorstellingsoort;
		this.v_leeftijdscategorie = v_leeftijdscategorie;
		this.afkomst = afkomst;
		this.datum = datum;
		this.tijd = tijd;
		this.cabaretier_id = cabaretier_id;
	}

	public Voorstelling() {
	}
    
    //get sets
    public Integer getConcert_id() {
		return concert_id;
	}

	public void setConcert_id(Integer concert_id) {
		this.concert_id = concert_id;
	}

	public Integer getTheatervoorstelling_id() {
		return theatervoorstelling_id;
	}

	public void setTheatervoorstelling_id(Integer theatervoorstelling_id) {
		this.theatervoorstelling_id = theatervoorstelling_id;
	}

	public Integer getCabaretier_id() {
		return cabaretier_id;
	}

	public void setCabaretier_id(Integer cabaretier_id) {
		this.cabaretier_id = cabaretier_id;
	}

	public Integer getV_theaterzaal_id() {
		return v_theaterzaal_id;
	}

	

	public Integer getVoorstelling_id() {
        return voorstelling_id;
    }

    public void setVoorstelling_id(Integer voorstelling_id) {
        this.voorstelling_id = voorstelling_id;
    }
    

    public Integer getTheaterzaal_id() {
        return v_theaterzaal_id;
    }

    public void setV_theaterzaal_id(Integer v_theaterzaal_id) {
        this.v_theaterzaal_id = v_theaterzaal_id;
    }


    public String getVoorstellingsoort() {
        return voorstellingsoort;
    }

    public void setVoorstellingsoort(String voorstellingsoort) {
        this.voorstellingsoort = voorstellingsoort;
    }

    public String getV_leeftijdscategorie() {
        return v_leeftijdscategorie;
    }

    public void setV_leeftijdscategorie(String v_leeftijdscategorie) {
        this.v_leeftijdscategorie = v_leeftijdscategorie;
    }

    public String getAfkomst() {
        return afkomst;
    }

    public void setAfkomst(String afkomst) {
        this.afkomst = afkomst;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijd() {
        return tijd;
    }

    public void setTijd(String tijd) {
        this.tijd = tijd;
    }
}
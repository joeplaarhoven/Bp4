package com.example.bp4.Voorstelling;

import com.example.bp4.Caberetier.Caberetier;
import com.example.bp4.Concert.ConcertPK;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="voorstellingen")
@Inheritance(strategy = InheritanceType.JOINED)

//@IdClass(VoorstellingenPK.class)
public class Voorstelling implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer voorstelling_id;

    protected Integer v_theaterzaal_id;
    protected Integer caberatier_id;
    protected String voorstellingsoort;
    protected String v_leeftijdscategorie;
    public String afkomst;
    public String datum;
    public String tijd;

	public Voorstelling(Integer v_theaterzaal_id, String voorstellingsoort, String v_leeftijdscategorie, String afkomst,
			String datum, String tijd, Integer caberatier_id1) {
		this.v_theaterzaal_id = v_theaterzaal_id;
		this.voorstellingsoort = voorstellingsoort;
		this.v_leeftijdscategorie = v_leeftijdscategorie;
		this.afkomst = afkomst;
		this.datum = datum;
		this.tijd = tijd;
		this.caberatier_id = caberatier_id;
	}

	public Voorstelling() {
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
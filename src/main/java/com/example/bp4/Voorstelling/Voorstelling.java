package com.example.bp4.Voorstelling;

import com.example.bp4.Caberetier.Caberetier;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@MappedSuperclass
@Table(name="voorstellingen")
public class Voorstelling {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer voorstelling_id;

    public Integer theaterzaal_id;
    public String voorstellingsoort;
    public String leeftijdsCat;
    private String afkomst;
    private String datum;
    private String tijd;

	public Voorstelling(Integer theaterzaal_id, String voorstellingsoort, String leeftijdsCat, String afkomst,
			String datum, String tijd) {
		this.theaterzaal_id = theaterzaal_id;
		this.voorstellingsoort = voorstellingsoort;
		this.leeftijdsCat = leeftijdsCat;
		this.afkomst = afkomst;
		this.datum = datum;
		this.tijd = tijd;
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
        return theaterzaal_id;
    }

    public void setTheaterzaal_id(Integer theaterzaal_id) {
        this.theaterzaal_id = theaterzaal_id;
    }


    public String getVoorstellingsoort() {
        return voorstellingsoort;
    }

    public void setVoorstellingsoort(String voorstellingsoort) {
        this.voorstellingsoort = voorstellingsoort;
    }

    public String getLeeftijdsCat() {
        return leeftijdsCat;
    }

    public void setLeeftijdsCat(String leeftijdsCat) {
        this.leeftijdsCat = leeftijdsCat;
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

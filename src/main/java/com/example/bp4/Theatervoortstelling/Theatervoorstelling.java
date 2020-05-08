package com.example.bp4.Theatervoortstelling;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

@Entity
@Table(name="theatervoorstellingen")
@IdClass(TheatervoorstellingPK.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Theatervoorstelling extends Voorstelling {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer theatervoorstelling_id;
	
	@Column(name = "theatervoorstelling_naam", nullable = true, unique = false)
    public String theatervoorstelling_naam;
    @Column(name = "acteurs", nullable = true, unique = false)
    public String acteurs;
    @Column(name = "productie_afkomst", nullable = true, unique = false)
    public String productie_afkomst;
    
    public Theatervoorstelling(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, Integer theatervoorstelling_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, theatervoorstelling_id);

        this.theatervoorstelling_id = theatervoorstelling_id;
	}
    
	public Theatervoorstelling(Integer theatervoorstelling_id, String theatervoorstelling_naam, String acteurs, String productie_afkomst) {
		this.theatervoorstelling_id = theatervoorstelling_id;
		this.theatervoorstelling_naam = theatervoorstelling_naam;
		this.acteurs = acteurs;
		this.productie_afkomst = productie_afkomst;
	}
	
	public Theatervoorstelling(String theatervoorstelling_naam, String acteurs, String productie_afkomst, Integer voorstelling_id) {
		this.theatervoorstelling_naam = theatervoorstelling_naam;
		this.acteurs = acteurs;
		this.productie_afkomst = productie_afkomst;
		this.voorstelling_id = voorstelling_id;
	}

//    public Theatervoorstelling(Integer theaterID, 
//    		String voorstellingSoort, 
//    		String theaterzaal, 
//    		String leeftijdsCat, 
//    		String afkomst, 
//    		String datum, 
//    		String tijd, 
//    		Integer theatervoorstelling_id) {
//        this.v_theaterzaal_id = theaterID;
//        this.voorstellingsoort = voorstellingSoort;
//        this.v_leeftijdscategorie = leeftijdsCat;
//        this.afkomst = afkomst;
//        this.datum = datum;
//        this.tijd = tijd;
//        this.theatervoorstelling_id = theatervoorstelling_id;
//    }    
    
    public Theatervoorstelling(){
    	
    }

	public Integer getTheatervoorstelling_id() {
		return theatervoorstelling_id;
	}

	public void setTheatervoorstelling_id(Integer theatervoorstelling_id) {
		this.theatervoorstelling_id = theatervoorstelling_id;
	}

	public String getTheatervoorstelling_naam() {
		return theatervoorstelling_naam;
	}

	public void setTheatervoorstelling_naam(String theatervoorstelling_naam) {
		this.theatervoorstelling_naam = theatervoorstelling_naam;
	}

	public String getActeurs() {
		return acteurs;
	}

	public void setActeurs(String acteurs) {
		this.acteurs = acteurs;
	}

	public String getProductie_afkomst() {
		return productie_afkomst;
	}

	public void setProductie_afkomst(String productie_afkomst) {
		this.productie_afkomst = productie_afkomst;
	}
    
}

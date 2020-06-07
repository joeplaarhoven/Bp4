package com.example.bp4.Theatervoortstelling;

import com.example.bp4.Voorstelling.Voorstelling;
import javax.persistence.*;

//Geeft aan dat de class Theatervoorstelling een entiteit is
@Entity
//Hier geef je aan welke class de ID/PK class
@IdClass(TheatervoorstellingPK.class)
//Naam van de tabel in de database
@Table(name="theatervoorstellingen")
public class Theatervoorstelling extends Voorstelling {
	
	//Variabelen declareren
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer theatervoorstelling_id;
	
	public Integer voorstelling_id;
	
	@Column(name = "theatervoorstelling_naam", nullable = true, unique = false)
    public String theatervoorstelling_naam;
    @Column(name = "acteurs", nullable = true, unique = false)
    public String acteurs;
    @Column(name = "productie_afkomst", nullable = true, unique = false)
    public String productie_afkomst;
    
    //Constructor voor een voorstelling in te plannen
    public Theatervoorstelling(Integer theaterzaal_id, String voorstellingSoort, String leeftijdsCat, String afkomst, String datum, String tijd, Integer theatervoorstelling_id) {
    	super(theaterzaal_id, voorstellingSoort, leeftijdsCat, afkomst, datum, tijd, theatervoorstelling_id);

        this.theatervoorstelling_id = theatervoorstelling_id;
	}
	
    //Constructor voor het toevoegen van een theatervoorstelling
	public Theatervoorstelling(String theatervoorstelling_naam, String acteurs, String productie_afkomst, Integer voorstelling_id) {
		this.theatervoorstelling_naam = theatervoorstelling_naam;
		this.acteurs = acteurs;
		this.productie_afkomst = productie_afkomst;
		this.voorstelling_id = voorstelling_id;
	}
	
    public Theatervoorstelling(){
    	
    }
    
    //Getters & Setters van theatervoorstelling
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
	
	 public Integer getVoorstelling_id() {
		return voorstelling_id;
	}

	public void setVoorstelling_id(Integer voorstelling_id) {
		this.voorstelling_id = voorstelling_id;
	}    
	
}

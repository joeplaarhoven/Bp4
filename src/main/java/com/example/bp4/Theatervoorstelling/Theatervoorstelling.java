package com.example.bp4.Theatervoorstelling;

import javax.persistence.*;

@Entity
@Table(name="theatervoorstellingen")
public class Theatervoorstelling {    
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer theatervoorstelling_id;
	
	@Column(name = "theatervoorstelling_naam", nullable = false, unique = false)
    private String theatervoorstelling_naam;
	@Column(name = "acteurs", nullable = false, unique = false)
    private String acteurs;
	@Column(name = "productieafkomst", nullable = false, unique = false)
    private String productieafkomst;
	
    public Theatervoorstelling(String theatervoorstelling_naam, String acteurs, String productieafkomst) {
    	this.theatervoorstelling_naam = theatervoorstelling_naam;
    	this.acteurs = acteurs;
    	this.productieafkomst = productieafkomst;
    }
    
    public Theatervoorstelling() {
    	
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

	public String getProductieafkomst() {
		return productieafkomst;
	}

	public void setProductieafkomst(String productieafkomst) {
		this.productieafkomst = productieafkomst;
	}
    	
}

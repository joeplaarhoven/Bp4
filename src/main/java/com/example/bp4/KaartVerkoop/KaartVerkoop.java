package com.example.bp4.KaartVerkoop;

import com.example.bp4.EigenaarTheater.EigenaarTheaterPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//aangeven dat dit een entiteit is
@Entity
//de naam van de tabel in de database
@Table(name="kaartenverkopen")
//ID class zodat er meerdere pk's in de klasse kan staan
@IdClass(KaartVerkoopPK.class)
public class KaartVerkoop {
	//variabelen declareren
    @Id
    private Integer kv_gebruikers_id;
    @Id
    private Integer kv_voorstelling_id;

    //constructor
    public KaartVerkoop(Integer gebruikerId, Integer voorstellingId) {
		this.kv_gebruikers_id = gebruikerId;
		this.kv_voorstelling_id = voorstellingId;
	}
    
    public KaartVerkoop() {
	}

    //get sets
	public Integer getGebruikersID() {
        return kv_gebruikers_id;
    }

    public void setGebruikersID(Integer gebruikersID) {
        this.kv_gebruikers_id = gebruikersID;
    }

    public Integer getVoorstellingID() {
        return kv_voorstelling_id;
    }

    public void setVoorstellingID(Integer voorstellingID) {
        this.kv_voorstelling_id = voorstellingID;
    }
}

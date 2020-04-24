package com.example.bp4.KaartVerkoop;

import com.example.bp4.EigenaarTheater.EigenaarTheaterPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="kaartenverkopen")
@IdClass(KaartVerkoopPK.class)
public class KaartVerkoop {
    @Id
    private Integer gebruikersID;
    @Id
    private Integer voorstellingID;

    public Integer getGebruikersID() {
        return gebruikersID;
    }

    public void setGebruikersID(Integer gebruikersID) {
        this.gebruikersID = gebruikersID;
    }

    public Integer getVoorstellingID() {
        return voorstellingID;
    }

    public void setVoorstellingID(Integer voorstellingID) {
        this.voorstellingID = voorstellingID;
    }
}

package com.example.bp4.EigenaarTheater;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="eigenarentheaters")
@IdClass(EigenaarTheaterPK.class)
public class EigenaarTheater{

    @Id
    private Integer theaterID;
    @Id
    private Integer eigenaarID;

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getEigenaarID() {
        return eigenaarID;
    }

    public void setEigenaarID(Integer eigenaarID) {
        this.eigenaarID = eigenaarID;
    }
}

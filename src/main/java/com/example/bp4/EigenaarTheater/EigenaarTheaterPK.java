package com.example.bp4.EigenaarTheater;

import java.io.Serializable;
import java.util.Objects;

public class EigenaarTheaterPK implements Serializable {
    private int theaterID;
    private int eigenaarID;

    public EigenaarTheaterPK() {
    }

    public EigenaarTheaterPK(int theaterID, int eigenaarID) {
        this.theaterID = theaterID;
        this.eigenaarID = eigenaarID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EigenaarTheaterPK theaterID1 = (EigenaarTheaterPK) o;
        if (theaterID != theaterID1.theaterID) return false;
        return eigenaarID == theaterID1.eigenaarID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(theaterID, eigenaarID);
    }
}

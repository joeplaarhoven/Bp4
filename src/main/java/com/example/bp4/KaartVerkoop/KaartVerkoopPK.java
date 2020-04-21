package com.example.bp4.KaartVerkoop;

import java.io.Serializable;
import java.util.Objects;

public class KaartVerkoopPK implements Serializable {
    private int gebruikersID;
    private int voorstellingID;

    public KaartVerkoopPK() {
    }

    public KaartVerkoopPK(int gebruikersID, int voorstellingID) {
        this.gebruikersID = gebruikersID;
        this.voorstellingID = voorstellingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KaartVerkoopPK gebruikersID1 = (KaartVerkoopPK) o;
        if (gebruikersID != gebruikersID1.gebruikersID) return false;
        return voorstellingID == gebruikersID1.voorstellingID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gebruikersID, voorstellingID);
    }
}

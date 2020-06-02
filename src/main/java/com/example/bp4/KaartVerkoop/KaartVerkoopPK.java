package com.example.bp4.KaartVerkoop;

import java.io.Serializable;
import java.util.Objects;

public class KaartVerkoopPK implements Serializable {
    private Integer kv_gebruikers_id;
    private Integer kv_voorstelling_id;

    public KaartVerkoopPK() {
    }

    public KaartVerkoopPK(int gebruikersID, int voorstellingID) {
        this.kv_gebruikers_id = gebruikersID;
        this.kv_voorstelling_id = voorstellingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KaartVerkoopPK gebruikersID1 = (KaartVerkoopPK) o;
        if (kv_gebruikers_id != gebruikersID1.kv_gebruikers_id) return false;
        return kv_voorstelling_id == gebruikersID1.kv_voorstelling_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kv_gebruikers_id, kv_voorstelling_id);
    }
}

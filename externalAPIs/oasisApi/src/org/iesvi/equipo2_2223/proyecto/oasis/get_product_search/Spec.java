package org.iesvi.equipo2_2223.proyecto.oasis.get_product_search;

public class Spec {
    @Override
    public String toString() {
        return "Spec{}";
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec) == false) {
            return false;
        }
        Spec rhs = ((Spec) other);
        return true;
    }

}

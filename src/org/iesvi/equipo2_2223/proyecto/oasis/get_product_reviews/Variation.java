
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;


public class Variation {
    @Override
    public String toString() {
        return "Variation{}";
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
        if ((other instanceof Variation) == false) {
            return false;
        }
        Variation rhs = ((Variation) other);
        return true;
    }

}


package org.iesvi.equipo2_2223.proyecto.oasis.get_product_offers;


public class ProductInformation {
    @Override
    public String toString() {
        return "ProductInformation{}";
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
        if ((other instanceof ProductInformation) == false) {
            return false;
        }
        ProductInformation rhs = ((ProductInformation) other);
        return true;
    }

}

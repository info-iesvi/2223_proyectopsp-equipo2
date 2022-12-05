
package org.iesvi.equipo2_2223.proyecto.oasis.get_product;


public class CustomizationOptions {
    @Override
    public String toString() {
        return "CustomizationOptions{}";
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
        if ((other instanceof CustomizationOptions) == false) {
            return false;
        }
        CustomizationOptions rhs = ((CustomizationOptions) other);
        return true;
    }

}

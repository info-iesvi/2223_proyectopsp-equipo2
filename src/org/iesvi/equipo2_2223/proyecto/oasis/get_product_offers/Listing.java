
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_offers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listing {

    @SerializedName("price_with_currency")
    @Expose
    private String priceWithCurrency;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("shipping_price")
    @Expose
    private Object shippingPrice;
    @SerializedName("has_prime_shipping")
    @Expose
    private boolean hasPrimeShipping;
    @SerializedName("ships_from")
    @Expose
    private String shipsFrom;
    @SerializedName("sold_by")
    @Expose
    private String soldBy;
    @SerializedName("fullfilled_by_amazon")
    @Expose
    private boolean fullfilledByAmazon;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Listing() {
    }

    /**
     * 
     * @param priceWithCurrency
     * @param shippingPrice
     * @param price
     * @param soldBy
     * @param shipsFrom
     * @param hasPrimeShipping
     * @param fullfilledByAmazon
     */
    public Listing(String priceWithCurrency, Object price, Object shippingPrice, boolean hasPrimeShipping, String shipsFrom, String soldBy, boolean fullfilledByAmazon) {
        super();
        this.priceWithCurrency = priceWithCurrency;
        this.price = price;
        this.shippingPrice = shippingPrice;
        this.hasPrimeShipping = hasPrimeShipping;
        this.shipsFrom = shipsFrom;
        this.soldBy = soldBy;
        this.fullfilledByAmazon = fullfilledByAmazon;
    }

    public String getPriceWithCurrency() {
        return priceWithCurrency;
    }

    public void setPriceWithCurrency(String priceWithCurrency) {
        this.priceWithCurrency = priceWithCurrency;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Object shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public boolean isHasPrimeShipping() {
        return hasPrimeShipping;
    }

    public void setHasPrimeShipping(boolean hasPrimeShipping) {
        this.hasPrimeShipping = hasPrimeShipping;
    }

    public String getShipsFrom() {
        return shipsFrom;
    }

    public void setShipsFrom(String shipsFrom) {
        this.shipsFrom = shipsFrom;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public boolean isFullfilledByAmazon() {
        return fullfilledByAmazon;
    }

    public void setFullfilledByAmazon(boolean fullfilledByAmazon) {
        this.fullfilledByAmazon = fullfilledByAmazon;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "priceWithCurrency='" + priceWithCurrency + '\'' +
                ", price=" + price +
                ", shippingPrice=" + shippingPrice +
                ", hasPrimeShipping=" + hasPrimeShipping +
                ", shipsFrom='" + shipsFrom + '\'' +
                ", soldBy='" + soldBy + '\'' +
                ", fullfilledByAmazon=" + fullfilledByAmazon +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.priceWithCurrency == null)? 0 :this.priceWithCurrency.hashCode()));
        result = ((result* 31)+((this.shippingPrice == null)? 0 :this.shippingPrice.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.soldBy == null)? 0 :this.soldBy.hashCode()));
        result = ((result* 31)+((this.shipsFrom == null)? 0 :this.shipsFrom.hashCode()));
        result = ((result* 31)+(this.hasPrimeShipping? 1 : 0));
        result = ((result* 31)+(this.fullfilledByAmazon? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Listing) == false) {
            return false;
        }
        Listing rhs = ((Listing) other);
        return ((((((((this.priceWithCurrency == rhs.priceWithCurrency)||((this.priceWithCurrency!= null)&&this.priceWithCurrency.equals(rhs.priceWithCurrency)))&&((this.shippingPrice == rhs.shippingPrice)||((this.shippingPrice!= null)&&this.shippingPrice.equals(rhs.shippingPrice))))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.soldBy == rhs.soldBy)||((this.soldBy!= null)&&this.soldBy.equals(rhs.soldBy))))&&((this.shipsFrom == rhs.shipsFrom)||((this.shipsFrom!= null)&&this.shipsFrom.equals(rhs.shipsFrom))))&&(this.hasPrimeShipping == rhs.hasPrimeShipping))&&(this.fullfilledByAmazon == rhs.fullfilledByAmazon));
    }

}

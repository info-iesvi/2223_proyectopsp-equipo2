
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_offers;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductOffersData {

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("listings")
    @Expose
    private List<Listing> listings = new ArrayList<Listing>();
    @SerializedName("pagination")
    @Expose
    private List<Object> pagination = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductOffersData() {
    }

    /**
     * 
     * @param listings
     * @param item
     * @param pagination
     */
    public GetProductOffersData(Item item, List<Listing> listings, List<Object> pagination) {
        super();
        this.item = item;
        this.listings = listings;
        this.pagination = pagination;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    public List<Object> getPagination() {
        return pagination;
    }

    public void setPagination(List<Object> pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "GetProductOffersData{" +
                "item=" + item +
                ", listings=" + listings +
                ", pagination=" + pagination +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.listings == null)? 0 :this.listings.hashCode()));
        result = ((result* 31)+((this.item == null)? 0 :this.item.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductOffersData) == false) {
            return false;
        }
        GetProductOffersData rhs = ((GetProductOffersData) other);
        return ((((this.listings == rhs.listings)||((this.listings!= null)&&this.listings.equals(rhs.listings)))&&((this.item == rhs.item)||((this.item!= null)&&this.item.equals(rhs.item))))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))));
    }

}

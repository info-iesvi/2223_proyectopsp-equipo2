
package org.iesvi.equipo2_2223.proyecto.oasis.get_product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerReviews {

    @SerializedName("ratings_count")
    @Expose
    private long ratingsCount;
    @SerializedName("stars")
    @Expose
    private double stars;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerReviews() {
    }

    /**
     * 
     * @param ratingsCount
     * @param stars
     */
    public CustomerReviews(long ratingsCount, double stars) {
        super();
        this.ratingsCount = ratingsCount;
        this.stars = stars;
    }

    public long getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(long ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "CustomerReviews{" +
                "ratingsCount=" + ratingsCount +
                ", stars=" + stars +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((int)(this.ratingsCount^(this.ratingsCount >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.stars)^(Double.doubleToLongBits(this.stars)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerReviews) == false) {
            return false;
        }
        CustomerReviews rhs = ((CustomerReviews) other);
        return ((this.ratingsCount == rhs.ratingsCount)&&(Double.doubleToLongBits(this.stars) == Double.doubleToLongBits(rhs.stars)));
    }

}

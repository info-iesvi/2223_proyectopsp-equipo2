
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_offers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("product_information")
    @Expose
    private ProductInformation productInformation;
    @SerializedName("listings_link")
    @Expose
    private String listingsLink;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("average_rating")
    @Expose
    private double averageRating;
    @SerializedName("total_reviews")
    @Expose
    private long totalReviews;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param image
     * @param totalReviews
     * @param author
     * @param subtitle
     * @param averageRating
     * @param name
     * @param productInformation
     * @param listingsLink
     * @param brand
     */
    public Item(String name, String subtitle, String author, String brand, ProductInformation productInformation, String listingsLink, String image, double averageRating, long totalReviews) {
        super();
        this.name = name;
        this.subtitle = subtitle;
        this.author = author;
        this.brand = brand;
        this.productInformation = productInformation;
        this.listingsLink = listingsLink;
        this.image = image;
        this.averageRating = averageRating;
        this.totalReviews = totalReviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(ProductInformation productInformation) {
        this.productInformation = productInformation;
    }

    public String getListingsLink() {
        return listingsLink;
    }

    public void setListingsLink(String listingsLink) {
        this.listingsLink = listingsLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public long getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(long totalReviews) {
        this.totalReviews = totalReviews;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", author='" + author + '\'' +
                ", brand='" + brand + '\'' +
                ", productInformation=" + productInformation +
                ", listingsLink='" + listingsLink + '\'' +
                ", image='" + image + '\'' +
                ", averageRating=" + averageRating +
                ", totalReviews=" + totalReviews +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((int)(this.totalReviews^(this.totalReviews >>> 32))));
        result = ((result* 31)+((this.author == null)? 0 :this.author.hashCode()));
        result = ((result* 31)+((this.subtitle == null)? 0 :this.subtitle.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.averageRating)^(Double.doubleToLongBits(this.averageRating)>>> 32))));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.productInformation == null)? 0 :this.productInformation.hashCode()));
        result = ((result* 31)+((this.listingsLink == null)? 0 :this.listingsLink.hashCode()));
        result = ((result* 31)+((this.brand == null)? 0 :this.brand.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return ((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&(this.totalReviews == rhs.totalReviews))&&((this.author == rhs.author)||((this.author!= null)&&this.author.equals(rhs.author))))&&((this.subtitle == rhs.subtitle)||((this.subtitle!= null)&&this.subtitle.equals(rhs.subtitle))))&&(Double.doubleToLongBits(this.averageRating) == Double.doubleToLongBits(rhs.averageRating)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.productInformation == rhs.productInformation)||((this.productInformation!= null)&&this.productInformation.equals(rhs.productInformation))))&&((this.listingsLink == rhs.listingsLink)||((this.listingsLink!= null)&&this.listingsLink.equals(rhs.listingsLink))))&&((this.brand == rhs.brand)||((this.brand!= null)&&this.brand.equals(rhs.brand))));
    }

}

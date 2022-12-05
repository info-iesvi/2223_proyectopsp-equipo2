
package org.iesvi.equipo2_2223.proyecto.oasis.get_product;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductInformation {

    @SerializedName("Publisher")
    @Expose
    private String publisher;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Paperback")
    @Expose
    private String paperback;
    @SerializedName("ISBN-10")
    @Expose
    private String isbn10;
    @SerializedName("ISBN-13")
    @Expose
    private String isbn13;
    @SerializedName("Item Weight")
    @Expose
    private String itemWeight;
    @SerializedName("Dimensions")
    @Expose
    private String dimensions;
    @SerializedName("Best Sellers Rank")
    @Expose
    private List<String> bestSellersRank = new ArrayList<String>();
    @SerializedName("Customer Reviews")
    @Expose
    private CustomerReviews customerReviews;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductInformation() {
    }

    /**
     * 
     * @param customerReviews
     * @param isbn13
     * @param publisher
     * @param paperback
     * @param language
     * @param isbn10
     * @param bestSellersRank
     * @param itemWeight
     * @param dimensions
     */
    public ProductInformation(String publisher, String language, String paperback, String isbn10, String isbn13, String itemWeight, String dimensions, List<String> bestSellersRank, CustomerReviews customerReviews) {
        super();
        this.publisher = publisher;
        this.language = language;
        this.paperback = paperback;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.itemWeight = itemWeight;
        this.dimensions = dimensions;
        this.bestSellersRank = bestSellersRank;
        this.customerReviews = customerReviews;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getBestSellersRank() {
        return bestSellersRank;
    }

    public void setBestSellersRank(List<String> bestSellersRank) {
        this.bestSellersRank = bestSellersRank;
    }

    public CustomerReviews getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(CustomerReviews customerReviews) {
        this.customerReviews = customerReviews;
    }

    @Override
    public String toString() {
        return "ProductInformation{" +
                "publisher='" + publisher + '\'' +
                ", language='" + language + '\'' +
                ", paperback='" + paperback + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", itemWeight='" + itemWeight + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", bestSellersRank=" + bestSellersRank +
                ", customerReviews=" + customerReviews +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.customerReviews == null)? 0 :this.customerReviews.hashCode()));
        result = ((result* 31)+((this.isbn13 == null)? 0 :this.isbn13 .hashCode()));
        result = ((result* 31)+((this.publisher == null)? 0 :this.publisher.hashCode()));
        result = ((result* 31)+((this.paperback == null)? 0 :this.paperback.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.isbn10 == null)? 0 :this.isbn10 .hashCode()));
        result = ((result* 31)+((this.bestSellersRank == null)? 0 :this.bestSellersRank.hashCode()));
        result = ((result* 31)+((this.itemWeight == null)? 0 :this.itemWeight.hashCode()));
        result = ((result* 31)+((this.dimensions == null)? 0 :this.dimensions.hashCode()));
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
        return ((((((((((this.customerReviews == rhs.customerReviews)||((this.customerReviews!= null)&&this.customerReviews.equals(rhs.customerReviews)))&&((this.isbn13 == rhs.isbn13)||((this.isbn13 != null)&&this.isbn13 .equals(rhs.isbn13))))&&((this.publisher == rhs.publisher)||((this.publisher!= null)&&this.publisher.equals(rhs.publisher))))&&((this.paperback == rhs.paperback)||((this.paperback!= null)&&this.paperback.equals(rhs.paperback))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.isbn10 == rhs.isbn10)||((this.isbn10 != null)&&this.isbn10 .equals(rhs.isbn10))))&&((this.bestSellersRank == rhs.bestSellersRank)||((this.bestSellersRank!= null)&&this.bestSellersRank.equals(rhs.bestSellersRank))))&&((this.itemWeight == rhs.itemWeight)||((this.itemWeight!= null)&&this.itemWeight.equals(rhs.itemWeight))))&&((this.dimensions == rhs.dimensions)||((this.dimensions!= null)&&this.dimensions.equals(rhs.dimensions))));
    }

}

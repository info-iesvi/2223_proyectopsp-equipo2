package org.iesvi.equipo2_2223.proyecto.oasis.get_product_search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductSearchResultsDataBook {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("position")
    @Expose
    private long position;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("has_prime")
    @Expose
    private boolean hasPrime;
    @SerializedName("is_best_seller")
    @Expose
    private boolean isBestSeller;
    @SerializedName("is_amazon_choice")
    @Expose
    private boolean isAmazonChoice;
    @SerializedName("is_limited_deal")
    @Expose
    private boolean isLimitedDeal;
    @SerializedName("stars")
    @Expose
    private double stars;
    @SerializedName("total_reviews")
    @Expose
    private Object totalReviews;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("availability_quantity")
    @Expose
    private Object availabilityQuantity;
    @SerializedName("spec")
    @Expose
    private Spec spec;
    @SerializedName("price_string")
    @Expose
    private Object priceString;
    @SerializedName("price_symbol")
    @Expose
    private Object priceSymbol;
    @SerializedName("price")
    @Expose
    private Object price;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductSearchResultsDataBook() {
    }

    /**
     * 
     * @param isLimitedDeal
     * @param image
     * @param priceString
     * @param availabilityQuantity
     * @param isBestSeller
     * @param stars
     * @param type
     * @param url
     * @param spec
     * @param totalReviews
     * @param hasPrime
     * @param price
     * @param name
     * @param position
     * @param priceSymbol
     * @param isAmazonChoice
     */
    public GetProductSearchResultsDataBook(String type, long position, String name, String image, boolean hasPrime, boolean isBestSeller, boolean isAmazonChoice, boolean isLimitedDeal, double stars, Object totalReviews, String url, Object availabilityQuantity, Spec spec, Object priceString, Object priceSymbol, Object price) {
        super();
        this.type = type;
        this.position = position;
        this.name = name;
        this.image = image;
        this.hasPrime = hasPrime;
        this.isBestSeller = isBestSeller;
        this.isAmazonChoice = isAmazonChoice;
        this.isLimitedDeal = isLimitedDeal;
        this.stars = stars;
        this.totalReviews = totalReviews;
        this.url = url;
        this.availabilityQuantity = availabilityQuantity;
        this.spec = spec;
        this.priceString = priceString;
        this.priceSymbol = priceSymbol;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isHasPrime() {
        return hasPrime;
    }

    public void setHasPrime(boolean hasPrime) {
        this.hasPrime = hasPrime;
    }

    public boolean isIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    public boolean isIsAmazonChoice() {
        return isAmazonChoice;
    }

    public void setIsAmazonChoice(boolean isAmazonChoice) {
        this.isAmazonChoice = isAmazonChoice;
    }

    public boolean isIsLimitedDeal() {
        return isLimitedDeal;
    }

    public void setIsLimitedDeal(boolean isLimitedDeal) {
        this.isLimitedDeal = isLimitedDeal;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public Object getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Object totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getAvailabilityQuantity() {
        return availabilityQuantity;
    }

    public void setAvailabilityQuantity(Object availabilityQuantity) {
        this.availabilityQuantity = availabilityQuantity;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Object getPriceString() {
        return priceString;
    }

    public void setPriceString(Object priceString) {
        this.priceString = priceString;
    }

    public Object getPriceSymbol() {
        return priceSymbol;
    }

    public void setPriceSymbol(Object priceSymbol) {
        this.priceSymbol = priceSymbol;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GetProductSearchResultsDataBook{" +
                "type='" + type + '\'' +
                ", position=" + position +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", hasPrime=" + hasPrime +
                ", isBestSeller=" + isBestSeller +
                ", isAmazonChoice=" + isAmazonChoice +
                ", isLimitedDeal=" + isLimitedDeal +
                ", stars=" + stars +
                ", totalReviews=" + totalReviews +
                ", url='" + url + '\'' +
                ", availabilityQuantity=" + availabilityQuantity +
                ", spec=" + spec +
                ", priceString=" + priceString +
                ", priceSymbol=" + priceSymbol +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+(this.isLimitedDeal? 1 : 0));
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.priceString == null)? 0 :this.priceString.hashCode()));
        result = ((result* 31)+((this.availabilityQuantity == null)? 0 :this.availabilityQuantity.hashCode()));
        result = ((result* 31)+(this.isBestSeller? 1 : 0));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.stars)^(Double.doubleToLongBits(this.stars)>>> 32))));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.spec == null)? 0 :this.spec.hashCode()));
        result = ((result* 31)+((this.totalReviews == null)? 0 :this.totalReviews.hashCode()));
        result = ((result* 31)+(this.hasPrime? 1 : 0));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((int)(this.position^(this.position >>> 32))));
        result = ((result* 31)+((this.priceSymbol == null)? 0 :this.priceSymbol.hashCode()));
        result = ((result* 31)+(this.isAmazonChoice? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductSearchResultsDataBook) == false) {
            return false;
        }
        GetProductSearchResultsDataBook rhs = ((GetProductSearchResultsDataBook) other);
        return ((((((((((((((((this.isLimitedDeal == rhs.isLimitedDeal)&&((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image))))&&((this.priceString == rhs.priceString)||((this.priceString!= null)&&this.priceString.equals(rhs.priceString))))&&((this.availabilityQuantity == rhs.availabilityQuantity)||((this.availabilityQuantity!= null)&&this.availabilityQuantity.equals(rhs.availabilityQuantity))))&&(this.isBestSeller == rhs.isBestSeller))&&(Double.doubleToLongBits(this.stars) == Double.doubleToLongBits(rhs.stars)))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.spec == rhs.spec)||((this.spec!= null)&&this.spec.equals(rhs.spec))))&&((this.totalReviews == rhs.totalReviews)||((this.totalReviews!= null)&&this.totalReviews.equals(rhs.totalReviews))))&&(this.hasPrime == rhs.hasPrime))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&(this.position == rhs.position))&&((this.priceSymbol == rhs.priceSymbol)||((this.priceSymbol!= null)&&this.priceSymbol.equals(rhs.priceSymbol))))&&(this.isAmazonChoice == rhs.isAmazonChoice));
    }

}

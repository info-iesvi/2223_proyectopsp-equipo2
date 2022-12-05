
package org.iesvi.equipo2_2223.proyecto.oasis.get_product;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductData {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("product_information")
    @Expose
    private ProductInformation productInformation;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("brand_url")
    @Expose
    private Object brandUrl;
    @SerializedName("full_description")
    @Expose
    private String fullDescription;
    @SerializedName("pricing")
    @Expose
    private String pricing;
    @SerializedName("list_price")
    @Expose
    private String listPrice;
    @SerializedName("availability_status")
    @Expose
    private String availabilityStatus;
    @SerializedName("images")
    @Expose
    private List<String> images = new ArrayList<String>();
    @SerializedName("product_category")
    @Expose
    private String productCategory;
    @SerializedName("average_rating")
    @Expose
    private double averageRating;
    @SerializedName("small_description")
    @Expose
    private String smallDescription;
    @SerializedName("feature_bullets")
    @Expose
    private List<Object> featureBullets = new ArrayList<Object>();
    @SerializedName("total_reviews")
    @Expose
    private long totalReviews;
    @SerializedName("total_answered_questions")
    @Expose
    private long totalAnsweredQuestions;
    @SerializedName("customization_options")
    @Expose
    private CustomizationOptions customizationOptions;
    @SerializedName("seller_id")
    @Expose
    private String sellerId;
    @SerializedName("seller_name")
    @Expose
    private String sellerName;
    @SerializedName("fulfilled_by_amazon")
    @Expose
    private Object fulfilledByAmazon;
    @SerializedName("fast_track_message")
    @Expose
    private String fastTrackMessage;
    @SerializedName("aplus_present")
    @Expose
    private boolean aplusPresent;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductData() {
    }

    /**
     * 
     * @param images
     * @param smallDescription
     * @param aplusPresent
     * @param sellerName
     * @param fastTrackMessage
     * @param productInformation
     * @param fullDescription
     * @param customizationOptions
     * @param totalAnsweredQuestions
     * @param productCategory
     * @param totalReviews
     * @param featureBullets
     * @param sellerId
     * @param brandUrl
     * @param averageRating
     * @param name
     * @param fulfilledByAmazon
     * @param availabilityStatus
     * @param brand
     * @param pricing
     * @param listPrice
     */
    public GetProductData(String name, ProductInformation productInformation, String brand, Object brandUrl, String fullDescription, String pricing, String listPrice, String availabilityStatus, List<String> images, String productCategory, double averageRating, String smallDescription, List<Object> featureBullets, long totalReviews, long totalAnsweredQuestions, CustomizationOptions customizationOptions, String sellerId, String sellerName, Object fulfilledByAmazon, String fastTrackMessage, boolean aplusPresent) {
        super();
        this.name = name;
        this.productInformation = productInformation;
        this.brand = brand;
        this.brandUrl = brandUrl;
        this.fullDescription = fullDescription;
        this.pricing = pricing;
        this.listPrice = listPrice;
        this.availabilityStatus = availabilityStatus;
        this.images = images;
        this.productCategory = productCategory;
        this.averageRating = averageRating;
        this.smallDescription = smallDescription;
        this.featureBullets = featureBullets;
        this.totalReviews = totalReviews;
        this.totalAnsweredQuestions = totalAnsweredQuestions;
        this.customizationOptions = customizationOptions;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.fulfilledByAmazon = fulfilledByAmazon;
        this.fastTrackMessage = fastTrackMessage;
        this.aplusPresent = aplusPresent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(ProductInformation productInformation) {
        this.productInformation = productInformation;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Object getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(Object brandUrl) {
        this.brandUrl = brandUrl;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public List<Object> getFeatureBullets() {
        return featureBullets;
    }

    public void setFeatureBullets(List<Object> featureBullets) {
        this.featureBullets = featureBullets;
    }

    public long getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(long totalReviews) {
        this.totalReviews = totalReviews;
    }

    public long getTotalAnsweredQuestions() {
        return totalAnsweredQuestions;
    }

    public void setTotalAnsweredQuestions(long totalAnsweredQuestions) {
        this.totalAnsweredQuestions = totalAnsweredQuestions;
    }

    public CustomizationOptions getCustomizationOptions() {
        return customizationOptions;
    }

    public void setCustomizationOptions(CustomizationOptions customizationOptions) {
        this.customizationOptions = customizationOptions;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Object getFulfilledByAmazon() {
        return fulfilledByAmazon;
    }

    public void setFulfilledByAmazon(Object fulfilledByAmazon) {
        this.fulfilledByAmazon = fulfilledByAmazon;
    }

    public String getFastTrackMessage() {
        return fastTrackMessage;
    }

    public void setFastTrackMessage(String fastTrackMessage) {
        this.fastTrackMessage = fastTrackMessage;
    }

    public boolean isAplusPresent() {
        return aplusPresent;
    }

    public void setAplusPresent(boolean aplusPresent) {
        this.aplusPresent = aplusPresent;
    }

    @Override
    public String toString() {
        return "GetProductData{" +
                "name='" + name + '\'' +
                ", productInformation=" + productInformation +
                ", brand='" + brand + '\'' +
                ", brandUrl=" + brandUrl +
                ", fullDescription='" + fullDescription + '\'' +
                ", pricing='" + pricing + '\'' +
                ", listPrice='" + listPrice + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                ", images=" + images +
                ", productCategory='" + productCategory + '\'' +
                ", averageRating=" + averageRating +
                ", smallDescription='" + smallDescription + '\'' +
                ", featureBullets=" + featureBullets +
                ", totalReviews=" + totalReviews +
                ", totalAnsweredQuestions=" + totalAnsweredQuestions +
                ", customizationOptions=" + customizationOptions +
                ", sellerId='" + sellerId + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", fulfilledByAmazon=" + fulfilledByAmazon +
                ", fastTrackMessage='" + fastTrackMessage + '\'' +
                ", aplusPresent=" + aplusPresent +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.images == null)? 0 :this.images.hashCode()));
        result = ((result* 31)+((this.smallDescription == null)? 0 :this.smallDescription.hashCode()));
        result = ((result* 31)+(this.aplusPresent? 1 : 0));
        result = ((result* 31)+((this.sellerName == null)? 0 :this.sellerName.hashCode()));
        result = ((result* 31)+((this.fastTrackMessage == null)? 0 :this.fastTrackMessage.hashCode()));
        result = ((result* 31)+((this.productInformation == null)? 0 :this.productInformation.hashCode()));
        result = ((result* 31)+((this.fullDescription == null)? 0 :this.fullDescription.hashCode()));
        result = ((result* 31)+((this.customizationOptions == null)? 0 :this.customizationOptions.hashCode()));
        result = ((result* 31)+((int)(this.totalAnsweredQuestions^(this.totalAnsweredQuestions >>> 32))));
        result = ((result* 31)+((this.productCategory == null)? 0 :this.productCategory.hashCode()));
        result = ((result* 31)+((int)(this.totalReviews^(this.totalReviews >>> 32))));
        result = ((result* 31)+((this.featureBullets == null)? 0 :this.featureBullets.hashCode()));
        result = ((result* 31)+((this.sellerId == null)? 0 :this.sellerId.hashCode()));
        result = ((result* 31)+((this.brandUrl == null)? 0 :this.brandUrl.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.averageRating)^(Double.doubleToLongBits(this.averageRating)>>> 32))));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.fulfilledByAmazon == null)? 0 :this.fulfilledByAmazon.hashCode()));
        result = ((result* 31)+((this.availabilityStatus == null)? 0 :this.availabilityStatus.hashCode()));
        result = ((result* 31)+((this.brand == null)? 0 :this.brand.hashCode()));
        result = ((result* 31)+((this.pricing == null)? 0 :this.pricing.hashCode()));
        result = ((result* 31)+((this.listPrice == null)? 0 :this.listPrice.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductData) == false) {
            return false;
        }
        GetProductData rhs = ((GetProductData) other);
        return ((((((((((((((((((((((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images)))&&((this.smallDescription == rhs.smallDescription)||((this.smallDescription!= null)&&this.smallDescription.equals(rhs.smallDescription))))&&(this.aplusPresent == rhs.aplusPresent))&&((this.sellerName == rhs.sellerName)||((this.sellerName!= null)&&this.sellerName.equals(rhs.sellerName))))&&((this.fastTrackMessage == rhs.fastTrackMessage)||((this.fastTrackMessage!= null)&&this.fastTrackMessage.equals(rhs.fastTrackMessage))))&&((this.productInformation == rhs.productInformation)||((this.productInformation!= null)&&this.productInformation.equals(rhs.productInformation))))&&((this.fullDescription == rhs.fullDescription)||((this.fullDescription!= null)&&this.fullDescription.equals(rhs.fullDescription))))&&((this.customizationOptions == rhs.customizationOptions)||((this.customizationOptions!= null)&&this.customizationOptions.equals(rhs.customizationOptions))))&&(this.totalAnsweredQuestions == rhs.totalAnsweredQuestions))&&((this.productCategory == rhs.productCategory)||((this.productCategory!= null)&&this.productCategory.equals(rhs.productCategory))))&&(this.totalReviews == rhs.totalReviews))&&((this.featureBullets == rhs.featureBullets)||((this.featureBullets!= null)&&this.featureBullets.equals(rhs.featureBullets))))&&((this.sellerId == rhs.sellerId)||((this.sellerId!= null)&&this.sellerId.equals(rhs.sellerId))))&&((this.brandUrl == rhs.brandUrl)||((this.brandUrl!= null)&&this.brandUrl.equals(rhs.brandUrl))))&&(Double.doubleToLongBits(this.averageRating) == Double.doubleToLongBits(rhs.averageRating)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.fulfilledByAmazon == rhs.fulfilledByAmazon)||((this.fulfilledByAmazon!= null)&&this.fulfilledByAmazon.equals(rhs.fulfilledByAmazon))))&&((this.availabilityStatus == rhs.availabilityStatus)||((this.availabilityStatus!= null)&&this.availabilityStatus.equals(rhs.availabilityStatus))))&&((this.brand == rhs.brand)||((this.brand!= null)&&this.brand.equals(rhs.brand))))&&((this.pricing == rhs.pricing)||((this.pricing!= null)&&this.pricing.equals(rhs.pricing))))&&((this.listPrice == rhs.listPrice)||((this.listPrice!= null)&&this.listPrice.equals(rhs.listPrice))));
    }

}

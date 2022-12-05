
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductReviewsData {

    @SerializedName("average_rating")
    @Expose
    private double averageRating;
    @SerializedName("total_ratings")
    @Expose
    private long totalRatings;
    @SerializedName("filtered_total_ratings")
    @Expose
    private Object filteredTotalRatings;
    @SerializedName("total_reviews")
    @Expose
    private Object totalReviews;
    @SerializedName("filtered_total_reviews")
    @Expose
    private Object filteredTotalReviews;
    @SerializedName("5_star_ratings")
    @Expose
    private long _5StarRatings;
    @SerializedName("5_star_percentage")
    @Expose
    private double _5StarPercentage;
    @SerializedName("4_star_ratings")
    @Expose
    private long _4StarRatings;
    @SerializedName("4_star_percentage")
    @Expose
    private double _4StarPercentage;
    @SerializedName("3_star_ratings")
    @Expose
    private long _3StarRatings;
    @SerializedName("3_star_percentage")
    @Expose
    private double _3StarPercentage;
    @SerializedName("2_star_ratings")
    @Expose
    private long _2StarRatings;
    @SerializedName("2_star_percentage")
    @Expose
    private long _2StarPercentage;
    @SerializedName("1_star_ratings")
    @Expose
    private long _1StarRatings;
    @SerializedName("1_star_percentage")
    @Expose
    private double _1StarPercentage;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("top_positive_review")
    @Expose
    private TopPositiveReview topPositiveReview;
    @SerializedName("top_critical_review")
    @Expose
    private TopCriticalReview topCriticalReview;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = new ArrayList<Review>();
    @SerializedName("pagination")
    @Expose
    private List<Object> pagination = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductReviewsData() {
    }

    /**
     * 
     * @param _4StarRatings
     * @param _4StarPercentage
     * @param product
     * @param pagination
     * @param _3StarPercentage
     * @param totalRatings
     * @param _1StarRatings
     * @param filteredTotalReviews
     * @param _3StarRatings
     * @param _5StarRatings
     * @param _1StarPercentage
     * @param totalReviews
     * @param reviews
     * @param _2StarPercentage
     * @param averageRating
     * @param topCriticalReview
     * @param filteredTotalRatings
     * @param topPositiveReview
     * @param _2StarRatings
     * @param _5StarPercentage
     */
    public GetProductReviewsData(double averageRating, long totalRatings, Object filteredTotalRatings, Object totalReviews, Object filteredTotalReviews, long _5StarRatings, double _5StarPercentage, long _4StarRatings, double _4StarPercentage, long _3StarRatings, double _3StarPercentage, long _2StarRatings, long _2StarPercentage, long _1StarRatings, double _1StarPercentage, Product product, TopPositiveReview topPositiveReview, TopCriticalReview topCriticalReview, List<Review> reviews, List<Object> pagination) {
        super();
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
        this.filteredTotalRatings = filteredTotalRatings;
        this.totalReviews = totalReviews;
        this.filteredTotalReviews = filteredTotalReviews;
        this._5StarRatings = _5StarRatings;
        this._5StarPercentage = _5StarPercentage;
        this._4StarRatings = _4StarRatings;
        this._4StarPercentage = _4StarPercentage;
        this._3StarRatings = _3StarRatings;
        this._3StarPercentage = _3StarPercentage;
        this._2StarRatings = _2StarRatings;
        this._2StarPercentage = _2StarPercentage;
        this._1StarRatings = _1StarRatings;
        this._1StarPercentage = _1StarPercentage;
        this.product = product;
        this.topPositiveReview = topPositiveReview;
        this.topCriticalReview = topCriticalReview;
        this.reviews = reviews;
        this.pagination = pagination;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public long getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(long totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Object getFilteredTotalRatings() {
        return filteredTotalRatings;
    }

    public void setFilteredTotalRatings(Object filteredTotalRatings) {
        this.filteredTotalRatings = filteredTotalRatings;
    }

    public Object getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Object totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Object getFilteredTotalReviews() {
        return filteredTotalReviews;
    }

    public void setFilteredTotalReviews(Object filteredTotalReviews) {
        this.filteredTotalReviews = filteredTotalReviews;
    }

    public long get5StarRatings() {
        return _5StarRatings;
    }

    public void set5StarRatings(long _5StarRatings) {
        this._5StarRatings = _5StarRatings;
    }

    public double get5StarPercentage() {
        return _5StarPercentage;
    }

    public void set5StarPercentage(double _5StarPercentage) {
        this._5StarPercentage = _5StarPercentage;
    }

    public long get4StarRatings() {
        return _4StarRatings;
    }

    public void set4StarRatings(long _4StarRatings) {
        this._4StarRatings = _4StarRatings;
    }

    public double get4StarPercentage() {
        return _4StarPercentage;
    }

    public void set4StarPercentage(double _4StarPercentage) {
        this._4StarPercentage = _4StarPercentage;
    }

    public long get3StarRatings() {
        return _3StarRatings;
    }

    public void set3StarRatings(long _3StarRatings) {
        this._3StarRatings = _3StarRatings;
    }

    public double get3StarPercentage() {
        return _3StarPercentage;
    }

    public void set3StarPercentage(double _3StarPercentage) {
        this._3StarPercentage = _3StarPercentage;
    }

    public long get2StarRatings() {
        return _2StarRatings;
    }

    public void set2StarRatings(long _2StarRatings) {
        this._2StarRatings = _2StarRatings;
    }

    public long get2StarPercentage() {
        return _2StarPercentage;
    }

    public void set2StarPercentage(long _2StarPercentage) {
        this._2StarPercentage = _2StarPercentage;
    }

    public long get1StarRatings() {
        return _1StarRatings;
    }

    public void set1StarRatings(long _1StarRatings) {
        this._1StarRatings = _1StarRatings;
    }

    public double get1StarPercentage() {
        return _1StarPercentage;
    }

    public void set1StarPercentage(double _1StarPercentage) {
        this._1StarPercentage = _1StarPercentage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public TopPositiveReview getTopPositiveReview() {
        return topPositiveReview;
    }

    public void setTopPositiveReview(TopPositiveReview topPositiveReview) {
        this.topPositiveReview = topPositiveReview;
    }

    public TopCriticalReview getTopCriticalReview() {
        return topCriticalReview;
    }

    public void setTopCriticalReview(TopCriticalReview topCriticalReview) {
        this.topCriticalReview = topCriticalReview;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Object> getPagination() {
        return pagination;
    }

    public void setPagination(List<Object> pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "GetProductReviewsData{" +
                "averageRating=" + averageRating +
                ", totalRatings=" + totalRatings +
                ", filteredTotalRatings=" + filteredTotalRatings +
                ", totalReviews=" + totalReviews +
                ", filteredTotalReviews=" + filteredTotalReviews +
                ", _5StarRatings=" + _5StarRatings +
                ", _5StarPercentage=" + _5StarPercentage +
                ", _4StarRatings=" + _4StarRatings +
                ", _4StarPercentage=" + _4StarPercentage +
                ", _3StarRatings=" + _3StarRatings +
                ", _3StarPercentage=" + _3StarPercentage +
                ", _2StarRatings=" + _2StarRatings +
                ", _2StarPercentage=" + _2StarPercentage +
                ", _1StarRatings=" + _1StarRatings +
                ", _1StarPercentage=" + _1StarPercentage +
                ", product=" + product +
                ", topPositiveReview=" + topPositiveReview +
                ", topCriticalReview=" + topCriticalReview +
                ", reviews=" + reviews +
                ", pagination=" + pagination +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((int)(this._4StarRatings^(this._4StarRatings >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this._4StarPercentage)^(Double.doubleToLongBits(this._4StarPercentage)>>> 32))));
        result = ((result* 31)+((this.product == null)? 0 :this.product.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this._3StarPercentage)^(Double.doubleToLongBits(this._3StarPercentage)>>> 32))));
        result = ((result* 31)+((int)(this.totalRatings^(this.totalRatings >>> 32))));
        result = ((result* 31)+((int)(this._1StarRatings^(this._1StarRatings >>> 32))));
        result = ((result* 31)+((this.filteredTotalReviews == null)? 0 :this.filteredTotalReviews.hashCode()));
        result = ((result* 31)+((int)(this._3StarRatings^(this._3StarRatings >>> 32))));
        result = ((result* 31)+((int)(this._5StarRatings^(this._5StarRatings >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this._1StarPercentage)^(Double.doubleToLongBits(this._1StarPercentage)>>> 32))));
        result = ((result* 31)+((this.totalReviews == null)? 0 :this.totalReviews.hashCode()));
        result = ((result* 31)+((this.reviews == null)? 0 :this.reviews.hashCode()));
        result = ((result* 31)+((int)(this._2StarPercentage^(this._2StarPercentage >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.averageRating)^(Double.doubleToLongBits(this.averageRating)>>> 32))));
        result = ((result* 31)+((this.topCriticalReview == null)? 0 :this.topCriticalReview.hashCode()));
        result = ((result* 31)+((this.filteredTotalRatings == null)? 0 :this.filteredTotalRatings.hashCode()));
        result = ((result* 31)+((this.topPositiveReview == null)? 0 :this.topPositiveReview.hashCode()));
        result = ((result* 31)+((int)(this._2StarRatings^(this._2StarRatings >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this._5StarPercentage)^(Double.doubleToLongBits(this._5StarPercentage)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductReviewsData) == false) {
            return false;
        }
        GetProductReviewsData rhs = ((GetProductReviewsData) other);
        return ((((((((((((((((((((this._4StarRatings == rhs._4StarRatings)&&(Double.doubleToLongBits(this._4StarPercentage) == Double.doubleToLongBits(rhs._4StarPercentage)))&&((this.product == rhs.product)||((this.product!= null)&&this.product.equals(rhs.product))))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))))&&(Double.doubleToLongBits(this._3StarPercentage) == Double.doubleToLongBits(rhs._3StarPercentage)))&&(this.totalRatings == rhs.totalRatings))&&(this._1StarRatings == rhs._1StarRatings))&&((this.filteredTotalReviews == rhs.filteredTotalReviews)||((this.filteredTotalReviews!= null)&&this.filteredTotalReviews.equals(rhs.filteredTotalReviews))))&&(this._3StarRatings == rhs._3StarRatings))&&(this._5StarRatings == rhs._5StarRatings))&&(Double.doubleToLongBits(this._1StarPercentage) == Double.doubleToLongBits(rhs._1StarPercentage)))&&((this.totalReviews == rhs.totalReviews)||((this.totalReviews!= null)&&this.totalReviews.equals(rhs.totalReviews))))&&((this.reviews == rhs.reviews)||((this.reviews!= null)&&this.reviews.equals(rhs.reviews))))&&(this._2StarPercentage == rhs._2StarPercentage))&&(Double.doubleToLongBits(this.averageRating) == Double.doubleToLongBits(rhs.averageRating)))&&((this.topCriticalReview == rhs.topCriticalReview)||((this.topCriticalReview!= null)&&this.topCriticalReview.equals(rhs.topCriticalReview))))&&((this.filteredTotalRatings == rhs.filteredTotalRatings)||((this.filteredTotalRatings!= null)&&this.filteredTotalRatings.equals(rhs.filteredTotalRatings))))&&((this.topPositiveReview == rhs.topPositiveReview)||((this.topPositiveReview!= null)&&this.topPositiveReview.equals(rhs.topPositiveReview))))&&(this._2StarRatings == rhs._2StarRatings))&&(Double.doubleToLongBits(this._5StarPercentage) == Double.doubleToLongBits(rhs._5StarPercentage)));
    }

}


package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("stars")
    @Expose
    private Object stars;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("verified_purchase")
    @Expose
    private boolean verifiedPurchase;
    @SerializedName("manufacturer_replied")
    @Expose
    private boolean manufacturerReplied;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("userUrl")
    @Expose
    private String userUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("reviewUrl")
    @Expose
    private String reviewUrl;
    @SerializedName("total_found_helpful")
    @Expose
    private Object totalFoundHelpful;
    @SerializedName("images")
    @Expose
    private List<Object> images = new ArrayList<Object>();
    @SerializedName("variation")
    @Expose
    private Variation__3 variation;
    @SerializedName("videoUrl")
    @Expose
    private Object videoUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Review() {
    }

    /**
     * 
     * @param date
     * @param totalFoundHelpful
     * @param images
     * @param manufacturerReplied
     * @param stars
     * @param title
     * @param variation
     * @param videoUrl
     * @param verifiedPurchase
     * @param reviewUrl
     * @param review
     * @param userUrl
     * @param username
     */
    public Review(Object stars, String date, boolean verifiedPurchase, boolean manufacturerReplied, String username, String userUrl, String title, String review, String reviewUrl, Object totalFoundHelpful, List<Object> images, Variation__3 variation, Object videoUrl) {
        super();
        this.stars = stars;
        this.date = date;
        this.verifiedPurchase = verifiedPurchase;
        this.manufacturerReplied = manufacturerReplied;
        this.username = username;
        this.userUrl = userUrl;
        this.title = title;
        this.review = review;
        this.reviewUrl = reviewUrl;
        this.totalFoundHelpful = totalFoundHelpful;
        this.images = images;
        this.variation = variation;
        this.videoUrl = videoUrl;
    }

    public Object getStars() {
        return stars;
    }

    public void setStars(Object stars) {
        this.stars = stars;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isVerifiedPurchase() {
        return verifiedPurchase;
    }

    public void setVerifiedPurchase(boolean verifiedPurchase) {
        this.verifiedPurchase = verifiedPurchase;
    }

    public boolean isManufacturerReplied() {
        return manufacturerReplied;
    }

    public void setManufacturerReplied(boolean manufacturerReplied) {
        this.manufacturerReplied = manufacturerReplied;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReviewUrl() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewUrl) {
        this.reviewUrl = reviewUrl;
    }

    public Object getTotalFoundHelpful() {
        return totalFoundHelpful;
    }

    public void setTotalFoundHelpful(Object totalFoundHelpful) {
        this.totalFoundHelpful = totalFoundHelpful;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public Variation__3 getVariation() {
        return variation;
    }

    public void setVariation(Variation__3 variation) {
        this.variation = variation;
    }

    public Object getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Review{" +
                "stars=" + stars +
                ", date='" + date + '\'' +
                ", verifiedPurchase=" + verifiedPurchase +
                ", manufacturerReplied=" + manufacturerReplied +
                ", username='" + username + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                ", reviewUrl='" + reviewUrl + '\'' +
                ", totalFoundHelpful=" + totalFoundHelpful +
                ", images=" + images +
                ", variation=" + variation +
                ", videoUrl=" + videoUrl +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.totalFoundHelpful == null)? 0 :this.totalFoundHelpful.hashCode()));
        result = ((result* 31)+((this.images == null)? 0 :this.images.hashCode()));
        result = ((result* 31)+(this.manufacturerReplied? 1 : 0));
        result = ((result* 31)+((this.stars == null)? 0 :this.stars.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.variation == null)? 0 :this.variation.hashCode()));
        result = ((result* 31)+((this.videoUrl == null)? 0 :this.videoUrl.hashCode()));
        result = ((result* 31)+(this.verifiedPurchase? 1 : 0));
        result = ((result* 31)+((this.reviewUrl == null)? 0 :this.reviewUrl.hashCode()));
        result = ((result* 31)+((this.review == null)? 0 :this.review.hashCode()));
        result = ((result* 31)+((this.userUrl == null)? 0 :this.userUrl.hashCode()));
        result = ((result* 31)+((this.username == null)? 0 :this.username.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Review) == false) {
            return false;
        }
        Review rhs = ((Review) other);
        return ((((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.totalFoundHelpful == rhs.totalFoundHelpful)||((this.totalFoundHelpful!= null)&&this.totalFoundHelpful.equals(rhs.totalFoundHelpful))))&&((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images))))&&(this.manufacturerReplied == rhs.manufacturerReplied))&&((this.stars == rhs.stars)||((this.stars!= null)&&this.stars.equals(rhs.stars))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.variation == rhs.variation)||((this.variation!= null)&&this.variation.equals(rhs.variation))))&&((this.videoUrl == rhs.videoUrl)||((this.videoUrl!= null)&&this.videoUrl.equals(rhs.videoUrl))))&&(this.verifiedPurchase == rhs.verifiedPurchase))&&((this.reviewUrl == rhs.reviewUrl)||((this.reviewUrl!= null)&&this.reviewUrl.equals(rhs.reviewUrl))))&&((this.review == rhs.review)||((this.review!= null)&&this.review.equals(rhs.review))))&&((this.userUrl == rhs.userUrl)||((this.userUrl!= null)&&this.userUrl.equals(rhs.userUrl))))&&((this.username == rhs.username)||((this.username!= null)&&this.username.equals(rhs.username))));
    }

}

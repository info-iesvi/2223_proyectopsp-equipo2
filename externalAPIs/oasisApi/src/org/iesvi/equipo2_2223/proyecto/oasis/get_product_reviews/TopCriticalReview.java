
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopCriticalReview {

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
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("total_found_helpful")
    @Expose
    private Object totalFoundHelpful;
    @SerializedName("images")
    @Expose
    private List<Object> images = new ArrayList<Object>();
    @SerializedName("variation")
    @Expose
    private Variation__2 variation;
    @SerializedName("videoUrl")
    @Expose
    private Object videoUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TopCriticalReview() {
    }

    /**
     * 
     * @param date
     * @param totalFoundHelpful
     * @param images
     * @param videoUrl
     * @param verifiedPurchase
     * @param review
     * @param manufacturerReplied
     * @param stars
     * @param title
     * @param variation
     * @param username
     */
    public TopCriticalReview(Object stars, String date, boolean verifiedPurchase, boolean manufacturerReplied, String username, String title, String review, Object totalFoundHelpful, List<Object> images, Variation__2 variation, Object videoUrl) {
        super();
        this.stars = stars;
        this.date = date;
        this.verifiedPurchase = verifiedPurchase;
        this.manufacturerReplied = manufacturerReplied;
        this.username = username;
        this.title = title;
        this.review = review;
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

    public Variation__2 getVariation() {
        return variation;
    }

    public void setVariation(Variation__2 variation) {
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
        return "TopCriticalReview{" +
                "stars=" + stars +
                ", date='" + date + '\'' +
                ", verifiedPurchase=" + verifiedPurchase +
                ", manufacturerReplied=" + manufacturerReplied +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
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
        result = ((result* 31)+((this.videoUrl == null)? 0 :this.videoUrl.hashCode()));
        result = ((result* 31)+(this.verifiedPurchase? 1 : 0));
        result = ((result* 31)+((this.review == null)? 0 :this.review.hashCode()));
        result = ((result* 31)+(this.manufacturerReplied? 1 : 0));
        result = ((result* 31)+((this.stars == null)? 0 :this.stars.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.variation == null)? 0 :this.variation.hashCode()));
        result = ((result* 31)+((this.username == null)? 0 :this.username.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TopCriticalReview) == false) {
            return false;
        }
        TopCriticalReview rhs = ((TopCriticalReview) other);
        return ((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.totalFoundHelpful == rhs.totalFoundHelpful)||((this.totalFoundHelpful!= null)&&this.totalFoundHelpful.equals(rhs.totalFoundHelpful))))&&((this.images == rhs.images)||((this.images!= null)&&this.images.equals(rhs.images))))&&((this.videoUrl == rhs.videoUrl)||((this.videoUrl!= null)&&this.videoUrl.equals(rhs.videoUrl))))&&(this.verifiedPurchase == rhs.verifiedPurchase))&&((this.review == rhs.review)||((this.review!= null)&&this.review.equals(rhs.review))))&&(this.manufacturerReplied == rhs.manufacturerReplied))&&((this.stars == rhs.stars)||((this.stars!= null)&&this.stars.equals(rhs.stars))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.variation == rhs.variation)||((this.variation!= null)&&this.variation.equals(rhs.variation))))&&((this.username == rhs.username)||((this.username!= null)&&this.username.equals(rhs.username))));
    }

}

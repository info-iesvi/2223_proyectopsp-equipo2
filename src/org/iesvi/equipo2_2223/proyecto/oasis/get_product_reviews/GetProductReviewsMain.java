
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductReviewsMain {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("count")
    @Expose
    private long count;
    @SerializedName("data")
    @Expose
    private List<GetProductReviewsData> data = new ArrayList<GetProductReviewsData>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductReviewsMain() {
    }

    /**
     * 
     * @param data
     * @param success
     * @param count
     */
    public GetProductReviewsMain(boolean success, long count, List<GetProductReviewsData> data) {
        super();
        this.success = success;
        this.count = count;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<GetProductReviewsData> getData() {
        return data;
    }

    public void setData(List<GetProductReviewsData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetProductReviewsMain{" +
                "success=" + success +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((int)(this.count^(this.count >>> 32))));
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+(this.success? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductReviewsMain) == false) {
            return false;
        }
        GetProductReviewsMain rhs = ((GetProductReviewsMain) other);
        return (((this.count == rhs.count)&&((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data))))&&(this.success == rhs.success));
    }

}

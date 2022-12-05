package org.iesvi.equipo2_2223.proyecto.oasis.get_product_search;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProductSearchResultsData {

    @SerializedName("ads")
    @Expose
    private List<Object> ads = new ArrayList<Object>();
    @SerializedName("amazons_choice")
    @Expose
    private List<Object> amazonsChoice = new ArrayList<Object>();
    @SerializedName("results")
    @Expose
    private List<GetProductSearchResultsDataBook> results = new ArrayList<GetProductSearchResultsDataBook>();
    @SerializedName("explore_more_items")
    @Expose
    private List<Object> exploreMoreItems = new ArrayList<Object>();
    @SerializedName("pagination")
    @Expose
    private List<String> pagination = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GetProductSearchResultsData() {
    }

    /**
     * 
     * @param ads
     * @param pagination
     * @param exploreMoreItems
     * @param amazonsChoice
     * @param results
     */
    public GetProductSearchResultsData(List<Object> ads, List<Object> amazonsChoice, List<GetProductSearchResultsDataBook> results, List<Object> exploreMoreItems, List<String> pagination) {
        super();
        this.ads = ads;
        this.amazonsChoice = amazonsChoice;
        this.results = results;
        this.exploreMoreItems = exploreMoreItems;
        this.pagination = pagination;
    }

    public List<Object> getAds() {
        return ads;
    }

    public void setAds(List<Object> ads) {
        this.ads = ads;
    }

    public List<Object> getAmazonsChoice() {
        return amazonsChoice;
    }

    public void setAmazonsChoice(List<Object> amazonsChoice) {
        this.amazonsChoice = amazonsChoice;
    }

    public List<GetProductSearchResultsDataBook> getResults() {
        return results;
    }

    public void setResults(List<GetProductSearchResultsDataBook> results) {
        this.results = results;
    }

    public List<Object> getExploreMoreItems() {
        return exploreMoreItems;
    }

    public void setExploreMoreItems(List<Object> exploreMoreItems) {
        this.exploreMoreItems = exploreMoreItems;
    }

    public List<String> getPagination() {
        return pagination;
    }

    public void setPagination(List<String> pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "GetProductSearchResultsData{" +
                "ads=" + ads +
                ", amazonsChoice=" + amazonsChoice +
                ", results=" + results +
                ", exploreMoreItems=" + exploreMoreItems +
                ", pagination=" + pagination +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.ads == null)? 0 :this.ads.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        result = ((result* 31)+((this.amazonsChoice == null)? 0 :this.amazonsChoice.hashCode()));
        result = ((result* 31)+((this.results == null)? 0 :this.results.hashCode()));
        result = ((result* 31)+((this.exploreMoreItems == null)? 0 :this.exploreMoreItems.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetProductSearchResultsData) == false) {
            return false;
        }
        GetProductSearchResultsData rhs = ((GetProductSearchResultsData) other);
        return ((((((this.ads == rhs.ads)||((this.ads!= null)&&this.ads.equals(rhs.ads)))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))))&&((this.amazonsChoice == rhs.amazonsChoice)||((this.amazonsChoice!= null)&&this.amazonsChoice.equals(rhs.amazonsChoice))))&&((this.results == rhs.results)||((this.results!= null)&&this.results.equals(rhs.results))))&&((this.exploreMoreItems == rhs.exploreMoreItems)||((this.exploreMoreItems!= null)&&this.exploreMoreItems.equals(rhs.exploreMoreItems))));
    }

}

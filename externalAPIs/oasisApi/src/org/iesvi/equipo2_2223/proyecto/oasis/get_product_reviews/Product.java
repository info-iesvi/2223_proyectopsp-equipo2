
package org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("variation")
    @Expose
    private Variation variation;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param image
     * @param price
     * @param name
     * @param brand
     * @param url
     * @param variation
     */
    public Product(String url, String name, String brand, Object price, String image, Variation variation) {
        super();
        this.url = url;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.variation = variation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Variation getVariation() {
        return variation;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }

    @Override
    public String toString() {
        return "Product{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", variation=" + variation +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.brand == null)? 0 :this.brand.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.variation == null)? 0 :this.variation.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return (((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.brand == rhs.brand)||((this.brand!= null)&&this.brand.equals(rhs.brand))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.variation == rhs.variation)||((this.variation!= null)&&this.variation.equals(rhs.variation))));
    }

}

package org.iesvi.equipo2_2223.proyecto;

import com.google.gson.*;
import org.iesvi.equipo2_2223.proyecto.oasis.get_product.GetProductMain;
import org.iesvi.equipo2_2223.proyecto.oasis.get_product_offers.GetProductOffersMain;
import org.iesvi.equipo2_2223.proyecto.oasis.get_product_reviews.GetProductReviewsMain;
import org.iesvi.equipo2_2223.proyecto.oasis.get_product_search.GetProductSearchResultsMain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Main class to test that the API works and can be parsed by Java code.
 */
public class OasisTest {
    private static final String API_BASE_URI = "oasis.p.rapidapi.com";
    private static final String API_RAPID_KEY = "1117b57b77msh51891e40e9c90bep1153c9jsn21e36566450e";
    private static final String API_AMAZON_KEY = "979b944caf59ed6d0e8b80c58cfb6de3";

    public static void main(String[] args) {
        String productId = "8448027256";
        String searchTerms = "books eurovision";

        GetProductMain product = getProductById(productId);
        System.out.println(product);

        GetProductOffersMain productOffers = getProductOffersById(productId);
        System.out.println(productOffers);

        GetProductReviewsMain productReviews = getProductReviewsById(productId);
        System.out.println(productReviews);

        GetProductSearchResultsMain productSearchResults = getProductSearchResults(searchTerms);
        System.out.println(productSearchResults);
    }

    /**
     * Get the information about a product.
     *
     * @param productId the ID of the product
     * @return a POJO of the endpoint response
     */
    private static GetProductMain getProductById(String productId) {
        String endpoint = "/products";
        String uri = "https://" + API_BASE_URI + endpoint + "/" + productId + "?apiKey=" + API_AMAZON_KEY;

        GetProductMain productMainObject = null;

        try {
            productMainObject = (GetProductMain) requestAndParseContents(GetProductMain.class, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productMainObject;
    }

    /**
     * Get the offers for a product.
     *
     * @param productId the ID of the product
     * @return a POJO of the endpoint response
     */
    private static GetProductOffersMain getProductOffersById(String productId) {
        String endpoint = "/products";
        String uri = "https://" + API_BASE_URI + endpoint + "/" + productId + "/offers?apiKey=" + API_AMAZON_KEY;

        GetProductOffersMain productOffersMainObject = null;

        try {
            productOffersMainObject = (GetProductOffersMain) requestAndParseContents(GetProductOffersMain.class, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productOffersMainObject;
    }

    /**
     * Get the reviews of a product.
     *
     * @param productId the ID of the product
     * @return a POJO of the endpoint response
     */
    private static GetProductReviewsMain getProductReviewsById(String productId) {
        String endpoint = "/products";
        String uri = "https://" + API_BASE_URI + endpoint + "/" + productId + "/reviews?apiKey=" + API_AMAZON_KEY;

        GetProductReviewsMain productReviewsMainObject = null;

        try {
            productReviewsMainObject = (GetProductReviewsMain) requestAndParseContents(GetProductReviewsMain.class, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productReviewsMainObject;
    }

    /**
     * Get a list of products based on a search string.
     *
     * @param searchTerms the words to use in the search
     * @return a POJO of the endpoint response
     */
    private static GetProductSearchResultsMain getProductSearchResults(String searchTerms) {
        GetProductSearchResultsMain searchResultsMainObject = null;

        try {
            searchTerms = URLEncoder.encode(searchTerms, StandardCharsets.UTF_8.toString());
            String endpoint = "/search";
            String uri = "https://" + API_BASE_URI + endpoint + "/" + searchTerms + "?apiKey=" + API_AMAZON_KEY;

            searchResultsMainObject = (GetProductSearchResultsMain) requestAndParseContents(GetProductSearchResultsMain.class, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResultsMainObject;
    }

    /**
     * Auxiliary method to call an endpoint and transform the JSON response
     * into the POJO specified in the parameters.
     * It also removes some strange characters observed in the Postman testing.
     *
     * @param transformClass the POJO class into which our data should go
     * @param uri the address of the endpoint to call
     * @return the data transformed into a POJO
     * @throws IOException an exception if the contents of the response cannot be read
     */
    private static Object requestAndParseContents(Class transformClass, String uri) throws IOException {
        InputStreamReader inputStreamReader = makeGetRequestToUrl(uri);

        // map to GSON objects
        JsonElement root = JsonParser.parseReader(inputStreamReader);
        JsonObject object = root.getAsJsonObject();

        String contents = object.toString().replaceAll(" \u200F", "").replaceAll("\u200E", "").trim();
        return new Gson().fromJson(contents, transformClass);
    }

    /**
     * Auxiliary method to call an endpoint and return the response stream.
     *
     * @param uri the address to call
     * @return a stream reader built from the response to our call
     * @throws IOException an exception if the request cannot be made
     */
    private static InputStreamReader makeGetRequestToUrl(String uri) throws IOException {
        // make the GET request
        URL address = new URL(uri);
        URLConnection request = address.openConnection();
        request.addRequestProperty("X-RapidAPI-Key", API_RAPID_KEY);
        request.addRequestProperty("X-RapidAPI-Host", API_BASE_URI);
        request.connect();

        return new InputStreamReader((InputStream) request.getContent(), StandardCharsets.UTF_8);
    }
}

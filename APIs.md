# APIs for our project
In this document, we will talk about some tested APIs that we think might work in our project.

## Oasis API
Oasis API allows you to select the specific data you want from the Amazon website in a JSON format and use it to create your own personal Amazon clone or any E-commerce application. It only has 4 GET endpoints, so while it is not a complete REST API (that is, it doesn't make use of the POST, PUT, or DELETE verbs), it doesn't violate the principles of REST APIs, because it uses the GET method to query the Amazon database as is expected.
<br>The query methods are:
- GET Amazon Product Offers
- GET Amazon Product Reviews
- GET Amazon Product Search Results
- GET Amazon Product Info

This API operates from **oasis.p.rapidapi.com**, the fixed side of the address that will be present in all endpoint calls.

All endpoints in this API must have the following headers:
- X-RapidAPI-Key: a fixed value which identifies a client authorized to call RapidAPI.
- X-RapidAPI-Host: the host address of the API within the RapidAPI provider.

All endpoints must also submit the following parameter:
- apiKey: a fixed value which identifies a client authorized to call Amazon.

### GET Amazon Product Offers
This endpoint returns offers for a specific product on Amazon. It works by entering the product id.
The endpoint address would be: _products/{{productId}}/offers?apiKey={{amazonToken}}_

![image](https://user-images.githubusercontent.com/98974760/201979644-305ffb7d-ffd1-4330-a436-e57fdf684e67.png)

This endpoint must submit the product identifier for which we want to get information as part of the endpoint address.


### GET Amazon Product Reviews
This endpoint provides reviews of a specific product on Amazon. It works by entering the product id.
The endpoint address would be: _products/{{productId}}/reviews?apiKey={{amazonToken}}_

![image](https://user-images.githubusercontent.com/98974760/201980608-da398a9c-1332-4b55-b518-43bff478dd3f.png)

This endpoint must submit the product identifier for which we want to get information as part of the endpoint address.


### GET Amazon Product Search Results
This endpoint gets search results entering a keyword.
The endpoint address would be: _search/{{queryString}}?apiKey={{amazonToken}}_

![image](https://user-images.githubusercontent.com/98974760/201982464-4723380b-8615-48dd-b1a8-ddaccddfebe5.png)

This endpoint must submit the search query string as part of the endpoint address (for example, search/hello%20book?parameter=value), and the string must be URLEncoded (spaces and other characters transformed).


### GET Amazon Product Info
This endpoint gets details (e.g. images, price, reviews, etc.) about a specific product on Amazon. It works by entering the product id.
The endpoint address would be: _products/{{productId}}?apiKey={{amazonToken}}_

![image](https://user-images.githubusercontent.com/98974760/201982540-382d6c4e-957e-4faf-bde2-fd089cd5adba.png)

This endpoint must submit the product identifier for which we want to get information as part of the endpoint address.

## API Testing
A simple test involving POJOs has been designed to check that the API endpoints return values and can be read/printed from Java code.
Opening the IntelliJ project, one can run the main method inside the OasisTest class, and it will call the 4 API methods, as well as printing
their results with a regular toString call.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Quotes API
QUOTES API allows to randomly display a famous phrase from a registered author. It has only a GET method and, as with the previous api, it is not a full REST API either; nor does it violate the principles of REST APIs because it uses the GET method to query the database.
<br>The query method is:
- GET Random quote
- This API operates from **oasis.p.rapidapi.com**, the fixed side of the address that will be present in all endpoint calls.

All endpoints in this API must have the following headers:
- X-RapidAPI-Key: a fixed value which identifies a client authorized to call RapidAPI.
- X-RapidAPI-Host: the host address of the API within the RapidAPI provider.

It can also have an optional parameter called languague_code, which allows to extract the quote in several languages (English [en], Spanish [es], Portuguese [pt], Italian [it], German [de], French [fr], Czech [cs] and Slovak [sk]). If none is selected, the sentences will be in English by default.

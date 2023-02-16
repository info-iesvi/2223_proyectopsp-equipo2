# [ISSUE 1] ANALYSIS 1

## ANALYSIS. PROBLEM DEFINITION
The aim is to create a website for the sale of books, with specialized or rare titles that are difficult to find in any other online shop or bookshop, 
in order to meet the demand for this type of product.

## ANALYSIS. FUNCTIONAL REQUIREMENTS. USE CASES

### Functionalities

#### Customer User
- **Sign up**: An unregistered user, by clicking on the "Sign up" button, accesses a form in which he/she enters his/her data and, by clicking on "Send", 
    the system will save said data in the shop's database for this purpose. Once the user has registered, he/she can access the rest of the website's functionalities.
- **Login**: The user, once registered, can click on the "Login" button to access the website again on successive occasions. 
    This gives the user access to the profile and the rest of the shop.
- **Consult catalogue**: Once logged in, the user can consult the catalog of articles by typing directly into the text box what they are looking for 
    or by using the filters by title, author or publisher. Once they have found what they are looking for, they can put it in the shopping cart or mark the article as a favorite to buy it at a later date.
- **Buy item**: A logged-in user can also add items to the shopping cart, once the enquiry has been made, and finalize the purchase by choosing a valid payment method.
- **Leave a rating**: Once the user has purchased a product, he/she will be able to leave a review of it. In the profile a person can consult, in the corresponding tab, 
    all the reviews he/she has made.
- **Modify data**: By logging into the profile, the user can modify his or her data (e.g. address or telephone number).
- **Unsubscribe**: An user could unsubscribe from the website, thereby ceasing to be able to access the functionalities offered by the website. To regain access, 
    the user would have to re-register with a new username and password and re-enter their details.

#### Admin User
- **Login**: As a user, the web administrator, in order to access the functionalities of the website, will have to log in. To do this, 
    he/she must already be registered in the system, but not as a client user (with the form that appears on the main screen of the website), but internally.
- **Register an item**: As a user, the admin can perform the same functions as the Client, but as Administrator, he/she has other specific functions, 
    such as registering an article in the system by entering its data in the Warehouse database.
- **Deregister an item**: The administrator can also cancel an item because it is out of stock or will no longer be sold in the shop.
- **Modify item**: In addition, the administrator will be able to count the stock and modify the quantity of products remaining in the warehouse, 
    as well as make modifications to the articles themselves that undergo any type of change.

### Use Cases
#### Users
1. **Sign up**

![image](https://user-images.githubusercontent.com/98974760/215835262-b577ce93-de99-44ee-896e-5e56ba136dab.png)

2. **Login**

![image](https://user-images.githubusercontent.com/98974760/215835483-47394291-2fe2-4dd0-90d5-9fc78f674e4b.png)

3. **Modify data**

![image](https://user-images.githubusercontent.com/98974760/215835629-6306f6c3-9ab6-49e2-b231-40a676f07af8.png)

4. **Unsubscribe**

![image](https://user-images.githubusercontent.com/98974760/215835815-58ef89a6-ee12-4317-b1ee-d717786f8af7.png)

5. **View user list**

![image](https://user-images.githubusercontent.com/98974760/215836039-c88b3a7c-7558-4fc0-9137-55e844709241.png)

### Use case diagram
![CasosUso](https://user-images.githubusercontent.com/98974760/215837210-f97e30e8-0566-407c-8153-6c24edb39d39.png)

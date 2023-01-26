# [ISSUE 6] CODING 2

## CODING BOOK AND AUTHOR ENTITIES

Once the user management has been codified, in this second sprint we have considered codifying the management of books and their authors, creating for this the two entities with their corresponding controllers, their DTOs, and their Service layers.

The Service layer serves as an intermediary between the Repository layer and the Controller layer, therefore performing the conversion to DTO in it, thanks to the Converter class.

For example, we can see how the following classes are distributed in different layers of the MVC model:
- Author (domain)
- AuthorDTO (infra.dto)
- AuthorDTOConverter (infra.dto.converter)
- AuthorService (service)
- AuthorController (infra.controller)
- AuthorRepository (persistence)

![authorManagement](https://user-images.githubusercontent.com/98974760/212562982-cde63b36-a502-458c-97de-59f5134db5a3.PNG)

Only one DTO per Entity has been used, with the attributes of the same that we want to be displayed on the screen. In the DTOConverter of each Entity we have codified each one of the necessary methods in the Service layer to make said conversions.

![authorDTO](https://user-images.githubusercontent.com/98974760/212562991-cf4f74aa-8527-4d15-bbfe-a8604e0f805a.PNG)

## TESTING WITH POSTMAN

To test that all the Service layer methods work, we have used Postman with the following results:

### AUTHOR

#### CREATING A NEW AUTHOR

![image](https://user-images.githubusercontent.com/98974760/212563205-9d6d553c-b740-4eb8-9a74-58299055879a.png)

#### LIST ALL AUTHORS 

![image](https://user-images.githubusercontent.com/98974760/212563219-3b08bb2f-52f7-46e7-9952-d44ede6ab970.png)

#### LIST ONE AUTHOR

![image](https://user-images.githubusercontent.com/98974760/212563234-c1bab79e-f9a3-47ec-9008-42ba9ce864c3.png)

#### EDIT AN AUTHOR

![image](https://user-images.githubusercontent.com/98974760/212563248-b8534cdd-384a-4cc8-9061-f8a703427b56.png)

#### DELETE AN AUTHOR

![image](https://user-images.githubusercontent.com/98974760/212563260-71e45e15-0b24-422d-b24a-8d69dcd1ddc3.png)


### BOOK

The Book entity is linked to the Author entity, the latter being an attribute of the former. Therefore, the 'author' attribute is the foreign key of the book.

# [ISSUE 6] CODING 2

Once the user management has been codified, in this second sprint we have considered codifying the management of books and their authors, creating for this the two entities with their corresponding controllers, their DTOs, and their Service layers.

The Service layer serves as an intermediary between the Repository layer and the Controller layer, therefore performing the conversion to DTO in it, thanks to the Converter class.

For example, we can see how the following classes are distributed in different layers of the MVC model:
- Author (domain)
- AuthorDTO (infra.dto)
- AuthorDTOConverter (infra.dto.converter)
- AuthorService (service)
- AuthorController (infra.controller)
- AuthorRepository (persistence)

[img]

Only one DTO per Entity has been used, with the attributes of the same that we want to be displayed on the screen. In the DTOConverter of each Entity we have codified each one of the necessary methods in the Service layer to make said conversions.

[img]

## TESTING WITH POSTMAN

To test that all the Service layer methods work, we have used Postman with the following results:

### AUTHOR

#### CREATING A NEW AUTHOR


#### LIST ALL AUTHORS 


#### LIST ONE AUTHOR


#### EDIT AN AUTHOR


#### DELETE AN AUTHOR



### BOOK

The Book entity is linked to the Author entity, the latter being an attribute of the former. Therefore, the 'author' attribute is the foreign key of the book.
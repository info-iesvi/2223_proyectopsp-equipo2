# Issue 7
In a monolithic architecture, all entities are within the same project. In our case, we use an MVC (Model-View-Controller) structure; the folder structure separates the classes of the model (domain) from those of the controller (controller), the DTO (dto) and those related to the repository (persistence) or the services (service).
This structure is replicated with each of the entities that form part of the API developed (book, author, user), as well as in another folder (share) where those classes that are not specific to an entity are included.

![image](https://user-images.githubusercontent.com/58866375/216818408-40481c87-458f-452b-a5c4-048773d14993.png)

On the other hand, a microservices architecture proposes that all these entities are now developed in their own project individually, with the same folder structure they already had, but this time separately.

![image](https://user-images.githubusercontent.com/58866375/216818422-e1349ed3-ddf5-4136-b3fa-70fae6f3ce2c.png)

## Properties
The properties file has the same structure in the three microservices, as all three link to the same database. Below, we show an image with the content of this file:

![image](https://user-images.githubusercontent.com/58866375/216818065-82e809e4-65cd-4417-80b5-83f216fd66cc.png)

If you click on the following links, you will see the application properties file of each other:
- [Author](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/ISARA-microservices/author/src/main/resources/application.properties)
- [Book](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/ISARA-microservices/book/src/main/resources/application.properties)
- [User](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/ISARA-microservices/user/src/main/resources/application.properties)

As we can see, the server port is the same in the three microservices, however, if we look at the docker-compose file, we can see that each of them listens on a different port.

## Testing
### List all address
![listAllAddress](https://user-images.githubusercontent.com/58866375/216816683-632840b8-fea0-4592-8f8b-373f64697220.PNG)

### Create a new user
![createNewUser](https://user-images.githubusercontent.com/58866375/216816685-b89ffcab-d19a-4f0f-8724-de61a226da1b.PNG)

### Delete an author by ID
![deleteAnAuthorById](https://user-images.githubusercontent.com/58866375/216816691-93e09186-300a-44ae-8ef5-9a0a3ddf81de.PNG)

### Edit a book by ID
![editBookById](https://user-images.githubusercontent.com/58866375/216816702-59cbc999-f994-481b-aac5-543a2efd4457.PNG)

### Get an user by ID
![getAuserById](https://user-images.githubusercontent.com/58866375/216816711-561fa557-a074-4b8a-9985-64465b40421e.PNG)

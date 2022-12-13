# [ISSUE 3] CODING 1
In this first iteration in the development of the app we are going to start coding the CUs related only to the management of the users.

We are going to code following the Clean Architecture model (controller, service, repository), although, for now, we will simplify it by eliminating the Service layer as they are CRUD operations that only require access to the database and therefore no more business logic is developed than the access to the database itself to respond to the requests received by the controller.


## WEB PROGRAMMING PARADIGM: REST.
We have implemented a controller that manages the functionalities on the User entity of the application, another for the UserAdmin entity and another for UserCustomer.


### Annotations used in the controller.
The annotations that we have used in these controllers are the following:
- **@RestController**: Annotation to identify the controller.
- **@RequiredArgsConstructor**: Generates a constructor with any special arguments that the class has, such as those that are final or those marked as @NotNull.
- **@RequestMapping("/isara")**: Annotation that is responsible for relating a method or a class, as in this case, with an http request.

![image](https://user-images.githubusercontent.com/98974760/207098698-156c6450-6eee-4a33-95a6-e931ad6ff6a7.png)

- **@GetMapping**: Annotation to map HTTP GET requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping. In these controllers it is used to list users or to display a user by id. It is also used in the Address controller.

![image](https://user-images.githubusercontent.com/98974760/207100731-afd81b58-25fd-4533-bf1d-f7a04ce64c6b.png)
![image](https://user-images.githubusercontent.com/98974760/207100825-dd899b1e-4e01-41aa-90c2-66d46f3e692e.png)

- **@PostMapping**: Annotation to map POST HTTP requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping. In these controllers it is used to create new users or addresses.

![image](https://user-images.githubusercontent.com/98974760/207101156-1124d3ae-c9e7-46d6-8975-5d60cdf2b965.png)

- **@PutMapping**: Annotation to map HTTP PUT requests to specific controller methods. It is a compound annotation that acts as a shortcut for @RequestMapping. In these controllers it is used to modify existing users or addresses.

![image](https://user-images.githubusercontent.com/98974760/207101463-fdf7513d-e329-4194-87ce-f7f1ebac4950.png)

- **@DeleteMapping**: Annotation to map HTTP DELETE requests to specific controller methods. It is a composite annotation that acts as a shortcut for @RequestMapping. In these controllers it is used to delete existing users or addresses.

![image](https://user-images.githubusercontent.com/98974760/207101704-77867ce8-798b-42d1-b9bd-842287fdf59e.png)

- **@PathVariable**: This annotation is used to set the input parameter of the HTTP request.

![image](https://user-images.githubusercontent.com/98974760/207102954-19577ab9-f864-44c0-bd47-584ad31e3223.png)

- **@RequestBody**: This annotation is used to capture the input data in the body of the HttpRequest, which will be sent by the client in JSON format.

![image](https://user-images.githubusercontent.com/98974760/207103144-3ff06f7e-bc6d-457a-aa0b-4c84b8916757.png)

- **@Autowired**: Annotation that allows to inject some dependencies with others inside Spring.

![image](https://user-images.githubusercontent.com/98974760/207104259-9893bdf1-a6ab-45bd-8f57-ac3017ce1f12.png)
	

### Object declaration to achieve layer decoupling through dependency injection.


### Testing with Postman
The Postman tool has been used to test the CRUD methods created for both User and UserAddress.
1. **Create a new user**: Enter the username, password and email of the new user. This method would correspond to "Sing up".

![image](https://user-images.githubusercontent.com/98974760/206924063-c7f7a745-4a74-4ea8-9428-175b58c130f7.png)

2. **List all users**: This method lists all the users that are saved in the repository with all their data.

![image](https://user-images.githubusercontent.com/98974760/206924171-d8d848f3-be86-4d3a-9c4f-b5754755c427.png)

3. **List a user by id**: Enter the identifier of the user you want to search for and display the user's data, if it exists in the repository.

![image](https://user-images.githubusercontent.com/98974760/206924242-2b4dfe79-1505-4357-98b0-8b2a326dc86d.png)

4. **Create a new address**: Enter the data of the new address to be saved in the repository.

![image](https://user-images.githubusercontent.com/98974760/206924290-006ae2ae-61f9-45f3-9edf-f26e9f55747e.png)

5. **Edit user by id**: Enter the data of the user searched for by id that you want to change, including the address that can be entered either through the id of one that already exists or by entering all the data, if it does not exist yet, leaving these new data saved in the address repository.

![image](https://user-images.githubusercontent.com/98974760/206924336-51d7c0f3-0721-4ff6-b532-ecfa009100b4.png)
![image](https://user-images.githubusercontent.com/98974760/206924424-07198b40-b5df-4106-9b7f-88b41a380805.png)

6. **List all address**: This method lists all the address that are saved in the repository with all their data.

![image](https://user-images.githubusercontent.com/98974760/206924464-6ed2fd8d-d990-4090-8ea1-55981f175ea7.png)

7. **Delete user by id**: Enter the id of the user you want to delete. If it exists in the repository, it is removed and the status 204 No Content appears; if it does not exist, the status 404 Not Found appears.

![image](https://user-images.githubusercontent.com/98974760/206924492-bbd0bbea-6092-47ce-afb9-6eba459908e0.png)

8. **Delete address by id**: Enter the id of the address you want to delete. If it exists in the repository, it is removed and the status 204 No Content appears; if it does not exist, the status 404 Not Found appears.

![image](https://user-images.githubusercontent.com/98974760/206924700-3f6c5116-6e90-410c-8509-deef51a4fed6.png)


### ResponseEntity
ResponseEntity represents the complete HTTP response: status code, headers, and body. We have used the following responses:
- **200 OK**: Indicates that the request has been successful, either by listing the users, showing the data of a specific one or editing it.
- **201 Created**: Indicates that the request has been successful, and has performed the creation of the new object.
- **204 No Content**: Indicates that the delete request was successful, but the client does not receive a response.
- **404 Not Found**: Indicates that no result has been found, because the data has been entered incorrectly or because the database is empty.

This has been used in controllers (see code).


### DTO classes
Several DTO classes have been made for each entity. These are:
- **UserDTO** and **UserAdminDTO**
- **CreateUserDTO** and **CreateUserAdminDTO** to create a new user.
- **UpdateUserDTO** and **UpdateUserAdminDTO** to modify a specific user by id.
- **UserDTOConverter**, **UserAdminDTOConverter** and **AddressDTOConverter** to parse from User (or UserAdmin or UserAddress) to UserDTO (or UserAdminDTO or AddressDTO).
- **AddressDTO** to create a new address or to modify a specific address by id.


## REPOSITORY LAYER
### JPA for data persistence
The model annotations that allow persistence in JPA are those used in the User, UserAdmin, and UserCustomer classes. That is, @Entity, @Id, @GeneratedValue, @Column, @ManyToOne and @JoinColumn.
- **@Entity**: Defines the entities that are going to be persisted in the database, corresponding to a table of the same, and their attributes with the columns.

![image](https://user-images.githubusercontent.com/98974760/207414736-06aa7f4e-3aaa-47a5-8e7a-a29358969d97.png)

- **@Id**: All classes with the @Entity annotation have to carry the @Id in a mandatory way, this being the attribute taken as the identifier of the entity.

![image](https://user-images.githubusercontent.com/98974760/207414824-eb468292-e772-48f5-b14d-f32e541c9eae.png)

- **@GeneratedValue**: Defines the primary key. You can put the strategy attribute to tell it to auto-generate, for example.

![image](https://user-images.githubusercontent.com/98974760/207415378-6058af58-d57c-41d1-a116-1748f62413ef.png)

- **@Column**: With this annotation you can define such important aspects of the database columns as name, length, restrictions, etc. In case of not defining this annotation in the attributes, JPA will determine the name of the column automatically through the name of the attribute. In this case, it has only been defined to be non-nullable.

![image](https://user-images.githubusercontent.com/98974760/207414824-eb468292-e772-48f5-b14d-f32e541c9eae.png)

- **ManyToOne**: Relates two entities to each other, with a many-to-one relationship.
- **@JoinColumn**: It is used to indicate a foreign key, that is, that through the attribute you are joining two entities.

![image](https://user-images.githubusercontent.com/98974760/207416419-73e7c523-0493-437f-8980-eab3c7e7ce42.png)


The Maven dependency used that allows JPA to be available is the following:

	<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>

### Database managers
The configuration of the connection with the different databases is done in the "application.properties". There you specify the server port (if it is different from the 8080 that Tomcat uses by default), the username and password, and a number of other settings, depending on the chosen database.

#### H2
![image](https://user-images.githubusercontent.com/98974760/207419346-c6a5b90d-dbd8-4151-8953-8a8edcd2876f.png)

![image](https://user-images.githubusercontent.com/98974760/207419651-85b62142-c6ba-4ae0-a5d0-ab9378aa1b7a.png)

![image](https://user-images.githubusercontent.com/98974760/207420737-8a57d9e8-d4fb-4f29-8961-d5bab08398d2.png)

![image](https://user-images.githubusercontent.com/98974760/207420921-c1fa6208-d559-4b72-bf49-084e44f4251e.png)

#### MySQL

#### PostgresSQL

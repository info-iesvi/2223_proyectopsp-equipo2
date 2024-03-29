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
	

### Other annotations.
- **@SpringBootApplication**: This is an annotation that executes other 3 autoconfiguration with their default values: _@EnableAutoConfiguration, @ComponentScan_ and _@Configuration_.

![image](https://user-images.githubusercontent.com/98974760/207429725-772a17ea-0214-47c1-b26d-14c98c587b9e.png)

- **@Data**: It's a Lombok's annotation that creates _toString_, _equalsAndHashCode_, _getters_ and _setters_ and the _RequiredArgsConstructor_ too.

![image](https://user-images.githubusercontent.com/98974760/207429887-20fb9f90-ae2a-4f3b-b53d-3ed5dd0550b8.png)

- **@Getter and @Setter**: A default getter returns the field, and if, for example, it is called _getEmail_ if the field is called email; and a default setter is called _setEmail_ if the field is called email it returns void, and takes a parameter of the same type as the field.

![image](https://user-images.githubusercontent.com/98974760/207429950-b4bbf878-9a94-4be0-995a-f3dbbcda5a58.png)

- **@AllArgsConstructor**: It generates the constructor with all the arguments.
- **@NoArgsConstructor**: It generates the constructor without arguments.
- **@Inheritance(strategy = InheritanceType.JOINED)**: It's an annotation used to mark an annotation to be inherited to subclasses of the annotated class.

![image](https://user-images.githubusercontent.com/98974760/207430050-b4a63112-ef09-478d-8704-fcbb90268afb.png)


### Object declaration to achieve layer decoupling through dependency injection.
In the following classes, we declarate objects to achieve layer decoupling through dependency injection: _UserController_, _UserAdminController_ and _UserAddressController_. The reason we do this is to be able to perform CRUD operations as we can see in the following image:

![image](https://user-images.githubusercontent.com/58866375/207930462-9ed61c7a-5b75-4078-9212-079caecca5af.png)


### Testing with Postman
The Postman tool has been used to test the CRUD methods created for both User and UserAddress.
1. **Create a new user**: Enter the username, password and email of the new user. This method would correspond to "Sing up".

![image](https://user-images.githubusercontent.com/98974760/206924063-c7f7a745-4a74-4ea8-9428-175b58c130f7.png)

2. **List all users**: This method lists all the users that are saved in the repository with all their data.

![image](https://user-images.githubusercontent.com/98974760/206924171-d8d848f3-be86-4d3a-9c4f-b5754755c427.png)

3. **List a user by id**: Enter the identifier of the user you want to search for and display the user's data, if it exists in the reposit
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

To make the conversion to DTO, the ModelMapper pattern has been used, which is a Java library to map properties from one type of object to another, so for example we can transform a User into UserDTO.

![image](https://user-images.githubusercontent.com/98974760/207697287-4137d05f-2a5a-44e7-a000-5fd85185572f.png)


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

JPA methods can be used, even if they are not declared, because the repository interfaces extend from JPARespository.

The Maven dependency used that allows JPA to be available is the following:

	<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>

### Database managers
The configuration of the connection with the different databases is done in the _application.properties_. There you specify the server port (if it is different from the 8080 that Tomcat uses by default), the username and password, and a number of other settings, depending on the chosen database.

#### H2
**H2** is a relational database and works like an in-memory database, that is, it doesn't save changes from session to session. To start it, it is necessary to have configured the use of the h2-console in the _application.properties_ and, after starting our application, write in a browser _http://localhost:8083/h2-console_. Then the screen shown in the following image will appear, in which you will have to fill in the fields with the username, password and the url of the database defined in the same _application.properties_.

![image](https://user-images.githubusercontent.com/98974760/207419346-c6a5b90d-dbd8-4151-8953-8a8edcd2876f.png)

Several tests have been carried out to verify that the application works, so three new users have been added, then the first one has been modified, and finally the third one has been eliminated.

![image](https://user-images.githubusercontent.com/98974760/207419651-85b62142-c6ba-4ae0-a5d0-ab9378aa1b7a.png)

![image](https://user-images.githubusercontent.com/98974760/207420737-8a57d9e8-d4fb-4f29-8961-d5bab08398d2.png)

![image](https://user-images.githubusercontent.com/98974760/207420921-c1fa6208-d559-4b72-bf49-084e44f4251e.png)

#### MySQL
The Maven dependency used to make the connection to MySQL is as follows:

	<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
	
To configure the connection with MySQL, firstly a volume and a container have been created in DOCKER.

![proyecto-mysql](https://user-images.githubusercontent.com/98974760/207919510-979a1262-50b3-425b-81e4-b2ef776d3c1c.png)

In addition, the lines seen below have been included in the application.properties. It includes the MySQL Driver, the url of the database, the 'root' user and its password.

![image](https://user-images.githubusercontent.com/98974760/207919722-aa8c6ff4-ab53-4376-a393-6716566bd867.png)

We are asked to create a user other than root. With the following commands, written directly in the console, we have created it, with a password and giving it all the privileges.

![proyecto-mysql_crearUsuario](https://user-images.githubusercontent.com/98974760/207920452-a953aab5-cae4-4ded-ba71-36fdefe54e48.png)

Next, in addition to creating the database, the application has been started to verify that the tables are created without problem.

![proyecto-mysql_crearBD](https://user-images.githubusercontent.com/98974760/207920722-51c0e50a-8528-4f06-b7be-51051fb9d332.png)

And finally several test users have been introduced, one of them has been modified and it has been verified that the changes have been saved in the database.

![image](https://user-images.githubusercontent.com/98974760/207921880-c5a93c36-8a4d-43a8-a8e3-afcc112dabcd.png)


#### PostgresSQL
The Maven dependency used to make the connection to PostgresSQL is as follows:

	<dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.4.3</version>
        </dependency>

To configure the connection with PostgreSQL, firstly a volume and a container have been created in DOCKER.

![proyecto-postgresql](https://user-images.githubusercontent.com/98974760/207940881-3440b888-46c9-435f-92e1-637236e906ed.png)

In addition, the lines seen below have been included in the application.properties. It includes the PostgreSQL Driver and the url of the database.

![proyecto-postgresql_properties](https://user-images.githubusercontent.com/98974760/207941044-5d6cb580-973d-4f23-9a84-eccc2071666a.png)

Next, in addition to creating the database, the application has been started to verify that the tables are created without problem.

![proyecto-postgresql_tablas](https://user-images.githubusercontent.com/98974760/207941155-99c4ba09-c916-4286-86e4-9949ee46efb9.png)

And finally several test users have been introduced, one of them has been modified and it has been verified that the changes have been saved in the database.

![proyecto-postgresql_prueba](https://user-images.githubusercontent.com/98974760/207941223-337ced45-3fcf-4d95-bf94-270f9319a0bc.png)

![image](https://user-images.githubusercontent.com/98974760/208094100-33248c05-c25c-496b-bb8a-14ba7def650d.png)


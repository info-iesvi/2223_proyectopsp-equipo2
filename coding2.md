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


## DOCKERISING THE PROJECT

### PHASE 1. DOCKERISE THE DATABASE SERVICE

Using the following command, we create a container in Docker with MySQL, where we specify the password of the user 'root', the user 'usuario' and its password, as well as the database 'proyecto'.
`$ docker run -p 3306:3306 --name proyecto-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=usuario -e MYSQL_PASSWORD=usuario -e MYSQL_DATABASE=proyecto -v proyecto-mysql_data:/var/lib/mysql -d mysql:latest`

![image](https://user-images.githubusercontent.com/98974760/212563524-d450aa55-2466-4f21-8664-3e00aa695f5f.png)

Then we check that it has been created correctly in Docker Desktop:

![image](https://user-images.githubusercontent.com/98974760/212563536-85cb47b1-1c49-4f44-a987-00bbbdaad149.png)

#### Connection from the container

We test from the console if we can connect with the 'user' and we check the databases to which it has access, all with the following command.

`$ docker exec -it proyecto-mysql /bin/bash`

![image](https://user-images.githubusercontent.com/98974760/212563954-8c61459b-9de9-46de-a1d6-ae526cf24bf3.png)

`# mysql -u usuario -p -h localhost`

At this time, it asks us for the password. We introduce it to him and he already lets us in. And with the `show databases;` command we can check all the databases that the user has access to.

![image](https://user-images.githubusercontent.com/98974760/212563975-4cc318dd-85b8-4fea-820f-9110bb4feb73.png)

We look at the 'project' database with the `use project;` command and then check the tables it has created with the `show tables;` command.
As it is the first time we enter this database, after creating it, we see that it is empty.

![image](https://user-images.githubusercontent.com/98974760/212564081-101e92de-784b-480f-ab49-dcc71c5dd4a6.png)

### PHASE 2. DOCKERISE THE APPLICATION


### PHASE 3. DEFINITION AND IMPLEMENTATION OF A MULTI-CONTAINER APP


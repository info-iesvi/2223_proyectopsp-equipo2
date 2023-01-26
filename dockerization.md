# DOCKERISING THE PROJECT

## PHASE 1. DOCKERISE THE DATABASE SERVICE

Using the following command, we create a container in Docker with MySQL, where we specify the password of the user 'root', the user 'usuario' and its password, as well as the database 'proyecto'.

`$ docker run -p 3306:3306 --name proyecto-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=usuario -e MYSQL_PASSWORD=usuario -e MYSQL_DATABASE=proyecto -v proyecto-mysql_data:/var/lib/mysql -d mysql:latest`

![image](https://user-images.githubusercontent.com/98974760/212563524-d450aa55-2466-4f21-8664-3e00aa695f5f.png)

Then we check that it has been created correctly in Docker Desktop:

![image](https://user-images.githubusercontent.com/98974760/212563536-85cb47b1-1c49-4f44-a987-00bbbdaad149.png)

### Connection from the container

We test from the console if we can connect with the 'user' and we check the databases to which it has access, all with the following command.

`$ docker exec -it proyecto-mysql /bin/bash`

![image](https://user-images.githubusercontent.com/98974760/212563954-8c61459b-9de9-46de-a1d6-ae526cf24bf3.png)

`# mysql -u usuario -p -h localhost`

At this time, it asks us for the password. We introduce it to him and he already lets us in. And with the `show databases;` command we can check all the databases that the user has access to.

![image](https://user-images.githubusercontent.com/98974760/212563975-4cc318dd-85b8-4fea-820f-9110bb4feb73.png)

We look at the 'project' database with the `use project;` command and then check the tables it has created with the `show tables;` command.
As it is the first time we enter this database, after creating it, we see that it is empty.

![image](https://user-images.githubusercontent.com/98974760/212564081-101e92de-784b-480f-ab49-dcc71c5dd4a6.png)

## PHASE 2. DOCKERISE THE APPLICATION

Whenever we want to generate a new version of our image, we will need to change the version
in the POM file, where we will see something like ``<version>0.2.0</version>``, and in
the Dockerfile where we must change the JAR filename in something like ``ADD isara-0.2.0.jar app.jar``.

Versioning should be done in the following way:
- Major versions (A.y.z): Planned upgrades that happen only when very big changes happen, like API signatures changing or different behaviours for established services.
- Minor versions (x.A.z): Planned patches that happen with bug fixes or minor corrections that don't make a big difference in how the application behaves.
- Revisions (x.y.A): Unplanned modifications, should be very small changes, documentation additions, and any non-planned or emergency "hotfixes" that don't follow a rigid protocol for change.

After the version change, we should run the command ``mvn clean package`` so that the application is built and the image is compiled for use in Docker.
If any errors happen, details can be viewed adding `` -e`` to the Maven command from before.

The process may break in a first run, it will probably happen because Maven is missing the JAR file in the Docker context.

![image](https://user-images.githubusercontent.com/98974760/213020455-9f92edb0-0438-440a-b3c3-0e907705f8bc.png)

To solve this, copy the JAR file generated in the first run (target/isara-x.x.x.jar) into the folder src/main/docker and run the Maven command again.

Once we get a successful build, we can instantiate our application in Docker, with the steps described in Phase 3.

![image](https://user-images.githubusercontent.com/98974760/213020006-00c62597-2d61-4df3-a5ba-d9fda5649d38.png)


## PHASE 3. DEFINITION AND IMPLEMENTATION OF A MULTI-CONTAINER APP

Config values stored in ``.env`` file. Different environments with different values can
be used. One could have a ``docker-compose.pre.yml`` and a ``.env.pre``.

To start the container in the same terminal (container stops when closing the terminal):
``docker-compose up``

To start on its own process: ``docker-compose up -d``

![image](https://user-images.githubusercontent.com/98974760/213020638-8a02a797-1d05-4cfc-ae23-3ea30fad31e5.png)


To force the containers to be recreated even if they exist:
``docker-compose up -d --force-recreate``

To stop the containers: ``docker-compose down``

To stop the containers and remove the images and networks:
``docker-compose down --rmi all``

Add ``--force`` if you also want its shared images removed,
for example, mysql, used in several projects. USE CAREFULLY.

## PHASE 4. UPLOAD THE CONTAINER TO DOCKER HUB

Once the multicontainer is generated in Docker with the database and the application, the next step is to upload the image to Docker Hub.

To do this, we first log in to the Docker Hub page with the ``$ docker login`` command. Once you have entered the credentials that it will ask you for, if you were not logged in yet, write the command ``$ docker push <user>/<image_name>:<version>`` and that's it. We check our Docker Hub account to see if it was created successfully.

![image](https://user-images.githubusercontent.com/98974760/213216759-5c257495-12bc-4aef-81d0-1d5139485f25.png)

If we click on the repository, we can access it and read or edit its description. As well as other options, depending on the tab we select. But in this case we will be facing a common Docker Hub repository, usable by whoever wants from any computer.

![image](https://user-images.githubusercontent.com/98974760/213217574-2bc303e6-b617-4c39-b3ba-610f6300a076.png)

# DOCKERISING THE PROJECT

## WRITING COMANDS IN CONSOLE

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

We have had to create a "Dockerfile", which we have saved in the src/main/docker directory, specifying the necessary configurations for the creation of our image for Docker Hub. We will also use a specific maven plugin (spotify/docker-maven-plugin), which we will include and configure in the "pom.xml" file.

We have to select New file (in the top left-hand corner), and put what it says in the image below:

![image](https://user-images.githubusercontent.com/58866375/215343670-1c0f8ee7-c6f8-4e67-ab28-37625a72e21c.png)

(The configuration in the pom file):

![image](https://user-images.githubusercontent.com/98974760/214931223-ddd3211f-d0d7-467b-9996-e86595f73ca5.png)

In the "properties" section of the POM we define the prefix of the docker image to generate (docker.image.prefix). As can be seen, we have put the account name of one of us in Docker Hub (we use the Isa's account: igr1985), since we will upload the generated image to that repository.

![image](https://user-images.githubusercontent.com/98974760/214932122-566c5e38-a5e2-49f7-9728-32e17e28bf10.png)

Whenever we want to generate a new version of our image, we will need to change the version in the POM file, where we will see something like ``<version>0.2.0</version>``. If we want to do that in the Dockerfile, we have to create the JAR, where we must change JAR filename in something like ``ADD isara-0.2.0.jar app.jar``.

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


### PHASE 3. DEFINITION AND IMPLEMENTATION OF A MULTI-CONTAINER APP

Config values stored in ``.env`` file. Different environments with different values can be used. One could have a ``docker-compose.pre.yml`` and a ``.env.pre``.

A Docker Compose is a tool for defining and running multi-container Docker applications. A YAML file is used to configure the application's services. Then, with a single command, all the services in the configuration are created and started.

In our docker-compose, we have defined it as follows: 

![image](https://user-images.githubusercontent.com/58866375/215344221-a3a40b29-3d07-4e13-be77-fa423ba79530.png)

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


### PHASE 4. UPLOAD THE CONTAINER TO DOCKER HUB

First of all, we have to create a repository in the Dockerhub account. Once the multicontainer is generated in Docker with the database and the application, the next step is to upload the image to Docker Hub.

To do this, we first log in to the Docker Hub page with the ``$ docker login`` command. Once you have entered the credentials that it will ask you for, if you were not logged in yet, write the command ``$ docker push <user>/<image_name>:<version>`` and that's it. We check our Docker Hub account to see if it was created successfully.

![image](https://user-images.githubusercontent.com/98974760/213216759-5c257495-12bc-4aef-81d0-1d5139485f25.png)

If we click on the repository, we can access it and read or edit its description. As well as other options, depending on the tab we select. But in this case we will be facing a common Docker Hub repository, usable by whoever wants from any computer.

![image](https://user-images.githubusercontent.com/98974760/213217574-2bc303e6-b617-4c39-b3ba-610f6300a076.png)


## IN INTELLIJ IDE

1. Install the docker plugin in your IDE. To do this you have to go to the "File" tab and choose the "Settings" option (or press Ctrl + Alt + S). Then go to the "Plugins" section and search for "Docker". The one you have to install will appear first. Do it.
2. Once installed, the "Docker" option should appear in the "Build, Execution, Deployment" section of the "Settings". Open the tab and click on "Docker Registry".

![image](https://user-images.githubusercontent.com/98974760/214920697-0f67d7d7-4385-4f4b-a790-9ea260a1e97a.png)

3. Here the + sign at the top is given to be able to connect the IDE with our Docker Hub account, filling in the fields as shown in the following image. If you do not have a user account in Docker Hub, we would have to create one previously.

![image](https://user-images.githubusercontent.com/98974760/214921220-786fa793-374d-4e99-b45a-292f7fdd5632.png)

4. Once our Docker Hub account is connected to the IDE, it should appear in the lower tab called "Service" with all the images and containers that we have both in our account and in our Docker installed.

![image](https://user-images.githubusercontent.com/98974760/214923701-658edc5b-53e7-4713-bc10-7875c384df41.png)

5. We need to have maven installed for the next step.
6. We go to the Maven tab on the right and, first, click on "clean" (we will observe that the content of the "target" directory is deleted and recreated) and then we will click on "install" to generate our .jar inside this same folder.

![image](https://user-images.githubusercontent.com/98974760/214926765-ff4afd37-e3f1-498f-afb4-8b9594a65e25.png)

7. The next step is to create a Dockerfile, with which we can generate our image for Docker, by clicking on the green symbol that will appear at the beginning and then on "Build Image on Docker".

![image](https://user-images.githubusercontent.com/98974760/214927325-ee2695fb-6d32-4c22-bdd1-44dd1ed7d9a7.png)

8. Once finished, we can now push to Docker Hub.

![image](https://user-images.githubusercontent.com/98974760/214927585-cd9db6c0-cad9-4c31-9b36-4cc761130e86.png)

9. Then we will create the "docker-compose" file, where we will define the services, networks, volumes, etc. It is normally placed in the root directory.

![image](https://user-images.githubusercontent.com/98974760/214928192-bc1b4f81-6ecd-4dbe-8ccc-da56997f476c.png)

10. Once our docker-compose file is finished, we will have two ways to execute it:

![image](https://user-images.githubusercontent.com/58866375/215345193-07416b9c-2477-4cf5-acc7-efe9b2e47c64.png)

   - The first is from commands in the terminal locating us at the address where the docker-compose is located: `$ docker-compose up -d`
   - The second from IntelliJ itself, by clicking on the green icon that appears in front of "services" of our "docker-compose" file.

![image](https://user-images.githubusercontent.com/98974760/214929269-22e89f1d-73f2-4c15-ade0-05d36e5529f5.png)

11. Once executed, we will have our microservice installed and working in Docker.

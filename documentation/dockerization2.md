# DOCKERISING THE PROJECT - 2nd PART
## [Docker-compose](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/ISARA-microservices/docker-compose.yml)
### How to implement the app using docker-compose
1. First of all, we have to push the images of each microservice in dockerhub. You can see the information about how to create an image and post it in dockerhub in the [dockerization.md](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/documentation/dockerization.md).
2. Once we have the images in our Docker Hub account, in the folder where we have all the microservices projects saved separately, we create the docker-compose and the .env file to the configuration of our environment, where we are going to include all the services that we want to provide together with the database common they will have.

![image](https://user-images.githubusercontent.com/58866375/216817445-54a662b6-a6b3-49b1-8281-986e0b8c8752.png)

![image](https://user-images.githubusercontent.com/58866375/216817475-dbbad2aa-0fba-46b7-8d77-aaaa0290ce99.png)

3. After doing the documents, opening a terminal in the same folder, we write `$ docker-compose up -d` to have all the microservices together with the database in the same docker container.

![isara-microservices](https://user-images.githubusercontent.com/58866375/216817049-dddde8f6-d55f-48f4-be93-0eb9cc8d0fbb.jpeg)

4. Finally, you can see our testing using Postman in the following [link](https://github.com/info-iesvi/2223_proyectopsp-equipo2/blob/main/documentation/coding3-stage1.md#testing)

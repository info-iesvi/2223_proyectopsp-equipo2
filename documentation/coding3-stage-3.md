# [ISSUE 8] CODING 3 - STAGE 3

## UserService && UserServiceImpl

To implement the email service, we have created a sendEmail method inside the UserService interface (with its corresponding implementation in the UserService class). 

In it we created a secure SMTP client and define the server to be used, in this case Gmail, along with its corresponding port; also the username and password from which the emails will be sent. 

A key pair is then created to establish a secure communication channel. 

We connect the client to the server from the defined port and the key for communication is established. 

Later, the client sends the EHLO command to open a session with the server and the server establishes the TLS negotiation non-implicitly by executing the STARTTLS command.

Then, the authentication with the server is carried out, also passing our email (from which the emails will be sent) and our password as a parameter.

The email header is created with the sender, recipient and subject; and then more recipients are added, so that the message reaches several users with a copy. 

A Writer object is created to send the content of the message, equivalent to the DATA command, and it is verified that the mail has been sent successfully.

## UserController && UserControllerImpl

In order to test the newly created service, we have also had to implement a new method in the corresponding controller.

Then we have uploaded the image to Docker Hub again and run the command `$ docker-compose up -d`. Once the container is running in Docker, we have gone to Postman and tested the new service.

![image](https://user-images.githubusercontent.com/98974760/219482952-c78937be-a845-45d9-a429-7130a161d66c.png)

According to Postman, the shipment has been successful, but when checking the mail inbox, no new message appears.

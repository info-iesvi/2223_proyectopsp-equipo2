# [ISSUE 9] CODING 4 - SECURITY

Starting from the previous state of the API, we have been asked to add some security mechanisms to our app focusing on cryptography. These are:

1. The users' password, which was already saved in String format in the User entity, will be stored in the database applying a digest of it. 
When the user logs in, the appropriate verification must be carried out.

2. To keep a record of the users who access the app, the following information will be saved in a log file, with the following format: 
`username - date - time - requested resource - operation`. 
A line will be generated for each access. This file will be named _access.log_. 
For simplicity, it is only required to register the operations of a couple of functionalities.
In our case, we have applied it to the functionality of listing all users and to creating new users.

3. Another file named _access_symmetricEncryption.log_ will be generated with the encrypted content of the previous file using symmetric cryptography.
The secret key to be used must be generated and saved in another file named _key.secret_.
To encrypt file _access_symmetricEncryption.log_, the key stored in file _key.secret_ will be used.
The file must be decrypted, generating another one with the name _access_symmetricDecryption.log_.

4. Finally, we are going to sign the _access.log_ file.
You must generate another file named _access.signature_. 
For this you need a pair of private and public keys that must be generated and stored in the _key.private_ and _key.public_ files, respectively. 
The app must verify the signature.

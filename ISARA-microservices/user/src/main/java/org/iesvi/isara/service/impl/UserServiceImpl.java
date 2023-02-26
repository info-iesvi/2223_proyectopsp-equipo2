package org.iesvi.isara.service.impl;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
import org.iesvi.isara.model.User;
import org.iesvi.isara.model.UserEmail;
import org.iesvi.isara.model.dto.UserAccessDTO;
import org.iesvi.isara.model.dto.UserDTO;
import org.iesvi.isara.model.dto.converter.UserDTOConverter;
import org.iesvi.isara.repository.UserRepository;
import org.iesvi.isara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.Keyboard;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

/**
 * Service layer of the User Entity.
 * This serves as an intermediary between the User class and the UserController controller.
 *
 * @author Isa & Sara
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return UserDTOConverter.convertListToDto(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserDTOConverter.convertToDto(userRepository.findById(id));
    }

    @Override
    public UserDTO saveUser(User user) {
        return UserDTOConverter.convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void sendEmail(UserEmail email) {
        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

        String server = "smtp.gmail.com";
        String username = "isarabookstore@gmail.com";
        String password = "isara2023";
        int port = 587;
        String sender = "isarabookstore@gmail.com";

        try {
            int answer;

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(null, null);
            KeyManager keyManager = keyManagerFactory.getKeyManagers()[0];

            client.connect(server, port);
            System.out.println("1 - " + client.getReplyString());

            client.setKeyManager(keyManager);
            answer = client.getReplyCode();

            if (!SMTPReply.isPositiveCompletion(answer)) {
                client.disconnect();
                System.err.println("CONNECTION REFUSED");
            }

            client.ehlo(server);
            System.out.println("2 - " + client.getReplyString());

            if (client.execTLS()) {
                System.out.println("3 - " + client.getReplyString());

                if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.PLAIN, username, password)) {
                    System.out.println("4 - " + client.getReplyString());
                    String receiver1 = "isabelmaria.gonzalezrodriguez@iesvalleinclan.es";

                    SimpleSMTPHeader header = new SimpleSMTPHeader(sender, receiver1, email.getSubject());

                    client.setSender(sender);
                    client.addRecipient(receiver1);

                    String receiver2 = "sara.palmarodriguez@iesvalleinclan.es";
                    client.addRecipient(receiver2);

                    String receiverWithCopy = "jlrod2pruebas@gmail.com";
                    client.addRecipient(receiverWithCopy);

                    System.out.println("5 - " + client.getReplyString());

                    Writer writer = client.sendMessageData();
                    if (writer == null){
                        System.out.println("ERROR: FAILED TO SEND DATA");
                    }else{
                        writer.write(header.toString());
                        writer.write(email.getMessage());
                        writer.close();
                        System.out.println("6 - " + client.getReplyString());

                        boolean flag = client.completePendingCommand();
                        System.out.println("7 -"+client.getReplyString());

                        if (flag){
                            System.out.println("MESSAGE SENT SUCCESSFULLY");
                        } else {
                            System.out.println("ERROR: FAILED TO COMPLETE THE TRANSACTION");
                            System.exit(1);
                        }
                    }
                } else {
                    System.out.println("UNAUTHENTICATED USER");
                }
            }else {
                System.out.println("ERROR: FAILED TO EXECUTE STARTTLS");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            client.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("END OF SENDING");
    }

    @Override
    public void accessApp(UserAccessDTO userAccessDTO) {
        List<User> userList = userRepository.findAll();

        try {
            for (User user : userList) {
                if (user.getUserName().equalsIgnoreCase(userAccessDTO.getUserName())) {
                    URL url = getClass().getClassLoader().getResource("key.txt");
                    if (url != null) {
                        File keyFile = new File(url.toURI());
                        FileReader fileReader = new FileReader(keyFile);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String key = bufferedReader.readLine();

                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

                        byte[] bytesPassword = userAccessDTO.getPassword().getBytes();
                        messageDigest.update(bytesPassword);
                        byte[] resumePassword = messageDigest.digest(key.getBytes());
                        String loginPassword = new String(resumePassword);

                        if (loginPassword.equalsIgnoreCase(user.getPassword())) {
                            System.out.println("Welcome user " + user.getUserName());
                        }else{
                            System.out.println("Incorrect password");
                        }
                    } else {
                        throw new IllegalArgumentException("File not found");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

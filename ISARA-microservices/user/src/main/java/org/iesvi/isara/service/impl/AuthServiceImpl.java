package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.User;
import org.iesvi.isara.repository.UserRepository;
import org.iesvi.isara.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateCredentials(String authHeader) {
        List<User> userList = userRepository.findAll();
        String userPassword = authHeader.split(", ")[5].split("\"")[1];
        String userName = authHeader.split(", ")[0].split("\"")[1];
        String algorithm = authHeader.split(", ")[4].split("\"")[1]; //SHA-256 by default
        boolean result = false;

        try {
            for (User user : userList) {
                if (user.getUserName().equalsIgnoreCase(userName)) {
                    MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

                    byte[] bytesPassword = userPassword.getBytes();
                    messageDigest.update(bytesPassword);
                    byte[] resumePassword = messageDigest.digest(userPassword.getBytes());
                    String loginPassword = new String(resumePassword);

                    if (loginPassword.equalsIgnoreCase(user.getPassword())) {
                        result = true;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public String getUser(String authHeader) {
        return authHeader.split(", ")[0].split("\"")[1];
    }

    @Override
    public String encodePassword(String password) {
        byte[] resumePassword = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytesPassword = password.getBytes();
            messageDigest.update(bytesPassword);
            resumePassword = messageDigest.digest(password.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new String(resumePassword);
    }
}

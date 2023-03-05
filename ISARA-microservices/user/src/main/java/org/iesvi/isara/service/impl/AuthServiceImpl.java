package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.User;
import org.iesvi.isara.repository.UserRepository;
import org.iesvi.isara.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.HexadecimalOperations;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateCredentials(String authHeader) {
        List<User> userList = userRepository.findAll();
        Base64.Decoder base64Decoder = Base64.getDecoder();
        String userName = new String(base64Decoder.decode(authHeader.split(" ")[1])).split(":")[0];
        String userPassword = new String(base64Decoder.decode(authHeader.split(" ")[1])).split(":")[1];
        boolean result = false;

        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                String encodedUserPassword = HexadecimalOperations.getHexStringFromBytes(encodePassword(userPassword).getBytes());

                if (encodedUserPassword.equalsIgnoreCase(user.getPassword())) {
                    result = true;
                }
            }
        }

        return result;
    }

    @Override
    public String getUser(String authHeader) {
        Base64.Decoder base64Decoder = Base64.getDecoder();
        return new String(base64Decoder.decode(authHeader.split(" ")[1])).split(":")[0];
    }

    @Override
    public String encodePassword(String password) {
        byte[] resumePassword = new byte[0];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            resumePassword = messageDigest.digest(password.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new String(resumePassword);
    }
}

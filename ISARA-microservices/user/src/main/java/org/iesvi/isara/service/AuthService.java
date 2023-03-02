package org.iesvi.isara.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    boolean validateCredentials(String authHeader);
    String getUser(String authHeader);
    String encodePassword(String password);
}

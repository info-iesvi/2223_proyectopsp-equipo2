package org.iesvi.isara.service;

public interface AuthService {
    boolean validateCredentials(String authHeader);
    String getUser(String authHeader);
    String encodePassword(String password);
}

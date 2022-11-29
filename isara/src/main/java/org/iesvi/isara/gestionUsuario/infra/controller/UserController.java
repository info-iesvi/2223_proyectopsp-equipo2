package org.iesvi.isara.gestionUsuario.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.gestionUsuario.domain.User;
import org.iesvi.isara.gestionUsuario.infra.dto.CreateUserDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.UpdateUserDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.UserDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.UserDTOConverter;
import org.iesvi.isara.gestionUsuario.infra.persistence.UserRepository;
import org.iesvi.isara.shared.infra.persistence.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserDTOConverter userDTOConverter;

    /**
     * Método para obtener una lista con todos los usuarios
     *
     * @return 404 Not Found si no encuentra ningún usuario, 200 OK si encuentra usuarios y la lista de los mismos
     */
    @GetMapping("/users/")
    public ResponseEntity<?> getAllUsers() {
        List<User> usersList = userRepository.findAll();

        if (usersList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<UserDTO> userDTOList = usersList.stream()
                    .map(userDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userDTOList);
        }
    }

    /**
     * Método para obtener un usuario por su ID
     *
     * @param id Identificador del usuario
     * @return 404 Not Found si no encuentra al usuario, 200 OK si encuentra al usuario y los datos del mismo
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(user);
        }
    }

    /**
     * Método para añadir un nuevo usuario
     *
     * @param newUser Datos del nuevo usuario
     * @return 201 Created si se ha insertado con éxito el nuevo usuario
     */
    @PostMapping("/user")
    public ResponseEntity<User> addNewUser(@RequestBody CreateUserDTO newUser) {
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    /**
     * Método para editar un usuario
     *
     * @param editUser Datos nuevos del usuario
     * @param id Identificador del usuario
     * @return 200 OK si se edita correctamente, 404 Not Found si no es así
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUser(@RequestBody UpdateUserDTO editUser, @PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(editUser.getUserName());
            user.setPassword(editUser.getPassword());
            user.setFirstName(editUser.getFirstName());
            user.setLastName(editUser.getLastName());
            user.setAddress(editUser.getAddress());
            user.setPhoneNumber(editUser.getPhoneNumber());
            user.setEmail(editUser.getEmail());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para borrar un usuario por su ID
     *
     * @param id Identificador del usuario
     * @return 202 No Content si se ha borrado con éxito el usuario, 404 Not Found si no se ha encontrado
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}

package org.iesvi.isara.gestionUsuario.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.gestionUsuario.domain.UserAdmin;
import org.iesvi.isara.gestionUsuario.infra.dto.CreateUserAdminDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.UpdateUserAdminDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.UserAdminDTO;
import org.iesvi.isara.gestionUsuario.infra.dto.converter.UserAdminDTOConverter;
import org.iesvi.isara.gestionUsuario.infra.persistence.UserAdminRepository;
import org.iesvi.isara.shared.domain.Address;
import org.iesvi.isara.shared.infra.persistence.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserAdminController {
    private final UserAdminRepository userAdminRepository;
    private final UserAdminDTOConverter userAdminDTOConverter;
    private final AddressRepository addressRepository;

    @GetMapping("/users/admin/")
    public ResponseEntity<?> getAllUsersAdmin() {
        List<UserAdmin> userAdminList = userAdminRepository.findAll();

        if (userAdminList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<UserAdminDTO> userAdminDTOList = userAdminList.stream()
                    .map(userAdminDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userAdminDTOList);
        }
    }

    @GetMapping("/user/admin/{id}")
    public ResponseEntity<?> getUserAdminById(@PathVariable Long id) {
        UserAdmin userAdmin = userAdminRepository.findById(id).orElse(null);

        if (userAdmin == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(userAdmin);
        }
    }

    @PostMapping("/user/admin")
    public ResponseEntity<UserAdmin> addNewUserAdmin(@RequestBody CreateUserAdminDTO newUserAdmin) {
        UserAdmin userAdmin = new UserAdmin();

        userAdmin.setUserName(newUserAdmin.getUserName());
        userAdmin.setPassword(newUserAdmin.getPassWord());
        userAdmin.setFirstName(newUserAdmin.getFirstName());
        userAdmin.setLastName(newUserAdmin.getLastName());
        userAdmin.setEmail(newUserAdmin.getEmail());
        userAdmin.setSalary(newUserAdmin.getSalary());

        return ResponseEntity.status(HttpStatus.CREATED).body(userAdminRepository.save(userAdmin));
    }

    @PutMapping("/user/admin/{id}")
    public ResponseEntity<?> editUserAdmin(@RequestBody UpdateUserAdminDTO editUserAdmin, @PathVariable Long id) {
        return userAdminRepository.findById(id).map(userAdmin -> {
            Address address = addressRepository.findById(editUserAdmin.getAddress().getIdAddress()).orElse(null);

            userAdmin.setUserName(editUserAdmin.getUserName());
            userAdmin.setPassword(editUserAdmin.getPassword());
            userAdmin.setFirstName(editUserAdmin.getFirstName());
            userAdmin.setLastName(editUserAdmin.getLastName());
            userAdmin.setAddress(address);
            userAdmin.setPhoneNumber(editUserAdmin.getPhoneNumber());
            userAdmin.setEmail(editUserAdmin.getEmail());
            userAdmin.setSalary(editUserAdmin.getSalary());

            return ResponseEntity.ok(userAdminRepository.save(userAdmin));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/user/admin/{id}")
    public ResponseEntity<?> deleteUserAdmin(@PathVariable Long id) {
        if (userAdminRepository.existsById(id)) {
            userAdminRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

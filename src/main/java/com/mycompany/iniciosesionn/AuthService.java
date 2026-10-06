package com.mycompany.iniciosesion.service;

import com.mycompany.iniciosesion.model.User;
import com.mycompany.iniciosesion.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Crear usuario
    public User register(User user) {
        return userRepository.save(user);
    }

    // Login
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener usuario por id
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Actualizar usuario
    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    // Eliminar usuario
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

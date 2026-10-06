package com.mycompany.iniciosesion.controller;

import com.mycompany.iniciosesion.model.User;
import com.mycompany.iniciosesion.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Registrar usuario
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = authService.login(user.getUsername(), user.getPassword());
        if (dbUser != null) {
            return "Login exitoso";
        } else {
            return "Credenciales incorrectas";
        }
    }

    // Obtener todos los usuarios
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return authService.getAllUsers();
    }

    // Obtener usuario por id
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return authService.getUserById(id);
    }

    // Actualizar usuario
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return authService.updateUser(id, user);
    }

    // Eliminar usuario
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        boolean deleted = authService.deleteUser(id);
        return deleted ? "Usuario eliminado " : "Usuario no encontrado ";
    }
}


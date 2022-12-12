package pl.britenet.campusnovemberspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campusnovemberspringboot.model.Credentials;
import pl.britenet.campusnovemberspringboot.model.LoginResponse;
import pl.britenet.campusnovemberspringboot.service.AuthService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public LoginResponse login(@RequestBody Credentials credentials) {
        return this.authService.login(credentials);
    }

    @GetMapping
    public boolean getUser(@RequestHeader("Authorization") String token) {
        return this.authService.isLoggedIn(token);
    }
}

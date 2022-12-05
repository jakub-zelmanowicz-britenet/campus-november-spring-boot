package pl.britenet.campusnovemberspringboot.service;

import org.springframework.stereotype.Service;
import pl.britenet.campusnovemberspringboot.model.Credentials;
import pl.britenet.campusnovemberspringboot.model.LoginResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthService {

    //private final UserService userService;

    private final Map<String, Integer> activeTokenMap = new HashMap<>();

    public LoginResponse login(Credentials credentials) {
        //User user = this.userService.getUser(credentials.getUsername(), credentials.getPassword());
        //if (user != null) {}
        // throw new IllegalStateException() ...

        String token = UUID.randomUUID().toString();
        this.activeTokenMap.put(token, 7 /* user.getId() */);

        LoginResponse loginResponse = new LoginResponse(true, token);
        return loginResponse;
    }

    public boolean isLoggedIn(String token) {
        return this.activeTokenMap.containsKey(token);
    }

    public void register() {}
}

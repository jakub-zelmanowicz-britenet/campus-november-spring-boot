package pl.britenet.campusnovemberspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campusnovemberspringboot.service.AuthService;

@CrossOrigin
@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final AuthService authService;

    @Autowired
    public OrderController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public Object getOrder(@RequestHeader("Authorization") String token) {
        int userId = this.authService.getUserId(token);
        return null;
    }

}

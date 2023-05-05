package fr.cgs.cgs_back.controller;

import fr.cgs.cgs_back.dto.UserDto;
import fr.cgs.cgs_back.entity.User;
import fr.cgs.cgs_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto) {
        User user = userService.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok(user);
    }
}

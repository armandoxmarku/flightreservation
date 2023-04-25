package com.flightreservationApp.controller;

import com.flightreservationApp.dto.user.UserDTO;
import com.flightreservationApp.dto.user.UserUpdateDTO;
import com.flightreservationApp.entity.User;
import com.flightreservationApp.mapper.UserMapper;
import com.flightreservationApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{userRole}")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO req, @PathVariable String userRole){
        UserDTO dto = userService.registerUser(req,userRole);
        return ResponseEntity.ok(dto);
    }
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody String email, String password){
        User user =userService.loginUser(email,password);
        return ResponseEntity.ok(user);
    }
    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Integer id, @RequestBody UserUpdateDTO req){
        UserUpdateDTO u = userService.updateUser(id,req);
        return ResponseEntity.ok(u);
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Integer id){
        User u = userService.findById(id);
        return ResponseEntity.ok(UserMapper.toDto(u));
    }
}

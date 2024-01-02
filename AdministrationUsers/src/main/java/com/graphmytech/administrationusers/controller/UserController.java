package com.graphmytech.administrationusers.controller;

import com.graphmytech.administrationusers.dto.CreateUserDTO;
import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.service.UserService;
import com.graphmytech.administrationusers.mapper.UserMapper;

import com.graphmytech.administrationusers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController()
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to create a new user
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserRequestDTO) {

        User savedUser = userService.createUser(createUserRequestDTO.getName(), createUserRequestDTO.getAge());

        UserDTO response = UserMapper.map(savedUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//
//    // Endpoint to get details of a user by ID
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
//        UserDTO user = userService.getUserById(id);
//        return user != null ?
//                new ResponseEntity<>(user, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Endpoint to update user details
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDetails) {
//        UserDTO updatedUser = userService.updateUser(id, userDetails);
//        return updatedUser != null ?
//                new ResponseEntity<>(updatedUser, HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // Endpoint to delete a user by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//

    // Endpoint to get all users


}

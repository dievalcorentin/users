package com.graphmytech.administrationusers.controller;

import com.graphmytech.administrationusers.dto.CreateUserDTO;
import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.service.UserService;
import com.graphmytech.administrationusers.mapper.UserMapper;

import com.graphmytech.administrationusers.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // Endpoint to list all users
    @Operation(summary = "Get list of Users", description = "This endpoint allows retrieve the list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/list", produces = "application/json")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return UserMapper.map(users);
    }


    // Endpoint to create a new user
    @Operation(summary = "Create a User", description = "This endpoint allows to create a User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Successfully created"),
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public UserDTO createUser(@RequestBody CreateUserDTO createUserRequestDTO ) {
        User savedUser = userService.createUser(createUserRequestDTO.getEmail(), createUserRequestDTO.getPassword());
        return UserMapper.map(savedUser);
    }


    // Endpoint to update user details
    @Operation(summary = "Update User Details", description = "This endpoint allows updating user details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User details successfully updated"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDetails) {
        User userToUpdate = UserMapper.map(userDetails); // Convert UserDTO to User entity
        User updatedUser = userService.updateUser(id, userToUpdate);
        if (updatedUser != null) {
            UserDTO updatedUserDTO = UserMapper.map(updatedUser); // Convert User entity to UserDTO
            return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

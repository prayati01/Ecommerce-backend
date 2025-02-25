package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Users;
import com.example.ecommerce.repository.UsersRepo;
import com.example.ecommerce.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        //earlier we wrote     public ResponseEntity<Users> addUser(@RequestBody Users user) {
        //but it gave error bcos in catch block we return a string (since e.getmessage() but here we were giving <User>
        // so we gave return type as a wildcard (<?>)
        try {
            Users newUser = usersService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/loginUser")
    public ResponseEntity<Boolean> loginUser(@RequestBody Users user) {
        boolean isValidUser = usersService.loginUser(user.getEmail(), user.getPassword());

        if (isValidUser) {
            return ResponseEntity.ok(true);  // 200 OK, User authenticated
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false); // 401 Unauthorized
        }
    }

    //@PostMapping("/addUser")
    //    //@CrossOrigin(origins ="http://localhost:3000" )
    //    //bcozou rreact application was running on 3000 but we gave 8082 so to avoid error of cross origin
    //    public Users addUser(@RequestBody Users user){
    //        return usersService.addUser(user);
    //    }


    //@PostMapping("/loginUser")
    //@CrossOrigin(origins ="http://localhost:3000" )
    //public Boolean loginUser(@RequestParam String email, @RequestParam String password){
      //  return usersService.loginUser(email, password);

    //}

}
//to test in postman, for
//1.adding a user (post req.
//http://localhost:8082/loginUser
//{
//    "username": "prayati",
//    "email": "prayati@example.com",
//    "password": "securepassword"
//}
//to test login a user (post req)
//usign query parameters
//http://localhost:8080/loginUser?email=john@example.com&password=securepassword
//using json raw body(if @requestbody was used)
//{
//    "email": "prayati@example.com",
//    "password": "securepassword"
//}
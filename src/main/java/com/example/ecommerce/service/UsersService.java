package com.example.ecommerce.service;

import com.example.ecommerce.entity.Users;
import com.example.ecommerce.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public Users addUser(Users user){
        //to check if yser with sam email alre
        return usersRepo.save(user);
    }

    public Boolean loginUser(String email, String password) {  // Changed method signature
        Optional<Users> userOptional = usersRepo.findByEmail(email);
        if (userOptional.isEmpty()){
            return false; //user not found
        }

        Users user1 = userOptional.get();//extracting user from optional

        //checking ifpsd match
        if(!user1.getPassword().equals(password)){
            return false; //incorrecct passowrd
        }
        return true;//sucessfull logun

    }
}

package com.trekappAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.trekappAPI.entity.Treks;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @CrossOrigin()
    @PostMapping("/users/register")
    public Status registerUser( @RequestBody User newUser) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUser);
        return Status.SUCCESS;
    }

    @CrossOrigin()
    @PostMapping("/users/login")
    public Status loginUser( @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                //userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @CrossOrigin()
    @PostMapping("/users/logout")
    public Status logUserOut( @RequestBody User user) {
        List<User> users = userRepository.findAll();

        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @CrossOrigin()
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
    @GetMapping("/users")
    public List<User> gettreks(){
		return userRepository.findAll();
	}
    
    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateTrek(@PathVariable Long id ,@RequestBody User user) {
     User exiuser = userRepository.findById(id).orElse(null);
		
     	exiuser.setEmail(user.getEmail());
     	exiuser.setPassword(user.getPassword());
     	exiuser.setName(user.getName());
		
	
		User updateUser = userRepository.save(exiuser);
    	return ResponseEntity.ok(updateUser);
   	 	
    	
    }
    
    @DeleteMapping("/users/delete/{id}")
    public String deleteTrek(@PathVariable Long id) {
   	  userRepository.deleteById(id);
   	return "user removed" + id;
    }
    @CrossOrigin()
    @GetMapping("/users/{id}")
    public User getUserbyId(@PathVariable Long id) {
		return userRepository.findById(id).orElse(null);
	}
    
    @GetMapping("/usersByemail/{email}")
    public User getUserByEmail(@PathVariable String email) {
    	return userRepository.findByEmail(email);
    }
    
}
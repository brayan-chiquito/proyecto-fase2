package dm.bigqueryconsult.controller;


import dm.bigqueryconsult.model.User;
import dm.bigqueryconsult.service.QueryService;
import dm.bigqueryconsult.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:9000")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        logger.info("findAll() method called");
        return this.userService.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user){
        logger.info("save() method called");
        return this.userService.save(user);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        logger.info("findById() method called");
        User user = this.userService.findById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user){
        logger.info("update() method called");
        User user1 = this.userService.findById(id);
        if(user1 == null){
            return ResponseEntity.notFound().build();
        }
        user1.setNameUser(user.getNameUser());
        user1.setEmailUser(user.getEmailUser());

        return ResponseEntity.ok().body(this.userService.save(user1));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id){
        logger.info("delete() method called");
        User user = this.userService.findById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        this.userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package gr.mariakapa.cinema.RestController;

import gr.mariakapa.cinema.Entity.UserType;
import gr.mariakapa.cinema.Service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserTypeController {

     @Autowired
     UserTypeService userTypeService;


     @PostMapping("/saveUserType")
     public ResponseEntity<UserType> saveUserType(@RequestBody UserType req) {
         return new ResponseEntity<>(userTypeService.saveUserType(req), HttpStatus.CREATED);
     }


     @GetMapping("/usertype/{id}")
    public UserType getUserTypeById(@PathVariable int id){
       return  userTypeService.findUserTypeById(id);
    }

}

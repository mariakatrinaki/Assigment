package gr.mariakapa.cinema.RestController;

import gr.mariakapa.cinema.Entity.User;
import gr.mariakapa.cinema.RequestResponse.UserResponse;
import gr.mariakapa.cinema.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

       @Autowired
       UserService userService;




    @PostMapping("/saveUser")
    public User addUserType(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userService.save_user(user);
    }

       @GetMapping("/user-UserType/{id}")
       public UserResponse findUserById_UserType(@PathVariable int id){

        return  userService.findUserById_UserType(id);
       }

       @GetMapping("/user-UserType/name/{name}")
       public List<UserResponse> getUsersByType(@PathVariable String name){
        return userService.getUsersByType(name);
       }

    @GetMapping("/users-UserType")
    public List<UserResponse>  getUsers_UserType(){

        return userService.getUsers_UserType();
    }




    @GetMapping("/user-Orders")
    public List<User> getUsersOrders(){
        return userService.getUserOrders();
    }

    @GetMapping("/user-Orders/{id}")
    public User getUserOrders(@PathVariable int id){
        return userService.findUserById(id);

    }

}

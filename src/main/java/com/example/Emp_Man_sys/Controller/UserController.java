package com.example.Emp_Man_sys.Controller;
import com.example.Emp_Man_sys.Entity.UserEntity;
import com.example.Emp_Man_sys.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public UserEntity createUser(@RequestParam Long emp_id,
                                 @RequestBody UserEntity user) {
        return userService.createUser(emp_id, user);
    }

    @GetMapping("/{emp_id}")
    public UserEntity getUser(@PathVariable Long emp_id) {
        return userService.getUserById(emp_id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/{emp_id}")
    public UserEntity updateUser(@PathVariable Long emp_id,
                                 @RequestBody UserEntity user) {
        return userService.updateUser(emp_id, user);
    }


    @DeleteMapping("/{emp_id}")
    public String deleteUser(@PathVariable Long emp_id) {
        userService.deleteById(emp_id);
        return "User deleted successfully";
    }
}

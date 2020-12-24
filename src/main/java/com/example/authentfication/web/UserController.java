package com.example.authentfication.web;

import com.example.authentfication.entities.AppUser;
import com.example.authentfication.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm)
    {
       return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) throws Exception {
        accountService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.GONE);
    }

    @GetMapping("/users")
    public List<AppUser> users() throws Exception {
       return accountService.users();

    }
}



















@Data
class UserForm
{
    private String username;
    private String password;
    private String confirmedPassword;
}

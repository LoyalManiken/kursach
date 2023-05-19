package dev.application.paymentInfo.Controller;

import dev.application.paymentInfo.Dto.UserDto;
import dev.application.paymentInfo.Entity.User;
import dev.application.paymentInfo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<UserDto>(HttpStatus.OK);
    }
    @GetMapping("/users")
    public List<UserDto> users(){
        return userService.findAllUsers();
    }
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserDto userDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getUsername(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
}

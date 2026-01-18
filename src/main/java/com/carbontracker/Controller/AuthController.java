package com.carbontracker.Controller;

import com.carbontracker.ExceptionHandler.UserAlreadyExistsException;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
import com.carbontracker.Response.AuthResponse.RegisterResponse;
import com.carbontracker.Service.AuthService;
import com.carbontracker.Utility.ValidationUtility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final ValidationUtility validationUtility;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request,
                                               HttpServletRequest httpServletRequest){
        if(!validationUtility.validateUser(request)){
            throw new UserAlreadyExistsException("User is already Registered");
        }
        String url = httpServletRequest.getRequestURL().toString();
        RegisterResponse response = authService.registerUser(request, url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

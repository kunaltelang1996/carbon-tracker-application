package com.carbontracker.Controller;

import com.carbontracker.ExceptionHandler.UserExceptions.UserAlreadyExistsException;
import com.carbontracker.ExceptionHandler.UserExceptions.UserNotRegisteredException;
import com.carbontracker.Request.AuthRequest.LoginRequest;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
import com.carbontracker.Response.AuthResponse.LoginResponse;
import com.carbontracker.Response.AuthResponse.RegisterResponse;
import com.carbontracker.Service.AuthService;
import com.carbontracker.Utility.ValidationUtility;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication Controller", description = "APIs for user authentication and registration")
public class AuthController {

    private final AuthService authService;
    private final ValidationUtility validationUtility;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@Valid @RequestBody RegisterRequest request,
                                               HttpServletRequest httpServletRequest){
        if(validationUtility.validateUser(request.getEmail())){
            throw new UserAlreadyExistsException("User is already Registered");
        }
        String url = httpServletRequest.getRequestURL().toString();
        RegisterResponse response = authService.registerUser(request, url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest request,
                                                   HttpServletRequest httpServletRequest) {

        if(!validationUtility.validateUser(request.getEmail())){
            throw new UserNotRegisteredException("User is not Registered");
        }
        String url = httpServletRequest.getRequestURL().toString();
        LoginResponse response = authService.loginUser(request, url);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

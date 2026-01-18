package com.carbonTracker.Controller;

import com.carbonTracker.ExceptionHandler.UserAlreadyExistsException;
import com.carbonTracker.Request.AuthRequest.RegisterRequest;
import com.carbonTracker.Response.AuthReponse.RegisterReponse;
import com.carbonTracker.Service.AuthService;
import com.carbonTracker.Utility.ValidationUtility;
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
    public ResponseEntity<RegisterReponse> registerUser(@RequestBody RegisterRequest request,
                                               HttpServletRequest httpServletRequest){
        if(!validationUtility.validateUser(request)){
            throw new UserAlreadyExistsException("User is already Registered");
        }
        String url = httpServletRequest.getRequestURL().toString();
        RegisterReponse response = authService.registerUser(request, url);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

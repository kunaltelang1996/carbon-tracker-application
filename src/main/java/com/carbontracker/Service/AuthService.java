package com.carbontracker.Service;

import com.carbontracker.Constants.AppConstants;
import com.carbontracker.Constants.StatusCodes;
import com.carbontracker.Model.User;
import com.carbontracker.Repository.UserRepository;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
import com.carbontracker.Response.AuthResponse.RegisterResponse;
import com.carbontracker.Response.StatusServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse registerUser(RegisterRequest request, String url) {
        RegisterResponse response = new RegisterResponse();
        StatusServiceResponse statusServiceResponse = new StatusServiceResponse();
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        userRepository.save(user);

        statusServiceResponse.setMessage("User registered successfully");
        statusServiceResponse.setUrl(url);
        statusServiceResponse.setStatus(AppConstants.SUCCESS);
        statusServiceResponse.setStatusCode(StatusCodes.REGISTER_SUCCESS_STATUS_CODE);

        response.setStatusServiceResponse(statusServiceResponse);

        return response;
    }
}

package com.carbontracker.Service;

import com.carbontracker.Constants.AppConstants;
import com.carbontracker.Constants.StatusCodes;
import com.carbontracker.Model.User;
import com.carbontracker.Repository.UserRepository;
import com.carbontracker.Request.AuthRequest.LoginRequest;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
import com.carbontracker.Response.AuthResponse.LoginResponse;
import com.carbontracker.Response.AuthResponse.RegisterResponse;
import com.carbontracker.Response.StatusServiceResponse;
import com.carbontracker.Response.TokenResponse;
import com.carbontracker.Utility.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value(value = "${security.jwt.access-token.expiration}")
    private long accessTokenExpiryMillis;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

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


    public LoginResponse loginUser(@Valid LoginRequest request, String url) {

        LoginResponse response = new LoginResponse();
        TokenResponse tokenResponse = new TokenResponse();
        User user = userRepository.findByEmail(request.getEmail());
        StatusServiceResponse statusServiceResponse = new StatusServiceResponse();
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            statusServiceResponse.setMessage("User logged in successfully");
            statusServiceResponse.setUrl(url);
            statusServiceResponse.setStatus(AppConstants.SUCCESS);
            statusServiceResponse.setStatusCode(StatusCodes.LOGIN_SUCCESS_STATUS_CODE);

            String accessToken = jwtUtil.generateAccessToken(String.valueOf(user.getId()));
            String refreshToken = jwtUtil.generateRefreshToken(String.valueOf(user.getId()));
            tokenResponse.setAccessToken(accessToken);
            tokenResponse.setRefreshToken(refreshToken);
            tokenResponse.setExpiryTime(accessTokenExpiryMillis);

            response.setTokenResponse(tokenResponse);
            response.setStatusServiceResponse(statusServiceResponse);

        } else {
            statusServiceResponse.setMessage("Invalid email or password");
            statusServiceResponse.setUrl(url);
            statusServiceResponse.setStatus(AppConstants.FAILED);
            statusServiceResponse.setStatusCode(StatusCodes.LOGIN_FAILURE_STATUS_CODE);
            response.setStatusServiceResponse(statusServiceResponse);
            response.setTokenResponse(null);
        }

        return response;


    }
}

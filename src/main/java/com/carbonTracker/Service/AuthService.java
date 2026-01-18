package com.carbonTracker.Service;

import com.carbonTracker.Constants.AppConstants;
import com.carbonTracker.Constants.StatusCodes;
import com.carbonTracker.Model.User;
import com.carbonTracker.Repository.UserRepository;
import com.carbonTracker.Request.AuthRequest.RegisterRequest;
import com.carbonTracker.Response.AuthReponse.RegisterReponse;
import com.carbonTracker.Response.StatusServiceReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public RegisterReponse registerUser(RegisterRequest request, String url) {
        RegisterReponse response = new RegisterReponse();
        StatusServiceReponse statusServiceReponse = new StatusServiceReponse();
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        userRepository.save(user);

        statusServiceReponse.setMessage("User registered successfully");
        statusServiceReponse.setUrl(url);
        statusServiceReponse.setStatus(AppConstants.SUCCESS);
        statusServiceReponse.setStatusCode(StatusCodes.REGISTER_SUCCESS_STATUS_CODE);

        response.setStatusServiceReponse(statusServiceReponse);

        return response;
    }
}

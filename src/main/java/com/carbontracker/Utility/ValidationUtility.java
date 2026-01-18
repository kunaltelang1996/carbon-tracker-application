package com.carbontracker.Utility;

import com.carbontracker.Repository.UserRepository;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Utility class for validating user-related operations.
 */
@Component
@RequiredArgsConstructor
public class ValidationUtility {

    private final UserRepository userRepository;

    /**
     * Validates if a user with the given email already exists.
     *
     * @param request The registration request containing user details
     * @return true if user does not exist, false if user already exists
     */
    public boolean validateUser(RegisterRequest request){
        return !userRepository.existsByEmail(request.getEmail());
    }
}

package com.carbonTracker.Utility;

import com.carbonTracker.Model.User;
import com.carbonTracker.Repository.UserRepository;
import com.carbonTracker.Request.AuthRequest.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidationUtility {

    private final UserRepository userRepository;

    public boolean validateUser(RegisterRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if(user != null){
            return false;
        }

        return true;
    }
}

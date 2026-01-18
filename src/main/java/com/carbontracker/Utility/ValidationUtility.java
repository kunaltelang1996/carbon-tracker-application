package com.carbontracker.Utility;

import com.carbontracker.Model.User;
import com.carbontracker.Repository.UserRepository;
import com.carbontracker.Request.AuthRequest.RegisterRequest;
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

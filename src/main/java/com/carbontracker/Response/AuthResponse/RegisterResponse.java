package com.carbontracker.Response.AuthResponse;

import com.carbontracker.Response.StatusServiceResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {

    @JsonProperty("statusServiceResponse")
    private StatusServiceResponse statusServiceResponse;
}

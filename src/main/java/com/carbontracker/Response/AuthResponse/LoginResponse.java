package com.carbontracker.Response.AuthResponse;

import com.carbontracker.Response.StatusServiceResponse;
import com.carbontracker.Response.TokenResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statusServiceResponse","tokenResponse"})
public class LoginResponse {

    @JsonProperty("statusServiceResponse")
    private StatusServiceResponse statusServiceResponse;

    @JsonProperty("tokenResponse")
    private TokenResponse tokenResponse;
}

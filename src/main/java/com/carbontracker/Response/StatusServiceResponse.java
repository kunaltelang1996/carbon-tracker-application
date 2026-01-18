package com.carbontracker.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"message","statusCode","status","url"})
public class StatusServiceResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("url")
    private String url;

    public StatusServiceResponse() {}

    public StatusServiceResponse(String message, String statusCode, String status, String url) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.url = url;
    }
}

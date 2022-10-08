package com.maveric.techhub.project.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

}

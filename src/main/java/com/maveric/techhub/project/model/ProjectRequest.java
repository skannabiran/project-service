package com.maveric.techhub.project.model;

import com.maveric.techhub.project.util.ServiceConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProjectRequest {

    @NotBlank(message = ServiceConstants.TITLE_IS_MANDATORY)
    private String title;
    @NotBlank(message = ServiceConstants.DESCRIPTION_IS_MANDATORY)
    private String description;
    @NotBlank(message = ServiceConstants.CONTACT_PERSON_IS_MANDATORY)
    private String contactPerson;
    @NotBlank(message = ServiceConstants.TECHNOLOGIES_IS_MANDATORY)
    private String technologies;
    private String dependencies;
    private String keyMembers;
    private String referenceMaterials;


}

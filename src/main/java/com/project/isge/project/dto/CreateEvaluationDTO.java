package com.project.isge.project.dto;

import com.project.isge.project.models.Module;
import lombok.Data;

@Data
public class CreateEvaluationDTO {
    private String user;
    private Module module;
}

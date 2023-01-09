package com.project.isge.project.dto;

import com.project.isge.project.models.Criterion;
import com.project.isge.project.models.Evaluation;
import lombok.Data;

@Data
public class CreateNotationDTO {
    private float note;
    private Evaluation evaluation;
    private Criterion criterion;
}

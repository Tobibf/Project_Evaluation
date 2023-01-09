package com.project.isge.project.services;

import com.project.isge.project.dto.CreateEvaluationDTO;
import com.project.isge.project.dto.CreateModuleDTO;
import com.project.isge.project.dto.UpdateEvaluationDTO;
import com.project.isge.project.dto.UpdateModuleDTO;
import com.project.isge.project.exceptions.EvaluationNotExistException;
import com.project.isge.project.exceptions.ModuleNotExistException;
import com.project.isge.project.models.Evaluation;
import com.project.isge.project.models.Module;

import java.util.List;

public interface EvaluationService {
    Evaluation createModule(CreateEvaluationDTO evaluationDTO);

    void deleteById(int id);

    void updateModule(int id, UpdateEvaluationDTO evaluationDTO) throws EvaluationNotExistException;

    List<Evaluation> evaluationList();

    Evaluation getById(int id);
}

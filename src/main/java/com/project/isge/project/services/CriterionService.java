package com.project.isge.project.services;

import com.project.isge.project.dto.CreateCriterionDTO;

import com.project.isge.project.dto.UpdateCriterionDTO;

import com.project.isge.project.exceptions.CriterionNotExistException;
import com.project.isge.project.models.Criterion;


import java.util.List;

public interface CriterionService {
    Criterion createCriterion(CreateCriterionDTO criterionDTO);

    void deleteById(int id);

    void updateCriterion(int id, UpdateCriterionDTO criterionDTO) throws CriterionNotExistException;

    List<Criterion> criterionList();

    Criterion getById(int id);
}

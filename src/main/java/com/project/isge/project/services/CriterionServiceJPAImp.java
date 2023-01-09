package com.project.isge.project.services;

import com.project.isge.project.dto.CreateCriterionDTO;
import com.project.isge.project.dto.UpdateCriterionDTO;
import com.project.isge.project.exceptions.CriterionNotExistException;

import com.project.isge.project.models.Criterion;

import com.project.isge.project.models.Evaluation;
import com.project.isge.project.repositories.CriterionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriterionServiceJPAImp implements CriterionService {
    private CriterionRepository criterionRepository;

    public CriterionServiceJPAImp(CriterionRepository criterionRepository) {
        this.criterionRepository = criterionRepository;
    }

    @Override
    public Criterion createCriterion(CreateCriterionDTO criterionDTO) {
        Criterion criterion = new Criterion();
        criterion.setName(criterionDTO.getName());
        return criterionRepository.save(criterion);
    }

    @Override
    public void deleteById(int id) {
        criterionRepository.deleteById(id);
    }

    @Override
    public void updateCriterion(int id, UpdateCriterionDTO criterionDTO) throws CriterionNotExistException {
        if (!criterionRepository.existsById(id)) {
            throw new CriterionNotExistException();
        }
        Criterion criterion = criterionRepository.findById(id).orElse(null);
        if (criterion != null) {
            criterion.setName(criterionDTO.getName());
            criterionRepository.save(criterion);
        }
    }

    @Override
    public List<Criterion> criterionList() {
        List<Criterion> criterionList = new ArrayList<>();
        for (Criterion criterion : criterionRepository.findAll()) {
            criterionList.add(criterion);
        }
        return criterionList;
    }

    @Override
    public Criterion getById(int id) {
        return criterionRepository.findById(id).orElse(null);
    }
}

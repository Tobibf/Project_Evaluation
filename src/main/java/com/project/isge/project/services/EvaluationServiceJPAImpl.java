package com.project.isge.project.services;

import com.project.isge.project.dto.CreateEvaluationDTO;
import com.project.isge.project.dto.UpdateEvaluationDTO;
import com.project.isge.project.exceptions.EvaluationNotExistException;
import com.project.isge.project.exceptions.ModuleNotExistException;
import com.project.isge.project.models.Evaluation;
import com.project.isge.project.models.Module;
import com.project.isge.project.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluationServiceJPAImpl implements EvaluationService {
    private EvaluationRepository evaluationRepository;

    public EvaluationServiceJPAImpl(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Evaluation createModule(CreateEvaluationDTO evaluationDTO) {
        Evaluation evaluation = new Evaluation();
        evaluation.setUser(evaluationDTO.getUser());
        evaluation.setModule(evaluationDTO.getModule());

        return evaluationRepository.save(evaluation);
    }

    @Override
    public void deleteById(int id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public void updateModule(int id, UpdateEvaluationDTO evaluationDTO) throws EvaluationNotExistException {
        if (!evaluationRepository.existsById(id)) {
            throw new EvaluationNotExistException();
        }
        Evaluation evaluation = evaluationRepository.findById(id).orElse(null);
        if (evaluation != null) {
            evaluation.setAverage(evaluationDTO.getAverage());
            evaluationRepository.save(evaluation);
        }
    }

    @Override
    public List<Evaluation> evaluationList() {

        List<Evaluation> evaluationList = new ArrayList<>();
        for (Evaluation evaluation : evaluationRepository.findAll()) {
            evaluationList.add(evaluation);
        }
        return evaluationList;
    }

    @Override
    public Evaluation getById(int id) {
        return evaluationRepository.findById(id).orElse(null);
    }
}

package com.project.isge.project.services;

import com.project.isge.project.dto.CreateNotationDTO;
import com.project.isge.project.dto.UpdateNotationDTO;
import com.project.isge.project.exceptions.NotationNotExistException;
import com.project.isge.project.models.Notation;
import com.project.isge.project.repositories.NotationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotationServiceJPAImpl implements NotationService {
    private NotationRepository notationRepository;

    public NotationServiceJPAImpl(NotationRepository notationRepository) {
        this.notationRepository = notationRepository;
    }

    @Override
    public Notation createNotation(CreateNotationDTO notationDTO) {

        Notation notation = new Notation();
        notation.setNote(notation.getNote());
        notation.setCriterion(notationDTO.getCriterion());
        notation.setEvaluation(notationDTO.getEvaluation());

        return notationRepository.save(notation);
    }

    @Override
    public void deleteById(int id) {
        notationRepository.deleteById(id);
    }

    @Override
    public void updateNotation(int id, UpdateNotationDTO notationDTO) throws NotationNotExistException {
        if (!notationRepository.existsById(id)) {
            throw new NotationNotExistException();
        }
        Notation notation = notationRepository.findById(id).orElse(null);
        if (notation != null) {
            notation.setNote(notationDTO.getNote());
            notationRepository.save(notation);
        }
    }

    @Override
    public List<Notation> notationList() {
        List<Notation> notationList = new ArrayList<>();
        for (Notation notation : notationRepository.findAll()) {
            notationList.add(notation);
        }
        return notationList;
    }

    @Override
    public Notation getById(int id) {
        return notationRepository.findById(id).orElse(null);
    }
}

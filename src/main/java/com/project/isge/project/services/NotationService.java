package com.project.isge.project.services;


import com.project.isge.project.dto.CreateNotationDTO;

import com.project.isge.project.dto.UpdateNotationDTO;

import com.project.isge.project.exceptions.NotationNotExistException;

import com.project.isge.project.models.Notation;

import java.util.List;

public interface NotationService {
    Notation createNotation(CreateNotationDTO notationDTO);

    void deleteById(int id);

    void updateNotation(int id, UpdateNotationDTO notationDTO) throws NotationNotExistException;

    List<Notation> notationList();

    Notation getById(int id);
}

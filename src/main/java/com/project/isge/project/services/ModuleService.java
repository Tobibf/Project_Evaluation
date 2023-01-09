package com.project.isge.project.services;

import com.project.isge.project.models.Module;
import com.project.isge.project.dto.CreateModuleDTO;
import com.project.isge.project.dto.UpdateModuleDTO;
import com.project.isge.project.exceptions.ModuleNotExistException;

import java.util.List;

public interface ModuleService {

    Module createModule(CreateModuleDTO moduleDTO);

    void deleteById(int id);

    void updateModule(int id, UpdateModuleDTO moduleDTO) throws ModuleNotExistException;

    List<Module> moduleList();

    Module getById(int id);
}

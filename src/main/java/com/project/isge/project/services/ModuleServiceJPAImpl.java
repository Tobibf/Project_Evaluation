package com.project.isge.project.services;

import com.project.isge.project.dto.CreateModuleDTO;
import com.project.isge.project.dto.UpdateModuleDTO;
import com.project.isge.project.exceptions.ModuleNotExistException;
import com.project.isge.project.models.Module;
import com.project.isge.project.repositories.ModuleRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleServiceJPAImpl implements ModuleService {

    private ModuleRepository moduleRepository;

    public ModuleServiceJPAImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module createModule(CreateModuleDTO moduleDTO) {

        Module module = new Module();
        module.setName(moduleDTO.getName());
        return moduleRepository.save(module);
    }

    @Override
    public void deleteById(int id) {
        moduleRepository.deleteById(id);
    }

    @Override
    public void updateModule(int id, UpdateModuleDTO moduleDTO) throws ModuleNotExistException {
        if (!moduleRepository.existsById(id)) {
            throw new ModuleNotExistException();
        }
        // Get module to DB
        Module module = moduleRepository.findById(id).orElse(null);
        if (module != null) {
            //Update the two columns
            module.setName(moduleDTO.getName());
            moduleRepository.save(module);
        }

    }

    @Override
    public List<Module> moduleList() {

        List<Module> moduleList = new ArrayList<>();
        for (Module module : moduleRepository.findAll()) {
            moduleList.add(module);
        }
        return moduleList;
    }

    @Override
    public Module getById(int id) {
        return moduleRepository.findById(id).orElse(null);
    }


}

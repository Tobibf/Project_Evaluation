package com.project.isge.project.controllers.rest;

import com.project.isge.project.dto.CreateModuleDTO;
import com.project.isge.project.dto.UpdateModuleDTO;
import com.project.isge.project.exceptions.ModuleNotExistException;
import com.project.isge.project.models.Module;
import com.project.isge.project.services.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluation")
public class ModuleRestController {
    private ModuleService moduleService;

    public ModuleRestController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    public Module createModule(@RequestBody CreateModuleDTO moduleDTO) {
        return moduleService.createModule(moduleDTO);
    }

    @GetMapping
    public List<Module> moduleList() {
        return moduleService.moduleList();
    }

    @GetMapping("{id}")
    public Module getModule(@PathVariable int id) {
        return moduleService.getById(id);
    }

    @PutMapping("{id}")
    public void updateModule(@PathVariable int id, @RequestBody UpdateModuleDTO module) throws ModuleNotExistException {
        moduleService.updateModule(id, module);
    }

    @DeleteMapping("{id}")
    public void deleteModule(@PathVariable int id) {
        moduleService.deleteById(id);
    }
}

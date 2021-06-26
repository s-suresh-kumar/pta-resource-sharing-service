package com.cognizant.ptaresourcesharingservice.controller;

import com.cognizant.ptaresourcesharingservice.models.Resource;
import com.cognizant.ptaresourcesharingservice.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceChainRegistration;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceRepository resourceRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Resource createResource(@RequestBody Resource resource){
        return resourceRepo.save(resource);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Resource> getAllResources(){
        return resourceRepo.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource getById(@PathVariable Integer id){
        return resourceRepo.getById(id);
    }

    @PutMapping(value="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editResources(@RequestBody Resource resource, @PathVariable Integer id){
        if (resource.getId() == null) {
            resource.setId(id);
        }
        if (resource.getId()!= id) {
            throw new IllegalArgumentException("ID in request body: " + resource.getId() + " does not match id in path " + id);
        }
        resourceRepo.save(resource);
    }

    @DeleteMapping(value="{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResource(@PathVariable Integer id) {
        resourceRepo.deleteById(id);
    }

}

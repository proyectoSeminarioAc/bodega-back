package co.edu.uniajc.project.store.controller;

import co.edu.uniajc.project.store.model.ProviderModel;
import co.edu.uniajc.project.store.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/provider")
@Api("Project")
public class ProviderController {
    private ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "provider List", response = ProviderModel.class)
    public List<ProviderModel> index() {
        return providerService.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create new provider", response = ProviderModel.class)
    public ProviderModel store(@RequestBody ProviderModel producto) {
        return providerService.store(producto);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get provider by id", response = ProviderModel.class)
    public Optional<ProviderModel> show(@PathVariable(value = "id") Long id) {
        return providerService.show(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update provider by id", response = ProviderModel.class)
    public Optional<ProviderModel> update(@PathVariable(value = "id") Long id, @RequestBody ProviderModel provider) {
        Optional<ProviderModel> providerToUpdate = providerService.show(id);

        return providerToUpdate.isEmpty() ? providerToUpdate : Optional.ofNullable(providerService.update(provider));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete provider by id")
    public boolean delete(@PathVariable(value = "id") Long id) {
       // int count = productService.countUserTasks(id);

        // return count == 0 ? productService.delete(id) : false;

        return providerService.delete(id);
    }
}

package co.edu.uniajc.project.store.controller;

import co.edu.uniajc.project.store.model.MovementModel;
import co.edu.uniajc.project.store.service.MovementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movement")
@Api("Project")
public class MovementController {
    private MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "Product List", response = MovementModel.class)
    public List<MovementModel> index() {
        return movementService.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create new movement", response = MovementModel.class)
    public MovementModel store(@RequestBody MovementModel producto) {
        return movementService.store(producto);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get movement by id", response = MovementModel.class)
    public Optional<MovementModel> show(@PathVariable(value = "id") Long id) {
        return movementService.show(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update movement by id", response = MovementModel.class)
    public Optional<MovementModel> update(@PathVariable(value = "id") Long id, @RequestBody MovementModel product) {
        Optional<MovementModel> productToUpdate = movementService.show(id);

        return productToUpdate.isEmpty() ? productToUpdate : Optional.ofNullable(movementService.update(product));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete product by id")
    public boolean delete(@PathVariable(value = "id") Long id) {
       // int count = productService.countUserTasks(id);

        // return count == 0 ? productService.delete(id) : false;

        return movementService.delete(id);
    }
}

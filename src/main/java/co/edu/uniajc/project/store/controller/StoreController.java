package co.edu.uniajc.project.store.controller;

import co.edu.uniajc.project.store.model.StoreModel;
import co.edu.uniajc.project.store.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@Api("Project")
public class StoreController {
    private StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "Store List", response = StoreModel.class)
    public List<StoreModel> index() {
        return storeService.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create new store", response = StoreModel.class)
    public StoreModel store(@RequestBody StoreModel store) {
        return storeService.store(store);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get store by id", response = StoreModel.class)
    public Optional<StoreModel> show(@PathVariable(value = "id") Long id) {
        return storeService.show(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update store by id", response = StoreModel.class)
    public Optional<StoreModel> update(@PathVariable(value = "id") Long id, @RequestBody StoreModel product) {
        Optional<StoreModel> productToUpdate = storeService.show(id);

        return productToUpdate.isEmpty() ? productToUpdate : Optional.ofNullable(storeService.update(product));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete store by id")
    public boolean delete(@PathVariable(value = "id") Long id) {
       // int count = productService.countUserTasks(id);

        // return count == 0 ? productService.delete(id) : false;

        return storeService.delete(id);
    }
}

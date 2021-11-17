package co.edu.uniajc.project.store.controller;

import co.edu.uniajc.project.store.model.DetailModel;
import co.edu.uniajc.project.store.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
@Api("Project")
public class DetailController {
    private DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "Detail List", response = DetailModel.class)
    public List<DetailModel> index() {
        return detailService.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create new detail", response = DetailModel.class)
    public DetailModel store(@RequestBody DetailModel producto) {
        return detailService.store(producto);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get detail by id", response = DetailModel.class)
    public Optional<DetailModel> show(@PathVariable(value = "id") Long id) {
        return detailService.show(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update detail by id", response = DetailModel.class)
    public Optional<DetailModel> update(@PathVariable(value = "id") Long id, @RequestBody DetailModel product) {
        Optional<DetailModel> productToUpdate = detailService.show(id);

        return productToUpdate.isEmpty() ? productToUpdate : Optional.ofNullable(detailService.update(product));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete detail by id")
    public boolean delete(@PathVariable(value = "id") Long id) {
       // int count = productService.countUserTasks(id);

        // return count == 0 ? productService.delete(id) : false;

        return detailService.delete(id);
    }
}

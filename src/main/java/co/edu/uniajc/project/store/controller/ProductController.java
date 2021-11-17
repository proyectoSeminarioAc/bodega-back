package co.edu.uniajc.project.store.controller;

import co.edu.uniajc.project.store.model.ProductModel;
import co.edu.uniajc.project.store.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Api("Project")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/")
    @ApiOperation(value = "Product List", response = ProductModel.class)
    public List<ProductModel> index() {
        return productService.findAll();
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create new product", response = ProductModel.class)
    public ProductModel store(@RequestBody ProductModel producto) {
        return productService.store(producto);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get product by id", response = ProductModel.class)
    public Optional<ProductModel> show(@PathVariable(value = "id") Long id) {
        return productService.show(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update product by id", response = ProductModel.class)
    public Optional<ProductModel> update(@PathVariable(value = "id") Long id, @RequestBody ProductModel product) {
        Optional<ProductModel> productToUpdate = productService.show(id);

        return productToUpdate.isEmpty() ? productToUpdate : Optional.ofNullable(productService.update(product));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete product by id")
    public boolean delete(@PathVariable(value = "id") Long id) {
       // int count = productService.countUserTasks(id);

        // return count == 0 ? productService.delete(id) : false;

        return productService.delete(id);
    }
}

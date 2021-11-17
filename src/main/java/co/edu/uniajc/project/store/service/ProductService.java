package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.ProductModel;
import co.edu.uniajc.project.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel store(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public Optional<ProductModel> show(Long id) {
        return productRepository.findById(id);
    }


    public ProductModel update(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public boolean delete(Long id) {
        productRepository.deleteById(id);

        return true;
    }

    /*
    public int countUserTasks(Long id) {
        return productRepository.countUserTasks(id);
    }

     */
}

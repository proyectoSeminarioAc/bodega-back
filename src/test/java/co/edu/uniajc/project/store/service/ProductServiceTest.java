package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.ProductModel;
import co.edu.uniajc.project.store.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private ProductModel productModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        productModel.setId(2L);
        productModel.setDescription("Movimiento de prueba");
        productModel.setAlternate_reference("214052");
    }

    @Test
    void findAll() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(productModel));
        assertNotNull(productService.findAll());
    }

    @Test
    void store() {
        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);
        assertNotNull(productService.store(productModel));
    }

    @Test
    void show() {
        when(productRepository.findAllById(any())).thenReturn(Arrays.asList(productModel));
        assertNotNull(productService.show(any()));
    }

    @Test
    void update() {
        when(productRepository.save(any(ProductModel.class))).thenReturn(productModel);
        assertNotNull(productService.update(productModel));
    }

    @Test
    void delete() {
        Mockito.when(productRepository.findAllById(any())).thenReturn(Arrays.asList(productModel));
        productService.delete(any());
    }

}
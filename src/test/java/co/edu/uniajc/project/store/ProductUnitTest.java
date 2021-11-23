package co.edu.uniajc.project.store;

import co.edu.uniajc.project.store.controller.ProductController;
import co.edu.uniajc.project.store.model.ProductModel;
import co.edu.uniajc.project.store.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class ProductUnitTest {

    @Mock
    private ProductService productService;

    ProductService productServiceMock = Mockito.mock(ProductService.class);
    ProductController productController = new ProductController(productServiceMock);
    ProductModel  productModel = new ProductModel();

    @BeforeEach
    public void setUp() {
        productModel.setId(2L);
        productModel.setDescription("Movimiento de prueba");
        productModel.setAlternate_reference("214052");
    }


    @Test
    void index() {
        Mockito.when(productService.findAll()).thenReturn(Arrays.asList(productModel));
        productController.index();
    }

    @Test
    void store() {
        Mockito.when(productService.store(any(ProductModel.class))).thenReturn(productModel);
        productController.store(any());
    }

    @Test
    void show() {
        Mockito.when(productService.show(any())).thenReturn(Optional.ofNullable(productModel));
        productController.show(any());
    }

    /*
    @Test
    void update() {
        Mockito.when(productService.show(any())).thenReturn(Optional.ofNullable(productModel));
        Mockito.when(productService.update(any(ProductModel.class))).thenReturn(productModel);
        productController.show(any());
        productController.update(any(), productModel);
    }
*/


    @Test
    void updateEmpty() {
        Mockito.when(productService.show(any())).thenReturn(Optional.empty());
        Mockito.when(productService.update(any(ProductModel.class))).thenReturn(productModel);
        productController.show(any());
        productController.update(any(), productModel);
        Optional<ProductModel> projectToUpdate = productService.show(any());

        final var userModel = projectToUpdate.isEmpty() ? projectToUpdate : Optional.ofNullable(productService.update(this.productModel));
    }

    @Test
    void delete() {
        Mockito.when(productService.show(any())).thenReturn(Optional.ofNullable(productModel));
        Optional<ProductModel> projectToDelete = productService.show(any());

        if (!projectToDelete.isEmpty()) {
            productService.delete(any());
            productController.delete(any());
        }

    }
}



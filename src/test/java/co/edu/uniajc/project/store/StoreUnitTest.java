package co.edu.uniajc.project.store;

import co.edu.uniajc.project.store.controller.StoreController;
import co.edu.uniajc.project.store.model.StoreModel;
import co.edu.uniajc.project.store.service.StoreService;
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
public class StoreUnitTest {

    @Mock
    private StoreService storeService;

    StoreService storeServiceMock = Mockito.mock(StoreService.class);
    StoreController storeController = new StoreController(storeServiceMock);
    StoreModel  storeModel = new StoreModel();

    @BeforeEach
    public void setUp() {
        storeModel.setId(2L);
        storeModel.setDescription("bodega  de prueba");
        storeModel.setName("Bodega Uniajc");
    }

    @Test
    void index() {
        Mockito.when(storeService.findAll()).thenReturn(Arrays.asList(storeModel));
        storeController.index();
    }

    @Test
    void store() {
        Mockito.when(storeService.store(any(StoreModel.class))).thenReturn(storeModel);
        storeController.store(any());
    }

    @Test
    void show() {
        Mockito.when(storeService.show(any())).thenReturn(Optional.ofNullable(storeModel));
        storeController.show(any());
    }

    @Test
    void update() {
        Mockito.when(storeService.show(any())).thenReturn(Optional.ofNullable(storeModel));
        Mockito.when(storeService.update(any(StoreModel.class))).thenReturn(storeModel);
        storeController.show(any());
        storeController.update(any(), storeModel);
    }



    @Test
    void updateEmpty() {
        Mockito.when(storeService.show(any())).thenReturn(Optional.empty());
        Mockito.when(storeService.update(any(StoreModel.class))).thenReturn(storeModel);
        storeController.show(any());
        storeController.update(any(), storeModel);
        Optional<StoreModel> projectToUpdate = storeService.show(any());

        final var userModel = projectToUpdate.isEmpty() ? projectToUpdate : Optional.ofNullable(storeService.update(this.storeModel));
    }

    @Test
    void delete() {
        Mockito.when(storeService.show(any())).thenReturn(Optional.ofNullable(storeModel));
        Optional<StoreModel> projectToDelete = storeService.show(any());

        if (!projectToDelete.isEmpty()) {
            storeService.delete(any());
            storeController.delete(any());
        }

    }
}



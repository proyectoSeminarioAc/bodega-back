package co.edu.uniajc.project.store;

import co.edu.uniajc.project.store.controller.ProviderController;
import co.edu.uniajc.project.store.model.ProviderModel;
import co.edu.uniajc.project.store.service.ProviderService;
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
public class ProviderUnitTest {

    @Mock
    private ProviderService providerService;

    ProviderService providerServiceMock = Mockito.mock(ProviderService.class);
    ProviderController providerController = new ProviderController(providerServiceMock);
    ProviderModel  providerModel = new ProviderModel();

    @BeforeEach
    public void setUp() {
        providerModel.setId(1L);
        providerModel.setName("Proveedor de prueba ");
        providerModel.setDirection("Carrera 123");
        providerModel.setEnrollment_date("2021-11-22");
    }


    @Test
    void index() {
        Mockito.when(providerService.findAll()).thenReturn(Arrays.asList(providerModel));
        providerController.index();
    }

    @Test
    void store() {
        Mockito.when(providerService.store(any(ProviderModel.class))).thenReturn(providerModel);
        providerController.store(any());
    }

    @Test
    void show() {
        Mockito.when(providerService.show(any())).thenReturn(Optional.ofNullable(providerModel));
        providerController.show(any());
    }

    @Test
    void update() {
        Mockito.when(providerService.show(any())).thenReturn(Optional.ofNullable(providerModel));
        Mockito.when(providerService.update(any(ProviderModel.class))).thenReturn(providerModel);
        providerController.show(any());
        providerController.update(any(), providerModel);
    }



    @Test
    void updateEmpty() {
        Mockito.when(providerService.show(any())).thenReturn(Optional.empty());
        Mockito.when(providerService.update(any(ProviderModel.class))).thenReturn(providerModel);
        providerController.show(any());
        providerController.update(any(), providerModel);
        Optional<ProviderModel> projectToUpdate = providerService.show(any());

        final var userModel = projectToUpdate.isEmpty() ? projectToUpdate : Optional.ofNullable(providerService.update(this.providerModel));
    }

    @Test
    void delete() {
        Mockito.when(providerService.show(any())).thenReturn(Optional.ofNullable(providerModel));
        Optional<ProviderModel> projectToDelete = providerService.show(any());

        if (!projectToDelete.isEmpty()) {
            providerService.delete(any());
            providerController.delete(any());
        }

    }
}



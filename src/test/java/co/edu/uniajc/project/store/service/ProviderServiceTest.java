package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.ProviderModel;
import co.edu.uniajc.project.store.repository.ProviderRepository;
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


class ProviderServiceTest {

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderService providerService;

    private ProviderModel providerModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        providerModel.setId(1L);
        providerModel.setName("Proveedor de prueba ");
        providerModel.setDirection("Carrera 123");
        providerModel.setEnrollment_date("2021-11-22");
    }

    @Test
    void findAll() {
        when(providerRepository.findAll()).thenReturn(Arrays.asList(providerModel));
        assertNotNull(providerService.findAll());
    }

    @Test
    void store() {
        when(providerRepository.save(any(ProviderModel.class))).thenReturn(providerModel);
        assertNotNull(providerService.store(providerModel));
    }

    @Test
    void show() {
        when(providerRepository.findAllById(any())).thenReturn(Arrays.asList(providerModel));
        assertNotNull(providerService.show(any()));
    }

    @Test
    void update() {
        when(providerRepository.save(any(ProviderModel.class))).thenReturn(providerModel);
        assertNotNull(providerService.update(providerModel));
    }

    @Test
    void delete() {
        Mockito.when(providerRepository.findAllById(any())).thenReturn(Arrays.asList(providerModel));
        providerService.delete(any());
    }

}
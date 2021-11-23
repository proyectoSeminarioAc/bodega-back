package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.MovementModel;
import co.edu.uniajc.project.store.repository.MovementRepository;
import co.edu.uniajc.project.store.service.MovementService;
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


class MovementServiceTest {

    @Mock
    private MovementRepository movementRepository;

    @InjectMocks
    private MovementService movementService;

    private MovementModel movementModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        movementModel.setId(1L);
        movementModel.setDescription("Movimiento de prueba");
        movementModel.setProvider_id(1L);
        movementModel.setDetail_id(1L);

    }

    @Test
    void findAll() {
        when(movementRepository.findAll()).thenReturn(Arrays.asList(movementModel));
        assertNotNull(movementRepository.findAll());
    }

    @Test
    void store() {
        when(movementRepository.save(any(MovementModel.class))).thenReturn(movementModel);
        assertNotNull(movementService.store(movementModel));
    }

    @Test
    void show() {
        when(movementRepository.findAllById(any())).thenReturn(Arrays.asList(movementModel));
        assertNotNull(movementService.show(any()));
    }

    @Test
    void update() {
        when(movementRepository.save(any(MovementModel.class))).thenReturn(movementModel);
        assertNotNull(movementService.update(movementModel));
    }

    @Test
    void delete() {
        Mockito.when(movementRepository.findAllById(any())).thenReturn(Arrays.asList(movementModel));
        movementService.delete(any());
    }

}
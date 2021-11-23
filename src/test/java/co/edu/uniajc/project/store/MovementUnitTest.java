package co.edu.uniajc.project.store;

import co.edu.uniajc.project.store.controller.MovementController;
import co.edu.uniajc.project.store.model.MovementModel;
import co.edu.uniajc.project.store.service.MovementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
class MovementUnitTest {

    MovementService movementServiceServiceMock = Mockito.mock(MovementService.class);

    MovementController movementController = new MovementController(movementServiceServiceMock);

    MovementModel movementModel = new MovementModel();


    @BeforeEach
    void setUp() {

        movementModel.setId(2L);
        movementModel.setDescription("Movimiento de prueba");
        movementModel.setDetail_id(1L);
        movementModel.setProvider_id(1L);

    }

    @Test
    void index() {
        Mockito.when(movementServiceServiceMock.findAll()).thenReturn(Arrays.asList(movementModel));
        movementController.index();
    }

    @Test
    void store() {
        Mockito.when(movementServiceServiceMock.store(any(MovementModel.class))).thenReturn(movementModel);
        movementController.store(any());
    }

    @Test
    void show() {
        Mockito.when(movementServiceServiceMock.show(any())).thenReturn(Optional.ofNullable(movementModel));
        movementController.show(any());
    }

    @Test
    void update() {
        Mockito.when(movementServiceServiceMock.show(any())).thenReturn(Optional.ofNullable(movementModel));
        Mockito.when(movementServiceServiceMock.update(any(MovementModel.class))).thenReturn(movementModel);
        movementController.show(any());
        movementController.update(any(), movementModel);
    }

    @Test
    void updateEmpty() {
        Mockito.when(movementServiceServiceMock.show(any())).thenReturn(Optional.empty());
        Mockito.when(movementServiceServiceMock.update(any(MovementModel.class))).thenReturn(movementModel);
        movementController.show(any());
        movementController.update(any(), movementModel);
    }

    @Test
    void delete() {
        Mockito.when(movementServiceServiceMock.show(any())).thenReturn(Optional.ofNullable(movementModel));
        movementController.delete(any());
    }
}
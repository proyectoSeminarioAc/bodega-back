package co.edu.uniajc.project.store;

import co.edu.uniajc.project.store.controller.DetailController;
import co.edu.uniajc.project.store.model.DetailModel;
import co.edu.uniajc.project.store.service.DetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
class DetailUnitTest {

    DetailService detailServiceMock = Mockito.mock(DetailService.class);

    DetailController detailController = new DetailController(detailServiceMock);

    DetailModel detailModel = new DetailModel();

    @BeforeEach
    void setUp() {

        detailModel.setId(1L);
        detailModel.setAmount("10000");
        detailModel.setAmount_total("20000");
        detailModel.setQuantity("2");
        detailModel.setStore_id(1L);

    }

    @Test
    void index() {
        Mockito.when(detailServiceMock.findAll()).thenReturn(Arrays.asList(detailModel));
        detailController.index();
    }

    @Test
    void store() {
        Mockito.when(detailServiceMock.store(any(DetailModel.class))).thenReturn(detailModel);
        detailController.store(any());
    }

    @Test
    void show() {
        Mockito.when(detailServiceMock.show(any())).thenReturn(Optional.ofNullable(detailModel));
        detailController.show(any());
    }

    @Test
    void update() {
        Mockito.when(detailServiceMock.show(any())).thenReturn(Optional.ofNullable(detailModel));
        Mockito.when(detailServiceMock.update(any(DetailModel.class))).thenReturn(detailModel);
        detailController.show(any());
        detailController.update(any(), detailModel);
    }

    @Test
    void updateEmpty() {
        Mockito.when(detailServiceMock.show(any())).thenReturn(Optional.empty());
        Mockito.when(detailServiceMock.update(any(DetailModel.class))).thenReturn(detailModel);
        detailController.show(any());
        detailController.update(any(), detailModel);
    }

    @Test
    void delete() {
        Mockito.when(detailServiceMock.show(any())).thenReturn(Optional.ofNullable(detailModel));
        detailController.delete(any());
    }
}
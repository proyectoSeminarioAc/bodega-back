package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.DetailModel;
import co.edu.uniajc.project.store.repository.DetailRepository;
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


class StoreServiceTest {

    @Mock
    private DetailRepository detailRepository;

    @InjectMocks
    private DetailService detailService;

    private DetailModel detailModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        detailModel.setId(1L);
        detailModel.setAmount("10000");
        detailModel.setAmount_total("20000");
        detailModel.setQuantity("2");
        detailModel.setStore_id(1L);
    }

    @Test
    void findAll() {
        when(detailRepository.findAll()).thenReturn(Arrays.asList(detailModel));
        assertNotNull(detailRepository.findAll());
    }

    @Test
    void store() {
        when(detailRepository.save(any(DetailModel.class))).thenReturn(detailModel);
        assertNotNull(detailService.store(detailModel));
    }

    @Test
    void show() {
        when(detailRepository.findAllById(any())).thenReturn(Arrays.asList(detailModel));
        assertNotNull(detailService.show(any()));
    }

    @Test
    void update() {
        when(detailRepository.save(any(DetailModel.class))).thenReturn(detailModel);
        assertNotNull(detailService.update(detailModel));
    }

    @Test
    void delete() {
        Mockito.when(detailRepository.findAllById(any())).thenReturn(Arrays.asList(detailModel));
        detailService.delete(any());
    }

}
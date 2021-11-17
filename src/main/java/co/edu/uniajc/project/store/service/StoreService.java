package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.StoreModel;
import co.edu.uniajc.project.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreModel> findAll() {

        return storeRepository.findAll();
    }

    public StoreModel store(StoreModel storeModel) {
        return storeRepository.save(storeModel);
    }

    public Optional<StoreModel> show(Long id) {
        return storeRepository.findById(id);
    }


    public StoreModel update(StoreModel productModel) {
        return storeRepository.save(productModel);
    }

    public boolean delete(Long id) {
        storeRepository.deleteById(id);

        return true;
    }

    /*
    public int countUserTasks(Long id) {
        return productRepository.countUserTasks(id);
    }

     */
}

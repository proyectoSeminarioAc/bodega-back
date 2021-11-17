package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.ProviderModel;
import co.edu.uniajc.project.store.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<ProviderModel> findAll() {
        return providerRepository.findAll();
    }

    public ProviderModel store(ProviderModel productModel) {
        return providerRepository.save(productModel);
    }

    public Optional<ProviderModel> show(Long id) {
        return providerRepository.findById(id);
    }


    public ProviderModel update(ProviderModel providerModel) {
        return providerRepository.save(providerModel);
    }

    public boolean delete(Long id) {
        providerRepository.deleteById(id);

        return true;
    }

    /*
    public int countUserTasks(Long id) {
        return productRepository.countUserTasks(id);
    }

     */
}

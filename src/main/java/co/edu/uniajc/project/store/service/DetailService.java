package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.DetailModel;
import co.edu.uniajc.project.store.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService {
    private final DetailRepository detailRepository;

    @Autowired
    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public List<DetailModel> findAll() {
        return detailRepository.findAll();
    }

    public DetailModel store(DetailModel detailModel) {
        return detailRepository.save(detailModel);
    }

    public Optional<DetailModel> show(Long id) {
        return detailRepository.findById(id);
    }


    public DetailModel update(DetailModel detailModel) {
        return detailRepository.save(detailModel);
    }

    public boolean delete(Long id) {
        detailRepository.deleteById(id);

        return true;
    }

    /*
    public int countUserTasks(Long id) {
        return productRepository.countUserTasks(id);
    }

     */
}

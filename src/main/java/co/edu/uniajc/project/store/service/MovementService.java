package co.edu.uniajc.project.store.service;

import co.edu.uniajc.project.store.model.MovementModel;
import co.edu.uniajc.project.store.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {
    private final MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<MovementModel> findAll() {
        return movementRepository.findAll();
    }

    public MovementModel store(MovementModel productModel) {
        return movementRepository.save(productModel);
    }

    public Optional<MovementModel> show(Long id) {
        return movementRepository.findById(id);
    }


    public MovementModel update(MovementModel productModel) {
        return movementRepository.save(productModel);
    }

    public boolean delete(Long id) {
        movementRepository.deleteById(id);

        return true;
    }

    /*
    public int countUserTasks(Long id) {
        return productRepository.countUserTasks(id);
    }

     */
}

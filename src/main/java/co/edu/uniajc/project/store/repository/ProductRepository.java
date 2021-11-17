package co.edu.uniajc.project.store.repository;

import co.edu.uniajc.project.store.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

  /*  @Query(nativeQuery = true, value = "SELECT * FROM product WHERE email = :email")
    Optional<ProductModel> findByEmail(@Param(value = "email") String email);

    @Query(nativeQuery = true, value = "SELECT count(*) FROM tasks WHERE id_responsible = :id")
    int countUserTasks(@Param(value = "id") Long id);
    */

}

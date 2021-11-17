package co.edu.uniajc.project.store.repository;

import co.edu.uniajc.project.store.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderModel, Long> {

  /*  @Query(nativeQuery = true, value = "SELECT * FROM product WHERE email = :email")
    Optional<ProductModel> findByEmail(@Param(value = "email") String email);

    @Query(nativeQuery = true, value = "SELECT count(*) FROM tasks WHERE id_responsible = :id")
    int countUserTasks(@Param(value = "id") Long id);
    */

}

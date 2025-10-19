package ma.mundia.tp2.repostory;

import ma.mundia.tp2.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterfaceReposotory extends JpaRepository<Product,Long> {
    List<Product> findByNomContains(String nom);
    List<Product> findByPrixGreaterThan(double price);
    @Query("SELECT p FROM Product p where p.nom LIKE :x")
    List<Product> search(@Param("x") String nom);

    List<Product> id(Long id);
}

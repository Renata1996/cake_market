package cakemanager.repositories;

import cakemanager.entities.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

    List<Cake> findAllByTitle(String substr);

    Cake findById(Long id);

}

package cake_manager.services;

import cake_manager.domain.Cake;

import java.util.List;

public interface CakeService {

    List<Cake> getAllCakes();

    Cake getCakeById(Long id);

    Cake saveOrUpdate(Cake cake);

    void delete(Long id);

    List<Cake> getCakesByTitle(String title);
}

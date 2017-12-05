package cakemanager.services;

import cakemanager.domain.Cake;

import java.util.List;

public interface CakeService {

    List<Cake> getAllCakes();

    Cake getCakeById(Long id);

    Cake saveOrUpdate(Cake cake);

    void delete(Long id);

    List<Cake> getCakesByTitle(String title);
}

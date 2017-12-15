package cakemanager.services;


import cakemanager.entities.Cake;
import cakemanager.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CakeServiceImpl implements CakeService {

    private CakeRepository cakeRepository;

    @Autowired
    public CakeServiceImpl(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @Override
    public List<Cake> getAllCakes() {
        List<Cake> cakeList = new ArrayList<>();
        cakeRepository.findAll().forEach(cakeList::add);
        return cakeList;
    }

    @Override
    public Cake getCakeById(Long id) {
        return cakeRepository.findById(id);
    }

    @Override
    public Cake saveOrUpdate(Cake cake) {
        cakeRepository.save(cake);
        return cake;
    }

    @Override
    public void delete(Long id) {
        cakeRepository.delete(id);
    }

    @Override
    public List<Cake> getCakesByTitle(String title) {
        List<Cake> cakeList = new ArrayList<>();
        cakeList.addAll(cakeRepository.findAllByTitle(title));
        return cakeList;
    }
}

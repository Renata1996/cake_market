package cakemanager.services;


import cakemanager.domain.Cake;
import cakemanager.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

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
        List<Cake> cakeList = new ArrayList<Cake>();
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
        List<Cake> cakeList = new ArrayList<Cake>();
        cakeList.addAll(cakeRepository.findAllByTitle(title));
        return cakeList;
    }
}

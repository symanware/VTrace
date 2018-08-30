package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.exception.BadRequestException;
import sample.exception.ResourceNotFoundException;
import sample.model.Wine;
import sample.repository.WineRepository;


import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class WineServiceImpl implements WineService {

    @Autowired
    WineRepository wineRepository;

    @Override
    public Wine findWineById(Integer wineId)  {

        Optional<Wine> wine = wineRepository.findById(wineId);
         if(!wine.isPresent())
             throw new ResourceNotFoundException("Resource not found for id " + wineId);

        //filter.massage
        if(wine.get().getLotCode().equals("16ZFYVPN")){
            wine.get().setLotCode("Bingo");
        }
        return wine.get();
    }

    @Override
    public List<Wine> findByProductStateId(Integer productStateId) {
        List<Wine> wine = wineRepository.findByProductStateId(productStateId);
        if(wine.isEmpty()){
            throw new ResourceNotFoundException("Resource not found for id " + productStateId);
        }
        return wine;
    }

    @Override
    public List<Wine> findByOwnerId(Integer ownerId) {
        List<Wine> wine = wineRepository.findByOwnerId(ownerId);
        if(wine.isEmpty()){
            throw new ResourceNotFoundException("Resource not found for id " + ownerId);
        }
        return wine;
    }
}

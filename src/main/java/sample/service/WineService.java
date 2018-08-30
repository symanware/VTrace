package sample.service;

import org.springframework.stereotype.Service;
import sample.model.Wine;
import java.util.List;

@Service
public interface WineService {

    public Wine findWineById(Integer wineId);
    public List<Wine> findByProductStateId(Integer productStateId);
    public List<Wine> findByOwnerId(Integer ownerId);

}

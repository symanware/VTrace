package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.model.Wine;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer> {


    public List<Wine> findByProductStateId(Integer productStateId);
    public List<Wine> findByOwnerId(Integer ownerId);
}

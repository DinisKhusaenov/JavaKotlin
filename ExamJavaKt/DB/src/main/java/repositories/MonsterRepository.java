package repositories;

import entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Integer>{

    Monster findByName(String name);
}

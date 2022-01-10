package repositories;

import entities.Pers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersRepository extends JpaRepository<Pers, Integer> {

    Pers findByName(String name);
}

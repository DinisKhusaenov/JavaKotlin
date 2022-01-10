package services;

import java.util.Collection;
import entities.Monster;
import repositories.MonsterRepository;

public class MonsterService {
    private final MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public Monster saveMonster(Monster monster) {
        Monster nameMonster = monsterRepository.findByName("MONSTER_NAME");
        return monsterRepository.save(monster);
    }

    public Collection<Monster> findAll() {
        return monsterRepository.findAll();
    }

    public Monster findByUsername(String name) {
        return monsterRepository.findByName(name);
    }

}

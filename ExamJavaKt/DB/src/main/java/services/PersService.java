package services;

import java.util.Collection;
import entities.Pers;
import repositories.PersRepository;

public class PersService {
    private final PersRepository persRepository;

    public PersService(PersRepository persRepository) {
        this.persRepository = persRepository;
    }

    public Pers savePers(Pers pers) {
        return persRepository.save(pers);
    }

    public Collection<Pers> findAll() {
        return persRepository.findAll();
    }

    public Pers findByUsername(String name) {
        return persRepository.findByName(name);
    }

}

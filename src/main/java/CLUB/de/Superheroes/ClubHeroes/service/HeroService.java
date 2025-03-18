package CLUB.de.Superheroes.ClubHeroes.service;

import CLUB.de.Superheroes.ClubHeroes.entity.Hero;
import CLUB.de.Superheroes.ClubHeroes.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Optional<Hero> getHeroById(Long id) {
        return heroRepository.findById(id);
    }

    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}

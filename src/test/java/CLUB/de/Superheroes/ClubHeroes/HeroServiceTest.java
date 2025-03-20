package CLUB.de.Superheroes.ClubHeroes;

import CLUB.de.Superheroes.ClubHeroes.entity.Hero;
import CLUB.de.Superheroes.ClubHeroes.repository.HeroRepository;
import CLUB.de.Superheroes.ClubHeroes.service.HeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Indica que la prueba se ejecuta en un contexto de Spring Boot
@SpringBootTest

class HeroServiceTest {

    private HeroRepository heroRepository;
    private HeroService heroService;

    // Método que se ejecuta antes de cada prueba para configurar las dependencias
    @BeforeEach
    void setUp() {

        // Se crea un mock del repositorio de héroes
        heroRepository = Mockito.mock(HeroRepository.class);

        // Se inicializa el servicio con el repositorio
        heroService = new HeroService(heroRepository);
    }

    // Prueba para verificar que se obtienen todos los héroes correctamente
    @Test
    void testGetAllHeroes() {
        // Se crea una lista de héroes simulada
        List<Hero> heroes = Arrays.asList(
                new Hero(1L, "Superman", "Super fuerza", "Krypton", 1, "Clark Kent", null),
                new Hero(2L, "Batman", "Alta inteligencia", "Gotham", 2, "Bruce Wayne", null)
        );
        // Se configura el comportamiento del mock para que devuelva la lista simulada
        when(heroRepository.findAll()).thenReturn(heroes);

        // Se llama al método del servicio que debe recuperar todos los héroes
        List<Hero> result = heroService.getAllHeroes();

        // Se verifica que el resultado tiene el tamaño esperado
        assertEquals(2, result.size());

        // Se verifica que el método findAll del repositorio fue llamado exactamente una vez
        verify(heroRepository, times(1)).findAll();
    }
}
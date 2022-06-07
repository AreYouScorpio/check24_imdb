package imdb_check24.web;

import imdb_check24.dto.FilmDto;
import imdb_check24.mapper.FilmMapper;
import imdb_check24.model.Film;
import imdb_check24.repository.FilmRepository;
import imdb_check24.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.*;

@Controller
public class FilmTLController {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmMapper filmMapper;

    @Autowired
    FilmRepository filmRepository;


    int a; // test

    private List<FilmDto> allFilms = new ArrayList<>();

    {
        allFilms.add(new FilmDto(1, "Jaws", "Spielberg"));

    }


    @Transactional
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }


    public Optional<Film> findById(long id) {
        return filmRepository.findById(id);
    }

    @Transactional
    public Film update(long id, Film film) {
        if (filmRepository.existsById(film.getId()))
            return filmRepository.save(film);
        else throw new NoSuchElementException();
    }

    @Transactional
    public void delete(long id) {
        filmRepository.deleteById(id);
    }


    @GetMapping("/")
    public String home() {
        System.out.println("hello"); // teszt kiírás frissül-e
        System.out.println(a); // teszt kiírás frissül-e
        return "index";
    }

    @GetMapping("/films")
    public String listFilms(Map<String, Object> model) {
        model.put("films", findAll());
        model.put("newFilm", new FilmDto());
        return "films";

    }

    @PostMapping("/films")
    public String addFilm(FilmDto film) {
        save(filmMapper.dtoToFilm(film));
        return "redirect:films";

    }


}

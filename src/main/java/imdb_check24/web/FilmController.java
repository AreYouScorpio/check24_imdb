package imdb_check24.web;

import imdb_check24.dto.FilmDto;
import imdb_check24.mapper.FilmMapper;
import imdb_check24.mapper.RatingMapper;
import imdb_check24.mapper.UserMapper;
import imdb_check24.model.Film;
import imdb_check24.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    //https://mapstruct.org/ minták !!! és pom.xml --- https://mapstruct.org/documentation/installation/

    @Autowired
    FilmService filmService;

    @Autowired
    FilmMapper filmMapper;




    @GetMapping
    public List<FilmDto> getAll() {
        return filmMapper.filmsToDtos(filmService.findAll());
    }


    @GetMapping("/{id}")
    public FilmDto getById(@PathVariable long id) {
        Film film = filmService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));


        return filmMapper.filmToDto(film);

    }


    @PostMapping
    public FilmDto createFilm(@RequestBody @Valid FilmDto filmDto /*, BindingResult errors */) {

        Film film = filmService.save(filmMapper.dtoToFilm(filmDto));
        return filmMapper.filmToDto(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable long id) {
        filmService.delete(id);
    }




    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> modifyFilm(@PathVariable long id,
                                              @RequestBody FilmDto filmDto) {

        Film film = filmMapper.dtoToFilm(filmDto);
        film.setId(id);
        try {
            FilmDto savedFilmDto = filmMapper.filmToDto(filmService.update(film));
            return ResponseEntity.ok(savedFilmDto);
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }






}

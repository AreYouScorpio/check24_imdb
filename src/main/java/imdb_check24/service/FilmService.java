package imdb_check24.service;

import imdb_check24.model.Film;
import imdb_check24.repository.FilmRepository;
import imdb_check24.repository.RatingRepository;
import imdb_check24.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FilmService {

    // Spring Data injection
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;


    @Transactional
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Transactional
    public Film update(Film film) {
        if (filmRepository.existsById(film.getId()))
            return filmRepository.save(film);
        else throw new NoSuchElementException();
    }


    public List<Film> findAll() {

        return filmRepository.findAll();
    }

    public Optional<Film> findById(long id) {
        return filmRepository.findById(id);
    }

    @Transactional
    public void delete(long id) {
        filmRepository.deleteById(id);
    }


}

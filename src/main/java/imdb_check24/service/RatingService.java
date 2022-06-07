package imdb_check24.service;

import imdb_check24.model.Film;
import imdb_check24.model.Rating;
import imdb_check24.repository.FilmRepository;
import imdb_check24.repository.RatingRepository;
import imdb_check24.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RatingService {

    // Spring Data injection
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;


    @Transactional
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Transactional
    public Rating update(Rating rating) {
        if (ratingRepository.existsById(rating.getId()))
            return ratingRepository.save(rating);
        else throw new NoSuchElementException();
    }


    public List<Rating> findAll() {

        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(long id) {
        return ratingRepository.findById(id);
    }

    @Transactional
    public void delete(long id) {
        ratingRepository.deleteById(id);
    }


}

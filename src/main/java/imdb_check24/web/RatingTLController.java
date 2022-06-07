package imdb_check24.web;

import imdb_check24.dto.FilmDto;
import imdb_check24.dto.RatingDto;
import imdb_check24.mapper.RatingMapper;
import imdb_check24.model.Rating;
import imdb_check24.repository.RatingRepository;
import imdb_check24.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class RatingTLController {

    @Autowired
    RatingService ratingService;

    @Autowired
    RatingMapper ratingMapper;

    @Autowired
    RatingRepository ratingRepository;


    @Transactional
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }


    public Optional<Rating> findById(long id) {
        return ratingRepository.findById(id);
    }

    @Transactional
    public Rating update(long id, Rating rating) {
        if (ratingRepository.existsById(rating.getId()))
            return ratingRepository.save(rating);
        else throw new NoSuchElementException();
    }

    @Transactional
    public void delete(long id) {
        ratingRepository.deleteById(id);
    }


    @GetMapping("/ratings")
    public String listUsers(Map<String, Object> model) {
        model.put("ratings", findAll());
        model.put("newRating", new RatingDto());
        return "ratings";

    }

    @PostMapping("/ratings")
    public String addRating(RatingDto rating) {
        save(ratingMapper.dtoToRating(rating));
        return "redirect:ratings";

    }


}

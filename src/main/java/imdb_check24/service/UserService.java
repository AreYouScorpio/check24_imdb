package imdb_check24.service;

import imdb_check24.model.ImdbUser;
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
public class UserService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;


    @Transactional
    public ImdbUser save(ImdbUser imdbUser) {
        return userRepository.save(imdbUser);
    }

    @Transactional
    public ImdbUser update(ImdbUser imdbUser) {
        if (userRepository.existsById(imdbUser.getId()))
            return userRepository.save(imdbUser);
        else throw new NoSuchElementException();
    }


    public List<ImdbUser> findAll() {
        return userRepository.findAll();
    }

    public Optional<ImdbUser> findById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }


}

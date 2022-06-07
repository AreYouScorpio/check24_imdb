package imdb_check24.web;

import imdb_check24.dto.FilmDto;
import imdb_check24.dto.UserDto;
import imdb_check24.mapper.UserMapper;
import imdb_check24.model.ImdbUser;
import imdb_check24.repository.UserRepository;
import imdb_check24.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.*;

@Controller
public class UserTLController {

    @Autowired
    RatingService ratingService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public ImdbUser save(ImdbUser imdbUser) {
        return userRepository.save(imdbUser);
    }

    public List<ImdbUser> findAll() {
        return userRepository.findAll();
    }


    public Optional<ImdbUser> findById(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public ImdbUser update(long id, ImdbUser imdbUser) {
        if (userRepository.existsById(imdbUser.getId()))
            return userRepository.save(imdbUser);
        else throw new NoSuchElementException();
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }


    @GetMapping("/users")
    public String listUsers(Map<String, Object> model) {
        model.put("users", findAll());
        model.put("newUser", new UserDto());
        return "users";

    }

    @PostMapping("/users")
    public String addUser(UserDto user) {
        save(userMapper.dtoToUser(user));
        return "redirect:users";

    }


}

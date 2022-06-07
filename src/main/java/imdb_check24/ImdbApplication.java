package imdb_check24;

import imdb_check24.service.FilmService;
import imdb_check24.service.RatingService;
import imdb_check24.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {


    @Autowired
    FilmService filmService;
    @Autowired
    RatingService ratingService;
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ImdbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }


}

package imdb_check24.dto;

import imdb_check24.model.Film;
import imdb_check24.model.ImdbUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class RatingDto {

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Film film;

    @ManyToOne
    private ImdbUser imdbUser;

    @Size(min = 1, max = 5)
    private int stars;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public ImdbUser getUser() {
        return imdbUser;
    }

    public void setUser(ImdbUser imdbUser) {
        this.imdbUser = imdbUser;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public RatingDto(Film film, ImdbUser imdbUser, int stars) {
        this.film = film;
        this.imdbUser = imdbUser;
        this.stars = stars;
    }

    public RatingDto() {
    }
}

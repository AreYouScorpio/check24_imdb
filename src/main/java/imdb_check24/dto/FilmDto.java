package imdb_check24.dto;

import javax.validation.constraints.Size;

public class FilmDto {
    private long id;

    @Size(min = 1, max = 30)
    private String title;
    @Size(min = 3, max = 20)
    private String director;
    @Size(min = 3, max = 20)
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public FilmDto(long id, String title, String director) {
        super();
        this.id = id;
        this.title = title;
        this.director = director;
    }

    public FilmDto() {
    }

}

package imdb_check24.mapper;

import imdb_check24.dto.FilmDto;
import imdb_check24.model.Film;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FilmMapper {

    List<FilmDto> filmsToDtos(List<Film> films);

    FilmDto filmToDto(Film film);

    Film dtoToFilm(FilmDto filmDto);
}




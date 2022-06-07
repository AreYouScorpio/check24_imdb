package imdb_check24.mapper;

import imdb_check24.dto.FilmDto;
import imdb_check24.dto.RatingDto;
import imdb_check24.model.Film;
import imdb_check24.model.Rating;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RatingMapper {

    List<RatingDto> ratingsToDtos(List<Rating> ratings);

    RatingDto ratingToDto(Rating rating);

    Rating dtoToRating(RatingDto ratingDto);
}




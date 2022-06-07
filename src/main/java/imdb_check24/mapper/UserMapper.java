package imdb_check24.mapper;

import imdb_check24.dto.UserDto;
import imdb_check24.model.ImdbUser;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDto> usersToDtos(List<ImdbUser> imdbUsers);

    UserDto userToDto(ImdbUser imdbUser);

    ImdbUser dtoToUser(UserDto userDto);
}




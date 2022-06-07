package imdb_check24.repository;

import imdb_check24.model.ImdbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ImdbUser, Long> {


}

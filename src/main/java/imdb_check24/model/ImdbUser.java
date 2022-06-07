package imdb_check24.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class ImdbUser {

    @Id
    @GeneratedValue
    private long id;
    @Size(min = 1, max = 10)
    private String userName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ImdbUser(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public ImdbUser() {
    }
}

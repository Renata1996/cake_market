package usermanager.user;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private int enabled;

}

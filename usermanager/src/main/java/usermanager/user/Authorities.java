package usermanager.user;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Authorities {

    @Id
    private String username;
    private String authority;

}

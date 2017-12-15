package usermanager.repositories;

import org.springframework.data.repository.CrudRepository;
import usermanager.user.Authorities;

public interface AuthoritiRepository extends CrudRepository<Authorities, String> {
}

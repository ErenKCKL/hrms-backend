package ashina.hrms.business.abstracts;

import ashina.hrms.core.utilities.results.DataResult;
import ashina.hrms.core.utilities.results.Result;
import ashina.hrms.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    User saveUser(User user);

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);


}

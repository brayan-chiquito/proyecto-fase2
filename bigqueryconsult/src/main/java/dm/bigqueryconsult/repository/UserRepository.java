package dm.bigqueryconsult.repository;

import dm.bigqueryconsult.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

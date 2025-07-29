package victordgarcez.api_rest_cloud.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victordgarcez.api_rest_cloud.API.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

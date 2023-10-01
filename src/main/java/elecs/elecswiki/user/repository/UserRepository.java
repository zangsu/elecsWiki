package elecs.elecswiki.user.repository;

import elecs.elecswiki.user.repository.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

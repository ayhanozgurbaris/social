package com.social.social.repos;
import com.social.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa yani repo'lar query atmanın metodlu halidir
public interface UserRepository extends JpaRepository<User, Long> {
}

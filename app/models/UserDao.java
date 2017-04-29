package models;

import models.ebean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Draft on 29.04.2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

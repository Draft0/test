package services;

import models.ebean.User;

/**
 * {@link models.ebean.User}
 */
public interface UserService {

    void save(User user);

    User findByEmail(String email);
}

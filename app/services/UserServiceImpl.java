package services;

import models.RoleDao;
import models.UserDao;
import models.ebean.Role;
import models.ebean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * implementation of {@link UserService} interface
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void  save(User user) {
        user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
        Set<Role> roles = new HashSet<>(  );
        roles.add( roleDao.getOne( 1L ) );
        user.setRoles( roles );
        userDao.save( user );
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail( email );
    }
}

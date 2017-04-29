package services;

import models.UserDao;
import models.ebean.Role;
import models.ebean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * impl of {@link UserDetailsService} interface
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail( email );

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(  );

        for (Role role : user.getRoles()) {
            grantedAuthorities.add( new SimpleGrantedAuthority( role.getName() ) );

        }
        return new org.springframework.security.core.userdetails.User( user.getEmail(), user.getPassword(), grantedAuthorities  );

    }
}

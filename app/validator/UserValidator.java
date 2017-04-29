package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import services.UserService;

/**
 * val for {@link models.ebean.User} class
 * impl {@link Validator} interface
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals( clazz );
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email", "Reguired" );
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue( "email", "Size.userForm.email" );
        }

        if (userService.findByEmail( user.getUsername() ) != null) {
            errors.rejectValue( "email", "Duplicate.userForm.username" );

        }

        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "password", "Reguired" );
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue( "password", "Size.userform.password" );
        }

    }

}

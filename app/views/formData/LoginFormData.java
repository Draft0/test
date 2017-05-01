package views.formData;

import models.UserDB;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Draft on 01.05.2017.
 */
public class LoginFormData {


    /** The submitted email. */
    public String email = "";
    /** The submitted password. */
    public String password = "";

    /** Required for form instantiation. */
    public LoginFormData() {
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<>();

        if (!UserDB.isValid(email, password)) {
            errors.add(new ValidationError("email", ""));
            errors.add(new ValidationError("password", ""));
        }

        return (errors.size() > 0) ? errors : null;
    }
}

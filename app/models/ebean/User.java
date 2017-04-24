package models.ebean;

import com.avaje.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public int id;

    @Constraints.Required
    @Formats.NonEmpty
    @Column(unique = true)
    public String email;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date dateCreation;

    @Formats.NonEmpty
    public Boolean validated = false;

    public static Model.Finder<Long, User> find = new Model.Finder<Long, User>( Long.class, User.class );

    public static User findByEmail(String email) {
        return find.where().eq( "email", email ).findUnique();
    }

    public static User authenticate(String email, String password) throws AppException {
        User user = find.where().eq( "email", email ).findUnique();
        if (user != null) {

            return user;
        }
        return null;
    }

    public static boolean confirm(User user) throws AppException {
        if (user == null) {
            return false;
        }


        user.validated = true;
        user.save();
        return true;
    }
}


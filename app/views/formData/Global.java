package views.formData;

import models.UserDB;
import play.Application;
import play.GlobalSettings;

import java.util.Date;

/**
 * Created by Draft on 01.05.2017.
 */
public class Global extends GlobalSettings {
    public void onStart(Application application) {
        UserDB.addUser( 1, "qwe@mail.ru", "play",(new Date() ) );
    }
}

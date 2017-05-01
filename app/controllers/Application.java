package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formData.LoginFormData;
import views.html.index;

/**
 * Created by Draft on 01.05.2017.
 */
public class Application extends Controller {

    public static Result index() {
        return ok( index.render( "Home", Secured.isLoggedIn( ctx() ), Secured.getUser( ctx() ) ) );
    }

    public static Result login() {
        Form <LoginFormData> formData = Form.form( LoginFormData.class );
        return ok( login.render( "Login", Secured.isLoggedIn( ctx() ), Secured.getUser( ctx() ), formData ) );
    }

    public static Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form <LoginFormData> formData = Form.form( LoginFormData.class ).bindFromRequest();

        if (formData.hasErrors()) {
            flash( "error", "Login credentials not valid." );
            return badRequest( login.render( "Login", Secured.isLoggedIn( ctx() ), Secured.getUser( ctx() ), formData ) );
        } else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session( "email", formData.get().email );
            return redirect( routes.Application.profile() );
        }
    }

    @Security.Authenticated(Secured.class)
    public static Result logout() {
        session().clear();
        return redirect( routes.Application.index() );
    }

    @Security.Authenticated(Secured.class)
    public static Result profile() {
        return ok( profile.render( "Profile", Secured.isLoggedIn( ctx() ), Secured.getUser( ctx() ) ) );
    }
}

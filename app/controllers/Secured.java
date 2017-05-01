package controllers;

import models.User;
import models.UserDB;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by Draft on 01.05.2017.
 */
public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context ctx) {
        return ctx.session().get( "email" );
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        return redirect(routes.Application.login());
    }

    public static String getUsers(Http.Context ctx) {
        return ctx.session().get("email");
    }

    public static boolean isLoggedIn(Http.Context ctx) {
        return (getUser(ctx) != null);
    }

    public static User getUser(Http.Context ctx) {
        return (isLoggedIn(ctx) ? UserDB.getUser(getUsers(ctx)) : null);
    }



}
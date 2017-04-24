package controllers;

import models.ebean.AppException;
import models.ebean.User;
import play.Logger;
import play.data.validation.Constraints;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;


public class HomeController extends Controller {


  public static Result GO_HOME = redirect(
          routes.HomeController.index()
  );

  public Result index() {
    // Check that the email matches a confirmed user before we redirect
    String email = ctx().session().get("email");
    if (email != null) {
      User user = User.findByEmail(email);
      if (user != null && user.validated) {
        return GO_HOME;
      } else {
        Logger.debug("Clearing invalid session credentials");
        session().clear();
      }
    }


    return null;
  }


  public static class Login {

    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;

    public String validate() {

      User user = null;
      try {
        user = User.authenticate(email, password);
      } catch (AppException e) {
        return Messages.get("error.technical");
      }
      if (user == null) {
        return Messages.get("invalid.user.or.password");
      } else if (!user.validated) {
        return Messages.get("account.not.validated.check.mail");
      }
      return null;
    }
  }

  public static class Register {

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String inputPassword;

    public String validate() {
      if (isBlank(email)) {
        return "Email is required";
      }

      if (isBlank(inputPassword)) {
        return "Password is required";
      }

      return null;
    }

    private boolean isBlank(String input) {
      return input == null || input.isEmpty() || input.trim().isEmpty();
    }
  }


  public Result logout() {
    session().clear();
    flash("success", Messages.get("youve.been.logged.out"));
    return GO_HOME;
  }
  }

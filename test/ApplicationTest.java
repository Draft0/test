import controllers.Secured;
import org.junit.*;

import play.twirl.api.Content;

import static org.junit.Assert.*;
import static play.mvc.Controller.ctx;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole Application, see the wiki for more details.
 *
 */
public class ApplicationTest {
    @Test
    public void index() throws Exception {
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void postLogin() throws Exception {
    }

    @Test
    public void logout() throws Exception {
    }

    @Test
    public void profile() throws Exception {
    }

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new Application is ready.", Secured.isLoggedIn( ctx() ), Secured.getUser( ctx() ) );
        assertEquals("text/html", html.contentType());
        assertTrue(html.body().contains("Your new Application is ready."));
    }


}

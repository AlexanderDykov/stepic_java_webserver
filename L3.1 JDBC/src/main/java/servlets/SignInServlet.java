package servlets;

import dbService.DBException;
import dbService.DBService;
import main.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DUX on 01.05.2016.
 */
public class SignInServlet extends HttpServlet {

    DBService dbService;

    public SignInServlet(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        if (login == null || pass == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserProfile profile = null;
        try {
            profile = dbService.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (profile != null && profile.getPassword().equals(pass)) {
            resp.getWriter().println("Authorized: ".concat(login));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

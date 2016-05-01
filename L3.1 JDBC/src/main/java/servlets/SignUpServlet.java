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
public class SignUpServlet extends HttpServlet {

    DBService dbService;

    public SignUpServlet(DBService dbService) {
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
        try {
            dbService.addUser(new UserProfile(login, pass));
            resp.getWriter().println("Signed Up");
        } catch (DBException e) {
            e.printStackTrace();
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

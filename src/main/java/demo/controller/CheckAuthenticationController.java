package demo.controller;

import demo.entity.Account;
import demo.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CheckAuthenticationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = ofy().load().type(Account.class)
                .filter("username", username)
                .filter("status", 1).first().now();
        if (account == null) {
            resp.sendError(404, "Not found");
            return;
        }
        if (StringUtil.comparePasswordWithSalt(password, account.getSalt(), account.getPassword())) {
           // login thành công.
        }
    }
}

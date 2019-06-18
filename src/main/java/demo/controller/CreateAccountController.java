package demo.controller;

import com.googlecode.objectify.ObjectifyService;
import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/account/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Account.class);
        Account account = new Account();
        account.setUsername(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        account.setSalt("123456");
        ofy().save().entity(account).now();
        resp.sendRedirect("/account/list");
    }
}

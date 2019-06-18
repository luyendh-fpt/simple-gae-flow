package demo.controller;

import com.googlecode.objectify.ObjectifyService;
import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class AccountDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(Account.class);
        String id = req.getParameter("id");
        Account account = ofy().load().type(Account.class).id(id).now();
        req.setAttribute("account", account);
        req.getRequestDispatcher("/admin/account/detail.jsp").forward(req, resp);
    }
}

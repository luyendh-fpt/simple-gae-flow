package demo.controller;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import demo.entity.Account;
import demo.entity.Student;

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
        ObjectifyService.register(Student.class);

        Account account = new Account();
        account.setUsername(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        account.setSalt("123456");

        Student student = new Student();
        student.setUsername(account.getUsername());
        student.setFullName("Hung");

        // set ref
        student.setAccountRef(Ref.create(account));
        account.setStudentRef(Ref.create(student));

        ofy().save().entity(account).now();
        ofy().save().entity(student).now();
        resp.sendRedirect("/account/list");
    }
}

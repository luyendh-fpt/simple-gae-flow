package demo.controller;

import demo.entity.ClassRoom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateClassRoomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/classroom/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        // validate data.
        ClassRoom classRoom = new ClassRoom(name, description);
        HashMap<String, String> errors = classRoom.validate();
        if (errors.size() == 0) {
            ofy().save().entity(classRoom).now();
            resp.sendRedirect("/classroom/list");
        } else {
            req.setAttribute("room", classRoom);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/classroom/form.jsp").forward(req, resp);
        }
    }
}

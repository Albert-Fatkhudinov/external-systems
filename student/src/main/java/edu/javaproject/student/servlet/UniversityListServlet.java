package edu.javaproject.student.servlet;

import edu.javaproject.student.domain.University;
import edu.javaproject.student.service.UniversityService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UniversityListServlet", urlPatterns = {"/universityList"})
public class UniversityListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        UniversityService service = webApplicationContext.getBean(UniversityService.class);

        List<University> list = service.findUniversities();
        list.forEach(u -> System.out.println(u.getUniversityId() + ": " +
                u.getUniversityName() + " " + u.getFaculties().size()));
        getServletContext().getRequestDispatcher("/universityList.jsp").forward(req, resp);
    }
}

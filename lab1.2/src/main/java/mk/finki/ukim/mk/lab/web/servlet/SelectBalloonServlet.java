package mk.finki.ukim.mk.lab.web.servlet;

import org.springframework.boot.web.servlet.server.Session;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "selectbaloonservlet" , urlPatterns = "/selectBalloon")
public class SelectBalloonServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        this.springTemplateEngine.process("selectBalloonSize.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = (String)req.getParameter("size");
        req.getSession().setAttribute("size", value);
        resp.sendRedirect("/BalloonOrder.do");
    }
}

package mk.finki.ukim.mk.lab.web.servlet;

import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.implementations.OrderServiceImplementation;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloonOrder", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderServiceImplementation orderService;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine, OrderServiceImplementation orderService){
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        this.springTemplateEngine.process("deliveryInfo.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = (String) req.getSession().getAttribute("value");
        String size = (String) req.getSession().getAttribute("size");

        String clientName = (String)req.getParameter("clientName");
        String clientAddress = (String)req.getParameter("clientAddress");

        orderService.placeOrder(color,clientName,clientAddress,size);

        String clientIPAddress = (String) req.getRemoteAddr();
        String clientBrowser = (String) req.getHeader("User-Agent");

        req.getSession().setAttribute("clName", clientName);
        req.getSession().setAttribute("clAddress", clientAddress);
        req.getSession().setAttribute("clientIPAddress",clientIPAddress);
        req.getSession().setAttribute("clientBrowser",clientBrowser);


        resp.sendRedirect("/ConfirmationInfo");
    }
}

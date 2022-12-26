package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class BaloonOrderController {

    private final OrderService orderService;

    public BaloonOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/BalloonOrder")
    protected String  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       return "deliveryInfo";
    }

    @PostMapping("/BalloonOrder")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String clientName = req.getParameter("clientName");
        String ballon =(String) session.getAttribute("color");
        session.setAttribute("clientName", clientName);
        LocalDateTime date = LocalDateTime.parse(req.getParameter("orderDate"));

        this.orderService.placeOrder(ballon, clientName, date);
        resp.sendRedirect("/ConfirmationInfo");
    }

}

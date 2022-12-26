package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.BalloonService;
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

@Controller
public class balloonSizeController {

    @GetMapping("/selectBalloon")
    protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "SelectBalloonSize";
    }
    @PostMapping("/selectBalloon")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("size", req.getParameter("size"));
        resp.sendRedirect("/BalloonOrder");
    }
}

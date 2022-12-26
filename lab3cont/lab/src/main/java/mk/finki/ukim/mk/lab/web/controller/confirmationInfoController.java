package mk.finki.ukim.mk.lab.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class confirmationInfoController {

    @GetMapping("/ConfirmationInfo")
    protected String doGet(HttpServletRequest req, HttpServletResponse resp,Model model) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String color =(String)session.getAttribute("color");
        String size = (String)session.getAttribute("size");
        String address = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        String clientName = (String)session.getAttribute("clientName");
        String clientAddress = (String)session.getAttribute("clientAddress");
        model.addAttribute("color", color);
        model.addAttribute("size", size);
        model.addAttribute("address", address);
        model.addAttribute("userAgent", userAgent);
        model.addAttribute("clientName", clientName);
        model.addAttribute("clientAddress", clientAddress);
        return "confirmationInfo";
    }

    /*@PostMapping("/ConfirmationInfo")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }*/
}

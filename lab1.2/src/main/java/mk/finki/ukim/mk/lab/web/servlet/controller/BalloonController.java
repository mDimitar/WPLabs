package mk.finki.ukim.mk.lab.web.servlet.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.Session;
import java.util.List;

//**

@Controller
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    private final OrderService orderService;

    //CDI
    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService,
                             OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
    }

    @GetMapping("/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("balloons", balloonService.listAll());
        return "listBalloons";
    }
    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String description,@RequestParam Long manufacturerId){
        balloonService.addBalloon(name,description,manufacturerId);
        return "redirect:/balloons";
    }
    //save after edit
    @PostMapping("/balloons/add/")
    public String saveEdit(@RequestParam Long id,@RequestParam String name, @RequestParam String description,@RequestParam Long manuId){
        balloonService.updateBalloon(id,name,description,manuId);
        return "redirect:/balloons";
    }
    @GetMapping("/balloons/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        balloonService.delete(id);
        return "redirect:/balloons";
    }
    @GetMapping("/balloons/add-form")
    public String getAddBalloonPage(Model model){
        model.addAttribute("manufacturers",manufacturerService.findAll());
        return "add-balloon"; //redirect na noviot html za dodavanje baloni
    }
    @GetMapping("/balloons/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        Balloon balloon = balloonService.findById(id);
        if(balloon == null)
            return "redirect:/balloons?=notexisting";
        model.addAttribute("balloon",balloon);
        model.addAttribute("manufacturers",manufacturerService.findAll());
        return "add-balloon";
    }
    @PostMapping("/orders")
    public String getOrdersPage(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "userOrders";
    }
}

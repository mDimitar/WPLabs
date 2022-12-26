package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BallonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BallonController(BalloonService balloonService, ManufacturerService manufacturerService,UserService userService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("balloons", this.balloonService.listAll());
        return "listBalloons";
    }
    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturerId){
        this.balloonService.addBalloon(name, description, manufacturerId);
        return "redirect:/balloons";
    }

    @PostMapping("/balloons/add/{id}")
    public String updateBalloon(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturerId){
        this.balloonService.updateBalloon(id, name, description, manufacturerId);
        return "redirect:/balloons";
    }
    @GetMapping("/balloons/add-form")
    public String getAddBalloonPage(Model model){
        model.addAttribute("manufactures", this.manufacturerService.findAll());
        return "add-balloon";
    }

    @GetMapping("/balloons/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        Balloon balloon = this.balloonService.findById(id);
        if(balloon == null)
            return "redirect:/balloons?error=balloon not exists";
        model.addAttribute("balloon", balloon);
        model.addAttribute("manufactures", this.manufacturerService.findAll());
        return "add-balloon";
    }
    @GetMapping("/balloons/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }
}

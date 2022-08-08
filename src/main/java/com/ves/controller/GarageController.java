package com.ves.controller;

import com.ves.entity.Account;
import com.ves.entity.Garage;
import com.ves.service.AccountService;
import com.ves.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
For Hasiru
 */

@Controller
@RequestMapping("/garage")
public class GarageController {

    @Autowired
    GarageService garageService;
    @Autowired
    AccountService accountService;


    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getGarageHome(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";
        List<Garage> garages = garageService.getAll();
        model.addAttribute("login", account);
        Garage garage = garageService.get(account);
        if (garage == null && account.isGarageOwner()){
            return "redirect:/garage/add";
        }

        model.addAttribute("garages", garages);
        model.addAttribute("my_garage", garage);

        return "garage/garages";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name, @RequestParam("phone") String number,
                      @RequestParam("longitude") Double longitude, @RequestParam("latitude") Double latitude,
                      @RequestParam("email") String email){

        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        Garage garage = new Garage(name, latitude, longitude, email, number, account.getRegisterId());
        Garage g = garageService.get(account);
        if (g != null){
            garage.setGarageId(g.getGarageId());
        }

        garageService.saveOrUpdate(garage);

        return "redirect:/garage/";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        Account account = accountService.getLogin();

        if (account == null) return "redirect:/login";

        Garage garage = garageService.get(account);
        model.addAttribute("garage", garage);
        model.addAttribute("login", account);

        return "garage/add";
    }


}

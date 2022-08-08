package com.ves.controller;

import com.ves.entity.Account;
import com.ves.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ves.entity.Mechanic;
import com.ves.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
For Avishka
 */

@Controller
@RequestMapping("/mechanic")
public class MechanicController {

    @Autowired
    MechanicService mechanicService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getHome(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("login", account);

        return "/mechanic/mechanic";
    }

    
    @RequestMapping(value = "/search_page", method ={RequestMethod.GET, RequestMethod.POST})
    public String sp_page(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("login", account);

        List<Mechanic> all = mechanicService.getAll();
        model.addAttribute("mechanics", all);

        return "/mechanic/customer_search";
    }

    @RequestMapping(value = "/mechanic_page", method =RequestMethod.GET)
    public String mechanic_page(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("login", account);

        return "/mechanic/mechanic";
    }

    @RequestMapping(value = "/add_mechanic", method =RequestMethod.POST)
    public String add_mechanic(@RequestParam("m_name") String m_name, @RequestParam("latitude") Double latitude,
                               @RequestParam("longitude") Double longitude,@RequestParam("price") Double price,
                               @RequestParam("type") String type,
                               Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("login", account);

        int owner_id = account.getRegisterId();
        Mechanic mechanic = new Mechanic(owner_id,m_name,type,latitude,longitude,price);
        mechanicService.saveOrUpdate(mechanic);

        return "redirect:/mechanic/search_page";
    }

}

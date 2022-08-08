package com.ves.controller;


import com.ves.entity.Account;
import com.ves.entity.Shop;
import com.ves.entity.ShopSparePart;
import com.ves.service.AccountService;
import com.ves.service.ShopService;
import com.ves.service.ShopSparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
For Sasindu
 */


@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;
    @Autowired
    ShopSparePartService shopSparePartService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String getShop(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";
        model.addAttribute("login", account);

        return "/Shop/shop";
    }


    @RequestMapping(value = "/add_shops", method =RequestMethod.POST)
    public String add_shops(@RequestParam("shop_name") String shop_name,@RequestParam("latitude") Double latitude,
                            @RequestParam("longitude") Double longitude,@RequestParam("Semail") String email,
                            Model model){

        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        int owner_id = account.getRegisterId();
        Shop shop = new Shop(owner_id,shop_name,latitude,longitude,email);
        shopService.saveOrUpdate(shop);

        return "redirect:/";
    }

    @RequestMapping(value = "/sp_page", method ={RequestMethod.GET, RequestMethod.POST})
    public String sp_page(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        return "/Shop/spare_part";
    }

    @RequestMapping(value = "/add_sp", method =RequestMethod.POST)
    public String add_sp(@RequestParam("shop_name") String shop_name,
                         @RequestParam("vehicle_model") String vehicle_model,
                         @RequestParam("sp_name") String sp_name,
                         @RequestParam("qty") int qty,
                         @RequestParam("price") Double price,
                         Model model){

        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";
        Shop shop = shopService.get(account);

        ShopSparePart shop_sp = new ShopSparePart(shop.getShopId(),vehicle_model,sp_name,qty,price);
        shopSparePartService.saveOrUpdate(shop_sp);

        return "redirect:/shop/sp_page";
    }

    @RequestMapping(value = "/shop_page", method =RequestMethod.GET)
    public String shop_page(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        return "/Shop/shop";
    }

    @RequestMapping(value = "/profile", method =RequestMethod.GET)
    public String profile(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("account", account);

        return "/Shop/owner_profile";
    }

    @RequestMapping(value = "/search_page", method = {RequestMethod.GET, RequestMethod.POST})
    public String search_page(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        return "/Shop/customer_search";
    }

    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    public String search(@RequestParam("search_item") String search_item,@RequestParam("s_radio") String s_radio,Model model){

        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";


        if(s_radio.equals("shop")){
            List<Shop> shop = shopService.search_shop(search_item);
            model.addAttribute("shop", shop);       
        }
        else{
            List<ShopSparePart> sparePart = shopSparePartService.search_part(search_item);
            model.addAttribute("spare", sparePart);
        }

        return "/Shop/customer_search";
    }


}

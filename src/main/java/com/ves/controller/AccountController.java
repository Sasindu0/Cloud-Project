package com.ves.controller;


import com.ves.entity.Account;
import com.ves.service.AccountService;
import com.ves.service.BoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
/*
For Navod
 */
public class AccountController {

    @Autowired BoomService boomService;
    @Autowired
    AccountService accountService;


    @RequestMapping(value = {"/", ""}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Model model){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        model.addAttribute("login", account);


        return "home";
    }

    @RequestMapping(value = "/login/submit", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        boolean success = accountService.login(username, password);
        if (success) {
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register/submit", method = RequestMethod.POST)
    public String register(@RequestParam MultiValueMap<String, String> data){
        String name = data.getFirst("name");
        String a = data.getFirst("age");
        Integer age = a == null ? -1 : Integer.parseInt(a);
        String address = data.getFirst("address");
        String mobileNumber = data.getFirst("phone");
        String email = data.getFirst("email");
        String username = data.getFirst("username");
        String password = data.getFirst("password");
        String accountType = data.getFirst("type");

        Account account = new Account(name, age, address, mobileNumber, email, username, password, accountType);
        boolean register = accountService.register(account);
        if (register) return "redirect:/";
        return "redirect:/register";

    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLogin(){

        return "account/login";
    }


    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public String getRegister(){
        return "account/register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        accountService.logout();
        return "redirect:/";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model){
        Account login = accountService.getLogin();
        if (login == null) return "redirect:/login";

        model.addAttribute("login", login);
        return "account/profile/profile-view";
    }


    @RequestMapping(value = "/profile/upload", method = RequestMethod.POST)
    public String updateImage(@RequestParam("image") MultipartFile image){
        Account login = accountService.getLogin();
        if (login == null) return "redirect:/login";
        try {
            byte[] bytes = image.getBytes();
            login.setIcon(bytes);
            accountService.saveOrUpdate(login);
        } catch (IOException ignored) {
        }

        return "redirect:/profile";
    }


    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    public String update(@RequestParam MultiValueMap<String, String> data){
        Account account = accountService.getLogin();
        if (account == null) return "redirect:/login";

        String name = data.getFirst("name");
        String a = data.getFirst("age");
        Integer age = a == null ? -1 : Integer.parseInt(a);
        String address = data.getFirst("address");
        String mobileNumber = data.getFirst("phone");
        String email = data.getFirst("email");
        String password = data.getFirst("password");
        String accountType = data.getFirst("type");

        account.setData(name, age, address, mobileNumber, email ,account.getUsername(), password, accountType);
        accountService.saveOrUpdate(account);

        return "account/profile/profile-view";

    }



}

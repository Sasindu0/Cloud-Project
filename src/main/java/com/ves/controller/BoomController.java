package com.ves.controller;

import com.ves.entity.*;
import com.ves.service.AccountService;
import com.ves.service.BoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/*
For Hasith
 */

@Controller
@RequestMapping("/boom-truck")
public class BoomController {

    @Autowired
    BoomService boomService;
    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession httpSession;


    @RequestMapping(value = {"/", ""}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getHome(Model model){
        Account account = accountService.getLogin();

        if (account == null) return "redirect:/login";

        HashMap<String, List<BoomBoomingSession>> sessions = boomService.getBoomingSessions(account);
        model.addAttribute("expired", sessions.get("expired"));
        model.addAttribute("on_going", sessions.get("on_going"));
        model.addAttribute("cancelled", sessions.get("cancelled"));
        model.addAttribute("completed", sessions.get("completed"));
        model.addAttribute("un_approved", sessions.get("un_approved"));

        model.addAttribute("trucks", boomService.getAllAvailable());
        model.addAttribute("login", account);
        BoomTruck truck = boomService.get(account);
        model.addAttribute("boom_truck", truck);
        return "boom/home";
    }

    @RequestMapping(value = "/near", method = RequestMethod.GET)
    public String getNearestTrucks(Model model,
                                   @RequestParam("lat") double latitude,
                                   @RequestParam("lon") double longitude
                                   ){
        Account account = accountService.getLogin();
        if (account == null) {
            model.addAttribute("Error", "E Session expired!");
            return "boom/error";
        }

        List<BoomTruck> trucks = boomService.getAllNearAvailable(latitude, longitude);
        model.addAttribute("trucks", trucks);

        return "boom/customer/near";

    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public String requestSession(
            @RequestParam("vehicle") String vehicle,
            @RequestParam("type") String type,
            @RequestParam("id") int truck,
            @RequestParam("lat") double latitude,
            @RequestParam("lon") double longitude
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        //Validation
        BoomTruck t = boomService.get(truck);
        BoomDraggingVehicle v = new BoomDraggingVehicle(type, vehicle, latitude, longitude, account.getRegisterId());
        boomService.requestSession(account, v, t);
        return "0";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    @ResponseBody
    public String cancel(
            @RequestParam("id") int id
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        BoomBoomingSession session = boomService.getSession(id);
        if (session == null){
            return "Unable to find booming session!";
        }

        if (session.getCustomerId().equals(account.getRegisterId())){
            boomService.cancel(session, true);
        }else if (session.getTruck().getDriver().getRegisterId().equals(account.getRegisterId())) {
            boomService.cancel(session, false);
        }else {
            return "Unauthorized action!";
        }

        return "0";
    }

    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    @ResponseBody
    public String complete(
            @RequestParam("id") int id
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        BoomBoomingSession session = boomService.getSession(id);
        if (session == null){
            return "Unable to find booming session!";
        }

        if (session.getCustomerId().equals(account.getRegisterId())){
            boomService.complete(session);
        }else if (session.getTruck().getDriver().getRegisterId().equals(account.getRegisterId())) {
            boomService.complete(session);
        }else {
            return "Unauthorized action!";
        }

        return "0";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET)
    @ResponseBody
    public String approve(
            @RequestParam("id") int id
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        BoomBoomingSession session = boomService.getSession(id);
        if (session == null){
            return "Unable to find booming session!";
        }

        if (session.getTruck().getDriver().getRegisterId().equals(account.getRegisterId())) {
            boomService.approve(session);
        }else {
            return "Unauthorized action!";
        }

        return "0";
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    @ResponseBody
    public String available(
            @RequestParam("available") boolean available
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        if (account.isDriver()) {
            BoomTruck truck = boomService.get(account);
            if (truck == null){
                return "You don't have a boom truck!";
            }
            truck.setAvailable(available);
            boomService.saveOrUpdate(truck);
            return truck.getAvailable() ? "1" : "0";
        }
        else {
            return "Unauthorized action!";
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String updateInfo(
            @RequestParam("vehicle") String vehicle,
            @RequestParam("licence") String licence,
            @RequestParam("price") String price,
            @RequestParam("lat") double latitude,
            @RequestParam("lon") double longitude
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        BoomTruck truck = boomService.get(account);
        if (truck == null){
            truck = new BoomTruck();
            truck.setDriver(account);
            truck.setDriverId(account.getRegisterId());
        }

        vehicle = vehicle.toUpperCase(Locale.ROOT);
        if (!(vehicle.matches("[A-Z][A-Z]\\s+-\\s+\\d\\d\\d\\d")
                || vehicle.matches("[A-Z][A-Z][A-Z]\\s+-\\s+\\d\\d\\d\\d"))){
            return "Invalid vehicle number";
        }

        double p;
        try {
            p = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return "Invalid price per km!";
        }
        truck.setPricePerKm(p);
        truck.setVehicleNumber(vehicle);
        truck.setLicence(licence);
        truck.setLatitude(latitude);
        truck.setLongitude(longitude);

        boomService.saveOrUpdate(truck);

        return "0";
    }

    @RequestMapping(value = "/update-location", method = RequestMethod.GET)
    @ResponseBody
    public String updateLocation(
            @RequestParam("lat") double latitude,
            @RequestParam("lon") double longitude
    ){
        Account account = accountService.getLogin();
        if (account == null) {
            return "Session expired!";
        }

        BoomTruck truck = boomService.get(account);
        if (truck == null){
            return "You don't have a truck";
        }

        truck.setLongitude(longitude);
        truck.setLatitude(latitude);

        boomService.saveOrUpdate(truck);

        return "0";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String updateLocation(
            @RequestParam("id") int id,
            Model model
    ){

        Account account = accountService.getLogin();

        if (account == null){
            return "boom/boom info";
        }

        BoomBoomingSession session = boomService.getSession(id);
        model.addAttribute("session", session);
        return "boom/boom info";
    }

    @RequestMapping(value = "/track", method = RequestMethod.GET)
    @ResponseBody
    public String trackLocation(
            @RequestParam("id") int id,
            Model model
    ){

        Account account = accountService.getLogin();

        if (account == null){
            return "Your session is expired!";
        }

        BoomBoomingSession session = boomService.getSession(id);
        if (session == null) return "Invalid session";
        if (!session.isOngoing()) return "Session is not ongoing!";

        if (account.getRegisterId().equals(session.getCustomerId())){
            return String.format(
                    "0 Customer's %f %f",
                    session.getTruck().getLatitude(), session.getTruck().getLongitude()
            );
        }else {
            return String.format(
                    "0 Driver's %f %f",
                    session.getCustomerVehicle().getLatitude(), session.getCustomerVehicle().getLongitude()
            );
        }

    }




}

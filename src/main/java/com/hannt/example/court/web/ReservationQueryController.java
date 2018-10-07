package com.hannt.example.court.web;

import com.hannt.example.court.domain.Reservation;
import com.hannt.example.court.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {
    private ReservationService reservationService;
    @Autowired
    public void setReservationService(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public void setupForm(){}

    @PostMapping
    public String submitForm(@RequestParam("courtName") String courtName, Model model){
        List<Reservation> reservations = Collections.emptyList();
        if(!StringUtils.isEmpty(courtName)){
            reservations = reservationService.query(courtName);
        }
        model.addAttribute("reservations", reservations);
        return "reservationQuery";
    }
}

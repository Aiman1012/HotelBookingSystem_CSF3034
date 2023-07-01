package com.myHotel.Controller;

import com.myHotel.Exception.UserNotFoundException;
import com.myHotel.Model.Reservation;
import com.myHotel.Model.Room;
import com.myHotel.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ReservationController {
@Autowired
    public ReservationService reservationService;

    @GetMapping("/reservations")
    public String showReservationList(Model model){
        List<Reservation> listReservations = reservationService.listAll();
        model.addAttribute("ListReservations", listReservations);

        return "ReservationList";
    }

    @GetMapping("/reservationList/new")
    public String addNewReservation(Model model){
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("pageTitle", "Add New Reservation");

        return "addReservation";
    }

    @PostMapping("/reservationList/save")
    public String saveReservation(Reservation reservation, RedirectAttributes ra){
        reservationService.save(reservation);
        ra.addFlashAttribute("message", "The reservation has been saved successfully");
        return "redirect:/reservations";
    }

    @GetMapping("/reservationList/edit/{reservationList}")
    public String editReservation(@PathVariable("reservationList") Integer reservationId, Model model, RedirectAttributes ra){
        try {
            Reservation reservation = reservationService.get(reservationId);
            model.addAttribute("reservation", reservation);
            model.addAttribute("pageTitle", "Edit Reservation (ID : " + reservationId+ ")");
            return "addReservation";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/rooms";
        }
    }

    @GetMapping("/reservationList/delete/{reservationId}")
    public String deleteReservation(@PathVariable("reservationId") Integer reservationId, RedirectAttributes ra){
        try {
            reservationService.deleteReservation(reservationId);
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", "The user has been deleted.");
        }
        return "redirect:/reservations";
    }
}

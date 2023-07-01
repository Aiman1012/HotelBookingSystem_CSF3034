package com.myHotel.Controller;

import com.myHotel.Exception.UserNotFoundException;
import com.myHotel.Model.Room;
import com.myHotel.Service.RoomService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RoomController {
    @Autowired private RoomService roomService;
    
    @GetMapping("/rooms")
    public String showRoomList(Model model){
        List<Room> listRooms = roomService.listAll();
        model.addAttribute("ListRooms", listRooms);

        return "roomList";
    }

    @GetMapping("/roomList/new")
    public String addNewRoom(Model model){
        Room room = new Room();
        model.addAttribute("room", room);
        model.addAttribute("pageTitle", "Add New Room");

        return "addRoom";
    }

    @PostMapping("/roomList/save")
        public String saveRoom(Room room, RedirectAttributes ra){
            roomService.save(room);
            ra.addFlashAttribute("message", "The room has been saved successfully");
            return "redirect:/rooms";
        }
    @GetMapping("/roomList/edit/{roomId}")
    public String editRoom(@PathVariable("roomId") Integer roomId, Model model, RedirectAttributes ra){
        try {
            Room room = roomService.get(roomId);
            model.addAttribute("room", room);
            model.addAttribute("pageTitle", "Edit Room (ID : " + roomId+ ")");
            return "addRoom";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/rooms";
        }
    }


    @GetMapping("/roomList/delete/{roomId}")
    public String deleteRoom(@PathVariable("roomId") Integer roomId, RedirectAttributes ra){
        try {
            roomService.deleteRoom(roomId);
        }catch (UserNotFoundException e){
            ra.addFlashAttribute("message", "The user has been deleted.");
        }
        return "redirect:/rooms";
    }

}

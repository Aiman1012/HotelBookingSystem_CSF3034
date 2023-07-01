package com.myHotel.Service;

import com.myHotel.Exception.UserNotFoundException;
import com.myHotel.Model.Room;
import com.myHotel.Repository.RoomRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired private RoomRepository roomRepo;

    public List<Room> listAll(){
        return (List<Room>) roomRepo.findAll();
    }

    public void save(Room room) {
        roomRepo.save(room);
    }

    public Room get(Integer roomId) throws UserNotFoundException {
        Optional<Room> resultRoom = roomRepo.findById(roomId);
        if (resultRoom.isPresent()){
            return resultRoom.get();
        }
        throw new UserNotFoundException("Could not found any room with ID " + roomId);
    }

    public void deleteRoom(Integer roomId) throws UserNotFoundException {
        Long roomCount = roomRepo.countByRoomId(roomId);
        if(roomCount== null || roomCount == 0){
            throw new UserNotFoundException("Could not found any room with ID " + roomId);
        }
        roomRepo.deleteById(roomId);
    }
}

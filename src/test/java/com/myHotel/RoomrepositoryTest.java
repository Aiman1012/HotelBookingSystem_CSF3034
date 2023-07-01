package com.myHotel;

import com.myHotel.Model.Room;
import com.myHotel.Repository.RoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)

public class RoomrepositoryTest {
    @Autowired private RoomRepository roomrepo;

    @Test
    public void testAddRoom(){
        Room room = new Room();

        room.setRoomName("Room 2");
        room.setRoomPrice("RM 456");
        room.setRoomAvail(false);

        Room savedRoom = roomrepo.save(room);

        Assertions.assertThat(savedRoom).isNotNull();
        Assertions.assertThat(savedRoom.getRoomId()).isGreaterThan(0);
    }

    @Test
    public void testListRoom(){
        Iterable<Room> rooms = roomrepo.findAll();
        Assertions.assertThat(rooms).hasSizeGreaterThan(0);

        for(Room room : rooms){
            System.out.println(room);
        }
    }
    @Test
    public void testUpdateRoom(){
        Integer roomId =1;
        Optional<Room> optionalRoom = roomrepo.findById(roomId);
        Room room= optionalRoom.get();
        room.setRoomPrice("RM 145");
        roomrepo.save(room);

        Room updatedRoom= roomrepo.findById(roomId).get();
        Assertions.assertThat(updatedRoom.getRoomPrice()).isEqualTo("RM 145");
    }

    @Test
    public void testGet(){
        Integer roomId = 2;
        Optional<Room> optionalRoom = roomrepo.findById(roomId);
        Room room =optionalRoom.get();

        Assertions.assertThat(optionalRoom).isPresent();
        System.out.println(optionalRoom.get());
    }

    @Test
    public void testDeleteRoom(){
        Integer roomId=2;
        roomrepo.deleteById(roomId);

        Optional<Room> optionalRoom = roomrepo.findById(roomId);
        Assertions.assertThat(optionalRoom).isNotPresent();

    }
}

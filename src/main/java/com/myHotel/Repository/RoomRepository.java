package com.myHotel.Repository;

import com.myHotel.Model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    Long countByRoomId(Integer roomId);
}

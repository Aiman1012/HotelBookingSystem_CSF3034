package com.myHotel.Repository;

import com.myHotel.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository  extends CrudRepository<Reservation, Integer> {
    Long countByReservationId(Integer reservationId);
}

package com.myHotel.Service;

import com.myHotel.Exception.UserNotFoundException;
import com.myHotel.Model.Reservation;
import com.myHotel.Model.Room;
import com.myHotel.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reserveRepo;

    public List<Reservation> listAll(){
        return (List<Reservation>)  reserveRepo.findAll();
    }

    public void save(Reservation reservation){
        reserveRepo.save(reservation);
    }

    public Reservation get(Integer reservationId) throws UserNotFoundException {
        Optional<Reservation> resultReserve = reserveRepo.findById(reservationId);
        if (resultReserve.isPresent()){
            return resultReserve.get();
        }
        throw new UserNotFoundException("Could not found any reservation with ID " + reservationId);
    }

    public void deleteReservation(Integer reservationId) throws UserNotFoundException {
        Long reservationCount = reserveRepo.countByReservationId(reservationId);
        if(reservationCount== null || reservationCount == 0){
            throw new UserNotFoundException("Could not found any room with ID " + reservationId);
        }
        reserveRepo.deleteById(reservationId);
    }
}

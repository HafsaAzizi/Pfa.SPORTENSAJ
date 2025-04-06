package com.example.pfa.repository;

import com.example.pfa.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

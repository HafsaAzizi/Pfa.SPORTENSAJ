package com.example.pfa.event;

import com.example.pfa.entity.Reservation;
import org.springframework.context.ApplicationEvent;

public class ReservationExpiredEvent extends ApplicationEvent {
    private final Reservation reservation;

    public ReservationExpiredEvent(Object source, Reservation reservation) {
        super(source);
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
}
package com.example.pfa.entity;

import com.example.pfa.enums.RequestStatus;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "reservation_date", nullable = false)
    private Instant reservationDate;

    @Column(name = "reservation_end", nullable = false)
    private Instant reservationEnd;

    @Column(name = "duration", nullable = false)
    private Duration duration;

    @OneToOne
    @JoinColumn(name = "request_user_id", nullable = false, unique = true)
    private PlatformUser requestOwner;

    @Column(name = "request_text")
    private String requestText;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "reservation_field", nullable = false)
    private Field field;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "app_user_id", nullable = false)
    private Set<PlatformUser> player;


    public Reservation() {}

    public Reservation(Long id, Instant reservationDate, Instant reservationEnd, Duration duration, PlatformUser requestOwner, String requestText, String password, RequestStatus status, Field field, Set<PlatformUser> player) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.reservationEnd = reservationEnd;
        this.duration = duration;
        this.requestOwner = requestOwner;
        this.requestText = requestText;
        this.password = password;
        this.status = status;
        this.field = field;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Instant reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Instant getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Instant reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Set<PlatformUser> getPlayer() {
        return player;
    }

    public void setPlayer(Set<PlatformUser> player) {
        this.player = player;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public PlatformUser getRequestOwner() {
        return requestOwner;
    }

    public void setRequestOwner(PlatformUser requestOwner) {
        this.requestOwner = requestOwner;
    }
}

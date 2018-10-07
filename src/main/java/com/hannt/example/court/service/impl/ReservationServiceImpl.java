package com.hannt.example.court.service.impl;

import com.hannt.example.court.domain.Player;
import com.hannt.example.court.domain.Reservation;
import com.hannt.example.court.domain.SportType;
import com.hannt.example.court.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    public static final SportType TENNIS = new SportType(1, "Tennis");
    public static final SportType SOCCER = new SportType(2, "Soccer");

    private final List<Reservation> reservations = new ArrayList<>();

    public ReservationServiceImpl() {
        reservations.add(new Reservation("Tennis #1", new Date(), 16,
                new Player("Roger", "N/A"), TENNIS));
        reservations.add(new Reservation("Tennis #2", new Date(), 20,
                new Player("James", "N/A"), TENNIS));
        reservations.add(new Reservation("Soccer #1", new Date(), 20,
                new Player("Kim", "N/A"), SOCCER));
    }

    @Override
    public List<Reservation> query(final String name) {
        return reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getCourtName(), name))
                .collect(Collectors.toList());
    }
}

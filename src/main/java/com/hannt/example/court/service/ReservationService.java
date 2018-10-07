package com.hannt.example.court.service;

import com.hannt.example.court.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> query(String name);
}

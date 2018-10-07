package com.hannt.example.court.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private String courtName;
    private Date date;
    private int hour;
    private Player player;
    private SportType sportType;
}

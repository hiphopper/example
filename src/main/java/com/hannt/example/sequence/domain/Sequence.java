package com.hannt.example.sequence.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;
}

package com.hannt.example.sequence;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
public class SequenceGenerator {
    @Setter private String prefix;
    @Setter private String suffix;
    @Setter private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence(){
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);

        return builder.toString();
    }
}

package com.hannt.example.sequence;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
public class SequenceGenerator {
    @Setter private String prefix;
    private String suffix;
    @Setter private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    @Required
    public void setSuffix(String suffix){
        this.suffix = suffix;
    }

    public String getSequence(){
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);

        return builder.toString();
    }
}

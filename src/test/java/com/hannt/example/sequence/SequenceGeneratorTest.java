package com.hannt.example.sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceGeneratorTest {
    @Test
    public void incrementSequence(){
        final String prefix = "10";
        final int initial = 1000;
        final String suffix = "A";
        int idx = 0;

        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setPrefix(prefix);
        sequenceGenerator.setInitial(initial);
        sequenceGenerator.setSuffix(suffix);

        assertEquals((prefix+initial+(idx++)+suffix), sequenceGenerator.getSequence());
        assertEquals((prefix+initial+(idx++)+suffix), sequenceGenerator.getSequence());
    }
}

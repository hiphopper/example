package com.hannt.example.sequence.config;

import com.hannt.example.sequence.SequenceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(SequenceGeneratorConfiguration.class)
public class SequenceGeneratorConfigurationWithSupporterTest {
    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Test
    public void notNullSequenceGenerator(){
        assertNotNull(sequenceGenerator);
    }
}

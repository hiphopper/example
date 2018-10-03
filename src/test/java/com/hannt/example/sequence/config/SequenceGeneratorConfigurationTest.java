package com.hannt.example.sequence.config;

import com.hannt.example.sequence.SequenceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SequenceGeneratorConfigurationTest {
    @Test
    public void notNullSequenceGenerator(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
        SequenceGenerator sequenceGenerator = context.getBean("sequenceGenerator", SequenceGenerator.class);

        assertNotNull(sequenceGenerator);

        assertEquals("301000000A", sequenceGenerator.getSequence());
        assertEquals("301000001A", sequenceGenerator.getSequence());

        ((AnnotationConfigApplicationContext) context).close();
    }
}

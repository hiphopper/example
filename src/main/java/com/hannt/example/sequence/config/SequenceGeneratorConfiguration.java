package com.hannt.example.sequence.config;

import com.hannt.example.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceGeneratorConfiguration {
    @Bean
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator seqGen = new SequenceGenerator();
        seqGen.setPrefix("30");
        seqGen.setSuffix("A");
        seqGen.setInitial(100000);

        return seqGen;
    }
}

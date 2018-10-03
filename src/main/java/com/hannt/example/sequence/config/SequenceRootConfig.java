package com.hannt.example.sequence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(
    basePackages = "com.hannt.example.sequence",
    includeFilters = {
        @ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = {"com.hannt.example.sequence.*.dao.*Dao", "com.hannt.example.sequence.*.*Service"}
        )
    },
    excludeFilters = {
        @ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = Controller.class
        )
    }
)
public class SequenceRootConfig {
}

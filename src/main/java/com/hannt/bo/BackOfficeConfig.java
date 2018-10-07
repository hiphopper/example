package com.hannt.bo;

import com.hannt.core.RootConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(RootConfig.class)
public class BackOfficeConfig {
}

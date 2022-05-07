package com.tedu.dataaccess.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring的配置类，它替代了applicationContext.xml
 */
@Configuration
@ComponentScan(value="com.tedu.dataaccess",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringConfiguration {
}

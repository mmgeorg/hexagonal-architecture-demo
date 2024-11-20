package com.demo.bar;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.demo.bar",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {TypeExcludeFilter.class})})
public class BarComponentConfiguration {
}

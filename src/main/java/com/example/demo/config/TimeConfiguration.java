package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;


//for format datetime of posts in post.html source: https://gist.github.com/romach/337a788b5303454e08811b80767f55f1
@Configuration
public class TimeConfiguration {

    @Bean
    public IDialect conditionalCommentDialect() {
        return new Java8TimeDialect();
    }
}

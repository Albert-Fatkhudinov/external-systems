package edu.javaproject.register.config;

import edu.javaproject.register.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/register.properties")
public class MarriageConfig {

    @Bean
    public PersonDao buildPersonDao() {
        System.out.println("Person is created");
        return new PersonDao();
    }
}

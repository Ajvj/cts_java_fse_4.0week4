// src/main/java/com/zoho/restcountries/RestCountryServiceApplication.java
package com.zoho.restcountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
@ImportResource("classpath:country.xml")
public class RestCountryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestCountryServiceApplication.class, args);
    }
}

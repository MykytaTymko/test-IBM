package com.tests.testibmback;

import com.tests.testibmback.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The class responsible for running the server part of our application.
 */
@SpringBootApplication
public class TestIbmBackApplication implements ApplicationRunner {

    @Autowired
    private LocationService locationService;

    /**
     * The method responsible for running the server part of our application.
     */
    public static void main(String[] args) {
        SpringApplication.run(TestIbmBackApplication.class, args);
    }

    /**
     * In this method, we automatically fill the database when the application starts.
     */
    @Override
    public void run(ApplicationArguments args) {
        locationService.fillDatabase();
    }
}

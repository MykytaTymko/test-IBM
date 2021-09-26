package com.tests.testibmback.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tests.testibmback.model.Location;
import com.tests.testibmback.repository.ILocationRepo;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LocationService implementation.
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ILocationRepo locationRepo;

    @Override
    public List<Location> findAll() {
        return locationRepo.findAll();
    }

    @Override
    public Location findById(final Long id) {
        if (locationRepo.findById(id).isPresent()) {
            return locationRepo.findById(id).get();
        }
        return null;
    }


    @Override
    public Location save(final Location location) {
        locationRepo.save(location);
        return location;
    }

    @Override
    public void delete(final Long id) {
        Location location = findById(id);
        locationRepo.delete(location);
    }

    @Override
    public List<Location> fillDatabase() {
        ObjectMapper objectMapper = new ObjectMapper();
        Location[] locations = new Location[0];
        try {
            locations = objectMapper.readValue(
                   new URL("https://data.sfgov.org/resource/yitu-d5am.json?$select=locations,title"), Location[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locationRepo.saveAll(Arrays.asList(locations));
    }
}

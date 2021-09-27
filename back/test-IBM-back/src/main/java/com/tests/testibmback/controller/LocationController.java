package com.tests.testibmback.controller;

import com.tests.testibmback.model.Location;
import com.tests.testibmback.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Location class controller.
 */
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationService locationService;

    /**
     * The method returns a list of all places that are present in the database.
     *
     * @return list of all existing locations.
     */
    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locationList =  locationService.findAll();
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    /**
     * The method returns the place by its id.
     *
     * @param id - place id.
     *
     * @return returns the location with the specified id or null.
     */
    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable final Long id) {
        Location location = locationService.findById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    /**
     * The method creates a new location and enters it into the database.
     *
     * @param location - created location.
     *
     * @return new location.
     */
    @PostMapping("/locations")
    public ResponseEntity<Location> saveLocation(@RequestBody final Location location) {
        Location newLocation = locationService.save(location);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }

    /**
     * The method updates the data in the existing location.
     *
     * @param location - the existing location that we want to change.
     *
     * @return updated location.
     */
    @PutMapping("/locations")
    public ResponseEntity<Location> updateLocation(@RequestBody final Location location) {
        try {
            return new ResponseEntity<>(locationService.save(location), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * The method deletes the location from the database by its id.
     *
     * @param id - place id.
     *
     * @return the console message about the successful deletion of the location.
     */
    @DeleteMapping("/locations/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable final Long id) {
        locationService.delete(id);
        return new ResponseEntity<>("Location was deleted successful.", HttpStatus.OK);
    }
}

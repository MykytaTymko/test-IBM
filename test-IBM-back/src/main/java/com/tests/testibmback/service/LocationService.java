package com.tests.testibmback.service;

import com.tests.testibmback.model.Location;
import java.util.List;

/**
 * Service for working with the Location class.
 */
public interface LocationService {

    /**
     * The method returns a list of all places that are present in the database.
     *
     * @return list of all existing locations.
     */
    List<Location> findAll();

    /**
     * The method returns the place by its id.
     *
     * @param id - place id.
     *
     * @return returns the location with the specified id or null.
     */
    Location findById(Long id);

    /**
     * The method creates a new location and enters it into the database.
     *
     * @param location - created location.
     *
     * @return new location.
     */
    Location save(Location location);

    /**
     * The method deletes the location from the database by its id.
     *
     * @param id - place id.
     */
    void delete(Long id);

    /**
     * The method fills the database at the beginning of the application.
     * The method is called automatically.
     *
     * @return list of locations that are entered into the database.
     */
    List<Location> fillDatabase();
}

package com.tests.testibmback.repository;

import com.tests.testibmback.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * An interface that makes it possible to use JpaRepository methods.
 */
@Repository
public interface ILocationRepo extends JpaRepository<Location, Long> {
}

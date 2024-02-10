package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.TestDrive;

@Repository
public interface TestDriveRepository extends JpaRepository<TestDrive, Long>{

}

package com.carbooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.carbooking.booking.entity.Registration;

@Repository
@EnableJpaRepositories
public interface RegisterRepository extends JpaRepository<Registration, Integer>{

	public Registration findByUsername(String username);

	public Registration findByEmail(String email);

	public Registration findByMobile(String mobile);

}

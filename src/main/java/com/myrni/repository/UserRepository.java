package com.myrni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.UserEO;

public interface UserRepository extends JpaRepository<UserEO, Long> {
	
	 Optional<UserEO> findByEmail(String email);

	    boolean existsByEmail(String email);

	    boolean existsByMobileNo(String mobileNo);

}

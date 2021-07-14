package com;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email =?1 ")
	 User  findByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.email =?1 ")
	boolean existsByEmail(String email);
	@Query("SELECT u FROM User u WHERE u.email =?1 ")
	Optional<User> findByUserEmail(String email);
	@Override
	Optional<User> findById(Long aLong);
	Optional<User> findUserByRole(String role);
}

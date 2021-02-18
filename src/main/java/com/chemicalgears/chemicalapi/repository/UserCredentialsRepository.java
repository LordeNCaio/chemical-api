package com.chemicalgears.chemicalapi.repository;

import com.chemicalgears.chemicalapi.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    UserCredentials findByUsername(String username);
    Optional<UserCredentials> findByUsernameAndPassword(String username, String password);
}

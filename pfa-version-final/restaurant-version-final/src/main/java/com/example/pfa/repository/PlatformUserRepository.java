package com.example.pfa.repository;

import com.example.pfa.entity.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatformUserRepository<T extends PlatformUser> extends JpaRepository<T, Long> {

    Optional<T> findByEmail(String username);

}

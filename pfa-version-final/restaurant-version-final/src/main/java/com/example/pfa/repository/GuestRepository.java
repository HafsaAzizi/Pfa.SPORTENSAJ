package com.example.pfa.repository;

import com.example.pfa.entity.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends PlatformUserRepository<Guest> {

}

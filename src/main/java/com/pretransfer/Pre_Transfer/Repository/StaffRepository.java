package com.pretransfer.Pre_Transfer.Repository;

import com.pretransfer.Pre_Transfer.Classes.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
    Optional<Staff> findByUsername(String username);
}

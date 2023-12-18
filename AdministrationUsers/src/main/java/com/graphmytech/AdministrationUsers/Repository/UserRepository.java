package com.graphmytech.AdministrationUsers.Repository;

import com.graphmytech.AdministrationUsers.Table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Your repository methods
}

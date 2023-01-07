package com.example.kkulaproject.datacalss;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUserid(Integer userid);
    User findByEmail(String email);
    
}

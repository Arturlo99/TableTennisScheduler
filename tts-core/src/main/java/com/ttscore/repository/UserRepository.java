package com.ttscore.repository;

import com.ttscore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT COUNT(u.email) FROM User u WHERE u.email = ?1")
    Integer countUsingEmail(String email);

    User findUserByEmail(String email);

    User findUserById(Integer id);
}
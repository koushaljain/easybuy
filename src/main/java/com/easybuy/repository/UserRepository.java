package com.easybuy.repository;

import com.easybuy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.email FROM User u WHERE u.userId=?1 ")
    public String getEmailByUserId(Integer userId);
}

package com.smfinance.datamodel.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smfinance.datamodel.objects.User;

public interface UserRepository extends JpaRepository<User, String>
{
    List<User> findByName(String name);
    
    @Query("select u from User u")
    Stream<User> findAllAndStream();
}

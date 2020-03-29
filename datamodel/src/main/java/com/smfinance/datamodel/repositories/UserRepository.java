package com.smfinance.datamodel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smfinance.datamodel.objects.User;

public interface UserRepository extends JpaRepository<User, String>
{
    List<User> findByName(String name);
}

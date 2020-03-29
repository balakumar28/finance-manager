package com.smfinance.datamodel.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.smfinance.datamodel.exceptions.ObjectNotFoundException;
import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.objects.UserType;
import com.smfinance.datamodel.repositories.UserRepository;

public class UserService
{
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    public void createUser(String name, UserType type, String city)
    {
        createUser(name, type, city, null, null, null, null, null);
    }
    
    public void createUser(String name, UserType type, String city, byte[] photo, String mobile, String mobile2, String mail, String address)
    {
        createUser(new User(name, type, mobile, mobile2, mail, address, city));
    }
    
    public void createUser(User user)
    {
        userRepository.save(user);
    }
    
    public void updateUser(User user)
    {
        userRepository.save(user);
    }
    
    public User getUser(String id) throws ObjectNotFoundException
    {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new ObjectNotFoundException(id);
        }
        return user.get();
    }
    
    public Collection<User> findUserByName(String name)
    {
        return userRepository.findByName(name);
    }
    
}

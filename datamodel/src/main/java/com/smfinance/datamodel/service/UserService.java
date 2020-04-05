package com.smfinance.datamodel.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smfinance.datamodel.exceptions.ObjectNotFoundException;
import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.repositories.UserRepository;

@Service
@Transactional
public class UserService implements IService
{
    public static final String NAME = UserService.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        LOGGER.debug("Returning " + users);
        return users;
    }
    
    public Stream<User> getUsersStream()
    {
        return userRepository.findAllAndStream();
    }
    
    public void persistUser(String name, String city)
    {
        persistUser(name, city, null, null, null, null, null);
    }
    
    public void persistUser(String name, String city, byte[] photo, String mobile, String mobile2, String mail, String address)
    {
        persistUser(new User(name, mobile, mobile2, mail, address, city));
    }
    
    public void persistUser(User user)
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
    
    public long getUsersCount()
    {
        return userRepository.count();
    }
    
    public void deleteAll(Iterable<User> users)
    {
        userRepository.deleteAll(users);
    }
}

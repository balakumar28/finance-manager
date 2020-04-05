package com.smfinance.datamodel.service;

import java.util.Objects;

import com.smfinance.datamodel.exceptions.DataModelException;
import com.smfinance.datamodel.exceptions.InvalidService;

public final class ServiceStore
{
    private static UserService userService;
    
    public static IService getService(String name) throws DataModelException
    {
        if(Objects.equals(UserService.NAME, name))
        {
            return userService();
        }
        throw new InvalidService(name);
    }
    
    private static IService userService()
    {
        if(userService == null)
            userService = new UserService();
        return userService;
    }
}

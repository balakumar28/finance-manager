package com.smfinance.views;

import com.smfinance.datamodel.service.UserService;
import com.vaadin.flow.router.Route;

@Route
public class AddUser extends UpdateUser
{
    private static final long serialVersionUID = -9001527925864107563L;
    
    public AddUser(UserService userService)
    {
        super(userService);
    }
}

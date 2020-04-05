package com.smfinance.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smfinance.datamodel.exceptions.ObjectNotFoundException;
import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.service.UserService;
import com.smfinance.util.StringUtils;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route
public class EditUser extends UpdateUser implements HasUrlParameter<String>
{
    private static final long serialVersionUID = -2972944925574579658L;
    private static final Logger LOGGER = LoggerFactory.getLogger(EditUser.class);
    
    public EditUser(UserService userService)
    {
        super(userService);
    }
    
    protected void populateFields(User user)
    {
        this.user.setUserId(StringUtils.nonNullify(user.getUserId()));
        name.setValue(StringUtils.nonNullify(user.getName()));
        mobile.setValue(StringUtils.nonNullify(user.getMobile()));
        mobile2.setValue(StringUtils.nonNullify(user.getMobile2()));
        mail.setValue(StringUtils.nonNullify(user.getMail()));
        city.setValue(StringUtils.nonNullify(user.getCity()));
        address.setValue(StringUtils.nonNullify(user.getAddress()));
    }
    
    @Override
    public void setParameter(BeforeEvent beforeEvent, String userId)
    {
        try
        {
            populateFields(userService.getUser(userId));
        }
        catch(ObjectNotFoundException e)
        {
            LOGGER.error("Failed to get User " + userId, e);
        }
    }
}

package com.smfinance.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.service.UserService;
import com.smfinance.util.StringUtils;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public abstract class UpdateUser extends VerticalLayout
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUser.class);
    private static final long serialVersionUID = 8718344571206043266L;
    
    protected final TextField name;
    protected final TextField mobile;
    protected final TextField mobile2;
    protected final TextField mail;
    protected final TextField city;
    protected final TextField address;
    protected final Button submit;
    protected final Button cancel;
    
    protected UserService userService;
    protected User user = new User();
    
    public UpdateUser(@Autowired UserService userService)
    {
        this.userService = userService;
        
        applyStyle();
        name = new TextField("Name");
        mobile = new TextField("Mobile");
        mobile2 = new TextField("Alternate Mobile");
        mail = new TextField("Mail");
        city = new TextField("City");
        address = new TextField("Address");
        submit = new Button("Submit");
        cancel = new Button("Cancel");
    
        submit.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
        cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        
        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        submit.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);
    
        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(submit, cancel);
        
        VerticalLayout form = new VerticalLayout();
        form.addClassName("top-margin");
        form.add(name, mobile, mobile2, mail, city, address, buttonGroup);
        
        add(form);
        
        submit.addClickListener(e -> updateUser());
        cancel.addClickListener(e -> navigateBack());
    }
    
    private void applyStyle()
    {
        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
    }
    
    protected void updateUser()
    {
        boolean isValid = validateMandatoryFields();
        if(!isValid)
            return;
        
        user.setName(StringUtils.capitalize(StringUtils.nullify(name.getValue())));
        user.setMobile(StringUtils.nullify(mobile.getValue()));
        user.setMobile2(StringUtils.nullify(mobile2.getValue()));
        user.setMail(StringUtils.nullify(mail.getValue()));
        user.setCity(StringUtils.capitalize(StringUtils.nullify(city.getValue())));
        user.setAddress(StringUtils.nullify(address.getValue()));
        try
        {
            userService.persistUser(user);
            navigateBack();
        }
        catch(Exception e)
        {
            LOGGER.error("Failed to save User " + user, e);
            handleException("Failed to save User. ", e);
        }
        
    }
    
    private void handleException(String msg, Exception e)
    {
        if(e instanceof DataIntegrityViolationException)
            msg = msg + "Duplicate entry is not allowed. Check Mobile value";
        else
            msg = msg + e.getLocalizedMessage();
        
        errorNotification(msg);
    }
    
    protected void navigateBack()
    {
        UI.getCurrent().navigate(ManageUsers.class);
    }
    
    protected boolean validateMandatoryFields()
    {
        if(StringUtils.isBlank(name.getValue()))
        {
            errorNotification("Name cannot be blank");
            return false;
        }
        if(StringUtils.isBlank(city.getValue()))
        {
            errorNotification("City cannot be blank");
            return false;
        }
        return true;
    }
    
    protected void errorNotification(String value)
    {
        Notification notification = new Notification(value, 3000, Notification.Position.TOP_STRETCH);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.open();
    }
    
    protected void todoNotification(String value)
    {
        Notification notification = new Notification(value, 3000, Notification.Position.BOTTOM_STRETCH);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.open();
    }
}

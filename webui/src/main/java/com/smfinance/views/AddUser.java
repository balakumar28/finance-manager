package com.smfinance.views;

import com.smfinance.util.StringUtils;
import com.smfinance.datamodel.objects.User;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class AddUser extends VerticalLayout
{
    private static final long serialVersionUID = -3443690775507514576L;
    
    private final TextField name;
    private final TextField mobile;
    private final TextField mobile2;
    private final TextField mail;
    private final TextField city;
    private final TextField address;
    
    public AddUser()
    {
        applyStyle();
        name = new TextField("Name");
        mobile = new TextField("Mobile");
        mobile2 = new TextField("Alternate Mobile");
        mail = new TextField("Mail");
        city = new TextField("City");
        address = new TextField("Address");
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
    
        submit.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
        cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        
        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        submit.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);
    
        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(submit, cancel);
        
        add(name, mobile, mobile2, mail, city, address, buttonGroup);
        
        submit.addClickListener(e -> addUser());
        cancel.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
    }
    
    private void applyStyle()
    {
        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
    }
    
    private void addUser()
    {
        boolean isValid = validateMandatoryFields();
        if(!isValid)
            return;
        
        String nameValue = name.getValue();
        String mobileValue = mobile.getValue();
        String mobile2Value = mobile2.getValue();
        String mailValue = mail.getValue();
        String cityValue = city.getValue();
        String addressValue = address.getValue();
        User user = new User();
        user.setName(nameValue);
        todoNotification("Adding User: " + user);
    }
    
    private boolean validateMandatoryFields()
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
    
    private void errorNotification(String value)
    {
        Notification notification = new Notification(value, 3000, Notification.Position.TOP_STRETCH);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
    
    private void todoNotification(String value)
    {
        Notification notification = new Notification(value, 3000, Notification.Position.BOTTOM_STRETCH);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }
}

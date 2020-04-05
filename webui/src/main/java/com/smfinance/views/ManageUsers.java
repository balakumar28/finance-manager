package com.smfinance.views;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.smfinance.datamodel.objects.User;
import com.smfinance.datamodel.service.UserService;
import com.smfinance.util.StringUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("users")
public class ManageUsers extends VerticalLayout
{
    private static final long serialVersionUID = 7549004889537010917L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ManageUsers.class);
    
    private UserService userService;
    private Div div = new Div();
    private H4 header = new H4();
    private H6 name = new H6();
    private H6 mobile = new H6();
    private H6 mobile2 = new H6();
    private H6 mail = new H6();
    private H6 city = new H6();
    private H6 address = new H6();
    
    public ManageUsers(@Autowired UserService userService)
    {
        this.userService = userService;
//        UI.getCurrent().
        Button addUser = new Button("Add User");
        Button editUser = new Button("Edit User");
        Button deleteUser = new Button("Delete User");
        
        addUser.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addUser.addClickListener(e -> UI.getCurrent().navigate(AddUser.class));
        
        editUser.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        deleteUser.addThemeVariants(ButtonVariant.MATERIAL_OUTLINED);
        
        HorizontalLayout buttonGroup = new HorizontalLayout();
        buttonGroup.add(addUser, editUser, deleteUser);
    
        Grid<User> userGrid = new Grid<>();
        userGrid.addColumn(User::getName).setHeader("Name");
        userGrid.addColumn(User::getCity).setHeader("City");
        userGrid.setItems(userService.getAllUsers());
        userGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        userGrid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);
        
        userGrid.asMultiSelect().addSelectionListener(e -> {
            editUser.setEnabled(e.getAllSelectedItems().size() == 1);
            deleteUser.setEnabled(!e.getAllSelectedItems().isEmpty());
            
            showUserDetails(e.getAllSelectedItems());
        });
        
        editUser.setEnabled(false);
        deleteUser.setEnabled(false);
    
        deleteUser.addClickListener(e -> {
            deleteUsers(userGrid.getSelectedItems());
            userGrid.setItems(userService.getAllUsers());
        });
    
        editUser.addClickListener(e -> UI.getCurrent().navigate(EditUser.class, userGrid.getSelectedItems().iterator().next().getUserId()));
        
        add(buttonGroup, userGrid);
        initializeUserView();
    }
    
    private void initializeUserView()
    {
        div.add(header, name, mobile, mobile2, mail, city, address);
    }
    
    private void showUserDetails(Set<User> userSet)
    {
        remove(div);
        if(userSet.size() == 1)
        {
            User user = userSet.iterator().next();
            header.setText("User Details:");
            name.setText("Name: " + StringUtils.nonNullify(user.getName()));
            mobile.setText("Primary Mobile: " + StringUtils.nonNullify(user.getMobile()));
            mobile2.setText("Alternate Mobile: " + StringUtils.nonNullify(user.getMobile2()));
            mail.setText("Mail: " + StringUtils.nonNullify(user.getMail()));
            city.setText("City: " + StringUtils.nonNullify(user.getCity()));
            address.setText("Address: " + StringUtils.nonNullify(user.getAddress()));
            add(div);
            LOGGER.info("Updated User Details for user " + name.getText());
        }
    }
    
    private void deleteUsers(Set<User> users)
    {
        userService.deleteAll(users);
    }
}

package com.smfinance.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.smfinance.GreetService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "SM Finance Manager",
     shortName = "SMFM App",
     description = "Finance Manager for SM Finances, a Vaadin application.",
     enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout
{
    
    private static final long serialVersionUID = 6910885182019043309L;
    
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service)
    {
        // Button click listeners can be defined as lambda expressions
        Button manageUsers = new Button("Manage Users");
        Button lend = new Button("Make a Lending");
        
        // Theme variants give you predefined extra styles for components.
        // Example: Primary button is more prominent look.
        manageUsers.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        lend.addThemeVariants(ButtonVariant.LUMO_ICON);
        
        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
        
        manageUsers.addClickListener(e -> UI.getCurrent().navigate(ManageUsers.class));
    
        Div buttonGroup = new Div();
        buttonGroup.add(manageUsers, lend);
        
        add(buttonGroup);
    }
    
}

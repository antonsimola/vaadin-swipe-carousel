package me.anton.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import me.anton.SwipeCarouselComponent;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Theme("demo")
@Title("MyComponent Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSpacing(true);
        verticalLayout.setMargin(false);

        SwipeCarouselComponent carousel = new SwipeCarouselComponent().withControls();
        carousel.setWidth("400px");
        carousel.setHeight("300px");
        carousel.disableAutoScroll();

        List<String> images = new ArrayList<>(Arrays.asList("http://stuffpoint.com/cats/image/443190-cats-cute-cat-7.jpg", "http://brooklynbrewery.com/blog/wp-content/uploads/2012/08/falling-cat-400x300.jpg"));
        carousel.setImages(images);
        TextField url = new TextField("give cat url");
        Button send = new Button("add cat image");
        send.addClickListener(event -> {
            images.add(url.getValue());
            carousel.setImages(images);
        });

        Button enableAuto = new Button("Enable autoscroll");
        enableAuto.addClickListener(event -> carousel.enableAutoScroll(1000));

        Button disableAuto = new Button("Disable autoscroll");
        disableAuto.addClickListener(event -> carousel.disableAutoScroll());

        verticalLayout.addComponents(carousel, url, send, enableAuto, disableAuto);
        setContent(verticalLayout);
    }
}

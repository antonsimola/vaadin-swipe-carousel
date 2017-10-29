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
import me.anton.SwipeCarousel;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Theme("demo")
@Title("Swipe Carousel Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

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

        // ATM It only allows urls as string... TODO Accept Vaadin Resources
        List<String> images = new ArrayList<>(Arrays.asList("http://stuffpoint.com/cats/image/443190-cats-cute-cat-7.jpg", "http://brooklynbrewery.com/blog/wp-content/uploads/2012/08/falling-cat-400x300.jpg"));

        SwipeCarousel carousel = new SwipeCarousel();
        //Remember to set width and height
        carousel.setWidth("400px");
        carousel.setHeight("300px");
        carousel.setImageUrls(images);

        //With default controls
        SwipeCarousel carouselWithControls = new SwipeCarousel().withControls();
        carouselWithControls.setWidth("400px");
        carouselWithControls.setHeight("300px");
        carouselWithControls.disableAutoScroll();

        carouselWithControls.setImageUrls(images);
        TextField url = new TextField("give cat url");
        Button send = new Button("add cat image");
        send.addClickListener(event -> {
            images.add(url.getValue());
            carouselWithControls.setImageUrls(images);
        });

        Button enableAuto = new Button("Enable autoscroll");
        enableAuto.addClickListener(event -> carouselWithControls.enableAutoScroll(1000));

        Button disableAuto = new Button("Disable autoscroll");
        disableAuto.addClickListener(event -> carouselWithControls.disableAutoScroll());

        verticalLayout.addComponents(carousel, carouselWithControls, url, send, enableAuto, disableAuto);
        setContent(verticalLayout);
    }
}

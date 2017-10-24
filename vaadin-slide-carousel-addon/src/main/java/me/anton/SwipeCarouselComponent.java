package me.anton;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;

import java.util.List;

public class SwipeCarouselComponent extends CssLayout {
    private final SwipeCarouselJavascriptComponent jsComponent;
    private Button previousButton;
    private Button nextButton;
    private List<String> imageUrls;

    public SwipeCarouselComponent() {
        jsComponent = new SwipeCarouselJavascriptComponent();
        addStyleName("swipe-carousel");
        addComponent(jsComponent);
    }

    public SwipeCarouselComponent withControls() {
        Button previousButton = new Button(VaadinIcons.ARROW_LEFT);
        previousButton.addStyleName("swipe-carousel-button");
        previousButton.addStyleName("swipe-carousel-left-button");
        Button nextButton = new Button(VaadinIcons.ARROW_RIGHT);
        nextButton.addStyleName("swipe-carousel-button");
        nextButton.addStyleName("swipe-carousel-right-button");
        return withControls(previousButton, nextButton);
    }

    public SwipeCarouselComponent withControls(Button previousButton, Button nextButton) {
        this.previousButton = previousButton;
        this.nextButton = nextButton;
        this.previousButton.addClickListener(event -> previous());
        this.nextButton.addClickListener(event -> next());
        addComponents(previousButton, this.nextButton);
        return this;
    }

    public void next() {
        jsComponent.next();
    }

    public void previous() {
        jsComponent.previous();
    }

    public void setImages(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        jsComponent.setImages(imageUrls);
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void enableAutoScroll() {
        jsComponent.enableAutoScroll();
    }

    public void enableAutoScroll(int interval) {
        jsComponent.enableAutoScroll(interval);
    }

    public void disableAutoScroll() {
        jsComponent.disableAutoScroll();
    }

}

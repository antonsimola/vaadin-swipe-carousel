package me.anton;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;

public class SwipeCarousel extends CssLayout {
    private final SwipeCarouselJavascriptComponent jsComponent;
    private Button previousButton;
    private Button nextButton;
    private List<String> imageUrls;

    public SwipeCarousel() {
        jsComponent = new SwipeCarouselJavascriptComponent();
        addStyleName("swipe-carousel-addon");
        addStyleName("swipe-carousel");
        addComponent(jsComponent);
    }

    /**
     * Add Default previous and next button to the component.
     *
     * @return this instance for chaining
     */
    public SwipeCarousel withControls() {
        Button previousButton = new Button(VaadinIcons.ARROW_LEFT);
        previousButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        previousButton.addStyleName("swipe-carousel-button");
        previousButton.addStyleName("swipe-carousel-left-button");
        Button nextButton = new Button(VaadinIcons.ARROW_RIGHT);
        nextButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        nextButton.addStyleName("swipe-carousel-button");
        nextButton.addStyleName("swipe-carousel-right-button");
        return withControls(previousButton, nextButton);
    }

    /**
     * Add previous and next button to the component.
     *
     * @return this instance for chaining
     */
    public SwipeCarousel withControls(Button previousButton, Button nextButton) {
        this.previousButton = previousButton;
        this.nextButton = nextButton;
        this.previousButton.addClickListener(event -> previous());
        this.nextButton.addClickListener(event -> next());
        addComponents(this.previousButton, this.nextButton);
        return this;
    }

    /**
     * Go to next slide
     */
    public void next() {
        jsComponent.next();
    }

    /**
     * Go to previous slide
     */
    public void previous() {
        jsComponent.previous();
    }

    /**
     * Set the image urls as string
     *
     * @param imageUrls list of image urls
     */
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        jsComponent.setImages(imageUrls);
    }

    /**
     * Get previous button
     *
     * @return previous button
     */
    public Button getPreviousButton() {
        return previousButton;
    }

    /**
     * Get next button
     *
     * @return next button
     */
    public Button getNextButton() {
        return nextButton;
    }

    /**
     * Get the image urls
     *
     * @return image urls
     */
    public List<String> getImageUrls() {
        return imageUrls;
    }

    /**
     * Enable auto scrolling with default interval
     */
    public void enableAutoScroll() {
        jsComponent.enableAutoScroll();
    }

    /**
     * Enable autoscrolling
     *
     * @param interval inteval in milliseconds
     */
    public void enableAutoScroll(int interval) {
        jsComponent.enableAutoScroll(interval);
    }

    /**
     * disable the auto scroll
     */
    public void disableAutoScroll() {
        jsComponent.disableAutoScroll();
    }

}

package me.anton;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import me.anton.client.SwipeCarouselState;

import java.util.Arrays;
import java.util.List;

@StyleSheet({"style.css"})
@JavaScript({"swipe.js", "carousel-factory.js", "swipe-carousel.js"})
class SwipeCarouselJavascriptComponent extends AbstractJavaScriptComponent {

    public SwipeCarouselJavascriptComponent() {
    }

    public boolean hasAutoScroll() {
        return getState().interval;
    }

    public void enableAutoScroll() {
        getState().interval = true;
    }

    public void enableAutoScroll(int delayInMilliseconds) {
        getState().interval = true;
        getState().intervalInMilliseconds = delayInMilliseconds;
    }

    public void disableAutoScroll() {
        getState().interval = false;
    }

    public void setImages(List<String> images) {
        getState().images = images;
    }

    public void setImages(String... images) {
        setImages(Arrays.asList(images));
    }


    public void next() {
        callFunction("next");
    }

    public void previous() {
        callFunction("previous");
    }
    @Override
    protected SwipeCarouselState getState() {
        return (SwipeCarouselState) super.getState();
    }
}

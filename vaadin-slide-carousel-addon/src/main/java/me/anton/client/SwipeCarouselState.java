package me.anton.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SwipeCarouselState extends JavaScriptComponentState {
    public final String uuid = UUID.randomUUID().toString();
    public List<String> images = new ArrayList<>();
    public int intervalInMilliseconds = 5000;
    public boolean interval = true;
}

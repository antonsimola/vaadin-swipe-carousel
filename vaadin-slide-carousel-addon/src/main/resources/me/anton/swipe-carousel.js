window.me_anton_SwipeCarouselJavascriptComponent =
    function () {
        // Create the component
        var component =
            new carouselFactory.SwipeCarousel(this.getElement(), this.getState());

        // Handle changes from the server-side
        this.onStateChange = function () {
            component.setImages(this.getState());
            component.setInterval(this.getState());
        };

        this.next = function () {
            component.next();
        };

        this.previous = function () {
            component.previous();
        };
    };
// Define the namespace
var carouselFactory = carouselFactory || {};

carouselFactory.SwipeCarousel = function (element, state) {
    var carousel = document.createElement('div');
    carousel.setAttribute('class', 'swipe');
    var parentWidth = element.parentElement.clientWidth;
    carousel.setAttribute('style', 'width:'+parentWidth+'px;margin:0 auto');

    var inner = document.createElement('div');
    inner.setAttribute('class', 'swipe-wrap');

    carousel.appendChild(inner);
    element.appendChild(carousel);

    var self = this;

    var swipeInstance = null;

    this.initSwipe = function(localState) {
        if(swipeInstance !== null) {
            swipeInstance.stop();
        }
        swipeInstance = Swipe(carousel, {
            startSlide: 0,
            auto: localState.interval ? localState.intervalInMilliseconds : null,
            continuous: true
        });
    };

    this.setImages = function (state) {
        while (inner.firstChild) {
            inner.removeChild(inner.firstChild);
        }
        state.images.forEach(function (image, index) {
            var carouselItem = document.createElement('div');
            carouselItem.setAttribute('class', 'swipe-carousel-item');

            var img = document.createElement('img');
            img.setAttribute('src', image);
            carouselItem.appendChild(img);
            inner.appendChild(carouselItem);
        });
        self.initSwipe(state);
    };

    this.setInterval = function (localState) {
        self.initSwipe(localState);
    };

    this.next = function() {
        swipeInstance.next();
    };

    this.previous = function() {
        swipeInstance.prev();
    };
};
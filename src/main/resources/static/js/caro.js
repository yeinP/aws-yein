window.onload = function() {
    var carousels = document.querySelectorAll('.carousel');

    carousels.forEach(function(carousel, index) {
        var currentPage = 1;
        var totalPages = carousel.querySelectorAll('.carousel-item').length;
        var pageNumber = carousel.parentElement.querySelector('.pages');
        pageNumber.innerText = currentPage + " / " + totalPages;

        var carouselId = carousel.getAttribute('id');

        carousel.addEventListener('slide.bs.carousel', function(event) {
            currentPage = event.to + 1;
            pageNumber.innerText = currentPage + " / " + totalPages;
        });
    });
};
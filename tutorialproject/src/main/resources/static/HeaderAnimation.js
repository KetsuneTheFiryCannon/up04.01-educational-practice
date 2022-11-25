function parallax_height() {
    var scroll_top = $(this).scrollTop();
    var sample_section_top = $(".sample-section").offset().top;
    var header_height = $(".sample-header-section").outerHeight();
    $(".sample-section").css({ "margin-top": header_height });
    $(".sample-header").css({ height: header_height - scroll_top });
}
parallax_height();
$(window).scroll(function() {
    parallax_height();
});
$(window).resize(function() {
    parallax_height();
});

var home_btn = document.getElementById("home-btn");

home_btn.addEventListener("mouseenter", (event) => {
    home_btn.classList.remove('bi-door-closed-fill');
    home_btn.classList.add('bi-door-open-fill');
    home_btn.
})


home_btn.addEventListener("mouseleave", (event) => {
    home_btn.classList.remove('bi-door-open-fill');
    home_btn.classList.add('bi-door-closed-fill');
})

var home_btn = document.getElementById("home-btn");

home_btn.addEventListener("mouseenter", (event) => {
    home_btn.classList.remove('bi-door-closed-fill');
    home_btn.classList.add('bi-door-open-fill');
    home_btn.
})


home_btn.addEventListener("mouseleave", (event) => {
    home_btn.classList.remove('bi-door-open-fill');
    home_btn.classList.add('bi-door-closed-fill');
})

var home_btn = document.getElementById("home-btn");

home_btn.addEventListener("mouseenter", (event) => {
    home_btn.classList.remove('bi-door-closed-fill');
    home_btn.classList.add('bi-door-open-fill');
    home_btn.
})


home_btn.addEventListener("mouseleave", (event) => {
    home_btn.classList.remove('bi-door-open-fill');
    home_btn.classList.add('bi-door-closed-fill');
})
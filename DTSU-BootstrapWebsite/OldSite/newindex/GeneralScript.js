$(document).ready(function () {
    $('body').css('display', 'none');
    $('body').fadeIn(750);

    $('.mainNavD').click(function (event) {
        event.preventDefault();
        newLocation = this.href;
        $('body').fadeOut(750, newPage);
    });
    
    $('.Enlarge').mouseenter(function () {
        $(this).css("font-size", "+=2%")
        $(this).css("color", "#660000")
    });
    $('.Enlarge').mouseleave(function () {
        $(this).css("font-size", "-=2%")
        $(this).css("color", "#000000")
    });
    
});
function newPage() {
    window.location = newLocation;
}
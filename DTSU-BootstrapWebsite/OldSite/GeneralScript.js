$(document).ready(function () {
    $('body').css('display', 'none');
    $('body').fadeIn(750);

    $('.mainNavD').click(function (event) {
        event.preventDefault();
        newLocation = this.href;
        $('body').fadeOut(750, newPage);
    });
    
    
});
function newPage() {
    window.location = newLocation;
}
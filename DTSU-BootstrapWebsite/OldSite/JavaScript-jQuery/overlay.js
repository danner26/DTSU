window.onresize = onResizeScreen;
function onResizeScreen() {
    var id = '#dialog';
    var winH = $(window).height();
    var winW = $(window).width();
    $(id).css('top', winH / 2 - $(id).height() / 2);
    $(id).css('left', winW / 2 - $(id).width() / 2);

}
$(document).ready(function () {
    var id = '#dialog';

    //Get the window height and width
    var winH = $(window).height();
    var winW = $(window).width();

    if (winW < 1187) {
        window.alert("Your browser has been detected smaller than normal; The webpage may be distorted. Please enlarge the browser (if possible) for a better experiance. We are sorry for the inconvenience.");
    }
    //transition effect		
    $('#mask').fadeIn(1000);
    $('#mask').fadeTo("slow", 0.8);

    //Set the popup window to center
    $(id).css('top', winH / 2 - $(id).height() / 2);
    $(id).css('left', winW / 2 - $(id).width() / 2);

    //transition effect
    $(id).fadeIn(3000);

    //if close button is clicked
    $('.window .close').click(function (e) {
        //Cancel the link behavior
        e.preventDefault();

        $('#mask').hide();
        $('.window').hide();
    });

    //if mask is clicked
    $('#mask').click(function () {
        $(this).hide();
        $('.window').hide();
    });
    $(document).resize(function () {
        if ($(document).height() != maskHeight || $(document).width() != maskWidth) {
            var winH = $(window).height();
            var winW = $(window).width();
            $(id).css('top', winH / 2 - $(id).height() / 2);
            $(id).css('left', winW / 2 - $(id).width() / 2);
        };
    });

});
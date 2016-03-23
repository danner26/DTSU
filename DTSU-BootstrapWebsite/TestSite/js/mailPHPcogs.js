function reqListener() {
    console.log(this.responseText)
}
$('#submitForm').click(function (e) {
    e.preventDefault();
    var submitPHP = $('#formToSubmit').attr('action');
    $.post(submitPHP, {
        userName: $("#userName").val(),
        userEmail: $("#userEmail").val(),
        subject: $("#subject").val(),
        userReview: $("#userReview").val(),
        rating: $("#rating").val(),
        goodCheck: $("#goodCheck").val(),
        termsCheck: $("#termsCheck").val()
    }, function (data) {
        if (data == '"valid"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-success alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Success!</strong> We have recieved your message. Thank you!</div>');
        } else if (data == '"invalid1"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-warning alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> The form detects you have entered an invalid email. Please try again!</div>');
        } else if (data == '"invalid2"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-danger alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> Email could not be sent. Please try again, or email support@danstechsupport.com!</div>');
        } else if (data == '"invalid3"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-danger alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> Cannot connect to database/server. Please try again, or email support@danstechsupport.com!</div>');
        } else if (data == '"invalid4"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-warning alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> The form detects invalid characters in your name. Please try again, or if you see this an error, please email support@danstechsupport.com!</div>');
        } else if (data == '"invalid5"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-warning alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> The form detects numbers in your name. Please try again, or if you see this an error, please email support@danstechsupport.com!</div>');
        } else if (data == '"invalid6"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-warning alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> You did not check the validation box. Please try again!</div>');
        } else if (data == '"invalid7"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-danger alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> We have detected this as a bot spam. If you find this an error, please email support@danstechsupport.com!</div>');
        } else if (data == '"invalid9"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-warning alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> The form detects you have not entered a rating. Please try again!</div>');
        } else if (data == '"error"') {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-danger alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> The server could not process your request.. please email support@danstechsupport.com so this issue can be addressed.</div>');
        } else {
            $("#overlay-form").trigger("click");
            $('#alertLocation').html('<div class="alert alert-danger alert-dismissable" role="alert" style="position:absolute; top: 60px; left: 35%; text-align:center; z-index: 10; max-width= 60%;"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> An unknown error has occured. Please email support@danstechsupport.com to report this, so we can look into it! Appologies, and thank you!</div>');
        }
    });
});
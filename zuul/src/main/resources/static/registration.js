;
$(function() {
    $("#registration").submit(function() {
        var formData = {
            "username":$("#userName").val()
            , "password":$("#password").val()
        };
        $.ajax({
            url:'http://localhost:9097/uaa/registration'
            , type:'POST'
            , data: $.toJSON(formData)
            ,contentType: 'application/json'
            , success: function(res) {
                $(location).attr('href', 'http://localhost:8881/login')
            }
        });

        return false;
    });
});
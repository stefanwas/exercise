function status() {
    $.get('rest/status', function(data) {
        $('#status').append(data);
    });
}

function saveUser() {

    var userName = $('#name').val();
    var userPass = $('#password').val();
    var data = {
        name: userName,
        password: userPass
    };

    $.ajax({
        type: "POST",
        url: "rest/user/create",
        headers: {
            "Content-Type" : "application/json; charset=utf-8"
        },
        data: JSON.stringify(data),
        dataType: "text"
    }).done(function(data) {
        $('#response').text(data);
    });
}
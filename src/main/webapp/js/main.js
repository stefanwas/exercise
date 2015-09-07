function status() {
    $.get('rest/status', function(data) {
        $('#status').append(data);
    });
}

function saveUser() {
//    $.post('rest/user/create', { name: 'Stefan', password : 'abc123'}, function(data) {
//        $('#response').append(data);
//    });
    var userName = $('#name').val();
    var userPass = $('#password').val();

    $.ajax({
        url: "rest/user/create",
        type: "POST",
        headers: {
            "Content-Type" : "application/json; charset=utf-8"
        },
        data: '{ "name": "userName", "password": "userPass"}',
//        data: "{ 'name': '" + userName + "', 'password':'" + userPass + "'}",
        dataType: "text",
        success: function(data) {
            $('#response').text(data);
        },
        failure: function(data) {
            $('#response').text(data);
        }
    });
}
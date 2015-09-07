function status() {
    $.get('/rest/status', function(data) {
        $('#status').append(data);
    });
}

function saveUser() {
    $.post('/rest/status', { name: 'Stefan', password : 'abc123'}, function(data) {
        $('#response').append(data);
    });
}
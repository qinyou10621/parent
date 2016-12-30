$(document).ready(function () {
    $("#submit").click(submitInformation)
});

function submitInformation() {
    var username = $("#username").val();
    var password = $("#password").val();

    var url = "checkInformation";
    var data = {username: username, password: password};

    $.post(url, data, function (result) {
        if (0 == result.status) {
            $("#submit").after("<b>成功接收返回参数</b>");
        }
    });
}


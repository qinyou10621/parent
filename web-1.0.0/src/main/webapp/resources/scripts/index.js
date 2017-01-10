$(document).ready(function () {
    $("#login_submit").click(login_submit);
    $("#register_submit").click(register_submit);
    $("#imageCode").on('click', changeImageCode);
    changeImageCode();

});

function login_submit() {
    var username = $("#username").val();
    var password = $("#password").val();

    var url = "checkInformation";
    var data = {username: username, password: password};

    $.post(url, data, function (result) {
        if (0 == result.status) {
            $("#submit").after("<b>成功接收返回参数</b>");
        } else {
            window.location.href = '../../resources/page/loginFail.html';
        }
    });
}
/**
 * 网页内部跳转，不经过服务器
 */
function locationToHref(href) {
    location.href = href;
}

function register_submit() {
    var url = "../../check/register";
    var data = {username: $("#register_username").val(), password: $("#register_password").val()};
    $.post(url, data, function () {
    });
}

function changeImageCode() {
    var url = "identifyingCode";
    var data = "";
    $.post(url, data, function (imageCodePath) {
        $('imageCode').attr("src", imageCodePath)
        console.log(imageCodePath)
    })
}


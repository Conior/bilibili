// 初始化隐藏格式校验提示
$(function () {
    $("#username_err").css('display','none');
    $("#phone_err").css('display','none');
    $("#email_err").css('display','none');
    $("#password_err").css('display','none');
});



// 账号校验
function accountCheck(){
    var username = $.trim($('#username').val());
    if(""==username){
        $("#username_err").html("用户名不能为空");
        $("#username_err").css('display','block');
        return false;
    }
    // 中文，英文字母和数字及_  4~10位
    var usernameReg = /^[\u4e00-\u9fa5_a-zA-Z0-9_]{4,10}$/;
    if (!usernameReg.exec(username)){
        $("#username_err").html("用户名格式不正确");
        $("#username_err").css('display','block');
        return false;
    }
    $("#username_err").css('display','none');


    var phone = $.trim($("#phone").val());
    if(""==phone){
        $("#phone_err").html("手机不能为空");
        $("#phone_err").css('display','block');
        return false;
    }
    var phoneReg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!phoneReg.exec(phone)) {
        $("#phone_err").html("手机格式不正确");
        $("#phone_err").css('display','block');
        return false;
    }
    $("#phone_err").css('display','none');


    var email = $.trim($("#email").val());
    if(""==email){
        $("#email_err").html("邮箱不能为空");
        $("#email_err").css('display','block');
        return false;
    }
    var emailReg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if(!emailReg.exec(email)){
        $("#email_err").html("邮箱格式不正确");
        $("#email_err").css('display','block');
        return false;
    }
    $("#email_err").css('display','none');


    var password = $.trim($("#password").val());
    if(""==password){
        $("#password_err").html("密码不能为空");
        $("#password_err").css('display','block');
        return false;
    }
    var passwordReg = /^(\w){6,20}$/;
    if (!passwordReg.exec(password)) {
        $("#password_err").html("密码格式不正确");
        $("#password_err").css('display','block');
        return false;
    }
    $("#password_err").css('display','none');

    return true;
};


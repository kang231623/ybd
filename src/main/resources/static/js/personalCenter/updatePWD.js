$(function () {

    //手机验证码输入框失焦时验证
    $("#mobileCode").blur(function () {
        var mobile = $("#mobile");
        if (!mobile.val()) {
            return false;
        }
        var mobileCode = $("#mobileCode");
        if (!mobileCode.val()) {
            isError(mobileCode, "手机验证码不能为空");
            return false;
        }
        var flag = false;

        $.ajax({
            url: "/usermanager/verifyMobileCode",
            type: "post",
            dataType: "json",
            async: false,
            data: {mobileCode: mobileCode.val(),mobile: mobile.val()},
            success: function (data) {
                if (data == false) {
                    isError(mobileCode, "手机验证码不正确");
                    flag = true;
                }
            },
            error: function () {
                alert("请求失败");
            }

        });
        if (flag) {
            return false;
        }
        isOk(mobileCode, "OK");
    })
    //密码输入框失焦时验证
    $("#password").blur(function () {
        var password = $("#password");
        if (!password.val()) {
            isError(password, "密码不能为空");
            return false;
        }
        isOk(password, "OK");
    })
    $("#password").blur(function () {
        $("#qrpassword").val("");
        $("#qrpassword").parent().parent().removeClass("has-error");
        $("#qrpassword").parent().parent().removeClass("has-success");
    })
    //手机号码输入框失焦时验证
    $("#qrpassword").blur(function () {
        var password = $("#password");
        var qrpassword = $("#qrpassword");
        if (!qrpassword.val()) {
            isError(qrpassword, "确认密码不能为空");
            return false;
        }
        if (password.val() != qrpassword.val()) {
            isError(qrpassword, "两次密码不一致");
            return false;
        }
        isOk(qrpassword, "OK");
    })
    //获取验证码按钮点击时验证
    $("#mobileCodebtn").click(function () {

        var mobile = $("#mobile");
        var mobileCodebtn = $("#mobileCodebtn");

        mobileCodebtn.attr("disabled", true); //防止多次点击

        var flag = false;

        $.ajax({
            url: "/usermanager/getmobileCode",
            type: "post",
            dataType: "json",
            data: {mobile: mobile.val()},
            success: function (data) {

                alert("验证码："+data);

            },
            error: function () {
                alert("请求失败");
            }
        });

        timeCount(mobileCodebtn);

    })

    //计时函数 在60秒之后获取验证码按钮才能点击
    function timeCount(obj) {

        var time = 30;
        var timer = setInterval(function () {
            if (time == 0) {
                clearInterval(timer);
                obj.attr("disabled", false);
                obj.val("重新获取验证码");
            } else {
                obj.val(time + "秒后重新发送");
                time--;
            }
        }, 1000);
    }
})

function submitForm() {
    if (verify($("#mobileCode")) && verify($("#password")) && verify($("#qrpassword"))) {
        $.ajax({
            url: "/usermanager/updateUserPassword",
            type: "post",
            dataType: "json",
            async: false,
            data: {password: $("#password").val()},
            success: function (data) {

                alert("修改密码成功，重新登录!!")


                top.location.href = "/user/logout";
            },
            error: function () {
                layui.alert("请求失败");
            }
        });
        return false;
    }
    alert("请完整信息！！！")
    return false;
}

//验证通过
function isOk(obj) {
    var _pdiv = obj.parents(".form-group");
    if (_pdiv.hasClass("has-error")) {
        _pdiv.removeClass("has-error");
    }
    _pdiv.addClass("has-success");
}
//验证不通过
function isError(obj, text) {
    var _pdiv = obj.parents(".form-group");
    if (_pdiv.hasClass("has-success")) {
        _pdiv.removeClass("has-success");
    }
    _pdiv.addClass("has-error");
}
function verify(obj) {
    if(!obj.parents(".form-group").hasClass("has-success") && !obj.parents(".form-group").hasClass("has-error")){
        obj.trigger("blur");
    }
    if (obj.parents(".form-group").hasClass("has-success")) {
        return true;
    } else {
        return false;
    }
}



function submitForm() {
    if(confirm("确认操作吗？")) {
        var data = new FormData($("#userinfo_form")[0]);
        $.ajax({
            url: "/usermanager/updateUserInfo",//在controller方法中如何接收图片数据
            type: "post",
            dataType: "json",
            data: data,
            processData : false,//默认：true，提交表单时心写，值为false
            contentType : false,//默认：true，不让JQuery对其操作
            success: function (data) {
                if (data) {
                    alert("成功！");
                    top.location.href = "/user/logout";
                } else {
                    alert("失败！")
                }
            }
        });
    }
}


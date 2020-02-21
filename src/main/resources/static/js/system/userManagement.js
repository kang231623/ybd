$(function () {
    //1.初始化Table
    user_table(null);

    $("#collapseOne").on('show.bs.collapse', function () {
        $("#collapseID").val(1);
    })

    $("#collapseTwo").on('show.bs.collapse', function () {
        $("#collapseID").val(2);
        $.ajax({
            url: "/usermanager/findRes",
            type: "post",
            dataType: "json",
            async: false,
            data: {},
            success: function (data) {
                $("#resParentCheckbox").empty();
                for (var i = 0; i < data.length; i++) {
                    $("#resParentCheckbox").append("<div id=" + "resChildCheckbox" + data[i].info + " class='panel-body panel-success'></div>");

                    $("#resChildCheckbox" + data[i].info).append(
                        "<div><label class='checkbox-inline'>" +
                        "<input type='checkbox' name='listRes' onchange='checkAll(this)' value=" + data[i].id + ">" + data[i].resName +
                        "</label></div>");
                    var list = data[i].resList;

                    $("#resChildCheckbox" + data[i].info).append("<div>");
                    for (var j = 0; j < list.length; j++) {
                        $("#resChildCheckbox" + data[i].info).append(
                            "<label class='checkbox-inline'>" +
                            "<input type='checkbox' name='listRes' onchange='checkaaa(this)' value=" + list[j].id + ">" + list[j].resName +
                            "</label>");
                    }
                    $("#resParentCheckbox").append("</div></div>");
                }
            },
            error: function () {
                alert("请求失败");
            }
        });


    })
})

function user_table(formData) {
    $("#user_table").bootstrapTable("destroy");
    $("#user_table").bootstrapTable({ // 对应table标签的id
        url: "/usermanager/findManager?"+formData, // 获取表格数据的url
        method: "get", //请求方式
        cache: false, //关闭缓存
        toolbar: '#toolbar', //工具按钮用哪个容器
        pagination: true, //开启分页
        sidePagination: "server", //客户端分页client,"server"服务端分页
        pageNumber: 1, //分页起始行,默认第一行
        sortName: "id", //排序名
        sortOrder: "asc", //排序方式
        pageSize: 10, //每页几行
        pageList: [10, 20, 30], //设置每页几行的下拉框
        striped: true,       //是否显示行间隔色
        clickToSelect: true, //设置复选框头
        showRefresh: true,   //是否显示刷新按钮
        //请求参数
        queryParams: function (params) { //参数
            return {
                limit: params.limit,// 每页要显示的数据条数
                offset: params.offset,// 每页显示数据的开始行号
                sort: params.sort,// 要排序的字段
                order: params.order,  // 排序规则
            };
        },//返回
        responseHandler: function (data) {
            return {
                "total": data.total,//总页数
                "rows": data.list //返回数据的集合
            };
        },
        columns: [//field对应的是entity中的属性 title:列名
            {
                field: 'id', // 返回json数据中的name
                title: '序号', // 表格表头显示文字
                formatter: function (value, row, index) {//单元格格式化函数，有三个参数：value： 该列的字段值；row： 这一行的数据对象；index： 行号，第几行，从0开始计算
                    return index + 1;
                }
            },{
                field: 'userName',
                title: '用户名'
            },{
                field: 'sex',
                title: '性别',
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return '男'
                    } else if (value == 0) {
                        return '女'
                    } else {
                        return '未知'
                    }
                }
            },{
                field: 'phone',
                title: "电话"
            },{
                field: 'email',
                title: "邮箱地址"
            },{
                field: 'integral',
                title: "积分"
            },{
                field: 'quantizationIntegral',
                title: "量化积分"
            },{
                field: 'position',
                title: "职位"
            },{
                title: "操作",
                formatter: function (value, row, index) {
                    var str =
                        "<a href='javascript:deleteManager(" + row.id + ")' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">" +
                        "<i class=\"layui-icon layui-icon-delete\">" +
                        "</i>删除</a> ";
                    return str;
                }
            }
        ]
    })
}

function user_likeForm_querybtn() {
    var formData = $("#user_likeForm").serialize();

    user_table(formData);

}


//点击打开新建用户模态框
function addUserInfo() {
    $("#addUserInfo_Modal").modal("show");

    findUserRole();
}
//添加角色
function findUserRole() {
    $.ajax({
        url: "/usermanager/findRole",
        type: "post",
        dataType: "json",
        data: {},
        success: function (data) {
            $("#roleRadio").empty();
            for (var i = 0; i < data.length; i++) {
                $("#roleRadio").append(
                    "<label class='radio-inline'>" +
                    "<input type='radio' name='role' value=" + data[i].id + ">" + data[i].rolename +
                    "</label>"
                );
            }
            $('input:radio:first').attr('checked', 'checked');

        },
        error: function () {
            alert("请求失败");
        }
    });
}
function addUserRole() {
    var userName = $("#username");
    if (!userName.val()) {
        isError(userName, "请输入用户账号")
        return false;
    }
    var myFalg = false;
    $.ajax({
        url: "/usermanager/findUserName",
        type: "post",
        dataType: "json",
        async: false,
        data: {"userName": userName.val()},
        success: function (data) {
            if (data == 0) {
                isOk(userName, "可以使用的管理员账号");
            } else {
                isError(userName, "用户账号重复");
                myFalg = true;
            }
        },
        error: function () {
            alert("请求失败");
        }
    });

    if (myFalg) {
        return false;
    }
    var password = $("#password");
    if (!password.val()) {
        isError(password, "请输入用户登录密码")
        return false;
    }
    isOk(password, "可以使用的用户登录密码");

    var voio= "";
    var addUserRoleRes = "";

    var roleId = 0;
    if ($("#collapseID").val()==2) {
        addUserRoleRes=addRole();
        if(addUserRoleRes==false){
            return false;
        }
    } else {
        roleId = $('input[name="role"]:checked').val();
    }
    voio=voio+addUserRoleRes;
    voio=voio+"&username="+userName.val();
    voio=voio+"&password="+password.val();
    voio=voio+"&roleId="+roleId;
    $.ajax({
        url: "/usermanager/addUserAndUserRoleAndRes",
        type: "post",
        dataType: "json",
        data: voio,
        success: function (data) {

            alert("创建管理员成功！！");

            window.location.reload();

        },
        error: function () {
            alert("请求失败");
        }
    });
}

function addRole() {
    var rolename = $("#rolename");
    if (!rolename.val()) {
        isError(rolename, "请输入角色信息");
        return false;
    }
    isOk(rolename, "角色信息通过");
    var rolecode = $("#rolecode");
    if (!rolecode.val()) {
        isError(rolecode, "角色编码不能为空");
        return false;
    }
    isOk(rolecode, "角色编码信息通过");

    return $("#roleForm").serialize();
}

//删除
function deleteManager(id) {
    if (confirm("确认删除么！！！")) {
        $.ajax({
            url: "/usermanager/deleteUser",
            type: "post",
            dataType: "json",
            async: false,
            data: {'userId':id},
            success: function (data) {
                if(data>0){
                    alert("删除成功！！！");
                    $("#user_table").bootstrapTable("refresh");
                }
            },
            error: function () {
                alert("请求失败");
            }
        });
    }
}

//复选框全选全不选
function checkAll(obj) {
    if ($(obj).prop("checked")) {
        $(obj).parent().parent().parent().find("input").prop("checked", true);
    } else {
        $(obj).parent().parent().parent().find("input").prop("checked", false);
    }

}
//复选框子节点联动父节点
function checkaaa(obj) {
    if ($(obj).prop("checked")) {
        $(obj).parent().parent().find("div").children().children().prop("checked", true);
    } else if ($(obj).parent().parent().find("input[type='checkbox']:checked").length == 1) {
        $(obj).parent().parent().find("div").children().children().prop("checked", false);
    }

}
//验证通过
function isOk(obj, text) {
    obj.parent().parent().removeClass("has-error");
    obj.parent().parent().addClass("has-success");
    obj.parent().next().children(":first").html(text);

}
//验证不通过
function isError(obj, text) {
    obj.parent().parent().removeClass("has-success");
    obj.parent().parent().addClass("has-error");
    obj.parent().next().children(":first").html(text);
}

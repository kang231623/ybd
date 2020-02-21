$(function () {
    //1.初始化Table
    integral_table(null);
})

function integral_table(formData) {
    $("#user_table").bootstrapTable("destroy");
    $("#user_table").bootstrapTable({ // 对应table标签的id
        url: "/integral/findUser?"+formData, // 获取表格数据的url
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
                field: 'integral',
                title: "积分"
            },{
                field: 'quantizationIntegral',
                title: "量化积分"
            },{
                field: 'chapterSerialNumber',
                title: '等级',
                formatter: function (value, row, index) {
                    if (value < 5 && value >= 0) {
                        return '初级'
                    } else if (value < 10 && value >= 5) {
                        return '中级'
                    } else {
                        return '高级'
                    }
                }
            },{
                title: "操作",
                formatter: function (value, row, index) {
                    var str =
                        "<a href='javascript:exchangeRecords(" + row.id + ")' class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">" +
                        // "<i class=\"layui-icon layui-icon-delete\">" +
                        "</i>兑换记录</a> ";
                    return str;
                }
            }
        ]
    })
}

function userIntegral_likeForm_querybtn() {
    var formData = $("#user_likeForm").serialize();

    integral_table(formData);

}

//兑换记录
function exchangeRecords(id) {
    $("#findExchangeRecords_Modal").modal("show");

     findExchangeRecords(id);
}

function findExchangeRecords(id) {
    $("#findExchangeRecords_table").bootstrapTable("destroy");
    $("#findExchangeRecords_table").bootstrapTable({ // 对应table标签的id
        url: "/integral/findExchangeRecords?id="+id, // 获取表格数据的url
        method: "get", //请求方式
        cache: false, //关闭缓存
        // toolbar: '#toolbar', //工具按钮用哪个容器
        pagination: true, //开启分页
        sidePagination: "server", //客户端分页client,"server"服务端分页
        pageNumber: 1, //分页起始行,默认第一行
        sortName: "id", //排序名
        sortOrder: "asc", //排序方式
        pageSize: 5, //每页几行
        pageList: [5,10, 20, 30], //设置每页几行的下拉框
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
                align: 'center',
                formatter: function (value, row, index) {//单元格格式化函数，有三个参数：value： 该列的字段值；row： 这一行的数据对象；index： 行号，第几行，从0开始计算
                    return index + 1;
                }
            },{
                field: 'operationTime',
                title: '时间',
                align: 'center',
            },{
                field: 'integralOperation',
                title: "积分",
                align: 'center',
            },{
                field: 'quantizationIntegralOperation',
                title: "量化积分",
                align: 'center',
            }
        ]
    })
}



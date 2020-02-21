<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/head.jsp"></jsp:include>
<body>

<script src="${pageContext.request.contextPath}/static/js/personalCenter/updatePWD.js"></script>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <form class="form-horizontal" role="form" id="userinfo_form">
                    <div class="form-group">
                        <label for="mobile" class="col-sm-1 control-label h5">手机号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" readonly id="mobile" value="${USER_SESSION.phone}" style="width: 330px;height: 40px"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobileCode" class="col-sm-1 control-label h5">手机验证码</label>
                        <div class="col-sm-2">
                            <input type="number" class="form-control" maxlength="4" autocomplete="off"
                                   id="mobileCode" style="width: 180px;height: 40px"/>
                        </div>
                        <div class="Codes_region col-sm-2" style="margin-left: -68px">
                            <input type="button" style="height: 39px" class="btn btn-primary" id="mobileCodebtn" value="点击获取验证码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-1 control-label h5">新密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="password" style="width: 330px;height: 40px"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="qrpassword" class="col-sm-1 control-label h5">确认新密码</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="qrpassword" style="width: 330px;height: 40px"/>
                        </div>
                    </div>

                </form>
                <button onclick="submitForm()" class="layui-btn" style="margin-left: 240px">确认修改密码</button>
            </div>
        </div>
    </div>
</div>
</body>

</html>

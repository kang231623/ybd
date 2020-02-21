<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../common/head.jsp"></jsp:include>
<body>

<script src="${pageContext.request.contextPath}/static/js/personalCenter/personalInfo.js"></script>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>
                    <form class="form-horizontal" role="form" id="userinfo_form">
                        <div class="layui-form" lay-filter="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="userName" value="${USER_SESSION.userName}"  class="layui-input">
                                    <input type="hidden" name="id" value="${USER_SESSION.id}"  class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-block">
                                    <input type="radio" name="sex" value="1" title="女" <c:if test="${USER_SESSION.sex==0}">checked</c:if>>
                                    <input type="radio" name="sex" value="0" title="男" <c:if test="${USER_SESSION.sex==1}">checked</c:if>>

                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">手机</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phone" value="${USER_SESSION.phone}"  lay-verify="phone" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="email" value="${USER_SESSION.email}"  lay-verify="email" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">积分</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="integral" value="${USER_SESSION.integral}" readonly lay-verify="integral" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">量化积分</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="quantizationIntegral" value="${USER_SESSION.quantizationIntegral}" readonly lay-verify="quantizationIntegral" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">职位</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="position" value="${USER_SESSION.position}" readonly lay-verify="position" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                    </form>
                    <button onclick="submitForm()" class="layui-btn" style="margin-left: 240px">确认修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
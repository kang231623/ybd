<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/head.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/static/js/integral/integralExChange.js"></script>

<div class="layui-fluid" style="height: 50%">
    <div class="layui-card">
        <div class="panel-body">
            <div class="panel panel-default">
                <div class="panel-heading">查询条件</div>
                <div class="panel-body">
                    <form id="user_likeForm" class="form-horizontal">
                        <div class="form-group" style="margin-top:15px">
                            <label class="control-label col-sm-1">用户名</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" name="userName">
                            </div>
                            <div class="col-sm-4" style="text-align:left;">
                                <button type="button" style="margin-left:50px" onclick="userIntegral_likeForm_querybtn()"
                                        class="layui-btn">查询
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <style>
                #user_table tr th {
                    padding: 1px;
                    height: 37px;
                    font-size: 14px;
                    text-align: center;
                    vertical-align: middle;
                }

                #user_table tr td {
                    padding: 1px;
                    height: 37px;
                    font-size: 14px;
                    text-align: center;
                    vertical-align: middle;
                }
            </style>
            <table id="user_table"></table>
        </div>
    </div>
</div>

    <!-- 模态框（Modal） -->
    <div class="modal" id="findExchangeRecords_Modal" role="dialog" aria-hidden="true" tabindex="-1" aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="width: 50%;">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">查询兑换记录</h4>
                </div>

                <div class="modal-body" style="height:auto;overflow: auto;">

                    <div class="panel-body">
                        <table id="findExchangeRecords_table"></table>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <a class="layui-btn layui-btn-fluid" data-dismiss="modal">关闭</a>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div>
        </div><!-- /.modal -->
    </div>

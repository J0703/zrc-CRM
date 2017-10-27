<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    <script src="../../js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/findAllDept.action",
                async: false,
                dataType: "json",
                success: function (posts) {
                    for (var i = 0; i < posts.length; i++) {
                        $("#department").append("<option value = '" + posts[i].depId + "'>" + posts[i].depName + "</option>");
                    }
                }
            });
            $("#department").change(function () {
                $("#post>option").remove();
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/findPostById.action",
                    async: false,
                    dataType: "json",
                    data: {"deptId": this.value},
                    success: function (posts) {
                        $("#post").append("<option value='-1'>--请选择职务--</option>");
                        for (var i = 0; i < posts.length; i++) {
                            $("#post").append("<option value = '" + posts[i].postId + "'>" + posts[i].postName + "</option>");
                        }
                    }
                });
            });
        })
    </script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="/crm2/staff/staffAction_edit.action" method="post">

    <input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value="${staff.loginName}"/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd" value="${staff.loginPwd}"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="${staff.staffName}"/></td>
            <td>性别：</td>
            <td>
                <input type="radio" name="gender"
                       <c:if test="${staff.gender eq '男' }">checked="checked"</c:if> value="男"/>男
                <input type="radio" name="gender"
                       <c:if test="${staff.gender eq '女' }">checked="checked"</c:if> value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select id="department" name="depId" onchange="changePost(this)">
                    <option value="">----请--选--择----</option>
                </select>

            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select name="postId" id="post">
                    <option value="">----请--选--择----</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="${staff.onDutyDate}" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
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
                        $("#department").append("<option name='depId' id='" + posts[i].depId + "' value = '" + posts[i].depId + "'>" + posts[i].depName + "</option>");
                    }
                    $("#" + "${ps.department.depId}").attr("selected", true);
                }
            });
        });
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
        <td width="44%" align="left">[职务管理]</td>
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

<form action="${pageContext.request.contextPath}/pages/post/listPost.jsp" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>选择部门：</td>
            <td>
                <select  id="department" name="depId">
                    <option value="">----请--选--择----</option>
                </select>
            </td>
            <td>职务：</td>
            <td><input type="text" name="postName" value="${ps.postName}"/></td>
        </tr>
    </table>
</form>
</body>
</html>

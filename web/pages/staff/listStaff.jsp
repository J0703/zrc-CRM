<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                    $("#" + "${ps.depId}").attr("selected", true);
                }
            });
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/findPostById.action",
                async: false,
                Type: "json",
                data: {"deptId": "${ps.depId}"},
                success: function (posts) {
                    for (var i = 0; i < posts.length; i++) {
                        $("#post").append("<option name='postId' id='" + posts[i].postId + "' value = '" + posts[i].postId + "'>" + posts[i].postName + "</option>");
                    }
                    $("#" + "${ps.postId}").attr("selected", true);
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

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img
                    src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="${pageContext.request.contextPath}/pages/staff/addStaff.jsp">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/find.action" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">
                <select id="department" name="deptId" onchange="changePost(this)">
                    <option value="-1">--请选择部门--</option>
                </select>
            </td>
            <td width="80px">职务：</td>
            <td width="200px">
                <select id="post" name="postId" id="postSelectId">
                    <option value="-1">--请选择职务--</option>
                </select>
            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12"/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>
<s:actionerror/>
<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>
    <c:forEach items="${pb.beanlist}" var="staff">
        <tr>
            <td align="center">${staff.staffName }</td>
            <td align="center">${staff.gender}</td>
            <td align="center">${staff.onDutyDate }</td>
            <td align="center">${staff.post.department.depName }</td>
            <td align="center">${staff.post.postName }</td>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/findStaffById.action?staffId=${staff.staffId}">
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第${pb.pageCode}/${pb.totalPage}页</span>
            <span>
        	<a href="">[首页]</a>&nbsp;&nbsp;
            <c:if test="${pb.pageCode > 1}">
                <a href="find.action?pageCode=${pb.pageCode - 1}&deptId=${ps.depId}& postId=${ps.postId}& staffName=${ps.staffName}">[上一页]</a>&nbsp;&nbsp;
            </c:if>
            <c:if test="${pb.pageCode<pb.totalPage}">
                <a href="find.action?pageCode=${pb.pageCode + 1}&deptId=${ps.depId}& postId=${ps.postId}& staffName=${ps.staffName}">[下一页]</a>&nbsp;&nbsp;
            </c:if>
            <a href="#">[尾页]</a>
            </span>
        </td>
    </tr>
</table>
</body>
</html>

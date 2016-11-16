<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<style>
*{font-family:"宋体";font-size:14px}
</style>
<div align="center">
<h2>管理员管理界面</h2>
<c:out value="${message }"/><br>
<table align="center" border="0" width="40%">
<tr><td><a href="${ctx}/home/homeMessage.jsp">客房信息</a></td><td><a href="${ctx}/home/stopHome.jsp">停用客房</a></td><td><a href="${ctx}/home/addHome.jsp">增加客房</a></td><td><a href="${ctx}/home/updateHome.jsp">更新客房信息</a></td></tr>
<tr><td><a href="${ctx}/admin/adminMessage.jsp">职工信息</a></td><td><a href="${ctx}/admin/deleteAdmin.jsp">删除职工</a></td><td><a href="${ctx}/admin/addAdmin.jsp">添加职工</a></td><td><a href="${ctx}/admin/updateAdmin.jsp">更新职工信息</a></td></tr>
</table>
<a href="login.jsp">退出</a>
</div>
<%@ include file="footer.htm" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/header.jsp" %>
<style>
* {	font-family: "宋体";font-size: 14px}
</style>
<%=request.getAttribute("message")%><br/>
<a href="${ctx}/admin/deleteAdmin.jsp">删除职工</a><BR>
<a href="${ctx}/admin/addAdmin.jsp">添加职工</a><BR>
<a href="${ctx}/admin/updateAdmin.jsp">修改职工信息</a><BR>
<a href="${ctx}/admin/adminMessage.jsp">查看职工信息</a><BR>
<%@ include file="/footer.htm"%>

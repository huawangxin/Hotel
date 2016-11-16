<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/header.jsp" %>
<style>
* {	font-family: "宋体";font-size: 14px}
</style>
<%=request.getAttribute("message")%><br/>
<a href="${ctx}/home/stopHome.jsp">停用客房</a><BR>
<a href="${ctx}/home/addHome.jsp">添加房间</a><BR>
<a href="${ctx}/home/updateHome.jsp">修改客房信息</a><BR>
<a href="${ctx}/home/homeMessage.jsp">查看客房信息</a><BR>
<%@ include file="/footer.htm"%>

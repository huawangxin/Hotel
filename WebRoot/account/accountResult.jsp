<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/header.jsp" %>
<style>
* {	font-family: "宋体";font-size: 14px}
</style>
<%=request.getAttribute("message")%><br/>
<a href="${ctx}/loginMessage3.jsp">返回服务页面</a><BR>
<%@ include file="/footer.htm"%>


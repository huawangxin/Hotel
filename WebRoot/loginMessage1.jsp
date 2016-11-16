<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<style>
*{font-family:"宋体";font-size:14px}
</style>
<div align="center">
<c:out value="${message }"/><br/>
<a href="${ctx}/login.jsp">重新登录</a><br>
</div>
<%@ include file="/footer.htm" %>

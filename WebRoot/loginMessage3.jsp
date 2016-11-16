<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>
<style>
*{font-family:"宋体";font-size:14px}
</style>
<div align="center">
<h2>管理员管理界面</h2>
<c:out value="${message }"/><br>
<table align="center" border="0" width="50%">
<tr><td><a href="${ctx}/person/personMessage.jsp">客户信息</a></td><td><a href="${ctx}/person/makeHome.jsp">客户预订</a></td><td><a href="${ctx}/person/makeEnter.jsp">订房客户入住</a></td><td><a href="${ctx}/person/changeHome.jsp">客户换房</a></td><td><a href="${ctx}/consum/selectConsum.jsp">查询消费信息</a></td></tr>
<tr><td><a href="${ctx}/person/homeMessage.jsp">房间信息</a></td><td><a href="${ctx}/person/quitHome.jsp">取消预定</a></td><td><a href="${ctx}/person/entering.jsp">未订房客户入住</a></td><td><a href="${ctx}/account/accountBill.jsp">结账退房</a></td><td><a href="${ctx}/consum/recordConsum.jsp">记录消费信息</a></td></tr>
</table>
<a href="login.jsp">退出</a>
</div>
<%@ include file="footer.htm" %>

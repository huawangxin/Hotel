<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,javax.sql.*,web.hotel.bean.Home" %>
<%@ page import="java.io.*,java.sql.*,javax.naming.*,javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
* {font-family: "宋体";font-size: 14px}
</style>
	<a href="${ctx}/loginMessage2.jsp">返回</a><br>
	客房信息：<br>
	<%
		String sql = "select * from admin";
		  	Context initContext=new InitialContext();
			DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
			Connection conn=ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
	%>
	<center>	
	<table width="600" border="1" bordercolor="000000"
		style="table-layout: fixed; word-break: break-all">
		<tr>
			<td width="100" bordercolor="ffffff">
				工号:
			</td>
			<td width="500" bordercolor="ffffff"><%=rs.getString("id") %></td>
		</tr>
		<tr>
			<td width="100" bordercolor="ffffff">
				姓名:
			</td>
			<td width="500" bordercolor="ffffff"><%=rs.getString("name") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				密码:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("password") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				身份:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("status") %></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			pstmt.close();
			conn.close();%>
<%@ include file="/footer.htm"%>

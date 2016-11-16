<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,javax.sql.*,web.hotel.bean.*" %>
<%@ page import="java.io.*,java.sql.*,javax.naming.*,javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
* {font-family: "宋体";font-size: 14px}
</style>
	<a href="${ctx}/loginMessage3.jsp">返回</a><br>
	客户信息：<br>
	<%
		String sql = "select * from person order by id asc";
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
				房间号:
			</td>
			<td width="500" bordercolor="ffffff"><%=rs.getString("id") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				姓名:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("name") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				身份证号:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("idcard") %></td>
		
		</tr>
		<tr>
			<td bordercolor="ffffff">
				房间类型:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("hometype") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				入住时间:
			</td>
			<td bordercolor="ffffff"><%=StringUtil.chanageNull(rs.getString("time"), "无")%></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				预定时间:
			</td>
			<td bordercolor="ffffff"><%=StringUtil.chanageNull(rs.getString("time1"), "无")%></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			pstmt.close();
			conn.close();%>
<%@ include file="/footer.htm"%>
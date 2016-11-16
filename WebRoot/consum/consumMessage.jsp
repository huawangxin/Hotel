<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,javax.sql.*,web.hotel.bean.Home" %>
<%@ page import="java.io.*,java.sql.*,javax.naming.*,javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
* {font-family: "宋体";font-size: 14px}
</style>
	<a href="${ctx}/loginMessage3.jsp">返回服务页面</a><br>
	消费信息：<br>
	<%		String id=request.getParameter("id");
			String drink = "select * from drink where id='"+id+"'";
			String food = "select * from food where id='"+id+"'";
			String tainment = "select * from tainment where id='"+id+"'";
			String phone = "select * from phone where id='"+id+"'";
		  	Context initContext=new InitialContext();
			DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
			Connection conn=ds.getConnection();
		
			PreparedStatement pstmt = conn.prepareStatement(drink);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){%>
	<center>
	<h2>饮料消费信息</h2>	
	<table width="600" border="1" bordercolor="000000" style="table-layout: fixed; word-break: break-all">
		<tr>
			<td width="100" bordercolor="ffffff">
				房间号:
			</td>
			<td width="500" bordercolor="ffffff"><%=rs.getString("id") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				服务类型:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("type") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费价格:
			</td>
			<td bordercolor="ffffff"><%=rs.getInt("cash") %></td>
		
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费时间:
			</td>
			<td bordercolor="ffffff"><%=rs.getString("time") %></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			pstmt.close();
			
			PreparedStatement ps = conn.prepareStatement(food);
			ResultSet rd = ps.executeQuery();
			while(rd.next()){%>
	<center>
	<h2>食物消费信息</h2>	
	<table width="600" border="1" bordercolor="000000" style="table-layout: fixed; word-break: break-all">
		<tr>
			<td width="100" bordercolor="ffffff">
				房间号:
			</td>
			<td width="500" bordercolor="ffffff"><%=rd.getString("id") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				服务类型:
			</td>
			<td bordercolor="ffffff"><%=rd.getString("type") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费价格:
			</td>
			<td bordercolor="ffffff"><%=rd.getInt("cash") %></td>
		
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费时间:
			</td>
			<td bordercolor="ffffff"><%=rd.getString("time") %></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			ps.close();
			
			PreparedStatement pst = conn.prepareStatement(tainment);
			ResultSet ra = pst.executeQuery();
			while(ra.next()){%>
	<center>
	<h2>娱乐消费信息</h2>	
	<table width="600" border="1" bordercolor="000000" style="table-layout: fixed; word-break: break-all">
		<tr>
			<td width="100" bordercolor="ffffff">
				房间号:
			</td>
			<td width="500" bordercolor="ffffff"><%=ra.getString("id") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				服务类型:
			</td>
			<td bordercolor="ffffff"><%=ra.getString("type") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费价格:
			</td>
			<td bordercolor="ffffff"><%=ra.getInt("cash") %></td>
		
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费时间:
			</td>
			<td bordercolor="ffffff"><%=ra.getString("time") %></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			pst.close();
			
			PreparedStatement pstm = conn.prepareStatement(phone);
			ResultSet rb = pstm.executeQuery();
			while(rb.next()){%>
	<center>
	<h2>电话消费信息</h2>	
	<table width="600" border="1" bordercolor="000000" style="table-layout: fixed; word-break: break-all">
		<tr>
			<td width="100" bordercolor="ffffff">
				房间号:
			</td>
			<td width="500" bordercolor="ffffff"><%=rb.getString("id") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				服务类型:
			</td>
			<td bordercolor="ffffff"><%=rb.getString("type") %></td>
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费价格:
			</td>
			<td bordercolor="ffffff"><%=rb.getInt("cash") %></td>
		
		</tr>
		<tr>
			<td bordercolor="ffffff">
				消费时间:
			</td>
			<td bordercolor="ffffff"><%=rb.getString("time") %></td>
		</tr>
	</table>
	<br>	
</center>
			<%} 
			rs.close();
			pst.close();%>
			<%conn.close();
			%>
			
<%@ include file="/footer.htm"%>

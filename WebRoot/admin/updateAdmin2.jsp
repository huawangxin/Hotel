<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,java.text.*,javax.sql.*,web.hotel.bean.*" %>
<%@ page import="java.io.*,java.sql.*,javax.naming.*,javax.sql.DataSource" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jsp"%>
<style>
* {font-family: "宋体";font-size: 14px}
</style>
	<a href="${ctx}/loginMessage2.jsp">返回管理界面</a><br>
	客房信息：<br>
	<%
		String message="";
		if (StringUtil.validateNull(request.getParameter("id"))) {
			message="对不起，工号不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(request, response);
		} 
		String sql = "select * from admin where id='"+request.getParameter("id")+"'";
		  	Context initContext=new InitialContext();
			DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
			Connection conn=ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
	%>
	<script src="hotel/js/validation-framework.js"></script>
		<div align="center">
			增加客房信息
		<form id="form9" name="form9" method="post"
			action="${ctx}/servlet/updateAdmin"
			onsubmit="return doValidate(this)">
			<table width="491" border="0">
				<tr>
					<td width="87">
						工号：
					</td>
					<td width="394">
						<label>
							<input name="id" type="text" id="id" size="40" value="<%=rs.getString("id")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						姓名：
					</td>
					<td>
						<label>
							<input name="name" type="text" id="name" size="40" value="<%=rs.getString("name")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<label>
							<input name="password" type="text" id="password" size="40" value="<%=rs.getString("password")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						身份：
					</td>
					<td>
						<label>
							<input name="status" type="text" id="status" size="40" value="<%=rs.getString("status")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						<label>
							<input type="submit" name="submit" id="submit" value="提交" />
						</label>
					</td>
					<td>
						<label>
							<input type="reset" name="reset" id="reset" value="重置" />
						</label>
					</td>
				</tr>
			</table>
		</form>
</div>
			<%} 
			rs.close();
			pstmt.close();
			conn.close();%>
<%@ include file="/footer.htm"%>

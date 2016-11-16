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
			message="对不起，房间号不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
		} 
		String sql = "select * from home where id='"+request.getParameter("id")+"'";
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
		<form id="form5" name="form5" method="post"
			action="${ctx}/servlet/updateHome"
			onsubmit="return doValidate(this)">
			<table width="491" border="0">
				<tr>
					<td width="87">
						客房号：
					</td>
					<td width="394">
						<label>
							<input name="id" type="text" id="id" size="40" value="<%=rs.getString("id")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房状态：
					</td>
					<td>
						<label>
							<input name="state" type="text" id="state" size="40" value="<%=rs.getString("state")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房类型：
					</td>
					<td>
						<label>
							<input name="type" type="text" id="type" size="40" value="<%=rs.getString("type")%>"/>
						</label>
					</td>
				</tr>
				<tr>
					<td>
						客房价格：
					</td>
					<td>
						<label>
							<input name="price" type="text" id="price" size="40" value="<%=rs.getString("price")%>"/>
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
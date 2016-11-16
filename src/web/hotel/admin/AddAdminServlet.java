package web.hotel.admin;

import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import web.hotel.bean.*;

public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "insert into admin (id,name,password,status) values(?,?,?,?)";
		int result = 0;
		String message="";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		if (StringUtil.validateNull(id)) {
			message="对不起，工号不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(request, response);
		} else if (StringUtil.validateNull("name")) {
			message="对不起，姓名不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(request, response);
		} else {
			try {
				Context initContext=new InitialContext();
				DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn=ds.getConnection();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, password);
				pstmt.setString(4, status);
				result = pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 0) {
				message="添加职工信息不成功";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/admin/adminResult.jsp").forward(request, response);
			} else {
				message="成功添加职工信息。<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/admin/adminResult.jsp").forward(request, response);
			}
		}
	}

}

package web.hotel.home;

import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import web.hotel.bean.*;

public class AddHomeServlet extends HttpServlet {
	private static final long serialVersionUID = -4301454054547170030L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "insert into home (id,state,type,price) values(?,?,?,?)";
		int result = 0;
		String message="";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		String type = request.getParameter("type");
		String price = request.getParameter("price");

		if (StringUtil.validateNull(id)) {
			message="对不起，房间号不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
		} else if (StringUtil.validateNull(state)) {
			message="对不起，房间状态不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
		} else {
			try {
				Context initContext=new InitialContext();
				DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn=ds.getConnection();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, state);
				pstmt.setString(3, type);
				pstmt.setString(4, price);
				result = pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 0) {
				message="添加房间信息失败";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
			} else {
				message="成功添加客房信息。<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
			}
		}
	}
}


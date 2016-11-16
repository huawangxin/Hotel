package web.hotel.home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import web.hotel.bean.StringUtil;

public class UpdateHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String sql = "update home set state='" + state + "',type='" + type
				+ "',price='" + price + "'  where id='" + id + "'";
		int result = 0;
		String message = "";

		if (StringUtil.validateNull(state)) {
			message = "对不起，房间状态不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(type)) {
			message = "对不起，房间类型不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(price)) {
			message = "对不起，房间价格不能为空，请您重新输入！<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(
					request, response);
		} else {
			try {
				Context initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn = ds.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 0) {
				message = "修改信息不成功！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(
						request, response);
			} else {
				message = "成功修改客房信息。<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(
						request, response);
			}
		}
	}

}

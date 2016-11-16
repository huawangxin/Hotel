package web.hotel.admin;

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

public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = -3640479168438763111L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String sql = "update admin set name='" + name + "',password='" + password
				+ "',status='" + status + "'  where id='" + id + "'";
		int result = 0;
		String message = "";

		if (StringUtil.validateNull(name)) {
			message = "�Բ�������״̬����Ϊ�գ������������룡<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(password)) {
			message = "�Բ������벻��Ϊ�գ������������룡<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(status)) {
			message = "�Բ�����ݲ���Ϊ�գ������������룡<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/admin/adminResult.jsp").forward(
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
				message = "�޸���Ϣ���ɹ���";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/admin/adminResult.jsp").forward(
						request, response);
			} else {
				message = "�ɹ��޸�ְ����Ϣ��<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/admin/adminResult.jsp").forward(
						request, response);
			}
		}
	}

}

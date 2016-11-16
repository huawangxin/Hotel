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

public class StopHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		String message="";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String sql = "delete from home where id='"+id+"'";
		if (StringUtil.validateNull(id)) {
			message="�Բ��𣬷���Ų���Ϊ�գ������������룡<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
		}else {
			try {
				Context initContext=new InitialContext();
				DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn=ds.getConnection();
				
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
				message="ͣ�ÿͷ����ɹ���<br>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
			} else {
				message="�ɹ�ͣ�ÿͷ���<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/home/homeResult.jsp").forward(request, response);
			}
		}
		
	}

}
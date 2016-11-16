package web.hotel.person;

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

public class QuitHomeServlet extends HttpServlet {
	private static final long serialVersionUID = -256756426470975594L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String make="��";
		String sql = "update home set state='"+make+"'  where id='" + id + "'";
		String sq = "delete from consume where id='"+id+"'";
		String sqq = "delete from person where id='"+id+"'";
		int result = 0;
		int res=0;
		int resu=0;
		String message = "";

		if (StringUtil.validateNull(id)) {
			message = "�Բ��𣬷���Ų���Ϊ�գ������������룡<br>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/person/personResult.jsp").forward(
					request, response);
		}else{
			try {
				Context initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn = ds.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();
				pstmt.close();
				PreparedStatement pst = conn.prepareStatement(sq);
				res = pst.executeUpdate();
				pst.close();
				PreparedStatement pss = conn.prepareStatement(sqq);
				resu=pss.executeUpdate();
				pss.close();
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((result!=0)&&(res!=0)&&(resu!=0)){
				message = "ȡ��Ԥ���ɹ�������50��Ѻ��<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}else {
				message = "ȡ��Ԥ�����ɹ���";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}  
		}
	}

}

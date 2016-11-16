package web.hotel.person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import web.hotel.bean.StringUtil;

public class MakeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 848420673746562574L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String hometype = request.getParameter("hometype");
		String make="预订";
		String sql = "update home set state='"+make+"'  where id='" + id + "'";
		String sq = "insert into consume (id,room) values(?,?)";
		String sqq = "insert into person (id,name,idcard,hometype,time1) values(?,?,?,?,?)";
		int result = 0;
		int res=0;
		int resu=0;
		String message = "";

		if (StringUtil.validateNull(id)) {
			message = "对不起，房间号不能为空，请您重新输入！<br>";
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
				pst.setString(1, id);
				pst.setInt(2, 100);
				res = pst.executeUpdate();
				pst.close();
				PreparedStatement pss = conn.prepareStatement(sqq);
				pss.setString(1, id);
				pss.setString(2, name);
				pss.setString(3, idcard);
				pss.setString(4, hometype);
				SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
				pss.setString(5, sdf.format(new java.util.Date()));
				resu=pss.executeUpdate();
				pss.close();
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((result!=0)&&(res!=0)&&(resu!=0)){
				message = "预定成功！<BR>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}else {
				message = "预定不成功！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}  
		}
	}
}

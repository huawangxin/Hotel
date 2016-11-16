package web.hotel.consum;

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

public class RecordConsumServlet extends HttpServlet {
	private static final long serialVersionUID = 1777536995343311616L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String drink = "insert into drink (id,type,cash,time) values(?,?,?,?)";
		String food = "insert into food (id,type,cash,time) values(?,?,?,?)";
		String tainment = "insert into tainment (id,type,cash,time) values(?,?,?,?)";
		String phone = "insert into phone (id,type,cash,time) values(?,?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat(
		"yyyy-MM-dd hh:mm:ss");
		int result = 0;
		String message="";
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String type1 = request.getParameter("type1");
		String type = request.getParameter("type");
		String cash = request.getParameter("cash");

		if (StringUtil.validateNull(id)) {
			message="对不起，房间号不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/consum/consumResult.jsp").forward(request, response);
		} else if (StringUtil.validateNull(cash)) {
			message="对不起，价格不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/consum/consumResult.jsp").forward(request, response);
		}else if (StringUtil.validateNull(type)) {
			message="对不起，服务类型不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/consum/consumResult.jsp").forward(request, response);
		}
		else {
			try {
				Context initContext=new InitialContext();
				DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn=ds.getConnection();
				
				if(type1.equals("drink")){
				PreparedStatement pstmt = conn.prepareStatement(drink);
				pstmt.setString(1, id);
				pstmt.setString(2, type);
				pstmt.setInt(3, Integer.parseInt(cash));
				pstmt.setString(4, sdf.format(new java.util.Date()));
				result = pstmt.executeUpdate();
				pstmt.close();
				}else if(type1.equals("food")){
					PreparedStatement pstmt = conn.prepareStatement(food);
					pstmt.setString(1, id);
					pstmt.setString(2, type);
					pstmt.setInt(3, Integer.parseInt(cash));
					pstmt.setString(4, sdf.format(new java.util.Date()));
					result = pstmt.executeUpdate();
					pstmt.close();
				}else if(type1.equals("phone")){
					PreparedStatement pstmt = conn.prepareStatement(phone);
					pstmt.setString(1, id);
					pstmt.setString(2, type);
					pstmt.setInt(3, Integer.parseInt(cash));
					pstmt.setString(4, sdf.format(new java.util.Date()));
					result = pstmt.executeUpdate();
					pstmt.close();
				}else{
					PreparedStatement pstmt = conn.prepareStatement(tainment);
					pstmt.setString(1, id);
					pstmt.setString(2, type);
					pstmt.setInt(3,Integer.parseInt(cash));
					pstmt.setString(4, sdf.format(new java.util.Date()));
					result = pstmt.executeUpdate();
					pstmt.close();
				}
				conn.close();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 0) {
				message="记录消费信息失败";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/consum/consumResult.jsp").forward(request, response);
			} else {
				message="成功记录消费信息";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/consum/consumResult.jsp").forward(request, response);
			}
		}
	}

}

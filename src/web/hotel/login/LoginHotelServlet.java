package web.hotel.login;

import java.io.*;
import java.sql.*;
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

public class LoginHotelServlet extends HttpServlet {
	private static final long serialVersionUID = -709815546902350871L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name1 = request.getParameter("name");
		String pass = request.getParameter("password");
		String radio = request.getParameter("radio");
		String sql = "select password,status from admin where name='"+request.getParameter("name")+"'";
		String result=null;
		String message="";
		int tag=0;
		if (StringUtil.validateNull(name1)) {
			tag=1;
			message="对不起，姓名不能为空，请重新登录！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/loginMessage1.jsp").forward(request, response);
			} else if (StringUtil.validateNull(pass)) {
				tag=1;
			message="对不起，主题不能为空，请重新登录！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/loginMessage1.jsp").forward(request, response);
			}
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:/comp/env/jdbc/oracleds");
			Connection conn=ds.getConnection();
			SimpleDateFormat sdf = new SimpleDateFormat(
		    "yyyy-MM-dd hh:mm:ss");
			result=sdf.format(new java.util.Date());
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				tag=1;
				if((rs.getString("password").equals(pass))&&(rs.getString("status").equals(radio))&&(radio.equals("manager"))){
					message=name1+"登陆成功              当前时间为："+result;
					request.setAttribute("message", message);
					request.getRequestDispatcher("/loginMessage2.jsp").forward(request, response);
				}else if((rs.getString("password").equals(pass))&&(rs.getString("status").equals(radio))&&(radio.equals("person"))){
					message=name1+"登陆成功              当前时间为："+result;
					request.setAttribute("message", message);
					request.getRequestDispatcher("/loginMessage3.jsp").forward(request, response);
				}else if((rs.getString("password").equals(pass))&&(rs.getString("status")!=radio)){
					message="请选择正确的身份";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/loginMessage1.jsp").forward(request, response);
				}else{
					message="密码不正确";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/loginMessage1.jsp").forward(request, response);
				}
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tag==0){
			message="此用户不存在";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/loginMessage1.jsp").forward(request, response);
		}
		
	}
	
}

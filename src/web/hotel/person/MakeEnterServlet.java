package web.hotel.person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import web.hotel.bean.StringUtil;

public class MakeEnterServlet extends HttpServlet {
	private static final long serialVersionUID = -7970864111348372252L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String make="满";
		String s="select idcard from person where id='" + id + "'";
		String ss="select price from home where id='" + id + "'";
		String sql = "update home set state='"+make+"'  where id='" + id + "'";
		SimpleDateFormat sdf = new SimpleDateFormat(
		"yyyy-MM-dd hh:mm:ss");
		String sqq = "update person set time='"+sdf.format(new java.util.Date())+"',time1='无' where='"+id+"'";
		int a=0;
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
				
				PreparedStatement ps = conn.prepareStatement(s);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
				if(rs.getString("idcard").equals(request.getParameter("idcard"))){
				ps.close();
				PreparedStatement pd = conn.prepareStatement(ss);
				ResultSet rd = pd.executeQuery();
				while(rd.next()){
				String sq = "update consume set room='"+Integer.parseInt(rd.getString("price"))+"' where id='" + id + "'";
				a=Integer.parseInt(rd.getString("price"))-100;
				pd.close();
				
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
						}
					}
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((result!=0)&&(res!=0)&&(resu!=0)){
				message = "入住成功！需补交'"+a+"'元";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}else {
				message = "入住不成功！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp").forward(
						request, response);
			}  
		}
	}

}

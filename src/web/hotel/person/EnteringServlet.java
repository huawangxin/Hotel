package web.hotel.person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class EnteringServlet extends HttpServlet {
	private static final long serialVersionUID = -1935995475019727609L;
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
		String make="满";
		String s="insert into person (name,id,idcard,hometype,time,time1) values(?,?,?,?,?,?)";
		String ss="select * from home where id='" + id + "'";
		String sql = "update home set state='"+make+"'  where id='" + id + "'";
		SimpleDateFormat sdf = new SimpleDateFormat(
		"yyyy-MM-dd hh:mm:ss");
		String sqq = "insert into consume (id,room) values(?,?)";
		int a=0;
		String b="";
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
				
				PreparedStatement pd = conn.prepareStatement(ss);
				ResultSet rd = pd.executeQuery();
				while(rd.next()){
				a=Integer.parseInt(rd.getString("price"));
				b=rd.getString("type");
				}
				pd.close();
				
				PreparedStatement ps = conn.prepareStatement(s);
				ps.setString(1, name);
				ps.setString(2, id);
				ps.setString(3, idcard);
				ps.setString(4, b);
				ps.setString(5, sdf.format(new java.util.Date()));
				ps.setString(6, "无");
				res = ps.executeUpdate();
				ps.close();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();
				pstmt.close();
				
				PreparedStatement pss = conn.prepareStatement(sqq);
				pss.setString(1, id);
				pss.setInt(2, a);
				resu=pss.executeUpdate();
				pss.close();
				conn.close();
						
					
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((result!=0)&&(res!=0)&&(resu!=0)){
				message = "入住成功！需交'"+a+"'元";
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

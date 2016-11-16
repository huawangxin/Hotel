package web.hotel.bill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class AccountBillServlet extends HttpServlet {
	private static final long serialVersionUID = 4261318000055910391L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		int a=0;
		int	b=0;
		int	c=0;
		int	d=0;
		int k=0;
		int	f=0;	
		int	g=0;
		int	h=0;
		int	i=0;
		int	j=0;
		int result=0;
		int total=0;
		String x="空";
		String drink = "select * from drink where id='"+id+"'";
		String food = "select * from food where id='"+id+"'";
		String tainment = "select * from tainment where id='"+id+"'";
		String phone = "select * from phone where id='"+id+"'";
		String delete1 = "delete from drink where id='"+id+"'";
		String delete2 = "delete from food where id='"+id+"'";
		String delete3 = "delete from tainment where id='"+id+"'";
		String delete4 = "delete from phone where id='"+id+"'";
		String delete5 = "delete from person where id='"+id+"'";
		String delete6 = "delete from consume where id='"+id+"'";
		//String delete7 = "delete from drink,food,tainment,phone,person,consume where id='"+id+"'";
		String update="update home set state='"+x+"'  where id='" +id+ "'";
		String message="";
		if (StringUtil.validateNull(id)) {
			message = "对不起，房间号不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/account/accountResult.jsp").forward(
					request, response);
		}
		try {
	  	Context initContext=new InitialContext();
		DataSource ds=(DataSource)initContext.lookup("java:/comp/env/jdbc/oracleds");
		Connection conn=ds.getConnection();
	
		PreparedStatement pstmt = conn.prepareStatement(drink);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){	
                 a=rs.getInt("cash");
		}
		rs.close();
		pstmt.close();
		
		PreparedStatement ps = conn.prepareStatement(food);
		ResultSet rc = ps.executeQuery();
		while(rc.next()){
			b=rc.getInt("cash"); 
		} 
		rc.close();
		ps.close();
		
		PreparedStatement pst = conn.prepareStatement(tainment);
		ResultSet ra = pst.executeQuery();
		while(ra.next()){
			c=ra.getInt("cash"); 
		} 
		ra.close();
		pst.close();
		
		PreparedStatement pstm = conn.prepareStatement(phone);
		ResultSet rb = pstm.executeQuery();
		while(rb.next()){
			d=rb.getInt("cash"); 
		} 
		rb.close();
		pst.close();
		
		PreparedStatement updatea = conn.prepareStatement(update);
		f = updatea.executeUpdate();
		updatea.close();
		
		PreparedStatement deleteb = conn.prepareStatement(delete1);
		g = deleteb.executeUpdate();
		deleteb.close();
		
		PreparedStatement deletec = conn.prepareStatement(delete2);
		h = deletec.executeUpdate();
		deletec.close();
		
		PreparedStatement deleted = conn.prepareStatement(delete3);
		i = deleted.executeUpdate();
		deleted.close();
		
		PreparedStatement deletee = conn.prepareStatement(delete4);
		j = deletee.executeUpdate();
		deletee.close();
		
		PreparedStatement deletef = conn.prepareStatement(delete5);
		k = deletef.executeUpdate();
		deletef.close();
		
		PreparedStatement deleteg = conn.prepareStatement(delete6);
		result = deleteg.executeUpdate();
		deleteg.close();
		conn.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		total=a+b+c+d;
		if ((total!=0)&&(result!=0)&&(f!=0)&&(g!=0)&&(h!=0)&&(i!=0)&&(j!=0)&&(k!=0)) {
			message = "退房成功！需交'" + total + "'元";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/account/accountResult.jsp")
					.forward(request, response);
		} else {
			message = "结账不成功！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/account/accountResult.jsp")
					.forward(request, response);
		}
		
	}

}

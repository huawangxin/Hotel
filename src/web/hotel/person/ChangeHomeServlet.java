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

public class ChangeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = -8065114485026237176L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		String idcard = request.getParameter("idcard");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int price1 = 0;
		int price2 = 0;
		String type2 = "";
		String make = "";
		String x = "空";
		String y = "满";
		String insert = "insert into consume (id,room) values(?,?)";
		String delete = "delete from consume where id='" + id1 + "'";
		String select1 = "select idcard from person where id='" + id1 + "'";
		String select2 = "select price from home where id='" + id1 + "'";
		String select3 = "select price,type from home where id='" + id2 + "'";
		String update2 = "update home set state='"+x+"'  where id='" + id1 + "'";
		String update3 = "update home set state='"+y+"'  where id='" + id2 + "'";

		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int result = 0;
		int res = 0;
		int resu = 0;
		String message = "";

		if (StringUtil.validateNull(id1)) {
			message = "对不起，房间号不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/person/personResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(id2)) {
			message = "对不起，房间号不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/person/personResult.jsp").forward(
					request, response);
		} else if (StringUtil.validateNull(idcard)) {
			message = "对不起，证件号不能为空，请您重新输入！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/person/personResult.jsp").forward(
					request, response);
		} else {
			try {
				Context initContext = new InitialContext();
				DataSource ds = (DataSource) initContext
						.lookup("java:/comp/env/jdbc/oracleds");
				Connection conn = ds.getConnection();

				PreparedStatement selecta = conn.prepareStatement(select1);
				ResultSet rd = selecta.executeQuery();
				while (rd.next()) {
					make = rd.getString("idcard");
					// a=Integer.parseInt(rd.getString("price"));
				}
				rd.close();

				if (make.equals(idcard)) {
					PreparedStatement selectb = conn.prepareStatement(select2);
					ResultSet rs = selectb.executeQuery();
					while (rs.next()) {
						price1 = Integer.parseInt(rs.getString("price"));
					}
					rs.close();

					PreparedStatement selectc = conn.prepareStatement(select3);
					ResultSet ra = selectc.executeQuery();
					while (ra.next()) {
						price2 = Integer.parseInt(ra.getString("price"));
						type2 = ra.getString("type");
					}
					ra.close();
					//String update1 = "update person set id="+id2+"  where idcard='" + idcard + "'";
					String update1 = "update person set id='" + id2 + "',hometype='"
					+ type2 + "',time='" + sdf.format(new java.util.Date())
					+ "'  where idcard='" + idcard + "'";

					PreparedStatement updatea = conn.prepareStatement(update1);
					result = updatea.executeUpdate();
					updatea.close();

					PreparedStatement updateb = conn.prepareStatement(update2);
					res = updateb.executeUpdate();
					updateb.close();

					PreparedStatement updatec = conn.prepareStatement(update3);
					b = updatec.executeUpdate();
					updatec.close();

					PreparedStatement deletea = conn.prepareStatement(delete);
					resu = deletea.executeUpdate();
					deletea.close();

					PreparedStatement inserta = conn.prepareStatement(insert);
					inserta.setString(1, id2);
					inserta.setInt(2, price2 + 20);
					c = inserta.executeUpdate();
					inserta.close();
				} else {
					message = "对不起，证件号正确，请您重新输入！";
					request.setAttribute("message", message);
					request.getRequestDispatcher("/person/personResult.jsp")
							.forward(request, response);
				}
				conn.close();
				d = price2 - price1;
				if (d > 0) {
					a = d + 20;
				} else {
					a = 20;
				}
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if ((result != 0) && (res != 0) && (resu != 0) && (b != 0)
					&& (c != 0)) {
				message = "换房成功！需交'" + a + "'元";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp")
						.forward(request, response);
			} else {
				message = "换房不成功！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/person/personResult.jsp")
						.forward(request, response);
			}
		}
	}

}

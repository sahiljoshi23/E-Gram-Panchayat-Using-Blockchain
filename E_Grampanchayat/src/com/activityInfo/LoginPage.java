package com.activityInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.user;

import com.Connection.ConnectionFactory;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");
		String userPass = request.getParameter("pass");
		System.out.println(userName + "\t" + userPass);

		String role = request.getParameter("role");
		try {
			if (role.equals("User")) {
				String queryString = "select * FROM tbluser WHERE U_Email_ID='"
						+ userName + "'and U_Password='" + userPass + "'";
				connection = ConnectionFactory.getInstance().getConnection();
				ptmt = connection.prepareStatement(queryString);

				resultSet = ptmt.executeQuery();
				if (resultSet.next()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("U_Email_ID", userName);
					session.setAttribute("U_Name",
							resultSet.getString("U_Name"));
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Login Success');");
					out.println("</script>");
					request.getRequestDispatcher("/UserHome.jsp").include(
							request, response);

				} else {

					response.sendRedirect("login.jsp?no=1");

				}
			} else if (role.equals("Gram_P")) {
				String queryString = "select * FROM tblowner WHERE O_Email_ID='"
						+ userName + "'and O_Password='" + userPass + "'";
				connection = ConnectionFactory.getInstance().getConnection();
				ptmt = connection.prepareStatement(queryString);

				resultSet = ptmt.executeQuery();
				if (resultSet.next()) {
					System.out.println(userName);
					HttpSession session = request.getSession(true);
					session.setAttribute("O_Email_ID", userName);
					session.setAttribute("O_Name",
							resultSet.getString("O_Name"));
					session.setAttribute("O_Mobile",
							resultSet.getString("O_Mobile"));

					session.setAttribute("O_Number",
							resultSet.getString("O_id"));
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Login Success');");
					out.println("</script>");
					request.getRequestDispatcher("/OwnerHomePage.jsp").include(
							request, response);

				} else {
					response.sendRedirect("login.jsp?no=1");
				}

			} else if (role.equals("Government")) {
				String queryString = "select * FROM tblaa WHERE A_Email_ID='"
						+ userName + "'and A_Password='" + userPass + "'";
				connection = ConnectionFactory.getInstance().getConnection();
				ptmt = connection.prepareStatement(queryString);

				resultSet = ptmt.executeQuery();
				if (resultSet.next()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("A_Email_ID", userName);
					session.setAttribute("A_Name",
							resultSet.getString("A_Name"));
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Login Success');");
					out.println("</script>");
					System.out.println(resultSet.getString("A_Name"));
					request.getRequestDispatcher("/AuthorityHomePage.jsp")
							.include(request, response);

				} else {

					 out.print("<h4 align='center'>Wrong Email ID and Password</h4>");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/login.jsp");
					dispatcher.include(request, response);
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

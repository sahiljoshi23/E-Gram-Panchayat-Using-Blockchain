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

import com.Connection.ConnectionFactory;

import Dao.user;

/**
 * Servlet implementation class RegisterPage
 */
@WebServlet("/RegisterPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterPage() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String O_Name, O_Email_ID, O_Password, Address, O_Mobile;
		O_Name = request.getParameter("uname");
		System.out.println(O_Name);
		O_Email_ID = request.getParameter("email");
		System.out.println(O_Email_ID);
		O_Password = request.getParameter("password");
		System.out.println(O_Password);
		O_Mobile = request.getParameter("mobile");
		System.out.println(O_Mobile);
		Address = request.getParameter("address");
		System.out.println(Address);

		String role = request.getParameter("role");
		try {
			if (role.equals("User")) {
				ResultSet rs=user.chckemail(O_Email_ID);
				
				if(rs.next())
				{
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Email ID Already Exist');");  
					out.println("</script>");  
					response.sendRedirect("login.jsp?no=1");
				}
				else
				{
					
					String queryString = "insert into tbluser(U_Name,U_Email_ID,U_Password,U_Mobile,Address) values(?,?,?,?,?)";
					connection =ConnectionFactory.getInstance().getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1,O_Name);
					ptmt.setString(2,O_Email_ID);
					ptmt.setString(3,O_Password);
					ptmt.setString(4,O_Mobile);
					ptmt.setString(5,Address);
					int i = ptmt.executeUpdate();
					if(i>0)
					{
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Register Successfully go to Login Page');");  
						out.println("</script>");    
						request.getRequestDispatcher("login.jsp").include(request, response);
					}else
					{					
						ServletContext context=getServletContext();	
						RequestDispatcher dispatcher=context.getRequestDispatcher("/login.jsp");
						dispatcher.forward(request, response);
					}
				}
			} else if (role.equals("Gram_P")) {
				ResultSet rs=user.O_chckemail(O_Email_ID);
				if(rs.next())
					{
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Email ID Already Exist');");  
						out.println("</script>");  
						response.sendRedirect("login.jsp?no=1");//.include(request, response);
					}
					else
					{
						connection =ConnectionFactory.getInstance().getConnection();
						String queryString = "insert into tblowner(O_Name, O_Email_ID, O_Password,O_Mobile,Address) values(?,?,?,?,?)";
						
						ptmt = connection.prepareStatement(queryString);
						ptmt.setString(1,O_Name);
						ptmt.setString(2,O_Email_ID);
						ptmt.setString(3,O_Password);
						ptmt.setString(4,O_Mobile);
						ptmt.setString(5,Address);
											
						int i = ptmt.executeUpdate();
							
						if(i>0)
						{
							out.println("<script type=\"text/javascript\">");  
							out.println("alert('Register Successfully go to Login Page');");  
							out.println("</script>");    
							request.getRequestDispatcher("login.jsp").include(request, response);
						}else
						{					
							ServletContext context=getServletContext();	
							RequestDispatcher dispatcher=context.getRequestDispatcher("/login.jsp");
							dispatcher.forward(request, response);
						}
					}
			} else if (role.equals("Government")) {
				ResultSet rs=user.A_chckemail(O_Email_ID);
				
				if(rs.next())
				{
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Email ID Already Exist');");  
					out.println("</script>");  
					//request.getRequestDispatcher("admin_signin.jsp").include(request, response);
					response.sendRedirect("login.jsp?no=1");
				}
				else
				{
					String queryString = "insert into tblaa(A_Name, A_Email_ID, A_Password,A_Mobile,Address) values(?,?,?,?,?)";
					connection =ConnectionFactory.getInstance().getConnection();
					ptmt = connection.prepareStatement(queryString);
					ptmt.setString(1,O_Name);
					ptmt.setString(2,O_Email_ID);
					ptmt.setString(3,O_Password);
					ptmt.setString(4,O_Mobile);
					ptmt.setString(5,Address);
				
					int i = ptmt.executeUpdate();
					if(i>0)
					{
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Register Successfully go to Login Page');");  
						out.println("</script>");
						request.getRequestDispatcher("login.jsp").include(request, response);
					}else
					{					
						ServletContext context=getServletContext();	
						RequestDispatcher dispatcher=context.getRequestDispatcher("/login.jsp");
						dispatcher.forward(request, response);
					}
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

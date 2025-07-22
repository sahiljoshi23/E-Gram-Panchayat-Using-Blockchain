package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.ConnectionFactory;

/**
 * Servlet implementation class ComplaintServlet
 */
@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		
		String gp_name=request.getParameter("gp_name");
		String gp_email=request.getParameter("gp_email");
		String Subject_name = request.getParameter("fund_name");
		String Description=request.getParameter("Description");
		String fund_date=request.getParameter("fund_date");
		
		String U_Email_ID;
		U_Email_ID=(String)session.getAttribute("U_Email_ID");
		System.out.println(U_Email_ID);
		
		
		
		try {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;
String Status_msg="Waiting";
			String queryString = "insert into complaints(user_id,Gram_Panchayat_Name,Gram_Panchayat_Email,subject,description,status) values(?,?,?,?,?,?)";
			connection = ConnectionFactory.getInstance().getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,U_Email_ID);
			ptmt.setString(2, gp_name);
			ptmt.setString(3, gp_email);
			ptmt.setString(4, Subject_name);
			ptmt.setString(5, Description);
			ptmt.setString(6,Status_msg);
		
			
			
			int i = ptmt.executeUpdate();

			if (i > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Send Complaints Successfully');");
				out.println("</script>");
				request.getRequestDispatcher("U_Track_Complaints_Show.jsp").include(request,
						response);
			} 

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

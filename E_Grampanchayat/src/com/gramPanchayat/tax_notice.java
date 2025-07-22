package com.gramPanchayat;

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
 * Servlet implementation class tax_notice
 */
@WebServlet("/tax_notice")
public class tax_notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tax_notice() {
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
		
		String user_name=request.getParameter("gp_name");
		String user_email=request.getParameter("gp_email");
		String Subject_name = request.getParameter("tax_name");
		String Description=request.getParameter("Description");
		String due_date=request.getParameter("due_date");
		String Tax_Amount=request.getParameter("Tax_Amount");
		
		String O_Email_ID;
		O_Email_ID=(String)session.getAttribute("O_Email_ID");
		System.out.println(O_Email_ID);
		
		
		
		try {
			Connection connection = null;
			PreparedStatement ptmt = null;
			ResultSet resultSet = null;
String Status_msg="Pending";
			String queryString = "insert into tax_notice(holder_name,email_id,Tax_Name,Tax_Description,tax_amount,due_date,status,Gram_Panchayat_Email) values(?,?,?,?,?,?,?,?)";
			connection = ConnectionFactory.getInstance().getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,user_name);
			ptmt.setString(2, user_email);
			ptmt.setString(3, Subject_name);
			ptmt.setString(4, Description);
			ptmt.setString(5,Tax_Amount);
			ptmt.setString(6, due_date);
			ptmt.setString(7,Status_msg);
			ptmt.setString(8,O_Email_ID);
		
			
			
			int i = ptmt.executeUpdate();

			if (i > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Send Tax Notice Successfully');");
				out.println("</script>");
				request.getRequestDispatcher("O_Track_Tax_Page.jsp").include(request,
						response);
			} 

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

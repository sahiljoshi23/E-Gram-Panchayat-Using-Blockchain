package com.gov_data;

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
 * Servlet implementation class User_Fund_info
 */
@WebServlet("/User_Fund_info")
public class User_Fund_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Fund_info() {
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
		String fund_name = request.getParameter("fund_name");
		String Description=request.getParameter("Description");
		String fund_cost = request.getParameter("fund_cost");
		String fund_date=request.getParameter("fund_date");
		
		String U_Email_ID;
		U_Email_ID=(String)session.getAttribute("A_Email_ID");
		System.out.println(U_Email_ID);
		
		
		
		try {
String Status_msg="Waiting";
			String queryString = "insert into tbl_user_fund_info(Panchayat_Name,Panchayat_Email_ID,U_Fund_name,U_Fund_cost,U_Fund_Description,U_Fund_Date,Status_msg) values(?,?,?,?,?,?,?)";
			connection = ConnectionFactory.getInstance().getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, gp_name);
			ptmt.setString(2, gp_email);
			ptmt.setString(3, fund_name);
			ptmt.setString(4, fund_cost);
			ptmt.setString(5, Description);
			ptmt.setString(6, fund_date);
			//ptmt.setString(7,U_Email_ID);
			ptmt.setString(7,Status_msg);
			int i = ptmt.executeUpdate();

			if (i > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Fund Send Successfully');");
				out.println("</script>");
				request.getRequestDispatcher("A_Add_Fund_Show.jsp").include(request,
						response);
			} 

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}

}

package com.gramPanchayat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Blockchain.ptop;

import com.Connection.ConnectionFactory;

/**
 * Servlet implementation class transferfunds
 */
@WebServlet("/transferfunds")
public class transferfunds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transferfunds() {
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
		HttpSession session = request.getSession(false);

		String id = request.getParameter("id");

		String U_Email_ID;
		U_Email_ID = (String) session.getAttribute("O_Email_ID");
		System.out.println(U_Email_ID);
		String Transfer_Funds=request.getParameter("Transfer_Funds");

		try {
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String Response_date = df.format(date);
			Connection connection = null;
			connection = ConnectionFactory.getInstance().getConnection();
			Statement ptmt = connection.createStatement();

			String Status_msg = "Transfer_Funds";

			Statement s=connection.createStatement();
			ResultSet sr=s.executeQuery("select * from tbl_user_fund_info where Panchayat_Email_ID='" + U_Email_ID
					+ "' and F_ID='" + id + "'");
			if(sr.next())
			{
				int dbamount=sr.getInt("Transfer_Funds");
				int amount=Integer.valueOf(Transfer_Funds);
				
				int totalamount=dbamount+amount;
				String data=Status_msg+"#"+Response_date+"#"+totalamount+"#"+U_Email_ID+"#"+id;
				ptmt.executeUpdate("update tbl_user_fund_info set Status_msg='" + Status_msg
						+ "', Response_date='" + Response_date
						+ "',Transfer_Funds='"+totalamount+"' where Panchayat_Email_ID='" + U_Email_ID
						+ "' and F_ID='" + id + "'");
				ptop.ptopverify(4,data);
				
			}
			
			
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Transfer Funds Successfully');");
			out.println("</script>");
			request.getRequestDispatcher("O_Track_Complaint_Show.jsp")
					.include(request, response);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

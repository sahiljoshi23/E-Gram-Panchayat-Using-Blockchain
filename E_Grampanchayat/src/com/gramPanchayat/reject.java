package com.gramPanchayat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

import com.Connection.ConnectionFactory;

/**
 * Servlet implementation class reject
 */
@WebServlet("/reject")
public class reject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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

		try {
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String Response_date = df.format(date);
			Connection connection = null;
			connection = ConnectionFactory.getInstance().getConnection();
			Statement ptmt = connection.createStatement();

			String Status_msg = "Reject";

			ptmt.executeUpdate("update complaints set status='" + Status_msg
					+ "', Response_date='" + Response_date
					+ "' where Gram_Panchayat_Email='" + U_Email_ID
					+ "' and id='" + id + "'");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Complaints Reject Successfully');");
			out.println("</script>");
			request.getRequestDispatcher("O_Track_Complaint_Show.jsp")
					.include(request, response);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

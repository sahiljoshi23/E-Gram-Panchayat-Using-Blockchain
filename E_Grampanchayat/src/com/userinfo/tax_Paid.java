package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import com.Connection.ConnectionFactory;

/**
 * Servlet implementation class tax_Paid
 */
@WebServlet("/tax_Paid")
public class tax_Paid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tax_Paid() {
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
		
		String gp_id=request.getParameter("gp_id");
		String gp_email=request.getParameter("gp_email");
		String Discount_Percent = request.getParameter("Discount");
		String Discount_Amount=request.getParameter("Discount_Amount");
		String Final_Amount=request.getParameter("Final_Amount");
		
		
		System.out.println(gp_email);
		
		Date date = new Date();
		SimpleDateFormat  df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String day=df.format(date);
		
		try {
			Connection connection = null;
			
String Status_msg="Paid";
			connection = ConnectionFactory.getInstance().getConnection();
			Statement st=connection.createStatement();
			st.executeUpdate("update tax_notice set status='"+Status_msg+"',Discount_Percent='"+Discount_Percent+"',Discount_Amount='"+Discount_Amount+"',Final_Amount='"+Final_Amount+"',Payment_Date='"+day+"' where Gram_Panchayat_Email='"+gp_email+"' and id='"+gp_id+"'");
		
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Tax Paid Successfully');");
				out.println("</script>");
				request.getRequestDispatcher("/U_Track_Tax_Show.jsp").include(request,
						response);
		

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}

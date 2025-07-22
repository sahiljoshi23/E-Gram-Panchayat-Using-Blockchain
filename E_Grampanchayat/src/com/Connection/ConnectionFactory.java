package com.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ConnectionFactory {

	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3307/gram_fund_distribution_application_db";
	String dbUser = "root";
	String dbPwd = "admin";

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser,dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public static String tax_Amount_Payable(String taxAmounts,String enddate)
	{
		String Amount_Payable="";
//		String enddate="2025-04-30";
		// Current date
        LocalDate currentDate = LocalDate.now();

        // Specify the end date (format: yyyy-MM-dd)
        LocalDate endDate = LocalDate.parse(enddate); // example end date

        // Calculate the number of days between current date and end date
        long totalDays =ChronoUnit.DAYS.between(currentDate, endDate)+1;

        // Output
      
        System.out.println("Days remaining: " + totalDays);
     // Assume tax amount
        
        double taxAmount = Double.valueOf(taxAmounts);
        double finaltaxAmount = 0;
     
        String discountGroup;
        double discountAmount;

        
        
        if (totalDays >= 15 && totalDays <= 20) {
        	discountGroup = "30%";
            discountAmount = taxAmount * 0.30;
            finaltaxAmount=taxAmount - discountAmount;
            
        } else if (totalDays >= 8 && totalDays <= 14) {
            discountGroup = "20%";
            discountAmount = taxAmount * 0.20;
            finaltaxAmount=taxAmount - discountAmount;
        } else if (totalDays >= 1 && totalDays <= 7) {
        	discountGroup = "10%";
            discountAmount = taxAmount * 0.10;
            finaltaxAmount=taxAmount - discountAmount;
        } else if (totalDays <= 0) {
            discountGroup = "0%";
            discountAmount = taxAmount * 0.10;
            finaltaxAmount=taxAmount + discountAmount;
            
        } else {
            discountGroup = "0%";
            discountAmount = taxAmount * 0.10;
            finaltaxAmount=taxAmount + discountAmount;
        }
Amount_Payable=finaltaxAmount+"@"+discountAmount+"@"+discountGroup;
        // Output
        System.out.println("Days remaining (including end date): " + totalDays);
        System.out.println("Discount Group: " + discountGroup);
        System.out.println("Discount Amount: ₹" + discountAmount);
        System.out.println("Amount Payable After Discount: ₹" + finaltaxAmount);
		
		
		
		
		return Amount_Payable;
	}
	
	
	
	public static void main(String[] args) {

    }
}

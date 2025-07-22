<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<%@ page import="com.Connection.*" %>
<%@page import="Dao.user"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> Page 02</title>
  
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
    crossorigin="anonymous"></script>
  <link rel="stylesheet" href="static/css/styles.css">
  <link rel="shortcut icon" href="static/media/village2.jpg" type="image/x-icon">

  <script src="static/js/script.js" defer></script>
</head>

<body>
  <nav>
    <div class="sidebar-header">
      <a class="logo-wrapper">
        <img src="static/media/logo.png" alt="Logo">
        <h4 class="hidden">E-GRAM PANCHAYAT</h4>
      </a>
      <button class="toggle-btn">
        <img src="static/svg/menu.svg" alt="expand button">
      </button>
    </div>


    <div class="sidebar-links">
     <jsp:include page="Omenu.jsp"></jsp:include>

    </div>


    <div class="sidebar-bottom">
      <div class="sidebar-links">
        <a href="LoginPage" class="link">
          <img src="static/svg/logout.svg" alt="">
          <span class="hidden">LogOut</span>
        </a>
      </div>

      <div class="user-profile">
        <div class="user-avatar">
          <img src="static/media/profile.png" alt="">
        </div>
        <div class="user-details hidden">
          <p class="username">USER INFORMATION</p>
        </div>
      </div>
    </div>
  </nav>
  

  <div class="header">
    <img src="static/svg/emblem.svg" alt="emblem" class="img-left">
    <h1 class="header-heading">E-Gram Panchayat</h1>
    <div class="img-right">
      <img src="static/media/sw.png" alt="logo" class="image">
      <img src="static/media/flag_india.gif" alt="INDIA" class="image">
    </div>
  </div>

<!-- {% if messages %} -->
  <!-- {% for message in messages %} -->
      <div class="alert alert-{{ message.tags }} {% if message.tags == 'error' %}alert-danger{% endif %} alert-dismissible text-center" role="alert" style="margin-left: 50px;">
        <!-- <strong>{% if message.tags == "success" %}Success!{% elif message.tags == "error" %}Error!{% endif %}</strong> {{ message }} -->
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
      </div>
  <!-- {% endfor %} -->
<!-- {% endif %} -->


  <section>
  <div class="" align="center">
      <h1 class="heading">Panchayat Fund Information</h1>
    </div>
  
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
          aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
          aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
          aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="static/media/village.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h2> Greater the Power of Panchayats the Better for the People.</h2>
          </div>
        </div>
        <div class="carousel-item">
          <img src="static/media/slider1.png" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h2>Rural Development With Technology</h2>
          </div>
        </div>
        <div class="carousel-item">
          <img src="static/media/rural-farm.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <h2>Nurturing Nature,Nourishing Nations</h2>
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
        data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
        data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </section>
  <section>
    <div class="">
      
    </div>
<div class="" align="center">
      <h1 class="heading">Panchayat Fund Information</h1>
    </div>
<TABLE class="table table-bordered">
            <TR class="danger">            	
              <TH>ID</TH>
                <TH>Fund Name</TH>
                <TH>Fund_Amount</TH>
                <TH>Date</TH>
                 <TH>Action</TH>
             
            </TR>
            <%
            String Gram_Panchayat_Email=(String)session.getAttribute("O_Email_ID");
        	Connection connection =ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
          
            ResultSet resultset =statement.executeQuery("select * from tbl_user_fund_info where Panchayat_Email_ID='"+Gram_Panchayat_Email+"'") ; 
			while(resultset.next())
             {
        %>
           <TR>
           
                <TD> <%= resultset.getString(1) %></TD>
            
               <TD> <%= resultset.getString(4) %> </TD>
                <TD> <%= resultset.getString(5) %> </TD>
                <TD> <%= resultset.getString(7) %> </TD>
                <td>
            <a href="O_Track_UpdateFund_Show.jsp?id=<%=resultset.getString(1)%>" style="background: yellow;color: black;">Next</a> 
        </td>
               
            </TR>
       <% 
           } 
       %>
         </TABLE>
    

  </section>
  <br><br><br>
  <br>

  <footer class="footer">
    <div class="footer-container">
      <div class="row">
        <div class="footer-col">
          <h4>Company</h4>
          <ul>
            <li><a href="#">About Us</a></li>
            <li><a href="#">Privacy Policy</a></li>
          </ul>
        </div>
        <div class="footer-col">
          <h4>Get Help</h4>
          <ul>
            <li><a href="#">Contact Us</a></li>
          </ul>
        </div>
        <div class="footer-col">
          <h4>Certificates</h4>
          <ul>
            <li><a href="#">Birth Certificate</a></li>
            <li><a href="#">Death Certificate</a></li>
          </ul>
        </div>
        <div class="footer-col">
          <h4>Follow Us</h4>
          <div class="social-links">
            <a href="#" class="face"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="twit"><i class=" fab fa-twitter"></i></a>
            <a href="#" class="insta"><i class="fab fa-instagram "></i></a>
            <a href="#" class="linkdi"><i class="fab fa-linkedin-in"></i></a>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script>
    // Function to automatically close alerts after 3 seconds
    $(document).ready(function() {
        setTimeout(function() {
            $(".alert").alert('close');
        }, 3000);
    });
</script>
</body>

</html>
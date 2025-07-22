<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Registration Form </title>
    <link rel="stylesheet" href="static/css/styles_login.css">
    
</head>

<body>

    <div class="wrapper" id="wrapper1" >
        <div class="form-wrapper sign-up" >
            <form action="RegisterPage" method="post">
                <!-- {% csrf_token %} -->
               
                 <div class="input-group">
                  <h2>Sign Up</h2>
                 <select  name="role" style="width: 100%;height: 40px;">
            <option >Select Role</option>
  <option value="User">User</option>
  <option value="Gram_P">Gram Panchayat</option>
  <option value="Government">Government</option>
   
</select>  
              <br/>
              <br/>
                    <input type="text" name="uname" required placeholder="User Name">
                    <br/><br/>
                    <input type="email" name="email" required placeholder=" Enter Email ID">
                <br/>   
                <br/>  
               
                    <input type="password" id="password1" placeholder="Enter Password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{6,20}$" title="Password must be between 8 and 20 characters long and contain at least one uppercase letter, one lowercase letter, and one special symbol" required>
                   <br/>
                <br/>
                    <input type="text" name="address" placeholder="Enter Address" required>
                    <br/>
                    <br/><input type="text" name="mobile" placeholder="Enter Mobile No" required>
                   
                </div>
                 
                <button type="submit" class="btn">Sign Up</button>
                <div class="sign-link">
                    <p>Already have an account? <a href="#" class="signIn-link">Sign In</a></p>
                </div>
                
            </form> 
        </div>

        <div class="form-wrapper sign-in">
            <form action="LoginPage" method="post">
                <!-- {% csrf_token %} -->
                <h2>Login</h2>
                
                
<div class="input-group">
                    <select  name="role" style="width: 100%;height: 40px;">
            <option >Select Role</option>
  <option value="User">User</option>
  <option value="Gram_P">Gram Panchayat</option>
  <option value="Government">Government</option>
   
</select>  
                </div>
                <div class="input-group">
                    <input type="text" name="username" required placeholder="Enter User Name">
                    
                </div>
                <div class="input-group">
                    <input type="password" name="pass" required placeholder="Enter  Password">
                    
                </div>
              
                <button type="submit" class="btn">Login</button>
                <div class="sign-link">
                    <p>Don't have an account? <a href="#" class="signUp-link">Sign Up</a></p>
                </div>
                 <div class="sign-link">
                    <p>Back to Home Page? <a href="index.jsp" class="signUp-link">Back</a></p>
                </div>
            </form>
        </div>
    </div>

    <script src="static/js/script_login.js"></script>
    
    <!-- {% endif %} -->
</body>

</html>
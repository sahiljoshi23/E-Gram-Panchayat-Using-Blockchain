<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="static/media/contact-form.png" type="image/x-icon">
     <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="shortcut icon" href="static/media/village2.jpg" type="image/x-icon">
    
    <title>Contact</title>
    <style>
    
    .container{
        display: flex;
        max-width: 1200px;
        width: 60%;
        margin: 0 auto;
        margin-top: 4rem;
        border: 1px solid black;
        box-shadow: 1rem 1rem 1rem gray;
        padding-left: 1rem;
    }
        .container .contact-info{
            width: 35%;
        }
        .form_field::placeholder {
            color: transparent;
        }

        .form_field:placeholder-shown~.form_label {
            top: 20px;
            font-size: 1.3rem;
            cursor: text;
            color: rgb(19, 20, 20);
        }

        .form_label {
            position: absolute;
            display: block;
            top: 0;
            color: black;
            font-size: 1rem;
            transition: 0.2s;
        }

        .form_group {
            display: block;
            position: relative;
            margin: 18px 0;
            padding: 15px 0 0;
            width: 50%;

        }

        .form_field {
            outline: 0;
            font-size: 1.3rem;
            width: 27rem;
            border: 0;
            border-bottom: 2px solid black;
            color: rgb(54, 52, 52);
            padding: 7px 0;
            background: transparent;

        }
        .btn{
    /* background-color: #5ea4ef; */
    background-color: rgb(46, 45, 45);
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 0.5rem;
    font-size: 16px;
    margin-left: 3rem;
    margin-bottom: 2rem;
    cursor: pointer;
}
    </style>
</head>

<body>
<header>
        <nav>
            <div class="logo">
                <img src="static/media/logo.png" alt="Not-found"><b>E-Gram Panchayat</b>
            </div>
             <ul class="nav-links">
                <li><a href="home.jsp">Home<img src="static/svg/home.svg" alt=""></a></li>
                <li><a href="about.jsp">About Us<img src="static/svg/about1.svg" alt=""></a></li>
                <li><a href="login.jsp">User<img src="static/svg/user.svg" alt=""></a></li>
                <li><a href="contact.jsp">Contact Us<img src="static/svg/contact1.svg" alt=""></a></li>
                <div id="#">Languages<img src="static/svg/lang.svg" alt=""></div>
            </ul> 
        </nav>
    </header>
    <h1>Get in Touch</h1>
    <div class="container">
        <div class="contact-info">
            <div class="contact_information">

                <h3>Locations</h3>
                <p>Prayagraj</p>
                <h3>Address</h3>
                <p>SSJ 246 Doorwani Nagar ADA Colony,Naini,Prayagraj</p>
                <h3>Phone</h3>
                <p>(+91) 630780764</p>
                <h3>Mail</h3>
                <p>princeking19ald@gmail.com</p>
            </div>
        </div>
        <div class="contact-form">
            <!-- <h1>Contact Us</h1> -->
            <form action="" method="post">
                
                <div class="form_group field">
                    <input type="input" class="form_field" placeholder="Name" id="name" name="cont_name" required />
                    <label for="name" class="form_label">Name</label>
                </div>
                <div class="form_group field">
                    <input type="email" class="form_field" placeholder="abc@example.com" id="email" name="cont_email" required />
                    <label for="name" class="form_label">Email</label>
                </div>
                <div class="form_group field">
                    <textarea class="form_field" id="message" placeholder="Message" cols="30" rows="5" name="cont_message"
                        required></textarea>

                    <label for="message" class="form_label">Message</label>
                </div>
                <br><br>
                <center><button class="btn">Send</button></center>
<div class="sign-link">
                    <p>Back to Home Page? <a href="index.jsp" class="signUp-link">Back</a></p>
                </div>
            </form>
        </div>
    </div>
</body>

</html>
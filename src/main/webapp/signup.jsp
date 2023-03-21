<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Signup</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link
      href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i"
      rel="stylesheet"
    />
    <!-- //web font -->
    <link href="signup.css" rel="stylesheet" />
  </head>
  <body>
  
  <input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
  
    <!-- main -->
    <div class="main-w3layouts wrapper">
      <h1>User Registration</h1>
      <div class="main-agileinfo">
        <div class="agileits-top">
          <form action="register" method="post">
            <input
              class="text"
              type="text"
              name="Username"
              placeholder="Username"
              required=""
            />
            <input
              class="text email"
              type="email"
              name="email"
              placeholder="Email"
              required=""
            />
            
           
            
            <input
              class="text"
              type="password"
              name="password"
              placeholder="Password"
              required=""
            />
            <input
              class="text w3lpass"
              type="password"
              name="password"
              placeholder="Confirm Password"
              required=""
            />
            <div class="wthree-text">
              <div class="clear"></div>
            </div>
            <input type="submit" value="SIGNUP" />
          </form>
          <p>Already have an Account? <a href="login.jsp"> Login Now!</a></p>
        </div>
      </div>
      <!-- copyright -->
      <div class="colorlibcopy-agile"></div>
      <!-- //copyright -->
      <ul class="colorlib-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>+
    </div>
    <!-- //main -->
    
    	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<link rel="stylesheet" href="alert/dist/sweetalert.css">
		
		
		<script type="text/javascript">
		
		var status =document.getElementById("status").value;
		
		if(status=="success")
			
		{
			swal("Congratulation!!!","Welcome to the team","success")
		}
		
		
		
		
		
		</script>
    
  </body>
</html>

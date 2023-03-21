<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">




<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>



	<div class="container p-4">


		<div class="row">

			<div class="col-md-6 offset-md-3">

				<div class="card">

					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>




						<form action="adddoct" method="post">
							<div class="form-group">
							
								
								
								<label for="exampleInputEmail1">Name</label> <input
									type="text" class="form-control" name="name" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name">
								<small id="emailHelp" class="form-text text-muted">Please put Dr. infront of Your name
								
								
								
								</small>
							
							
							
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
									
									
									
									<label for="exampleInputEmail1">Contact no</label> <input
									type="number" name="cont" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Your Contact no">
								<small id="emailHelp" class="form-text text-muted">We'll
									keep it confidential</small>
									
									
									
									<label for="exampleInputEmail1">Address</label> <input
									type="text" name="address" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Your Address">
								<small id="emailHelp" class="form-text text-muted">
								
								Separate each Attribute with commas and don't forget to provide your Pincode
								
								</small>
									
									
									
									<label for="exampleInputEmail1">Qualification</label> <input
									type="text" name="qual" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Quatifiaction">
								
							</div>
							
							
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>



					</div>




				</div>



			</div>




		</div>






	</div>


	







		<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">


<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<link rel="stylesheet" href="alert/dist/sweetalert.css">
		
		
		<script type="text/javascript">
		
		var status =document.getElementById("status").value;
		
		if(status=="success")
			
		{
			swal("Done","Your Response has been Submitted","success")
		}
		
		
		
		
		
		</script>
		
















</body>
</html>
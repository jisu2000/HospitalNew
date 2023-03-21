<%@page import="java.util.List"%>
<%@page import="com.jisu.model.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jisu.Repo.MySQLDao"%>
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
						<p class="fs-5 text-center">Add Patient</p>




						<form action="addpatient" method="post">
							<div class="form-group">



								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" name="name" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name">




								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email"> <label
									for="exampleInputEmail1">Contact no</label> <input
									type="number" name="cont" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Your Contact no"> <label
									for="exampleInputEmail1">Address</label> <input type="text"
									name="address" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Your Address">

								<label for="exampleInputEmail1">Disease</label> <input
									type="text" name="dis" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter disease">

								<label for="exampleInputEmail1">Condition</label> <input
									type="text" name="con" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Patient condition">



							<div class="dropdown">
									<button class="btn btn-warning dropdown-toggle" type="button"
										id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">Select Doctor And Submit</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
										<%
										MySQLDao service = new MySQLDao();

										List<Doctor> list = service.viewAllDoct();

										for (Doctor b : list)

										{
										%>
										<button class="dropdown-item" name="doct" value="<%=b.getName() %> " >><%=b.getName() %>
											
											</button>
										
										<%
										}
										%>
									</div>
								</div>

							</div>


						</form>



					</div>




				</div>



			</div>




		</div>






	</div>






























</body>
</html>
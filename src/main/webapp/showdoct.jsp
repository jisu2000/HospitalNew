<%@page import="com.jisu.model.Doctor"%>
<%@page import="com.jisu.model.Booking"%>
<%@page import="java.util.List"%>
<%@page import="com.jisu.Repo.MySQLDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Static Navigation - SB Admin</title>
<link href="css2/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="#"></a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="admin.jsp">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Dashboard
						</a>
						<div class="sb-sidenav-menu-heading"></div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
						
						</a>
					
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Services
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> Doctor
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseAuth"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="adddoct.jsp">Add Doctor</a> <a
											class="nav-link" href="showdoct.jsp">Show All Doctors</a> 
									</nav>
								</div>
							
								<div class="collapse" id="pagesCollapseError"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
								
								</div>
							</nav>
						</div>

					</div>
					<div class="sb-sidenav-footer">
						<div class="small">Logged in as:</div>
						<%=session.getAttribute("name") %>
					</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4 align-items-center font-monospace text-success" style="margin-left:30vw">Our famous Doctors</h1>

					<div class="card mb-4 mx-auto mt-6">

					<div class="card">
						<div class="card-body">
						
						<c:if test="${not empty success })">
						<p class="text-center text-success">${success}</p>
						<c:remove var="success"/>
						
						</c:if>
						
						
						<c:if test="${not empty error})">
						<p class="text-center text-success">${error}</p>
						<c:remove var="error"/>
						
						</c:if>
							

						<table class="table table-dark">
							<thead>

								<tr>
									<th scope="col">id</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Address</th>
									<th scope="col">Qualification</th>
								</tr>
							</thead>


							<%
							MySQLDao service = new MySQLDao();

							List<Doctor> list = service.viewAllDoct();

							for (Doctor b : list)

							{
							%>
							<tr>
								<th scope="row"><%=b.getId()%></th>
								<td><%=b.getName()%></td>
								<td><%=b.getEmail()%></td>
								<td><%=b.getCont()%></td>
								<td><%=b.getAddress()%></td>
								<td><%=b.getQual()%></td>



							</tr>

							<%
							}
							%>









						</table>
						
						</div>
						</div>
						
						


















					</div>
					<div style="height: 100vh"></div>
					<div class="card mb-4">
						<div class="card-body">When scrolling, the navigation stays
							at the top of the page. This is the end of the static navigation
							demo.</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js2/scripts.js"></script>
</body>
</html>

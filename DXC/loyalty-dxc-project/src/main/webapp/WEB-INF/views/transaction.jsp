<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>MyShop Admin - Dashboard</title>
<!-- Bootstrap core CSS-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css" />
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.css" rel="stylesheet">
<!-- Page level plugin CSS-->
<link
	href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<!-- Custom styles for this template-->
<link href="css/main-admin.css" rel="stylesheet">
<link href="css/product-manage.css" rel="stylesheet">
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<!-- <a class="navbar-brand mr-1" href="#">Start Bootstrap</a> -->
		<a class="navbar-brand" href="#"> <img src="img/logo-myshop.JPG"
			class="img-logo">
		</a>
		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a href="#editAccountModal" class="dropdown-item"
						data-toggle="modal">Account</a>
					<!-- <a class="dropdown-item" href="#">Activity Log</a> -->
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>
	</nav>
	<div id="wrapper">
		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link" > <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/transaction"> <i
					class="fas fa-box-open"></i> <span> Earn Point</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-newspaper"></i> <span> Redeemed Point</span></a></li>
		</ul>
		<div id="content-wrapper">
			<div class="container-fluid">
				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Transaction Earn Point
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Order ID</th>
										<th>Product</th>
										<th>Date Order</th>
										<th>Customer</th>
										<th>Point</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${points}" var="points">
										<tr>
											<td>${points.order.orderid}</td>
											<td style="width: 30px;"><select>
													<c:forEach items="${products}" var="products">
														<option value="">${products.name}</option>
													</c:forEach>
											</select></td>
											<td>${points.order.date_order}</td>
											<td>${points.order.account.name}</td>
											<td>${points.point}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
				<!-- Edit Account -->
				<div id="editAccountModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<form>
								<div class="modal-header">
									<h4 class="modal-title">Change Infomation</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
								</div>

								<div class="modal-body">
									<div class="form-group">
										<label>ID</label> <input type="text" class="form-control"
											disabled>
									</div>
									<div class="form-group">
										<label>User Name</label> <input type="text"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label>Password</label> <input type="password"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label>Confirm Password</label> <input type="password"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label>Full Name</label> <input type="text"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label>Address</label> <input type="text" class="form-control"
											required>
									</div>
									<div class="form-group">
										<label>Email</label> <input type="email" class="form-control"
											required>
									</div>
									<div class="form-group">
										<label>Cell phone</label> <input type="text"
											class="form-control" required>
									</div>

								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default"
										data-dismiss="modal" value="Cancel"> <input
										type="submit" class="btn btn-info" value="Save">
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Delete Modal HTML -->
				<!-- /.container-fluid -->

				<!-- Sticky Footer -->
				<footer class="sticky-footer">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright © My Shop-LeThaiDuy, All rights reserved</span>
						</div>
					</div>
				</footer>

			</div>
			<!-- /.content-wrapper -->
		</div>
		<!-- /#wrapper -->
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">Ã</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/datatables/jquery.dataTables.js"></script>
		<script src="vendor/datatables/dataTables.bootstrap4.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>



		<!-- Custom scripts for all pages-->
		<script src="js/myshop-admin.js"></script>
		<script src="js/product-manage.js"></script>

		<!--  -->
		<script>
			$(document).ready(function() {
				$('#dataTable').DataTable();
			});
		</script>
</body>

</html>
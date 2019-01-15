<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:wicket>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Buy Cheap Fashion Clothes Online</title>

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
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">


<!-- Custom styles for this template-->
<link href="css/main-admin.css" rel="stylesheet">
<link href="css/checkout-product.css" rel="stylesheet">
<link href="css/product-manage.css" rel="stylesheet">
<link href="css/detail-order-guest.css" rel="stylesheet">



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
		<div class="collapse navbar-collapse" id="navbarResponsive"></div>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="/product">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/login"
				id="login">Login</a></li>
			<!-- <li class="nav-item"><a class="nav-link" href="#">Register</a></li> -->
			<li class="nav-item">
				<form
					class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..." aria-label="Search"
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</form>
			</li>
		</ul>

		</div>

		<!-- Navbar Search -->


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
						data-toggle="modal">Account</a> <a href="/transaction"
						class="dropdown-item">Transaction</a> <a href="/redeempoint"
						class="dropdown-item">Redeempoint</a>

					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/logout">Logout</a>
				</div></li>
		</ul>

	</nav>


	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">
				<!-- start detail order -->
				<h2>PAYMENT</h2>

				<div class="row">
					<div class="col-75">
						<div class="container">
							<form action="/payment/save" method="post">

								<div class="row">
									<div class="col-50">
										<h3>Address Infomation</h3>
										<label for="fname"><i class="fa fa-user"></i> Full
											Name</label> <input type="text" id="fname" name="name"
											placeholder="John M. Doe" value="${accountselected.name}">
										<label for="email"><i class="fa fa-envelope"></i>
											Email</label> <input type="text" id="email" name="email"
											value="${accountselected.email}"
											placeholder="john@example.com"> <label for="adr"><i
											class="fa fa-address-card-o"></i> Address</label> <input type="text"
											id="adr" name="address" value="${accountselected.address}"
											placeholder="542 W. 15th Street"> <label
											for="cellphone"><i class="fas fa-mobile-alt"></i>
											Cellphone</label> <input type="text" id="cellphone" name="cellphone"
											value="${accountselected.cellphone}"
											placeholder="01234567789">



									</div>


								</div>

								<!--  -->
								<div class="table-title" style="margin-top: 15px;">
									<div class="row">
										<div class="col-sm-6">
											<h2>
												Detail <b>Product</b>
											</h2>
										</div>

									</div>
								</div>
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th><span class="custom-checkbox"> <input
													type="checkbox" id="selectAll"> <label
													for="selectAll"></label>
											</span></th>
											<th>Product ID</th>
											<th>Product name</th>
											<th>Price</th>
											<th>Action</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${products}" var="products">
											<tr>
												<td><span class="custom-checkbox"> <input
														type="checkbox" id="checkbox5" name="options[]" value="1">
														<label for="checkbox5"></label>
												</span></td>
												<td>${products.prodid}</td>
												<td>${products.name}</td>
												<td><span class="price" >${products.price}</span></td>
												<td><a href="#" class="delete"><i
														class="material-icons" data-toggle="tooltip"
														title="Delete">&#xE872;</i></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="order-bill">
									<div class="detail-order-bill">
										<div class="row-inf">
											<span class="lbl">Total Money:($)</span><span class="fee"
												id="total"> </span> <input type="hidden" name="total_money"
												id="result">

										</div>
									</div>

								</div>
								<button type="button" class="btn btn-primary"
									style="margin-left: 400px; width: 150px;"
									onclick="location.href='/product';">Buy Next</button>
								<button type="submit" class="btn btn-success"
									style="width: 150px;"
									onclick="location.href='javascript:AlertBackHome;';">Complete</button>
								<!-- AlertBackHome -->
							</form>
							<!-- start  product-->
							<div class="table-wrapper">

								<!--  table-->

								<!--  table-->
								<div class="clearfix">
									<div class="hint-text">
										Showing <b>5</b> out of <b>25</b> entries
									</div>
									<ul class="pagination">
										<li class="page-item disabled"><a href="#">Previous</a></li>
										<li class="page-item"><a href="#" class="page-link">1</a></li>
										<li class="page-item"><a href="#" class="page-link">2</a></li>
										<li class="page-item active"><a href="#"
											class="page-link">3</a></li>
										<li class="page-item"><a href="#" class="page-link">4</a></li>
										<li class="page-item"><a href="#" class="page-link">5</a></li>
										<li class="page-item"><a href="#" class="page-link">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- /.container-fluid -->
					<!-- end checkout product -->
				</div>
				<!--  total and button -->

			</div>
			<!-- /.container-fluid -->
			<!-- Edit Account -->
			<div id="editAccountModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<form>
							<div class="modal-header">
								<h4 class="modal-title">Account</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>

							<div class="modal-body">
								<div class="form-group">
									<label>User Name</label> <input type="text"
										class="form-control" value="${accountselected.userrname}">
								</div>
								<div class="form-group">
									<label>Full Name</label> <input type="text"
										class="form-control" value="${accountselected.name}" required>
								</div>
								<div class="form-group">
									<label>Point</label> <input type="text" class="form-control"
										value="${accountselected.point}" required>
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
			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright Â© My Shop-LeThaiDuy, All rights reserved</span>
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
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="vendor\datatables\jquery.dataTables.js"></script>
	<script src="vendor\datatables\dataTables.bootstrap4.js"></script>


	<!-- Custom scripts for all pages-->
	<script src="js\myshop-admin.js"></script>
	<script src="js\quanity-input.js"></script>

	<!--  -->
	<script>
		$(document).ready(function() {
			$('#dataTable').DataTable();

		});
		$('.table tbody').on('click', '.delete', function() {
			$(this).closest('tr').remove();
		});
		 var sum = 0;
		$('.price').each(function() {
			sum += +$(this).text() || 0;
		});
		
		$("#total").text(sum);
		$("#result").val(sum); 
	</script>
</body>

</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String timeStamp = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime()); %>
<%-- 
    Document   : kirim tagihan
    Created on : Nov 20, 2016, 3:07:40 PM
    Author     : Alicia Destriani S
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Sistem Pembayaran Uang Sekolah</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	</head>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="index.jsp">Sistem Pembayaran Uang Sekolah</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="index.jsp">Home</a></li>
											<li><a href="LihatStatus.jsp">Lihat Status</a></li>
											<li><a href="Admin.jsp">Admin</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<section class="wrapper style5">
							<div class="inner">

                                                            <h2>Kirim Daftar Tagihan Bulan <%= timeStamp %></h2>
                                                            <form action="ControlKirim" method="get" enctype="multipart/form-data">									
<br />                                                          <input type="submit" value="Kirim Tagihan" />
                                                            </form>											
							</div>
						</section>
					</article>

				<!-- Footer -->
					<footer id="footer">
						<ul class="copyright">
							<li>2016 - SMA Sanata Dharma</li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>
